package Trabalho;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/*
---------------------------------------- 
	essa classe deve implementar os numeros 18 ao 22 no trabalho; 
----------------------------------------
	23) Comece a contar o tempo.

	24) Carregue um dos arquivos de registro, tendo como chave o CPF, em um Hashing
		Encadeado.

	25) Faça a pesquisa, usando as 400 registros fornecidos pela professora, nos mesmos
		moldes do item (3). Não esqueça de gravar os resultados em arquivos.
	
	26) Repita 4 vezes os processos 24 e 25
	
	27) Termine de contar o tempo, faça uma média e armazene este resultado.
*/
public class ArvoreHashing {

	private static ClienteHash[] vet;
	private static int hash;
	private static NoArvoreHash[] arvh;
	private static long[] clientes;

	public static void ControleHash() throws IOException {
		int quantidade = 0;
		String metodo = "";

		for (int i = 1; i < 2; i++) {

			switch (i) {
			case 1:
				quantidade = 500;
				metodo = "ord";
				break;
			case 2:
				metodo = "inv";
				break;
			case 3:
				metodo = "alea";
				break;
			case 4:
				quantidade = 1000;
				metodo = "ord";
				break;
			case 5:
				metodo = "inv";
				break;
			case 6:
				metodo = "alea";
				break;
			case 7:
				quantidade = 5000;
				metodo = "ord";
				break;
			case 8:
				metodo = "inv";
				break;
			case 9:
				metodo = "alea";
				break;
			case 10:
				quantidade = 10000;
				metodo = "ord";
				break;
			case 11:
				metodo = "inv";
				break;
			case 12:
				metodo = "alea";
				break;
			}

			vet = new ClienteHash[quantidade];
			clientes = new long[400];
			CriaVetor("cliente" + quantidade + metodo + ".txt");
			clientes = LeCPF.ler("Cliente.txt");

			Hash(quantidade, vet, metodo);
		}
	}
	//metodo para marcar o tempo e chamar os outros metodos
	public static void Hash(int tamanho, ClienteHash[] i, String metodo) throws IOException {
		double tempoIni = 0;
		double tempoFin = 0;
		double tempo = 0;
		arvh = new NoArvoreHash[tamanho + tamanho / 10];
		ClienteHash t = new ClienteHash();

		for (int j = 0; j < tamanho; j++) {
			arvh[j] = new NoArvoreHash(t);
			if (j != 0) {
				arvh[j - 1].setDir(arvh[j]);
			}

		}

		arvh[tamanho - 1].setDir(arvh[0]);

		hash = HashCode(tamanho);
		for (int p = 0; p < 4; p++) {

			tempoIni = System.currentTimeMillis();

			Insere(i, hash);

			for (int j = 0; j < clientes.length; j++) {
				procura(arvh, clientes[j], hash);
			}

			tempoFin = System.currentTimeMillis();

			tempo = tempo + (tempoFin - tempoIni);

		}
		tempo = tempo/4;
		LeCPF.escrever(arvh, tempo, metodo, tamanho);
	}

	public static int HashCode(int q) {
		switch (q) {

		case 500:
			return 499;
		case 1000:
			return 997;
		case 5000:
			return 4999;
		case 10000:
			return 9973;
		default:
			return -1;

		}

	}

	public static void Insere(ClienteHash[] vet, int hash) {
		NoArvoreHash aux = null;

		long cpf = 0;
		int index = -1;

		for (int i = 0; i < vet.length; i++) {
			System.out.println("\n" + i + "---------------------------------------");
			System.out.println(vet[i].getAgencia() + "\n" + vet[i].getNumero() + "\n" + vet[i].getSaldo() + "\n"
					+ vet[i].getCpf());

			cpf = vet[i].cpf;
			index = (int) (cpf % hash);

			System.out.println(index);

			//if para inserir em uma celula vazia
			if (arvh[index].getInfo().getCpf() == 0) {
				System.out.println("usuário não possui conta cadastrada");
				arvh[index].setInfo(vet[i]);

			} 
			//if para quando a celula ja está preenchida pelo mesmo c´pf
			else if (arvh[index].getInfo().getCpf() == (long) vet[i].getCpf()) {
				System.out.println("usuário já possui conta cadastrada");
				aux = arvh[index];
				try {
					while (true) {
						if (aux.getEsq().getInfo().getCpf() > 0) {
							aux = aux.getEsq();
						}
					}

				} catch (Exception e) {

					NoArvoreHash inserir = new NoArvoreHash(vet[i]);
					aux.setEsq(inserir);
					System.out.println(aux.getEsq().getInfo().getSaldo());
					System.out.println("Inseriu o Filho");
				}

			} 
			//if para quando a celula ja está preenchida por outro cpf
			else {
				aux = arvh[index];

				while (aux.getInfo().getCpf() != (long) vet[i].getCpf() && aux.getInfo().getCpf() != 0) {
					aux = aux.getDir();
				}

				if (aux.getInfo().getCpf() == (long) vet[i].getCpf()) {
					System.out.println("usuário já possui conta cadastrada");
					try {
						while (true) {
							if (aux.getEsq().getInfo().getCpf() > 0) {
								aux = aux.getEsq();
							}
						}

					} catch (Exception e) {

						NoArvoreHash inserir = new NoArvoreHash(vet[i]);
						aux.setEsq(inserir);
						System.out.println("Inseriu o Filho");
						System.out.println(aux.getEsq().getInfo().getSaldo());
					}

				} else {
					System.out.println("Usuario não possui conta cadastrada porém deu azar");
					aux.setInfo(vet[i]);
				}

			}
		}

	}
'	//metodo para procurar o numero no vetor
	public static void procura(NoArvoreHash[] arv, long cpf, int hash) {
		System.out.println("\n\n\n-------------------------------------------------------");

		int index = (int) (cpf % hash);
		int a = 0;
		NoArvoreHash aux;

		if (arv[index].getInfo().getCpf() == cpf) {
			aux = arv[index];
			try {
				while (true) {
					System.out.println(aux.getInfo().toString());
					aux = aux.getEsq();
				}
			} catch (Exception e) {
				System.out.println("Fim");

			}
		}

		else if (arv[index].getInfo().getCpf() != cpf) {
			aux = arv[index];
			while (aux.getInfo().getCpf() != cpf && aux.getInfo().getCpf() != 0) {
				aux = aux.getDir();
			}
			if (aux.getInfo().getCpf() == 0) {
				System.out.println("Cpf não cadastrado");
			} else {
				try {
					while (true) {
						System.out.println(aux.getInfo().toString());
						aux = aux.getEsq();
					}
				} catch (Exception e) {
					System.out.println("Fim");

				}

			}
		}

	}
'//metodo para criar o vetor refente ao arquivo txt ultizado
	public static void CriaVetor(String nome) {

		String numeros = "";
		Scanner scanner;
		int i = 0;

		try {
			scanner = new Scanner(new FileReader("src/Arquivos/" + nome));

			while (scanner.hasNext()) {
				numeros = scanner.nextLine();
				vet[i] = new ClienteHash(numeros);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

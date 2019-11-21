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

	25) FaÃ§a a pesquisa, usando as 400 registros fornecidos pela professora, nos mesmos
		moldes do item (3). NÃ£o esqueÃ§a de gravar os resultados em arquivos.
	
	26) Repita 4 vezes os processos 24 e 25
	
	27) Termine de contar o tempo, faÃ§a uma media e armazene este resultado.
*/
public class ArvoreHashing {

	private static Cliente[] vet;
	private static int hash;
	private static NoArvoreHash[] arvh;

	private static long[] clientes;

	public static void ControleHash() throws IOException {
		int quantidade = 0;

		clientes = LeArquivos.cliente_cpfs;
		
		Hash(LeArquivos.cliente500inv.clone(), "inv");
		Hash(LeArquivos.cliente500alea.clone(), "alea");
		Hash(LeArquivos.cliente500ord.clone(), "ord");
		
		/*Hash(LeArquivos.cliente1000inv.clone(), "inv");
		Hash(LeArquivos.cliente1000alea.clone(), "alea");
		Hash(LeArquivos.cliente1000ord.clone(), "ord");
		
		Hash(LeArquivos.cliente5000inv.clone(), "inv");
		Hash(LeArquivos.cliente5000alea.clone(), "alea");
		Hash(LeArquivos.cliente5000ord.clone(), "ord");

		Hash(LeArquivos.cliente10000inv.clone(), "inv");
		Hash(LeArquivos.cliente10000alea.clone(), "alea");
		Hash(LeArquivos.cliente10000ord.clone(), "ord");

		Hash(LeArquivos.cliente50000inv.clone(), "inv");
		Hash(LeArquivos.cliente50000alea.clone(), "alea");
		Hash(LeArquivos.cliente50000ord.clone(), "ord");*/
	}

	public static void Hash(Cliente[] i, String metodo) throws IOException {
		double tempoIni = 0;
		double tempoFin = 0;
		double tempo = 0;
		int tamanho = i.length;
		
		arvh = new NoArvoreHash[tamanho + tamanho / 10];
		Cliente t = new Cliente();

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
			
			tempo = tempo/4;
			CriaArquivo.arquivoHash(arvh, tempo, metodo, tamanho);
			
			for (int j = 0; j < tamanho; j++) {
				arvh[j] = new NoArvoreHash(t);
				if (j != 0) {
					arvh[j - 1].setDir(arvh[j]);
				}

			}
			tempo = 0;

		}

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

	public static void Insere(Cliente[] vet, int hash) {
		NoArvoreHash aux = null;

		long cpf = 0;
		int index = -1;

		for (int i = 0; i < vet.length; i++) {
			System.out.println("\n" + i + "---------------------------------------");
			System.out.println(vet[i].getAgencia() + "\n" + vet[i].getNum() + "\n" + vet[i].getSaldo() + "\n"
					+ vet[i].getChave());

			cpf = vet[i].getChave();
			index = (int) (cpf % hash);

			System.out.println(index);

			// ve se o nÃ³ na posiÃ§Ã£o index existe

			if (arvh[index].getInfo().getChave() == 0) {
				System.out.println("usuÃ¡rio nÃ£o possui conta cadastrada");
				arvh[index].setInfo(vet[i]);

			} else if (arvh[index].getInfo().getChave() == (long) vet[i].getChave()) {
				System.out.println("usuÃ¡rio jÃ¡ possui conta cadastrada");
				aux = arvh[index];
				try {
					while (true) {
						if (aux.getEsq().getInfo().getChave() > 0) {
							aux = aux.getEsq();
						}
					}

				} catch (Exception e) {

					NoArvoreHash inserir = new NoArvoreHash(vet[i]);
					aux.setEsq(inserir);
					System.out.println(aux.getEsq().getInfo().getSaldo());
					System.out.println("Inseriu o Filho");
				}

			} else {
				aux = arvh[index];

				while (aux.getInfo().getChave() != (long) vet[i].getChave() && aux.getInfo().getChave() != 0) {
					aux = aux.getDir();
				}

				if (aux.getInfo().getChave() == (long) vet[i].getChave()) {
					System.out.println("usuÃ¡rio jÃ¡ possui conta cadastrada");
					try {
						while (true) {
							if (aux.getEsq().getInfo().getChave() > 0) {
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
					System.out.println("Usuario nÃ£o possui conta cadastrada porÃ©m deu azar");
					aux.setInfo(vet[i]);
				}

			}
		}

	}

	public static void procura(NoArvoreHash[] arv, long cpf, int hash) {
		System.out.println("\n\n\n-------------------------------------------------------");

		int index = (int) (cpf % hash);
		int a = 0;
		NoArvoreHash aux;

		if (arv[index].getInfo().getChave() == cpf) {
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

		else if (arv[index].getInfo().getChave() != cpf) {
			aux = arv[index];
			while (aux.getInfo().getChave() != cpf && aux.getInfo().getChave() != 0) {
				aux = aux.getDir();
			}
			if (aux.getInfo().getChave() == 0) {
				System.out.println("Cpf nÃ£o cadastrado");
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

	public static void CriaVetor(String nome) {

		String numeros = "";
		Scanner scanner;
		int i = 0;

		try {
			scanner = new Scanner(new FileReader("src/Arquivos/" + nome));

			while (scanner.hasNext()) {
				numeros = scanner.nextLine();
				vet[i] = new Cliente(numeros);
				i++;
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}

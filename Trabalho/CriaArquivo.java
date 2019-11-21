package Trabalho;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CriaArquivo {
	
	//Padrao de título: (HEAP)+tipo(ALEA ou ORD ou INV)+ tamanho.txt
	public static void criaTxt(String titulo, String conteudo) {
		File f = new File("src/Arquivos/"+titulo);
		FileWriter escreve = null;
		
		try {
			escreve = new FileWriter(f);
			escreve.write(conteudo);
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				escreve.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void arquivoHash(NoArvoreHash[] arvore, double media, String metodo, int quantidade) throws IOException {
		long[] numeros = new long[400];

		NoArvoreHash aux2;
		NoArvoreHash aux3;
		aux2 = arvore[0];

		FileWriter arq = new FileWriter("src\\Arquivos\\(HASH)" + quantidade + metodo + ".txt");
		PrintWriter gravarq = new PrintWriter(arq);
		
		
		gravarq.print(media);

		try {
			for (int j = 0; j < arvore.length; j++) {
				gravarq.print("-----------------\n");
				gravarq.print(aux2.getInfo().toString()+"\n");
				aux3 = aux2;
				while (aux3.getEsq() != null) {
					aux3 = aux3.getEsq();
					gravarq.print(aux3.getInfo().toString()+"\n");

				}
				aux2 = aux2.getDir();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
}

package Trabalho;

import java.io.*;
import java.util.Scanner;

public class LeCPF {
	
	public static Cliente[] cliente10000alea;

	//tem que fazer a mesma coisa para os outros arquivos (MENOS O Cliente.txt)
	public static void inicia_vetores() {
		cliente10000alea = criaVetor("cliente10000alea.txt");
		
	}
	
	
	public static String ler(String nomeArquivo){
		Scanner scanner;
		String conteudo = "";
		
		try {
			scanner = new Scanner(new FileReader("src/Arquivos/"+nomeArquivo));

			while (scanner.hasNext()) {
				conteudo += scanner.nextLine()+"//"; // Separa clientes
			}
		}catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return conteudo;
	}
	
	private static Cliente[] criaVetor(String nomeArquivo) {
		
		String str = ler(nomeArquivo);
		String[] temp = str.split("//");
		Cliente[] vet = new Cliente[temp.length];
		
		for(int i=0; i < temp.length; i++) {
			vet[i] = new Cliente(temp[i]);
		}
		
		return vet;
		
	}
	
}

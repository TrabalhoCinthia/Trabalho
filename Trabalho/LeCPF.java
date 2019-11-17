package Trabalho;

import java.io.*;
import java.util.Scanner;

public class LeCPF {

	public static long[] cliente_cpfs;
	public static Cliente[] cliente10000alea = criaVetor("cliente10000alea.txt");
	public static Cliente[] cliente10000inv = criaVetor("cliente10000inv.txt");
	public static Cliente[] cliente10000ord = criaVetor("cliente10000ord.txt");
	public static Cliente[] cliente1000alea = criaVetor("cliente1000alea.txt");
	public static Cliente[] cliente1000inv = criaVetor("cliente1000inv.txt");
	public static Cliente[] cliente1000ord = criaVetor("cliente1000ord.txt");
	public static Cliente[] cliente50000alea = criaVetor("cliente50000alea.txt");
	public static Cliente[] cliente50000inv = criaVetor("cliente50000inv.txt");
	public static Cliente[] cliente50000ord = criaVetor("cliente50000ord.txt");
	public static Cliente[] cliente5000alea = criaVetor("cliente5000alea.txt");
	public static Cliente[] cliente5000inv = criaVetor("cliente5000inv.txt");
	public static Cliente[] cliente5000ord = criaVetor("cliente5000ord.txt");
	public static Cliente[] cliente500alea = criaVetor("cliente500alea.txt");
	public static Cliente[] cliente500inv = criaVetor("cliente500inv.txt");
	public static Cliente[] cliente500ord = criaVetor("cliente500ord.txt");
	
	
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

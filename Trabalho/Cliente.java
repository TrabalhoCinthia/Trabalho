package Trabalho;

import java.io.*;
import java.util.Scanner;

public class LeArquivos {

	public static long[] cliente_cpfs = criaVetorLong("Cliente.txt");

	public static Cliente[] cliente500ord = criaVetorOrd("cliente500ord.txt");
	public static Cliente[] cliente500alea = criaVetorDes("cliente500alea.txt",cliente500ord);
	public static Cliente[] cliente500inv = criaVetorDes("cliente500inv.txt",cliente500ord);
	
	/*public static Cliente[] cliente1000ord = criaVetorOrd("cliente1000ord.txt");
	public static Cliente[] cliente1000alea = criaVetorDes("cliente1000alea.txt",cliente1000ord);
	public static Cliente[] cliente1000inv = criaVetorDes("cliente1000inv.txt",cliente1000ord);

	public static Cliente[] cliente5000ord = criaVetorOrd("cliente5000ord.txt");
	public static Cliente[] cliente5000alea = criaVetorDes("cliente5000alea.txt",cliente5000ord);
	public static Cliente[] cliente5000inv = criaVetorDes("cliente5000inv.txt",cliente5000ord);
	
	public static Cliente[] cliente10000ord = criaVetorOrd("cliente10000ord.txt");
	public static Cliente[] cliente10000alea = criaVetorDes("cliente10000alea.txt",cliente10000ord);
	public static Cliente[] cliente10000inv = criaVetorDes("cliente10000inv.txt",cliente10000ord);
	
	public static Cliente[] cliente50000ord = criaVetorOrd("cliente50000ord.txt");
	public static Cliente[] cliente50000alea = criaVetorDes("cliente50000alea.txt",cliente50000ord);
	public static Cliente[] cliente50000inv = criaVetorDes("cliente50000inv.txt",cliente50000ord);*/
	
	
	//Retorna o conteudo de um arquivo dado o nome do arquivo
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
	
	//Cria um vetor dado o nome de um arquivo com os elementos ordenados
	private static Cliente[] criaVetorOrd(String nomeArquivo) {
		
		String str = ler(nomeArquivo);
		String[] temp = str.split("//");
		Cliente[] vet = new Cliente[temp.length];
		
		for(int i=0; i < temp.length; i++) {
			vet[i] = new Cliente(temp[i]);
			if(i>0) {
				/*Se o valor dos cpfs forem iguais, os dois apontarão para
				 * o mesmo objeto Cpf */
				if(vet[i].getChave() == vet[i-1].getChave()) {
					vet[i].setCpf(vet[i-1].getCpf());
				}
			}
			
			System.out.println("lendo "+i+" de "+temp.length);
		}
		
		return vet;
		
	}
	
	/*Cria um vetor desordenado que usa os Clientes e CPFs
	  já criados no vetor ordenado de mesmo tamanho.*/
	private static Cliente[] criaVetorDes(String nomeArquivo, Cliente[]vet_ord) {
		
		String str = ler(nomeArquivo);
		String[] temp = str.split("//");
		Cliente[] vet = new Cliente[temp.length];
		
		for(int i=0; i < temp.length; i++) {
			//cria um novo Cliente com os atributos do arquivo
			vet[i] = new Cliente(temp[i]);
			
			//encontra o Cliente com o mesmo cpf e num no vet_ord e insere no vetor desordenado
			vet[i] = PesquisaBinaria.pesqCliente(vet[i], vet_ord);
			
			System.out.println("lendo "+i+" de "+temp.length);
		}
		
		return vet;
		
	}
	
	
	
	private static long[] criaVetorLong(String nomeArquivo) {
		
		String str = ler(nomeArquivo);
		String[] temp = str.split("//");
		long[] vet = new long[temp.length];
		
		for(int i=0; i < temp.length; i++) {
			vet[i] = Long.parseLong(temp[i]);
		}
		
		return vet;
		
	}
	
}

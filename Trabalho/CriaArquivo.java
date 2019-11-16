package Trabalho;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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
	
}

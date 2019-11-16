package Trabalho;

import java.io.File;
import java.io.IOException;

public class CriaArquivo {
	
	public static void criaTxt(String titulo, String conteudo) {
		File f = new File("src/Arquivos/"+titulo);
		try {
			f.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}

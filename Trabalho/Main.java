package Trabalho;
/*
----------------------------------------- 
  Essa classe é responsavel por chamar as outras. 
-----------------------------------------
*/
public class Main {

	public static void main(String[] args) {
		ex13a17_controle();
		
		
	}
	
	private static void ex13a17_controle() {
		System.out.println("começou");
		String medias = "Médias(em milissegundos)\n";
		
		/*medias += "\n50000 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente50000alea, "ALEA50000")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente50000inv, "INV50000")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente50000ord, "ORD50000")/4.0+"\n";*/
		
		medias += "\n10000 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente10000alea, "ALEA10000")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente10000inv, "INV10000")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente10000ord, "ORD10000")/4.0+"\n";
		
		System.out.println(medias);
		
		medias += "\n5000 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente5000alea, "ALEA5000")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente5000inv, "INV5000")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente5000ord, "ORD5000")/4.0+"\n";
		
		System.out.println(medias);
		
		medias += "\n1000 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente1000alea, "ALEA1000")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente1000inv, "INV1000")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente1000ord, "ORD1000")/4.0+"\n";
		
		System.out.println(medias);
		
		medias += "\n500 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente500alea, "ALEA500")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente500inv, "INV500")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente500ord, "ORD500")/4.0+"\n";
		
		CriaArquivo.criaTxt("(ABB)Médias.txt", medias);
		System.out.println(medias);
		
	}
	
	private static long exABB(Cliente[]vetor, String nome_vetor) {
		
		long inicio_milis;
		long final_milis;
		long[] cpfs = LeArquivos.cliente_cpfs;
		long soma = 0;
		
		//16) repetir 4 vezes
		for(int cont=0; cont<4; cont++) {
			
			//13 contar tempo
			inicio_milis = System.currentTimeMillis();
		
			ArvoreABB arv = new ArvoreABB();
			
			//14 carregar a ABB
			for(Cliente c : vetor) {
				arv.insere(c);
			}
			
			//15 pesquisar os cpfs na ABB e criar arquivo
			String conteudo="CPFs do Clientes.txt encontrados no "+nome_vetor+".txt \n";
			for(long cpf : cpfs) {
				if(arv.pesquisa(cpf))
					conteudo += cpf+"\n";
			}
			if(conteudo != "") {
				CriaArquivo.criaTxt("(ABB)"+nome_vetor+".txt", conteudo);
			}
			
			System.out.println(conteudo);
			final_milis = System.currentTimeMillis();
			soma += final_milis - inicio_milis;
			System.out.println(" ->Essa vez: "+(final_milis - inicio_milis)+" inicio: "+inicio_milis);
		}
		return soma;
		
	}
	
}

package Trabalho;
/*
----------------------------------------- 
  Essa classe é responsavel por chamar as outras. 
-----------------------------------------
*/
*/
public class Main {

	public static void main(String[] args) {
		
	}
	
	//Ex 13 a 17
	private void ex13a17() {
		//13
		long inicio_milis = System.currentTimeMillis();
		long final_milis;
		long media = 0;
		long[] cpfs;
		long[] Clientes400 = new long[100];// <- Trocar
		
		//16
		for(int vez = 1; vez <= 4; vez++) {
			
			cpfs = new long[100];// <- Trocar para cada vetor (500, 1000, 5000, 10000, ...)
			
			//14
			ArvoreABB arv = new ArvoreABB();
			for(long cpf : cpfs) {
				Item item = new Item(cpf);
				arv.insere(item);
			}
			
			//15
			String arquivo = "";
			for(long cpf : Clientes400) {
				if(arv.pesquisa(cpf))
					arquivo += cpf+"\n";
			}
			CriaArquivo.criaTxt("(ABB)"+tipo+tamanho+".txt", arquivo);
			
			final_milis = System.currentTimeMillis();
			media += final_milis-inicio_milis;
		}
		
		//17
		media = media/4;
		
		//armazenar a media
		
	}
	
}

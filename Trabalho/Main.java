package Trabalho;
/*
----------------------------------------- 
  Essa classe é responsavel por chamar as outras. 
-----------------------------------------
*/
/*
	---------------------------------------- 
essa classe deve implementar os numeros 13 ao 17 no trabalho; 
----------------------------------------
13) Comece a contar o tempo.

14) Carregue uma ABB com os registros de um dos arquivos, tendo como chave o CPF.
	Balanceie a árvore. Cuidado com os CPFs iguais: vocês devem pensar em uma
	maneira eficiente de armazenar os CPFs iguais

15) Faça a pesquisa na ABB, usando os 400 registros fornecidos pela professora,
	gerando arquivos no mesmo modelo do item (3).

16) Repita 4 vezes os processos 14 e 15

17) Termine de contar o tempo, faça uma média e armazene este resultado
*/
public class Main {

	public static void main(String[] args) {
		
	}
	
	private void ex13a17() {
		//13
		long inicio_milis = System.currentTimeMillis();
		long final_milis;
		
		//14
		long[] cpfs = new long[100];// <--- Trocar
		ArvoreABB arv = new ArvoreABB();
		for(long cpf : cpfs) {
			Item item = new Item(cpf);
			arv.insere(item);
		}
		
		//15
		for(long cpf : cpfs) {
			
		}
		
		
		
		
	}
	
}

package Trabalho;
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

public class ArvoreABB {
	
	private NoArvore raiz;
	public ArvoreABB(){
		this.raiz = null;
	}
	
	public boolean pesquisa (long chave){
		NoArvore temp;

		temp = this.pesquisa (chave, this.raiz);
		if (temp != null)
			return true;
		else
			return false;
	}
	
	private NoArvore pesquisa (long chave, NoArvore no){
		 NoArvore temp;
		 temp = no;

		if (temp != null){
			 if (chave < temp.getInfo().getChave())
				 temp = this.pesquisa (chave, temp.getEsq());
			 else{
				 if (chave > temp.getInfo().getChave())
				 temp = this.pesquisa (chave, temp.getDir());
			 }
		 }
		 return temp;
	}
	
	public boolean insere (Cliente elem){
		boolean existe;
		existe = this.pesquisa(elem.getChave());
		
		 if (existe)
			 return false;
		 else{
			 this.raiz = this.insere (elem, this.raiz);
			 return true;
		 }
	}

	private NoArvore insere (Cliente elem, NoArvore no){
		NoArvore novo;

		if (no == null){
			novo = new NoArvore(elem);
			return novo;
		}
		else {
			 if (elem.getChave() < no.getInfo().getChave()){
				 no.setEsq(this.insere (elem, no.getEsq()));
				 return no;
			 }
			 else{
				 no.setDir(this.insere (elem, no.getDir()));
				 return no;
			 }
		}
	}
	
	private NoArvore remove (int chave, NoArvore arv){
		if (arv == null)
			return arv;
		else{
			 if (chave < arv.getInfo().getChave())
				 arv.setEsq(this.remove (chave, arv.getEsq()));
			 else
				 if (chave > arv.getInfo(). getChave())
					 arv.setDir(this.remove (chave, arv.getDir()));
			 else
				 if (arv.getDir() == null)
					 return arv.getEsq();
			 else
				 if (arv.getEsq() == null)
					 return arv.getDir();
				 else
					 arv.setEsq(this.arruma (arv, arv.getEsq()));
		}
		return arv;
		}
		private NoArvore arruma (NoArvore Q, NoArvore R){
			if (R.getDir() != null)
				R.setDir(this.arruma (Q, R.getDir()));
			else{
				Q.setInfo(R.getInfo());
				R = R.getEsq();
			}
			return R;
		}
	
	
}

package Trabalho;
/*
	---------------------------------------- 
Faça os itens de 18 a 22 para cada um dos tamanhos (500, 1000, 5000, 10000 e
50000), para cada tipo de arquivo (aleatório, ordenado e invertido), usando AVL. 
----------------------------------------
	18) Comece a contar o tempo.

	19) Carregue uma AVL com os registros de um dos arquivos, tendo como chave o CPF.
		Balanceie a árvore. Cuidado com os CPFs iguais: vocês devem pensar em uma
		maneira eficiente de armazenar os CPFs iguais
	
	20) Faça a pesquisa na AVL, usando os 400 registros fornecidos pela professora, gerando
		arquivos no mesmo modelo do item (3).
	
	21) Repita 4 vezes os processos 19 e 20

	22) Termine de contar o tempo, faça uma média e armazene este resultado
*/


public class ArvoreAVL {
 private NoArvore raiz;
 private boolean h;
 
 public ArvoreAVL(){
    this.raiz = null;
    this.h = true;
 }
 
public void insere (Cliente elem){
    this.raiz = this.insere (elem, this.raiz);
}

private NoArvore insere (Cliente elem, NoArvore no){
    if (no == null){
        NoArvore novo = new NoArvore(elem);
        this.h = true;
        return novo;
    }
    else{
        if (elem.getChave() < no.getInfo().getChave()){
        // Insere à esquerda e verifica se precisa balancear à direita
            no.setEsq(this.insere (elem, no.getEsq()));
            no = this.balancearDir(no);
            return no;
        }
        else{
        // Insere à direita e verifica se precisa balancear à esquerda
             no.setDir(this.insere (elem, no.getDir()));
             no = this.balancearEsq (no);
             return no;
        }
    }
}

private NoArvore balancearDir (NoArvore no){
    if (this.h)
        switch (no.getFatorBalanceamento()){
        case 1 : no.setFatorBalanceamento((byte)0);
                this.h = false;
                break;
        case 0 : no.setFatorBalanceamento((byte)-1);
                  break;
        case -1: no = this.rotaçãoDireita(no);
                 break;
    }
    return no;
}

private NoArvore balancearEsq (NoArvore no){
    if (this.h)
        switch (no.getFatorBalanceamento()){
            case -1: no.setFatorBalanceamento((byte)0);
                    this.h = false;
                    break;
        case 0 : no.setFatorBalanceamento((byte)1);
                 break;
        case 1 : no = this.rotaçãoEsquerda(no);
                break;
        }
        return no;
    }

private NoArvore rotaçãoDireita (NoArvore no){
    NoArvore temp1, temp2;
    temp1 = no.getEsq();
    
    if (temp1.getFatorBalanceamento() == -1){
        no.setEsq(temp1.getDir());
        temp1.setDir(no);
        no.setFatorBalanceamento((byte)0);
        no = temp1;
    }
    else {
        temp2 = temp1.getDir();
        temp1.setDir(temp2.getEsq());
        temp2.setEsq(temp1);
        no.setEsq(temp2.getDir());
        temp2.setDir(no);
        
        if (temp2.getFatorBalanceamento() == -1)
            no.setFatorBalanceamento((byte)1);
         else
            no.setFatorBalanceamento((byte)0);
        
    if (temp2.getFatorBalanceamento() == 1)
        temp1.setFatorBalanceamento((byte)-1);
    else
        temp1.setFatorBalanceamento((byte)0);
        no = temp2;
    }
        no.setFatorBalanceamento((byte)0);
        this.h = false;
        return no;
    }
  
 private NoArvore rotaçãoEsquerda (NoArvore no){
    NoArvore temp1, temp2;
    temp1 = no.getDir();
    
    if (temp1.getFatorBalanceamento() == 1){
        no.setDir (temp1.getEsq());
        temp1.setEsq(no);
        no.setFatorBalanceamento((byte)0);
        no = temp1;
      }
    else {
        temp2 = temp1.getEsq();
        temp1.setEsq(temp2.getDir());
        temp2.setDir(temp1);
        no.setDir(temp2.getEsq());
        temp2.setEsq(no);
        
        if (temp2.getFatorBalanceamento() == 1)
            no.setFatorBalanceamento((byte)-1);
        else
            no. setFatorBalanceamento((byte)0);
        
        if (temp2. getFatorBalanceamento() == -1)
            temp1. setFatorBalanceamento((byte)1);
        else
            temp1. setFatorBalanceamento((byte)0);
            no = temp2;
        }
    no.setFatorBalanceamento((byte)0);
    this.h = false;
    return no;
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

}

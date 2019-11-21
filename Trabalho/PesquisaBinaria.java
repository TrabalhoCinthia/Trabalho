package Trabalho;

public class PesquisaBinaria {
	
	//Recebe o cpf de um Cliente e retorna o endereco desse Cliente se achar
	public static Cliente pesqCliente (Cliente c, Cliente[]vet){
		int meio, esq, dir;
		esq = 0;
		dir = vet.length-1;
		
		
		while (esq <= dir){
			meio = (esq + dir)/2;
			
			if (c.getChave() == vet[meio].getChave()) {
				if(c.getNum() == vet[meio].getNum()) {
					return vet[meio];
				}else if(c.getNum() < vet[meio].getNum()){
					dir = meio-1;
				}else {
					esq = meio+1;
				}
			}
			else{
				if (c.getChave() < vet[meio].getChave()) {
					dir = meio - 1;
				}else {
					esq = meio + 1;
				}
			}
		}
		System.out.println(">NaO ACHOU !!!");
			return null;
	}
        
	public static Cliente pesqCpf(long cpf, Cliente[]vet){
            int meio, esq, dir;
            esq = 0;
            dir = vet.length-1;
            Cliente aux = null;
            
            while (esq <= dir){
                meio = (esq + dir)/2;

                if (cpf == vet[meio].getChave()) {
                    aux = vet[meio];   
                    break;
                } else{
                    if (cpf < vet[meio].getChave()) {
                        dir = meio - 1;
                    }else {
                        esq = meio + 1;
                    }
                }
            }

            return aux;
	}        
	
	//retorna todos os clientes com um cpf
	public static Cliente[] pesqCpfMultp(long cpf, Cliente[]vet){
	        int meio, esq, dir;
	        esq = 0;
	        dir = vet.length-1;
	        Cliente[] mesmo_cpf = null;
	        int qtd_dir=0, qtd_esq=0;
	        
	        while (esq <= dir){
	            meio = (esq + dir)/2;
	
	            //Achou um cliente com o cpf
	            if (cpf == vet[meio].getChave()) {
	                System.out.println("achou cliente com o cpf"); 
	            	
	            	//Encontra a quantidade de clientes com mesmo cpf a direita
	                 while( (meio+qtd_dir+1 <vet.length )&&(cpf == vet[meio+qtd_dir+1].getChave())) {
	                	 qtd_dir++;
	                 }
	                 
	               //Encontra a quantidade de clientes com mesmo cpf a esquerda
	                 while( (meio-qtd_esq-1 >= 0)&&(cpf==vet[meio-qtd_esq-1].getChave()) ) {
	                	 qtd_esq++;
	                 }
	                 
	                 //Cria vetor com todos os clientes com mesmo cpf
	                 mesmo_cpf = new Cliente[ qtd_esq + qtd_dir + 1 ];
	                 for(int i=0; i<mesmo_cpf.length;i++) {
	                	 mesmo_cpf[i] = vet[meio-qtd_esq+i];
	                 }
	            	
	            	break;
	            	
	            } else{
	                if (cpf < vet[meio].getChave()) {
	                    dir = meio - 1;
	                }else {
	                    esq = meio + 1;
	                }
	            }
	        }
	
	        return mesmo_cpf;
	}    
	
}

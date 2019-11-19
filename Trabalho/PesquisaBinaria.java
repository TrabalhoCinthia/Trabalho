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
		System.out.println(">NÃO ACHOU !!!");
			return null;
	}
}

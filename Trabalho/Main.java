package Trabalho;
/*
----------------------------------------- 
  Essa classe é responsavel por chamar as outras. 
-----------------------------------------
*/
public class Main {

	public static void main(String[] args) {
		ex1a6_controle();
		ex7a12_controle();
                ex13a17_controle();
	}
		
        public static void CriaVetor(String nome) {
		
			String numeros = "";
			Scanner scanner;
			int i = 0;
			
			try {
				scanner = new Scanner(new FileReader("src/Arquivos/"+nome));
				while (scanner.hasNext()) {
					numeros = scanner.nextLine();
					vet[i] = new Cliente(numeros);
					i++;
				}
				
			}catch (FileNotFoundException e) {
				e.printStackTrace();
			}
	}
	
	private static void ex1a6_controle() {
		String medias = "Médias(em milissegundos)\n";
		System.out.println("começou");
               
		medias += "\n50000 Elementos\n";
		medias += "Aleatório - "+exHeapsort(LeArquivos.cliente50000alea, "ALEA50000")/4.0+"\n";
		medias += "Invertido - "+exHeapsort(LeArquivos.cliente50000inv, "INV50000")/4.0+"\n";
		medias += "Ordenado - "+exHeapsort(LeArquivos.cliente50000ord, "ORD50000")/4.0+"\n"; 

		medias += "\n10000 Elementos\n";
		medias += "Aleatório - "+exHeapsort(LeArquivos.cliente10000alea, "ALEA10000")/4.0+"\n";
		medias += "Invertido - "+exHeapsort(LeArquivos.cliente10000inv, "INV10000")/4.0+"\n";
		medias += "Ordenado - "+exHeapsort(LeArquivos.cliente10000ord, "ORD10000")/4.0+"\n"; 
		
		System.out.println(medias);

		medias += "\n5000 Elementos\n";
		medias += "Aleatório - "+exHeapsort(LeArquivos.cliente5000alea, "ALEA5000")/4.0+"\n"; 
		medias += "Invertido - "+exHeapsort(LeArquivos.cliente5000inv, "INV5000")/4.0+"\n"; 
		medias += "Ordenado - "+exHeapsort(LeArquivos.cliente5000ord, "ORD5000")/4.0+"\n"; 
		
		System.out.println(medias);

		medias += "\n1000 Elementos\n";
		medias += "Aleatório - "+exHeapsort(LeArquivos.cliente1000alea, "ALEA1000")/4.0+"\n"; 
		medias += "Invertido - "+exHeapsort(LeArquivos.cliente1000inv, "INV1000")/4.0+"\n"; 
		medias += "Ordenado - "+exHeapsort(LeArquivos.cliente1000ord, "ORD1000")/4.0+"\n"; 
		
		System.out.println(medias);
            
		medias += "\n500 Elementos\n";
		medias += "Aleatório - "+exHeapsort(LeArquivos.cliente500alea.clone(), "ALEA500")/4.0+"\n"; 
       		medias += "Invertido - "+exHeapsort(LeArquivos.cliente500inv.clone(), "INV500")/4.0+"\n"; 
                medias += "Ordenado - "+exHeapsort(LeArquivos.cliente500ord.clone(), "ORD500")/4.0+"\n"; 
                
		CriaArquivo.criaTxt("(HEAP)Médias.txt", medias);
		System.out.println(medias);
	}
	
	 
	private static long exHeapsort(Cliente[] vetor, String nome_vetor) {
		long inicio_milis;
		long final_milis;
        long soma = 0;

        //Roda 5 vezes
		for(int cont=0; cont<=4; cont++) {
				//1- Contar tempo
                inicio_milis = System.currentTimeMillis();

                System.out.println("vai fazer heap");
                
                //3- Ordenar por cpf
                PequisaHeap.heapSort(vetor);     

                System.out.println("fez heapsort");
                
                //Ordena por num da conta os CPFs repetidos
                for (int i = 1; i < vetor.length; i++) {
                    if (i <= 0) {
                        i = 1;
                    }
                    
                    if (vetor[i].getChave() == vetor[i - 1].getChave()) {
                        if (vetor[i].numero < vetor[i - 1].numero) {
                            Cliente aux = vetor[i];
                            vetor[i] = vetor[i - 1];
                            vetor[i - 1] = aux;
                            i-=2;
                        }
                    }
                }     
                
                System.out.println("ordenou por num da conta");

                //6- Termina de contar o tempo
                final_milis = System.currentTimeMillis();
                soma += final_milis - inicio_milis;
                System.out.println(" -> Dessa vez: "+(final_milis - inicio_milis)+" inicio: "+inicio_milis);
            }

                String conteudo = "";

                for (int i = 0; i < vetor.length; i++) {
                   conteudo += vetor[i].toString() + "\n";
                }

                CriaArquivo.criaTxt("(HEAP)" + nome_vetor + ".txt", conteudo);

                ////////////////////////////////////////////////////////////////

                System.out.println("vai fazer as pesquisas");
                
                String pesquisas = "Resultado pesquisas (" + nome_vetor + ")\n";

                for (int i = 0; i < LeArquivos.cliente_cpfs.length; i++) {
                	
                	long cpf = LeArquivos.cliente_cpfs[i];
                	
                	System.out.println("pesquisa "+i+" de "+LeArquivos.cliente_cpfs.length);
                    Cliente[] aux = PesquisaBinaria.pesqCpfMultp(cpf, vetor);
                    System.out.println("pesquisa concluida");
                    
                    pesquisas += "\nCPF "+cpf+":\n";
                    if(aux == null) {
                    	pesquisas += "NÃO HÁ CLIENTE COM O CPF "+cpf+"\n";
                    	System.out.println("cpf "+cpf+" nao achou clientes");
                    }else {
                    
                    	double saldo=0;
                    	String tipo_conta;
	                    for(int j=0;j<aux.length;j++) {
	                    	
	                    	//Se começa com 001 é conta corrente, com 002 é poupança
	                    	if(aux[j].toString().charAt(3) == '1') 
	                    		tipo_conta = "Conta Corrente";
	                    	else
	                    		tipo_conta = "Conta Poupança";
	                    	
	                    	pesquisas += "Agencia "+aux[j].getAgencia()
	                    			+"\t"+tipo_conta+": "+aux[j].getNum()
	                    			+"\t Saldo: "+aux[j].getSaldo()+"\n";
	                    	saldo += aux[j].getSaldo();
	                    	
	                    }
	                    pesquisas += "Saldo total: "+saldo+"\n";
	                    
                    }
                    

                }
                System.out.println("RESULTADO: "+pesquisas);
                CriaArquivo.criaTxt("(HEAP)Pesq"+nome_vetor+".txt", pesquisas);
		return soma;
	}   	
	
	
        private static void ex7a12_controle() {
		String medias = "Médias(em milissegundos)\n";
		System.out.println("começou");
               
		medias += "\n50000 Elementos\n";
		medias += "Aleatório - "+exQuicksort(LeArquivos.cliente50000alea, "ALEA50000")/4.0+"\n";
		medias += "Invertido - "+exQuicksort(LeArquivos.cliente50000inv, "INV50000")/4.0+"\n";
		medias += "Ordenado - "+exQuicksort(LeArquivos.cliente50000ord, "ORD50000")/4.0+"\n"; 

		medias += "\n10000 Elementos\n";
		medias += "Aleatório - "+exQuicksort(LeArquivos.cliente10000alea, "ALEA10000")/4.0+"\n";
		medias += "Invertido - "+exQuicksort(LeArquivos.cliente10000inv, "INV10000")/4.0+"\n";
		medias += "Ordenado - "+exQuicksort(LeArquivos.cliente10000ord, "ORD10000")/4.0+"\n"; 
		
		System.out.println(medias);

		medias += "\n5000 Elementos\n";
		medias += "Aleatório - "+exQuicksort(LeArquivos.cliente5000alea, "ALEA5000")/4.0+"\n"; 
		medias += "Invertido - "+exQuicksort(LeArquivos.cliente5000inv, "INV5000")/4.0+"\n"; 
		medias += "Ordenado - "+exQuicksort(LeArquivos.cliente5000ord, "ORD5000")/4.0+"\n"; 
		
		System.out.println(medias);

		medias += "\n1000 Elementos\n";
		medias += "Aleatório - "+exQuicksort(LeArquivos.cliente1000alea, "ALEA1000")/4.0+"\n"; 
		medias += "Invertido - "+exQuicksort(LeArquivos.cliente1000inv, "INV1000")/4.0+"\n"; 
		medias += "Ordenado - "+exQuicksort(LeArquivos.cliente1000ord, "ORD1000")/4.0+"\n"; 
		
		System.out.println(medias);
            
		medias += "\n500 Elementos\n";
		medias += "Aleatório - "+exQuicksort(LeArquivos.cliente500alea.clone(), "ALEA500")/4.0+"\n"; 
       		medias += "Invertido - "+exQuicksort(LeArquivos.cliente500inv.clone(), "INV500")/4.0+"\n"; 
                medias += "Ordenado - "+exQuicksort(LeArquivos.cliente500ord.clone(), "ORD500")/4.0+"\n"; 
                
		CriaArquivo.criaTxt("(QUICK)Médias.txt", medias);
		System.out.println(medias);
	}
	
	private static long exQuicksort(Cliente[] vetor, String nome_vetor) {
		long inicio_milis;
		long final_milis;
                long soma = 0;
		for(int cont=0; cont<4; cont++) {
		
                    inicio_milis = System.currentTimeMillis();
                    
                    PesquisaQuick.ordenaCpf(vetor, 0, vetor.length - 1);
                
                    for (int i = 1; i < vetor.length; i++) {
                        if (i <= 0) {
                            i = 1;
                        }

                        if (vetor[i].getChave() == vetor[i - 1].getChave()) {
                            if (vetor[i].numero < vetor[i - 1].numero) {
                                Cliente aux = vetor[i];
                                vetor[i] = vetor[i - 1];
                                vetor[i - 1] = aux;
                                i-=2;
                            }
                        }
                    }     
                    
                    final_milis = System.currentTimeMillis();
                    soma += final_milis - inicio_milis;
                    System.out.println(" -> Dessa vez: "+(final_milis - inicio_milis)+" inicio: "+inicio_milis);
                }
                
                String conteudo = "";
                
                for (int i = 0; i < vetor.length; i++) {
                   conteudo += vetor[i].toString() + "\n";
                }
                
                CriaArquivo.criaTxt("(QUICK)" + nome_vetor + ".txt", conteudo);
                
                String pesquisas = "Resultado pesquisas (" + nome_vetor + ")\n";

                for (int i = 0; i < LeArquivos.cliente_cpfs.length; i++) {
                    Cliente aux = PesquisaBinaria.pesqCpf(LeArquivos.cliente_cpfs[i], vetor);

                    if (aux != null) {
                       pesquisas += aux.toString() + "\n";
                    }
                }        

                CriaArquivo.criaTxt("(QUICK/PESQBIN)" + nome_vetor + ".txt", pesquisas);                
                
		return soma;
	}
    
	private static void ex13a17_controle() {
		System.out.println("começou");
		String medias = "Médias(em milissegundos)\n";
		
		medias += "\n50000 Elementos\n";
		medias += "Aleatório - "+exABB(LeArquivos.cliente50000alea, "ALEA50000")/4.0+"\n";
		medias += "Invertido - "+exABB(LeArquivos.cliente50000inv, "INV50000")/4.0+"\n";
		medias += "Ordenado - "+exABB(LeArquivos.cliente50000ord, "ORD50000")/4.0+"\n";
		
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

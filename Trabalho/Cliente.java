package Trabalho;

public class Cliente {
	long agencia;
	long numero;
	double saldo;
	Cpf cpf;


	public Cliente(long agencia, long numero, double saldo, Cpf cpf) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cpf = cpf;
	}
	
	public Cliente() {
		this.agencia = 0;
		this.numero = 0;
		this.saldo = 0;
		this.cpf = new Cpf(0);
	}
	
	public Cliente(String str) {
		String[] temp = str.split(";");
		this.agencia = Long.parseLong(temp[0]);
		this.numero = Long.parseLong(temp[1]);
		this.saldo = Double.parseDouble(temp[2]);
		this.cpf = new Cpf(Long.parseLong(temp[3]));
	}
	
	//Retorna o valor do Cpf (long)
	public long getChave() {
		return cpf.getCpf();
	}
	
	//Retorna o endereço do objeto Cpf
	public Cpf getCpf() {
		return cpf;
	}
	
	public long getNum() {
		return numero;
	}
	
	//Altera o objeto Cpf
	public void setCpf(Cpf cpf) {
		this.cpf = cpf;
	}
	
	public double getSaldo() {
        return saldo;
    }
	
	public long getAgencia() {
        return agencia;
    }
	
	
	
	@Override
	public String toString() {
		if(this.getChave()==0)
			return null;
		return "Cliente:\n"  
				+ "CPF: " + cpf.getCpf() + "\nAgencia: "+agencia
				+"\nConta: "+numero+"\nSaldo: "+saldo;
	}
	
	
	
}

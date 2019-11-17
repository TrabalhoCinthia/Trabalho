package Trabalho;

public class Cliente {
	long agencia;
	long numero;
	double saldo;
	long cpf;
	
	public Cliente(long agencia, long numero, double saldo, long cpf) {
		this.agencia = agencia;
		this.numero = numero;
		this.saldo = saldo;
		this.cpf = cpf;
	}
	
	public Cliente(String str) {
		String[] temp = str.split(";");
		this.agencia = Long.parseLong(temp[0]);
		this.numero = Long.parseLong(temp[1]);
		this.saldo = Double.parseDouble(temp[2]);
		this.cpf = Long.parseLong(temp[3]);
	}

	@Override
	public String toString() {
		return "Cliente [agencia=" + agencia + ", numero=" + numero + ", saldo=" + saldo + ", cpf=" + cpf + "]";
	}
	
	
	
}

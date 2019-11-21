package Trabalho;

public class NoArvore {
	private Cliente info;
	private NoArvore dir, esq;
	private byte fatorBalanceamento;
	
	public NoArvore (Cliente _info){
		this.info = _info;
	}
	
	public NoArvore getDir() {
		return dir;
	}
	public void setDir(NoArvore dir) {
		this.dir = dir;
	}
	public NoArvore getEsq() {
		return esq;
	}
	public void setEsq(NoArvore esq) {
		this.esq = esq;
	}
	public Cliente getInfo() {
		return info;
	}
	public void setInfo(Cliente novo) {
		this.info = novo;
	}
	public byte getFatorBalanceamento() {
                return this.fatorBalanceamento;
        }
        public void setFatorBalanceamento(byte fatorBalanceamento) {
                this.fatorBalanceamento = fatorBalanceamento;
        }

}

package bancoBanco;

import excecoes.NumeroContaInvalidoException;

public class ContaEspecial extends Conta{
	private static double BONUS = 0.1;
	public ContaEspecial(String numero) throws NumeroContaInvalidoException {
		super(numero);
	}
	
	public void renderBonus() {
		this.creditar(this.getSaldo()*BONUS);
	}
	
	public double getBonus() {
		return(this.getSaldo()*BONUS);
	}

}

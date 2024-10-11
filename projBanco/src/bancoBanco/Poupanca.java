package bancoBanco;

import excecoes.NumeroContaInvalidoException;

public class Poupanca extends Conta{
	private static double JUROS = 0.03;
	public Poupanca(String numero) throws NumeroContaInvalidoException{
		super(numero);
	}
	
	public void renderJuros() {
		this.creditar(this.getSaldo()*JUROS);
	}

}

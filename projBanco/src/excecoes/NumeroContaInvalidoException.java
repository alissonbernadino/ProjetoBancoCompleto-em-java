package excecoes;

public class NumeroContaInvalidoException extends Exception{
	public NumeroContaInvalidoException() {
		super("voce digitou um numero invalido para a conta\nvalido: xxxx-xx");
	}

}

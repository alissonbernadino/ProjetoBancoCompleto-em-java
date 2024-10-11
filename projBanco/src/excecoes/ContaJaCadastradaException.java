package excecoes;

public class ContaJaCadastradaException extends Exception{
	private String numero;
	public ContaJaCadastradaException(String numero) {
		super("a conta ja foi cadastrada: ");
		this.numero = numero;
	}
	
	public String getConta() {
		return this.numero;
	}

}

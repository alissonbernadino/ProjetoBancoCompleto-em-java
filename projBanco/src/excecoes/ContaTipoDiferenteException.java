package excecoes;

public class ContaTipoDiferenteException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ContaTipoDiferenteException() {
		super("O cast nao funcionou porque a conta nao eh desse tipo\n");
	}

}

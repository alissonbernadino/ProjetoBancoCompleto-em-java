package excecoes;

public class ContaInesistenteException extends Exception{
	public ContaInesistenteException() {
		super("Conta nao encontrada!\n");
	}

}

package excecoes;

public class SaldoInsuficienteException extends Exception{
	// excecao para saldo insuficiente
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double saldo;
	private String numero;
	public SaldoInsuficienteException(double saldo, String numero) {
		super("Saldo insuficiente!\n");
		this.numero = numero;
		this.saldo = saldo;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	public String getNumero() {
		return this.numero;
	}

}

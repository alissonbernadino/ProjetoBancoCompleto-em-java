package bancoBanco;
import excecoes.*;

public class Conta {
	private String numero;
	private double saldo;
	public Conta(String numero) throws NumeroContaInvalidoException{
		if(padraoCorretoString(numero)) {
			this.numero = numero;
			this.saldo = 0.0;
		}else {
			throw new NumeroContaInvalidoException();
		}
	}
	
	public void creditar(double saldo) {
		
		this.saldo += saldo;
	}
	
	public void debitar(double valor) throws SaldoInsuficienteException{
		if(this.saldo > valor) {
			this.saldo -= valor;
			}else {
			throw new SaldoInsuficienteException(this.saldo,this.numero);
			
			}
		}
	
	
	public String getConta() {
		return this.numero;
	}
	
	public double getSaldo() {
		return this.saldo;
	}
	
	private boolean padraoCorretoString(String numero) {
		return numero.matches("\\d{4}-\\d{2}"); // o \\d significa um digito de 0-9
	}
}

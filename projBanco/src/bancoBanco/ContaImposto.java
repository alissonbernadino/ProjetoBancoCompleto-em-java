package bancoBanco;
import excecoes.*;

public class ContaImposto extends Conta{
	private static double CPMF = 0.03;
	public ContaImposto(String numero) throws NumeroContaInvalidoException{
		super(numero);
	}
	
	public void debitar(double valor) throws SaldoInsuficienteException{
		double acrescimo = 0;
		acrescimo = valor*CPMF;
		super.debitar(valor+acrescimo);
	}
	
	

}

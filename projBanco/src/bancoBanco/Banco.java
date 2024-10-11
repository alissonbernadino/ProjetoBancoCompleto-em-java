package bancoBanco;
import bancoDados.*;
import excecoes.*; 


public class Banco {
	RepositorioContasArray repositorio;
	Conta contas;
	
	public Banco() {
		repositorio = new RepositorioContasArray();
	}
	
	public void cadastrar(Conta conta) throws ContaJaCadastradaException, NumeroContaInvalidoException{
		repositorio.inserir(conta);
	}
	
	public void creditar(String numero, double valor) throws ContaInesistenteException{
		this.contas = repositorio.procurar(numero);
		this.contas.creditar(valor); // isso funcionará porque contas referencia o msm valor do vetor do repositorio.

	}
	
	public String getConta(String numero) throws ContaInesistenteException{
		this.contas = repositorio.procurar(numero); // por causa da excecao, nao precisa mais ver se tem a conta
		return contas.getConta();
	}
	
	public void renderJuros(String numero)  throws ContaInesistenteException, ContaTipoDiferenteException{
		this.contas = repositorio.procurar(numero);
			if(this.contas instanceof Poupanca) {
				((Poupanca)this.contas).renderJuros();
			}else throw new ContaTipoDiferenteException();
	}
	
	public void renderBonus(String numero) throws ContaInesistenteException,ContaTipoDiferenteException{
		this.contas = repositorio.procurar(numero);
			if(this.contas instanceof ContaEspecial) {
				((ContaEspecial)this.contas).renderBonus();
			}else throw new ContaTipoDiferenteException();
	}
	
	
	
	public void debitar(String numero, double valor) throws ContaInesistenteException, SaldoInsuficienteException{
		this.contas = repositorio.procurar(numero);
		if(this.contas != null) {
			this.contas.debitar(valor); // isso funcionará porque contas referencia o msm valor do vetor do repositorio.
		}
	}
	
	public double getSaldo(String numero) throws ContaInesistenteException{
		this.contas = repositorio.procurar(numero);
		if(this.contas != null) {
			return contas.getSaldo();
		}
		return 0;
	}
	
	public void transferir(String numero1, String numero, double valor) throws ContaInesistenteException, SaldoInsuficienteException{
		this.contas = repositorio.procurar(numero1);
		Conta temp = repositorio.procurar(numero);
		if(this.contas != null && temp != null) {
			this.contas.debitar(valor);
			temp.creditar(valor);
		}
	}
	
	public void mostrar() {
		repositorio.mostrar();
}
}

	

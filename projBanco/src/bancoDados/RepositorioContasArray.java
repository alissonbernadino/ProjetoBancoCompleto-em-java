package bancoDados;
import excecoes.*;
import bancoBanco.Conta;


public class RepositorioContasArray implements RepositorioContas{
	private Conta[] contas;
	private int indice;
	
	public RepositorioContasArray() {
		this.contas = new Conta[100];
		this.indice = 0;
	}

	@Override
	public void inserir(Conta conta) throws ContaJaCadastradaException {
		for(int i=0;i<indice;i++) {
			if(contas[i].getConta().equals(conta.getConta())) {
				throw new ContaJaCadastradaException(conta.getConta());
			}
		}
		this.contas[indice] = conta;
		this.indice++;
	}

	@Override
	public Conta procurar(String numero) throws ContaInesistenteException{
		for(int i=0;i<indice;i++) {
			if(contas[i].getConta().equals(numero)) {
				return contas[i];
			
			}
		} throw new ContaInesistenteException();
	}

	@Override
	public void remover(String numero) throws ContaInesistenteException{
		int indice = -1;
		for(int i=0;i<this.indice;i++) {
			if(this.contas[i].getConta().equals(numero)) {
				indice = i;
			}
		}
		if(indice == -1) {
			throw new ContaInesistenteException();
		}else {
			this.contas[indice] = null;
			this.contas = preencher(this.indice,this.contas,indice);
		}
		
	}


	@Override
	public void atualizar(String numero, Conta novaConta) throws ContaInesistenteException {
		Conta temp;
		temp = procurar(numero);
		temp = novaConta;
	}

	@Override
	public boolean existe(String numero) throws ContaInesistenteException{
		Conta temp = procurar(numero);
		if(temp == null) {
			return false;
		}else {
			return true;
		}
	}
	
	private Conta[] preencher(int indice, bancoBanco.Conta[] contas, int comeco) {
		if(comeco == indice-1) {
			return contas;
		}else {
			contas[comeco] = contas[comeco+1];
			preencher(indice,contas,comeco+1);
			return contas;
		}
		
	}
	
	public void mostrar() {
		for(int i=0;i<contas.length;i++) {
			if(contas[i]!=null) {
			System.out.printf("\nnumero: %s\nvalor: %.2f\n",contas[i].getConta(), contas[i].getSaldo());
			}
		}
	}

}






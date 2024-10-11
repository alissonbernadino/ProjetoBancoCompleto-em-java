package bancoDados;
import bancoBanco.*;
import excecoes.ContaInesistenteException;
import excecoes.ContaJaCadastradaException;

public interface RepositorioContas {
	public void inserir(Conta conta) throws ContaJaCadastradaException;
	public Conta procurar(String numero) throws ContaInesistenteException;
	public void remover(String numero) throws ContaInesistenteException;
	public void atualizar(String numero, Conta novaConta) throws ContaInesistenteException;
	public boolean existe(String numero) throws ContaInesistenteException;
}

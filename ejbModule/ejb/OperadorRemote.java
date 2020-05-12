package ejb;

import javax.ejb.Remote;

import cadastro.Operador;

@Remote
public interface OperadorRemote {
	public Operador salvar(Operador p) throws Exception;

	public Operador consultarPorId(Long id);
	
	public void remover(Long id);

}

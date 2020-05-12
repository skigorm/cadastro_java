package ejb;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import cadastro.Operador;
import dao.OperadorDAO;


@Stateless
public class OperadorBean implements OperadorRemote {
	
	@PersistenceContext(unitName="OperadorPU")
	private EntityManager em;

	@Override
	public Operador salvar(Operador p) throws Exception {
		OperadorDAO dao = new OperadorDAO(em);
		return dao.salvar(p);
	}

	@Override
	public Operador consultarPorId(Long id) {
		OperadorDAO dao = new OperadorDAO(em);
		return dao.consultarPorId(id);
	}

	@Override
	public void remover(Long id) {
		OperadorDAO dao = new OperadorDAO(em);
		dao.remover(id);
	}

}

package dao;

import javax.persistence.EntityManager;

import cadastro.Operador;

public class OperadorDAO {
	
	private EntityManager em;
	
	public OperadorDAO(EntityManager em) {
		this.em = em;
	}
	
	public Operador salvar(Operador p) throws Exception {
		if(p.getId() == null) {			
			em.persist(p);
		} else {
			if(!em.contains(p)) {
				if(em.find(Operador.class, p.getId()) == null) {
					throw new Exception("Erro ao atualizar dados");
				}
			}
			p = em.merge(p);
		}
		
		return p;
	}
	
	public Operador consultarPorId(Long id) {
		return em.find(Operador.class, id);
	}
	
	public void remover(Long id) {
		Operador p = consultarPorId(id);
		em.remove(p);
	}
}

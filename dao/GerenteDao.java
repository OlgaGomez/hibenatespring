package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.edu.facitec.hibernatespringtaller.model.Gerente;

public class GerenteDao extends DaoGenerico<Gerente>{
	
	
	public GerenteDao (){
		super(Gerente.class);
	}
	@PersistenceContext
	private EntityManager  manager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	/*public void save(Gerente gerente){
		
		manager.persist(gerente);
		
	}*/
	
	
}

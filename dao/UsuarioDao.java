package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.edu.facitec.hibernatespringtaller.model.Usuario;

public class UsuarioDao extends DaoGenerico<Usuario> {
	
	public UsuarioDao (){
		super(Usuario.class);
	}
	@PersistenceContext
	private EntityManager  manager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	/*public void save(Usuario usuario){
		
		manager.persist(usuario);
		
	}*/
	
	

}

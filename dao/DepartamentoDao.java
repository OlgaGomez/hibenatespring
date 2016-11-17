package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.edu.facitec.hibernatespringtaller.model.Departamento;

public class DepartamentoDao extends DaoGenerico<Departamento>{
	


		
		
		public  DepartamentoDao() {
			super(Departamento.class);
		}

		@PersistenceContext
		private EntityManager  manager;

		@Override
		protected EntityManager getEntityManager() {
			// TODO Auto-generated method stub
			return manager;
		}
		
		
		/*public void save(departamento departamento){
			
			manager.persist(departamento);
			
		}*/
		
		
		
		
}

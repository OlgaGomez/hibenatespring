package py.edu.facitec.hibernatespringtaller.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import py.edu.facitec.hibernatespringtaller.model.ItemPedido;

public class ItemPedidoDao extends DaoGenerico<ItemPedido>{
	
	public ItemPedidoDao (){
		super(ItemPedido.class);
	}
	@PersistenceContext
	private EntityManager  manager;

	@Override
	protected EntityManager getEntityManager() {
		// TODO Auto-generated method stub
		return manager;
	}
	
	
	/*public void save(ItemPedido itemPedido){
		
		manager.persist(itemPedido);
		
	}*/
	
	
}

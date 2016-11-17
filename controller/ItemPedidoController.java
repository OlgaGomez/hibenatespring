package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.ItemPedidoDao;
import py.edu.facitec.hibernatespringtaller.model.ItemPedido;


@Transactional
@Controller

@RequestMapping("/itemPedido")
public class ItemPedidoController {
	//injecta una dependencia
		@Autowired
		private ItemPedidoDao itemPedidoDao;
		
		@RequestMapping(method=RequestMethod.POST)
		              //save: vienen los datos del formulario y se pasan a objeto
		public String save (ItemPedido itemPedido){
			itemPedidoDao.guardar(itemPedido,itemPedido.getId());
			System.out.println("Registrando el cliente"+itemPedido);
			
			        //crea la pagina ok.jsp
			return "/itemPedido/ok";
		}
		
						//responde a cliente/formulario
		@RequestMapping(value="/formulario",method=RequestMethod.GET) 
		public String formulario(){
			return "/itemPedido/formulario";
		}

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView getLista(){
			//objeto encargado de responder una petición
			ModelAndView model=new ModelAndView("/itemPedido/lista");
			
			model.addObject("itemPedido", itemPedidoDao.buscarTodos());
			
			return model;
		}
		
		
}

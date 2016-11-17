package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import py.edu.facitec.hibernatespringtaller.dao.ProductoDAO;

import py.edu.facitec.hibernatespringtaller.model.Producto;

@Transactional
@Controller

@RequestMapping("/producto")
public class ProductoController {
	//injecta una dependencia
		@Autowired
		private ProductoDAO productoDao;
		
		@RequestMapping(method=RequestMethod.POST)
		              //save: vienen los datos del formulario y se pasan a objeto
		public String save (Producto producto){
			productoDao.guardar(producto,producto.getId());
			System.out.println("Registrando el producto"+producto);
			
			        //crea la pagina ok.jsp
			return "/producto/ok";
		}
		
						//responde a producto/formulario
		@RequestMapping(value="/formulario",method=RequestMethod.GET) 
		public String formulario(){
			return "/producto/formulario";
		}

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView getLista(){
			//objeto encargado de responder una petición
			ModelAndView model=new ModelAndView("/producto/lista");
			
			model.addObject("producto", productoDao.buscarTodos());
			
			return model;
		}
		
		
}

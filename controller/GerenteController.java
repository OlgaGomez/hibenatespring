package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


import py.edu.facitec.hibernatespringtaller.dao.GerenteDao;

import py.edu.facitec.hibernatespringtaller.model.Gerente;

//gestiona transasiones
@Transactional
@Controller

@RequestMapping("/gerente")
public class GerenteController {
	//injecta una dependencia
		@Autowired
		private GerenteDao gerenteDao;
		
		@RequestMapping(method=RequestMethod.POST)
		              //save: vienen los datos del formulario y se pasan a objeto
		public String save (Gerente gerente){
			gerenteDao.guardar(gerente,gerente.getId());
			System.out.println("Registrando el gerente"+gerente);
			
			        //crea la pagina ok.jsp
			return "/gerente/ok";
		}
		
						//responde a gerente/formulario
		@RequestMapping(value="/formulario",method=RequestMethod.GET) 
		public String formulario(){
			return "/gerente/formulario";
		}

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView getLista(){
			//objeto encargado de responder una petición
			ModelAndView model=new ModelAndView("/gerente/lista");
			
			model.addObject("gerente",gerenteDao.buscarTodos());
			
			return model;
		}
		
		
		

}

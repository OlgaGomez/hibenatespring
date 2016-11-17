package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.DepartamentoDao;
import py.edu.facitec.hibernatespringtaller.model.Departamento;


//gestiona transasiones
@Transactional
@Controller

@RequestMapping("/departamento")

public class DepartamentoController {
	//injecta una dependencia
		@Autowired
		private DepartamentoDao departamentoDao;
		
		@RequestMapping(method=RequestMethod.POST)
		              //save: vienen los datos del formulario y se pasan a objeto
		public String save (Departamento departamento){
			departamentoDao.guardar(departamento,departamento.getId());
			System.out.println("Registrando el Departamento"+departamento);
			
			        //crea la pagina ok.jsp
			return "/departamento/ok";
		}
		
						//responde a cliente/formulario
		@RequestMapping(value="/formulario",method=RequestMethod.GET) 
		public String formulario(){
			return "/departamento/formulario";
		}

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView getLista(){
			//objeto encargado de responder una petición
			ModelAndView model=new ModelAndView("/departamento/lista");
			
			model.addObject("departamento", departamentoDao.buscarTodos());
			
			return model;
		}
		
		
}

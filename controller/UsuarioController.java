package py.edu.facitec.hibernatespringtaller.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import py.edu.facitec.hibernatespringtaller.dao.UsuarioDao;
import py.edu.facitec.hibernatespringtaller.model.Usuario;



//gestiona transasiones
@Transactional
@Controller

@RequestMapping("usuario")
public class UsuarioController {
	//injecta una dependencia
		@Autowired
		private UsuarioDao usuarioDao;
		
		@RequestMapping(method=RequestMethod.POST)
		              //save: vienen los datos del formulario y se pasan a objeto
		public String save (Usuario usuario){
			usuarioDao.guardar(usuario,usuario.getName());
			System.out.println("Registrando el usuario "+usuario);
			
			        //crea la pagina ok.jsp
			return "/usuario/ok";
		}
		
						//responde a cliente/formulario
		@RequestMapping(value="/formulario",method=RequestMethod.GET) 
		public String formulario(){
			return "/usuario/formulario";
		}

		@RequestMapping(method=RequestMethod.GET)
		public ModelAndView getLista(){
			//objeto encargado de responder una petición
			ModelAndView model=new ModelAndView("/usuarios/lista");
			
			model.addObject("cliente", usuarioDao.buscarTodos());
			
			return model;
		}
		
		
		
}

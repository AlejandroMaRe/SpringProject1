package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {

		@RequestMapping(value= {"/index","/","/home"}, method=RequestMethod.GET)
		public String index(Model model) {
			model.addAttribute("titulo","Hola en spring framework con model");
			return "index";
		}
		
		@GetMapping("/perfil")
		public String perfil(Model model) {
			Usuario usuario = new Usuario();
			usuario.setNombre("Alejandro");
			usuario.setApellido("Martínez");
			usuario.setEmail("ale@gmail.com");
			model.addAttribute("usuario", usuario);
			
			return "perfil";
		}
		
		@GetMapping("/listar")
		public String listar(Model model) {
			
			model.addAttribute("Titulo", "listado de usuarios");
			return "listar";
		}
		
		@ModelAttribute("usuarios")
		public List<Usuario> poblarUsuarios(){
			List<Usuario> usuarios = new ArrayList<>();
			usuarios.add(new Usuario("ALEJANDRO","MARTINEZ","@"));
			usuarios.add(new Usuario("rosa","reyes","@gmail"));
			usuarios.add(new Usuario("jorge","gomez","@outlook"));
			return usuarios;
		}
}

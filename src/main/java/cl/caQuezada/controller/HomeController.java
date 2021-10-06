package cl.caQuezada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;

import cl.caQuezada.service.LibroService;
import cl.caQuezada.vo.LibroVO;

@Controller
public class HomeController {

	@Autowired
	private LibroService libroService;
	
	@PostMapping("/home")
	public String home(ModelMap modelMap) {
		LibroVO librosVO = libroService.getAllLibros();
		modelMap.addAttribute("librosVO", librosVO);
		return "index";
	}
}

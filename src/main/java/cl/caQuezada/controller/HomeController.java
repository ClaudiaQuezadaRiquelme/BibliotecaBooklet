package cl.caQuezada.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import cl.caQuezada.model.Libro;
import cl.caQuezada.service.LibroService;
import cl.caQuezada.vo.LibroVO;

@Controller
public class HomeController {

	@Autowired
	LibroService libroService;
	
	@GetMapping({"/","/home"})
	public String home(ModelMap modelMap) {
		LibroVO librosVO = libroService.getAllLibros();
		modelMap.addAttribute("librosVO", librosVO);
		return "index";
	}
	
	@PostMapping("/addLibro")
	public ModelAndView addLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		LibroVO librosVO = libroService.add(libro);
		modelMap.addAttribute("librosVO", librosVO);
		return new ModelAndView("redirect:/");
	}
	
	@GetMapping({"/deleteLibro"})
	public ModelAndView deleteLibro(ModelMap modelMap, @RequestParam String id_libro) {
		Libro libroEliminado = new Libro();
		libroEliminado.setId_libro(Integer.parseInt(id_libro));
		libroService.delete(libroEliminado);
		return new ModelAndView("redirect:/");
	}
	
	@PostMapping("/findByTituloAndAutor")
	public String findByTituloAndAutor(
			ModelMap modelMap, 
			@RequestParam String titulo, String autor) {
		LibroVO librosVO = libroService.findByTituloAndAutor(titulo, autor);
		modelMap.addAttribute("librosVO", librosVO);
		return "index";
	}
	
	@RequestMapping("/findByIdLibro")
	public String findByIdLibro(ModelMap modelMap, @RequestParam String id_libro) {
		LibroVO libroVO = libroService.findById(Integer.parseInt(id_libro));
		modelMap.addAttribute("libroVO", libroVO.getLibros().get(0));
		return "edit";
	}
	
	@PostMapping("/editLibro")
	public ModelAndView editLibro(ModelMap modelMap, @ModelAttribute("libro") Libro libro) {
		LibroVO librosVO = libroService.update(libro);
		modelMap.addAttribute("librosVO", librosVO);
		return new ModelAndView("redirect:/");
	}
}

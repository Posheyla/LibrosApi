package com.codingdojo.controladores;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.modelos.Libro;
import com.codingdojo.servicios.ServicioLibro;

@Controller
public class ControladorLibros {
	private final ServicioLibro servicioLibro;
	public ControladorLibros (ServicioLibro servicioLibro) {
		this.servicioLibro = servicioLibro;
	}
	
    
	@RequestMapping("/api/libros")
	public String inicio(){
		return "index.jsp";
	}
	
	@RequestMapping("/libros")
	public String index(Model model) {
		List<Libro> listaLibros = servicioLibro.allLibros();
		model.addAttribute("listaLibros",listaLibros);
        return "libros.jsp";
    }
	
	@RequestMapping(value="/api/libros", method=RequestMethod.POST)
    public String create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Libro libro = new Libro(title, desc, lang, numOfPages);
		servicioLibro.createLibro(libro);
        return "redirect:/libros";
    }
    
    @RequestMapping("/libros/{id}")
    public String show(@PathVariable("id") Long id, Model model) {
    	Libro libro = servicioLibro.findLibro(id);
    	model.addAttribute("libro", libro);
        return "mostrar.jsp";
    }
    
    @RequestMapping(value="/api/libros/{id}", method=RequestMethod.PUT)
    public Libro update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Libro libro = servicioLibro.updateBook(id, title, desc, lang, numOfPages);
        return libro;
    }
    
    @RequestMapping(value="/api/libros/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	servicioLibro.deleteBook(id);
    }
}

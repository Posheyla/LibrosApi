package com.codingdojo.controladores;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.modelos.Libro;
import com.codingdojo.servicios.ServicioLibro;

@RestController
public class ControladorLibros {
	private final ServicioLibro servicioLibro;
	public ControladorLibros (ServicioLibro servicioLibro) {
		this.servicioLibro = servicioLibro;
	}
	
    
	@RequestMapping("/api/libros")
	public List<Libro> inicio(){
		return servicioLibro.allLibros();
	}
	
	@RequestMapping(value="/api/libros", method=RequestMethod.POST)
    public Libro create(@RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
		Libro libro = new Libro(title, desc, lang, numOfPages);
        return servicioLibro.createLibro(libro);
    }
    
    @RequestMapping("/api/books/{id}")
    public Libro show(@PathVariable("id") Long id) {
    	Libro libro = servicioLibro.findLibro(id);
        return libro;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.PUT)
    public Libro update(@PathVariable("id") Long id, @RequestParam(value="title") String title, @RequestParam(value="description") String desc, @RequestParam(value="language") String lang, @RequestParam(value="pages") Integer numOfPages) {
        Libro libro = servicioLibro.updateBook(id, title, desc, lang, numOfPages);
        return libro;
    }
    
    @RequestMapping(value="/api/books/{id}", method=RequestMethod.DELETE)
    public void destroy(@PathVariable("id") Long id) {
    	servicioLibro.deleteBook(id);
    }
}

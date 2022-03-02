package com.codingdojo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Libro;
import com.codingdojo.repositorios.RepositorioLibro;

@Service
public class ServicioLibro {

		private final RepositorioLibro repositorioLibro;
		
		public ServicioLibro (RepositorioLibro repositorioLibro) {
			this.repositorioLibro = repositorioLibro;
		}
		
		public List<Libro> allLibros(){
			return repositorioLibro.findAll();
		}
		
		public Libro createLibro (Libro b) {
			return repositorioLibro.save(b);
		}
		
		public Libro findLibro(Long id) {
			Optional<Libro> optionalLibro = repositorioLibro.findById(id);
			if(optionalLibro.isPresent()) {
				return optionalLibro.get();
			}
			else {
				return null;
			}
		}
		
		public Libro updateBook(Long id, String title, String desc, String lang, Integer numOfPages) {
			Optional<Libro> optionalLibro = repositorioLibro.findById(id);
			Libro libro = optionalLibro.get();
			libro.setId(id);
			libro.setTitle(title);
			libro.setDescription(desc);
			libro.setLanguage(lang);
			libro.setNumberOfPages(numOfPages);
			
			return repositorioLibro.save(libro);
			
			
		}
		
		public void deleteBook(Long id) {
			repositorioLibro.deleteById(id);
		}
}

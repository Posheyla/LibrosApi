package com.codingdojo.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Libro;

@Repository
public interface RepositorioLibro extends CrudRepository<Libro, Long>{

		List<Libro> findAll();
		List<Libro> findByDescriptionContaining(String search);
		Long countByTitleContaining(String search);
		Long deleteByTitleStartingWith(String search);
		
}

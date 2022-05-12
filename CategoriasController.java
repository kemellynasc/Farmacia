package com.farmacia.farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.farmacia.Model.Categoria;
import com.farmacia.farmacia.repository.CategoriaRepository;


@RestController
@RequestMapping("/categoria")
@CrossOrigin  ("*")
public interface CategoriasController {

	 
		@Autowired
		public CategoriaRepository repository;
		
		@GetMapping
		public ResponseEntity<List<Categoria>> getAll(){
			return ResponseEntity.ok(repository.findAll());
		}

		@GetMapping("/{id}")
		public ResponseEntity<Categoria> GetById(@PathVariable Long id){
			return repository.findById(id)
					.map(resp -> ResponseEntity.ok(resp))
					.orElse(ResponseEntity.notFound().build());
		}
		
		@GetMapping("/titulo/{titulo}")
		public ResponseEntity<Object>GetByTitulo(@PathVariable String Titulo){
			return ResponseEntity.ok(repository.findAllTituloContainigIgnoreCase(Titulo));
		}
		
}

package com.farmacia.farmacia.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farmacia.farmacia.Model.Medicamentos_;
import com.farmacia.farmacia.repository.MedicamentoRepository;

@RestController
@RequestMapping("/medicamento")
@CrossOrigin  ("*")
public class MedicamentosController {
 
	@Autowired
	public MedicamentoRepository repository;
	
	@GetMapping
	public ResponseEntity<List<Medicamentos_>> getAll(){
		return ResponseEntity.ok(repository.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Medicamentos_> GetById(@PathVariable Long id){
		return repository.findById(id)
				.map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/titulo/{titulo}")
	public ResponseEntity<Object> GetByTitulo(@PathVariable String Titulo){
		return ResponseEntity.ok(repository.findAllTituloContainigIgnoreCase(Titulo));
	}
	
}

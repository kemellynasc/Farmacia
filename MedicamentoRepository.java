package com.farmacia.farmacia.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import com.farmacia.farmacia.Model.Medicamentos_;

public interface MedicamentoRepository extends JpaRepository<Medicamentos_, Long>{

	public List<Medicamentos_> findAllByNomeContainingIgnoreCase(@Param("nome") 
	String nome);

	public Object findAllTituloContainigIgnoreCase(String titulo);
}

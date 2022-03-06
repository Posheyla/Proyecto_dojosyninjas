package com.codingdojo.respositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Ninja;

@Repository
public interface RepositorioNinja extends CrudRepository<Ninja,Long>{
	List<Ninja> findAll();
	
	//	INSERT INTO usuarios()
	// VALUES()
	@SuppressWarnings("unchecked")
	Ninja save(Ninja nuevoNinja);
	 
	
	List<Ninja> findByNombres(String nombres);
}

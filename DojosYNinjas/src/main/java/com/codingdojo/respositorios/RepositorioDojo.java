package com.codingdojo.respositorios;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.modelos.Dojo;

@Repository
public interface RepositorioDojo extends CrudRepository<Dojo,Long>{
	List<Dojo> findAll();
	
	//	INSERT INTO usuarios()
	// VALUES()
	@SuppressWarnings("unchecked")
	Dojo save(Dojo nuevoDojo);
	 
	
	List<Dojo> findByNombre(String nombre);
}

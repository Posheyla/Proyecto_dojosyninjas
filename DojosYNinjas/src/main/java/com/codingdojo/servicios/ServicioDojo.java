package com.codingdojo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.respositorios.RepositorioDojo;

@Service
public class ServicioDojo {
private final RepositorioDojo repositorioDojo;
	
	public ServicioDojo(RepositorioDojo repositorio) {
		this.repositorioDojo = repositorio;
	}
	
	public List<Dojo> selectAllFromDojos(){
		return repositorioDojo.findAll();
	}
	
	public Dojo insertIntoDojos( Dojo nuevoDojo) {
		return repositorioDojo.save(nuevoDojo);
	}
	
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = repositorioDojo.findById(id);
		if(optionalDojo.isPresent()) {
			return optionalDojo.get();
		}
		else {
			return null;
		}
	}
}

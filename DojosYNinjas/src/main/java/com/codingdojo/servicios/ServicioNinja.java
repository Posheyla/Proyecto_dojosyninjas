package com.codingdojo.servicios;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingdojo.modelos.Dojo;
import com.codingdojo.modelos.Ninja;
import com.codingdojo.respositorios.RepositorioDojo;
import com.codingdojo.respositorios.RepositorioNinja;

@Service
public class ServicioNinja {
	private final RepositorioNinja repositorioNinja;
	
	public ServicioNinja(RepositorioNinja repositorio) {
		this.repositorioNinja = repositorio;
	}
	
	public List<Ninja> selectAllFromNinjas(){
		return repositorioNinja.findAll();
	}
	
	public Ninja insertIntoNinjas( Ninja nuevoNinja) {
		return repositorioNinja.save(nuevoNinja);
	}
	
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = repositorioNinja.findById(id);
		if(optionalNinja.isPresent()) {
			return optionalNinja.get();
		}
		else {
			return null;
		}
	}
}

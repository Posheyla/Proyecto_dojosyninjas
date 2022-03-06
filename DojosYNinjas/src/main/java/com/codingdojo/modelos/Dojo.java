package com.codingdojo.modelos;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="dojos")
public class Dojo {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dojo_id;
    @NotNull
    @Size(min =4, max = 30, message = "El nombre debe ser mayor a 3 letras")
    private String nombre;
    
    @OneToMany(mappedBy="dojo", fetch = FetchType.LAZY)
    private List<Ninja> ninjas;
    
    public Dojo() {
        
    }

	public Dojo(Long dojo_id, @NotNull String nombre, List<Ninja> ninjas) {
		this.dojo_id = dojo_id;
		this.nombre = nombre;
		this.ninjas = ninjas;
	}

	public Long getDojo_id() {
		return dojo_id;
	}

	public void setDojo_id(Long dojo_id) {
		this.dojo_id = dojo_id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Ninja> getNinjas() {
		return ninjas;
	}

	public void setNinjas(List<Ninja> ninjas) {
		this.ninjas = ninjas;
	}
	
}

package com.codingdojo.modelos;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name="ninjas")
public class Ninja {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull 
    @Size(min =4, max = 30, message = "El nombre debe tene entre 4 y 30 caracteres")
    private String nombres;
    @NotNull 
    @Size(min =4, max = 30, message = "El apellido debe tene entre 4 y 30 caracteres")
    private String apellidos;
    @NotNull 
    private int edad;
    
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="dojo_id")
    private Dojo dojo;
    
    public Ninja() {
        
    }

	public Ninja(Long id, String nombres, String apellidos, int edad, Dojo dojo) {
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.edad = edad;
		this.dojo=dojo;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Dojo getDojo() {
		return dojo;
	}

	public void setDojo(Dojo dojo) {
		this.dojo = dojo;
	}
	
    
}
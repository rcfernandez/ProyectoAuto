package ar.edu.unlam.tallerweb1.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="Marca")
public class Marca {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;

	
	// RELACIONES	
	@OneToMany(mappedBy="marca")
	private List<Modelo> modelo = new ArrayList<>();
	
	
	
	// CONSTRUCTORES
	public Marca() {
	}


	public Marca(String nombre, List<Modelo> modelo) {
		this.nombre = nombre;
		this.modelo = modelo;
	}


	// GETTERS SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public List<Modelo> getModelo() {
		return modelo;
	}


	public void setModelo(List<Modelo> modelo) {
		this.modelo = modelo;
	}

	

	
	
	
	

	
	
		
}
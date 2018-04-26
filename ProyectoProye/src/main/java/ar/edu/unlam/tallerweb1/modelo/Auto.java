package ar.edu.unlam.tallerweb1.modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="Auto")
public class Auto {


		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="id")
		private Long id;
		
		@Column(name="color")
		private String color;
		
		@Column(name="patente")
		private String patente;
		
		// RELACIONES
		@OneToOne(mappedBy="auto")
		private Modelo modelo;
		
		
		// CONSTRUCTORES
		public Auto() {
		}
		
		
		public Auto(Long id, String color, String patente, Modelo modelo) {
			this.id = id;
			this.color = color;
			this.patente = patente;
			this.modelo = modelo;
		}







		// GETTERS SETTERS


		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}

		
		public String getColor() {
			return color;
		}
		
		public void setColor(String color) {
			this.color = color;
		}


		public String getPatente() {
			return patente;
		}


		public void setPatente(String patente) {
			this.patente = patente;
		}


		public Modelo getModelo() {
			return modelo;
		}


		public void setModelo(Modelo modelo) {
			this.modelo = modelo;
		}

		


		
		
		
		
		
		
}
package ar.edu.unlam.tallerweb1.persistencia;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.SpringTest;
import ar.edu.unlam.tallerweb1.modelo.Auto;
import ar.edu.unlam.tallerweb1.modelo.Marca;
import ar.edu.unlam.tallerweb1.modelo.Modelo;


/*

TAREA
------
1. buscar autos azules.
2. buscar auto por patente (unico resultado).
3a. buscar autos de modelo "Clio" por nombre del modelo.
3b. buscar autos de modelo "Clio" por modelo directamente.
4. buscar todos los autos de marca "Fiat".

*/

public class AutoTest extends SpringTest {

	
	// 1. buscar autos azules.
	@Test
	@Transactional
	@Rollback
	public void testBuscarAutosAzules() {
		
		Auto auto1 = new Auto();
		auto1.setColor("Azul");
		auto1.setPatente("ABC123");
		getSession().save(auto1);
		
		Auto auto2 = new Auto();
		auto2.setColor("Rojo");
		auto2.setPatente("XYZ987");
		getSession().save(auto2);
		
		Auto auto3 = new Auto();
		auto3.setColor("Azul");
		auto3.setPatente("GHI456");
		getSession().save(auto3);

		
		List<?> resultado = getSession().createCriteria(Auto.class)
							.add(Restrictions.eq("color", "Azul"))
							.list();
		
		assertThat(resultado).hasSize(2);
		
	}
	
	
	// 2. buscar auto por patente (unico resultado).
	@Test
	@Transactional
	@Rollback
	public void testBuscarAutoPorPatente() {
		
		Auto auto1 = new Auto();
		auto1.setColor("Azul");
		auto1.setPatente("ABC123");
		getSession().save(auto1);
		
		Auto auto2 = new Auto();
		auto2.setColor("Rojo");
		auto2.setPatente("XYZ987");
		getSession().save(auto2);
		
		Auto auto3 = new Auto();
		auto3.setColor("Azul");
		auto3.setPatente("GHI456");
		getSession().save(auto3);
		
	
		
		Object resultado = getSession().createCriteria(Auto.class)
							.add(Restrictions.eq("patente", "ABC123"))
							.uniqueResult();
						
		
		assertThat(resultado).isNotNull(); 
		
	}
	
	
	
	// 3a. buscar autos de modelo "Clio" por nombre del modelo.
	@Test
	@Transactional
	@Rollback
	public void testBuscarAutosClioPorNombreDelModelo() {
		
		
		Auto auto1 = new Auto();
		auto1.setColor("Azul");
		auto1.setPatente("ABC123");
		getSession().save(auto1);
		
		Auto auto2 = new Auto();
		auto2.setColor("Rojo");
		auto2.setPatente("XYZ987");
		getSession().save(auto2);
		
		Auto auto3 = new Auto();
		auto3.setColor("Negro");
		auto3.setPatente("GHI456");
		getSession().save(auto3);
		
		
		
		Modelo modelo1 = new Modelo();
		modelo1.setNombre("Clio");
		modelo1.setAuto(auto1);
		getSession().save(modelo1);
		
		Modelo modelo2 = new Modelo();
		modelo2.setNombre("Sandero");
		modelo2.setAuto(auto2);
		getSession().save(modelo2);
		
		Modelo modelo3 = new Modelo();
		modelo3.setNombre("Clio");
		modelo3.setAuto(auto3);
		getSession().save(modelo3);
		
		
		List<?> resultado = getSession().createCriteria(Auto.class)
				.createAlias("modelo", "modeloBuscado")
				.add(Restrictions.eq("modeloBuscado.nombre", "Clio"))
				.list();

		assertThat(resultado).hasSize(2); 
		
	}
	
	
	// 3b. buscar autos de modelo "Clio" por modelo directamente.
	@Test
	@Transactional
	@Rollback
	public void testBuscarAutosClioPorModeloDirectamente() {
		
		
		Auto auto1 = new Auto();
		auto1.setColor("Azul");
		auto1.setPatente("ABC123");
		getSession().save(auto1);
		
		
		Auto auto2 = new Auto();
		auto2.setColor("Rojo");
		auto2.setPatente("XYZ987");
		getSession().save(auto2);
		
		Auto auto3 = new Auto();
		auto3.setColor("Negro");
		auto3.setPatente("GHI456");
		getSession().save(auto3);
		
		
		
		Modelo modelo1 = new Modelo();
		modelo1.setNombre("Clio");
		modelo1.setAuto(auto1);
		getSession().save(modelo1);
		
		Modelo modelo2 = new Modelo();
		modelo2.setNombre("Sandero");
		modelo2.setAuto(auto2);
		getSession().save(modelo2);
		
		Modelo modelo3 = new Modelo();
		modelo3.setNombre("Clio");
		modelo3.setAuto(auto3);
		getSession().save(modelo3);
		
		
		List<?> resultado = getSession().createCriteria(Modelo.class)
				.add(Restrictions.eq("nombre", "Clio"))
				.list();

		assertThat(resultado).hasSize(2);
		
	}
	
	
	
	// 4. buscar todos los autos de marca "Fiat".
	@Test
	@Transactional
	@Rollback
	public void testBuscarAutosMarcaFiat() {
		
		
		Marca marca1 = new Marca();
		marca1.setNombre("Renault");
		getSession().save(marca1);
		
		Marca marca2 = new Marca();
		marca2.setNombre("Fiat");
		getSession().save(marca2);
		
	
		
		Auto auto1 = new Auto();
		auto1.setColor("Azul");
		auto1.setPatente("ABC123");
		getSession().save(auto1);
		
		Auto auto2 = new Auto();
		auto2.setColor("Rojo");
		auto2.setPatente("XYZ987");
		getSession().save(auto2);		
		
		Auto auto3 = new Auto();
		auto3.setColor("Azul");
		auto3.setPatente("GHI456");
		getSession().save(auto3);
		
		
		
		Modelo modelo1 = new Modelo();
		modelo1.setNombre("Clio");
		modelo1.setMarca(marca1);	// renault
		modelo1.setAuto(auto1);
		getSession().save(modelo1);
		
		Modelo modelo2 = new Modelo();
		modelo2.setNombre("Uno");
		modelo2.setMarca(marca2);	// fiat
		modelo2.setAuto(auto2);
		getSession().save(modelo2);
		
		Modelo modelo3 = new Modelo();
		modelo3.setNombre("Sandero");
		modelo3.setMarca(marca1);	// renault
		modelo3.setAuto(auto3);
		getSession().save(modelo3);
		

		List<?> resultado = getSession().createCriteria(Auto.class)
				.createAlias("modelo", "modeloBuscado")		
				.createAlias("modeloBuscado.marca", "marcaBuscada")		
				.add(Restrictions.eq("marcaBuscada.nombre", "Fiat"))
				.list();

		assertThat(resultado).hasSize(1);
		
		
	}
	
	
	
	
	

}	// fin Class AutoTest

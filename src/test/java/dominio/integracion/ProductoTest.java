package dominio.integracion;

import static org.junit.Assert.fail;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dominio.Producto;
import dominio.repositorio.RepositorioProducto;
import persistencia.sistema.SistemaDePersistencia;
import testdatabuilder.ProductoTestDataBuilder;

public class ProductoTest {

	private static final String CODIGO = "S01H1AT51";
	private SistemaDePersistencia sistemaPersistencia;
	private RepositorioProducto repositorioProducto;

	@Before
	public void setUp() {
		sistemaPersistencia = new SistemaDePersistencia();
		repositorioProducto = sistemaPersistencia.obtenerRepositorioProductos();
		sistemaPersistencia.iniciar();
	}

	@After
	public void tearDown() {
		sistemaPersistencia.terminar();
	}

	@Test
	public void productoNoEstaRegistrado() {
		// arrange
		Producto producto = null;

		// act
		try {
			producto = repositorioProducto.obtenerPorCodigo(CODIGO);
			fail();
		}catch(Exception ex) {
			// assert
			assertNull(producto);
		}		

	}
	
	@Test
	public void productoYaEstaRegistrado() {
		
		// arrange	
		Producto producto = new ProductoTestDataBuilder().conCodigo(CODIGO).build();
		Producto nuevoProducto = null; 
		// act
		repositorioProducto.agregar(producto);	
		nuevoProducto = repositorioProducto.obtenerPorCodigo(CODIGO);
		
		// assert
		assertNotNull(nuevoProducto);
		

	}

}

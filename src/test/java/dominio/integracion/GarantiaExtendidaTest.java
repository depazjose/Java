package dominio.integracion;

import static org.junit.Assert.*;

import org.junit.Test;
import dominio.GarantiaExtendida;
import dominio.Producto;

import testdatabuilder.GarantiaExtendidaTestDataBuilder;
import testdatabuilder.ProductoTestDataBuilder;

public class GarantiaExtendidaTest {

	private static final String NOMBRE_CLIENTE = "JOHN DOE";
	private static final int PRECIO_GARANTIA = 110000;
	private static final java.util.Date FECHA_SOLICITUD= new java.util.Date();
	private static final java.util.Date FECHA_FIN= new java.util.Date();
	private static final String CODIGO = "S01H1AT51";
	private static final String NOMBRE_PRODUCTO = "Impresora";
	private static final int PRECIO = 550000;
	
	
	@Test
	public void crearGarantiaExtendidaTest() {
		
		
		// arrange
		ProductoTestDataBuilder productoTestDataBuilder = new ProductoTestDataBuilder().
				conNombre(NOMBRE_PRODUCTO).
				conCodigo(CODIGO).
				conPrecio(PRECIO);
		
		Producto producto = productoTestDataBuilder.build(); 	
		GarantiaExtendidaTestDataBuilder garantiaTestDataBuilder = 
				new GarantiaExtendidaTestDataBuilder()
				.conProducto(producto)
				.conNombreCliente(NOMBRE_CLIENTE)
				.conFechaSolicitud(FECHA_SOLICITUD)
				.conFechaFinGarantia(FECHA_FIN)
				.conPrecioGarantia(PRECIO_GARANTIA);
		

		// act
		GarantiaExtendida garantiaEx = garantiaTestDataBuilder.build();

		// assert
		assertEquals(producto, garantiaEx.getProducto());
		assertEquals(NOMBRE_CLIENTE, garantiaEx.getNombreCliente());
		assertEquals(PRECIO_GARANTIA, garantiaEx.getPrecioGarantia(),0);
		assertEquals(FECHA_SOLICITUD, garantiaEx.getFechaSolicitudGarantia());
		assertEquals(FECHA_FIN, garantiaEx.getFechaFinGarantia());
	}

}

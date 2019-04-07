package dominio.unitaria;

import static org.junit.Assert.*;

import java.text.ParseException;

import org.junit.Test;

import dominio.Utiles;

public class UtilesTest {

	
	private final static double PRECIO_MAYOR_PRODUCTO      = 650000;
	private final static double PRECIO_MENOR_PRODUCTO      = 499000;
	private final static String FECHA_INI_GARANTIA         = "16/08/2018";
	private final static String FECHA_FIN_GARANTIA_P_MAYOR = "06/04/2019";
	private final static String FECHA_FIN_GARANTIA_P_MENOR = "23/11/2018";
	
	private final static String CODIGO_CON_TRES_VOCALES  = "S01H1ATEU";
	private final static String CODIGO_SIN_TRES_VOCALES  = "S01H1AT02";
		
	
	@Test
	public void fechaCorrectaFinGarantiaPrecioMayor() {
		
		//arrange
		java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fechaInicioGarantia=null;
		java.util.Date fechaFinGarantia=null;
		double precioProducto = PRECIO_MAYOR_PRODUCTO;
		
		//act
		try {
			fechaInicioGarantia = formatoFecha.parse(FECHA_INI_GARANTIA);
			fechaFinGarantia    = formatoFecha.parse(FECHA_FIN_GARANTIA_P_MAYOR);
		} catch (ParseException e) {			
			fail();
		}
		
		//assert
		assertEquals(fechaFinGarantia,
				Utiles.CalcularFechaFinGarantia(fechaInicioGarantia, precioProducto)
				);
	}
	
	@Test
	public void fechaCorrectaFinGarantiaPrecioMenor() {
		
		//arrange
		java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("dd/MM/yyyy");
		java.util.Date fechaInicioGarantia=null;
		java.util.Date fechaFinGarantia=null;
		double precioProducto = PRECIO_MENOR_PRODUCTO;
		
		//act
		try {
			fechaInicioGarantia = formatoFecha.parse(FECHA_INI_GARANTIA);
			fechaFinGarantia    = formatoFecha.parse(FECHA_FIN_GARANTIA_P_MENOR);
		} catch (ParseException e) {			
			fail();
		}
		
		//assert
		assertEquals(fechaFinGarantia,
				Utiles.CalcularFechaFinGarantia(fechaInicioGarantia, precioProducto)
				);
	}
	
	
	@Test
	public void codigoTieneTresVocales() {
		
		// arrange
		String CODIGO = CODIGO_CON_TRES_VOCALES;
		int CANT_VOCALES = 3;
		boolean resultado=false;
		
		// act
		resultado =Utiles.TieneVocales(CODIGO, CANT_VOCALES);
		
		//assert		
		assertTrue(resultado);

	}	
	
	@Test
	public void codigonNoTieneTresVocales() {
		
		// arrange
		String CODIGO = CODIGO_SIN_TRES_VOCALES;
		int CANT_VOCALES = 3;
		boolean resultado=false;
		
		// act
		resultado =Utiles.TieneVocales(CODIGO, CANT_VOCALES); 
		
		//assert		
		assertFalse(resultado);

	}	
	

}

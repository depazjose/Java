package dominio;

public class Utiles {

	
	private Utiles() {}
	/**
	 * Verifica si el codigo de producto tiene X vocales.
	 * 
	 * @param codigoProducto
	 *            String que representa el c�digo
	 * @param vocales
	 *            int que presenta la cantidad de vocales a buscar.
	 * @return true si la cadena contiene cantVocales, false sino
	 */
	public static boolean TieneVocales(String codigoProducto, int cantVocales) {
		boolean ret = false;
		int contador = codigoProducto
				.toUpperCase()
				.replaceAll("[^AEIOU]", "").length();
		if (contador==cantVocales) ret = true;
		return ret;
	}
	
	/**
	 * Devuelve la fecha fin de la garant�a extendida
	 * @param Date que presenta la fecha inicial
	 * @param costoProducto valor n�merico el costo del producto 
	 * @return Date que representa la fecha final
	 */
	public static java.util.Date CalcularFechaFinGarantia(
			java.util.Date fechaInicial, 
			double costoProducto) {
		int DIAS_MAYOR_GAR_EXT=200;
		int DIAS_MENOR_GAR_EXT=100;				
		int semanas=0;	
		int diasTotales=0;
		int diasSubtotales=0;	
		int diaDeSemanaInicial=0;
		int diasAdicionalesPorLunes=0;
		int diasFaltantesCompletarSemana=0;
		int diasPorAgregarDespuesSemanas=0;
		

		
		java.util.Calendar calendario = java.util.Calendar.getInstance();
		calendario.clear();		
		calendario.setTime(fechaInicial);	
		
		//Obtener el d�a de la semana de la fecha inicial
		diaDeSemanaInicial= calendario.get(java.util.Calendar.DAY_OF_WEEK);		
					

		if (costoProducto>500000) {	
			//Si es lunes, entonces sumar un d�a porque lunes no se cuenta
			if (diaDeSemanaInicial==java.util.Calendar.MONDAY) {				
				calendario.add(java.util.Calendar.DAY_OF_YEAR, 1);
				diaDeSemanaInicial= calendario.get(java.util.Calendar.DAY_OF_WEEK);				
			}	
			
			diasFaltantesCompletarSemana =   7 - diaDeSemanaInicial;	
			diasSubtotales = DIAS_MAYOR_GAR_EXT - diasFaltantesCompletarSemana;		
			//Obtener las semanas del total de d�as a adicionar
			diasPorAgregarDespuesSemanas = diasSubtotales % 7;			
			semanas = (diasSubtotales-diasPorAgregarDespuesSemanas)/7;	
			//Los d�as lunes a agregar son iguales al n�mero de semanas.
			diasAdicionalesPorLunes = semanas;			
			diasTotales = diasFaltantesCompletarSemana 
					+ diasSubtotales
					+ diasAdicionalesPorLunes + (diasAdicionalesPorLunes/7)
					+ diasPorAgregarDespuesSemanas - 1;			
			calendario.add(java.util.Calendar.DAY_OF_MONTH, diasTotales);	
			
			//Verificar si la fecha finaliza un domingo
			if(calendario.get(java.util.Calendar.DAY_OF_WEEK)==java.util.Calendar.SUNDAY) {
				calendario.add(java.util.Calendar.DAY_OF_MONTH, 1);
			}
		}
		else
		{
			diasTotales  = DIAS_MENOR_GAR_EXT - 1;		
			calendario.add(java.util.Calendar.DAY_OF_MONTH, diasTotales);	
		}
		
		return calendario.getTime();
	}
	
	/**
	 * Devuelve el costo de la garant�a extendida.
	 * @param precio valor base para el c�lculo
	 * @return valor que representa el costo de la garant�a.
	 */
	public static double CalcularPrecioGarantiaExtendida(double precio) {
		return precio > 500000 ? precio * 0.20 : precio * 0.10;
	}
	
}
package dominio;

import dominio.repositorio.RepositorioProducto;
import dominio.excepcion.GarantiaExtendidaException;
import dominio.repositorio.RepositorioGarantiaExtendida;

public class Vendedor {

	public static final String EL_PRODUCTO_NO_CUENTA_CON_GARANTIA = "Este producto no cuenta con garantía extendida";
	public static final String EL_PRODUCTO_TIENE_GARANTIA = "El producto ya cuenta con una garantia extendida";

	private RepositorioProducto repositorioProducto;
	private RepositorioGarantiaExtendida repositorioGarantia;

	public Vendedor(RepositorioProducto repositorioProducto, RepositorioGarantiaExtendida repositorioGarantia) {
		this.repositorioProducto = repositorioProducto;
		this.repositorioGarantia = repositorioGarantia;

	}

	public void generarGarantia(String codigo, String nombreCliente) {

		if (tieneGarantia(codigo))
			throw new GarantiaExtendidaException(EL_PRODUCTO_TIENE_GARANTIA);

		if (Utiles.TieneVocales(codigo, 3)) {
			throw new GarantiaExtendidaException(EL_PRODUCTO_NO_CUENTA_CON_GARANTIA);
		}

		Producto producto = repositorioProducto.obtenerPorCodigo(codigo);

		java.util.Date fechaSolicitudGarantiaEx = new java.util.Date();

		java.util.Date fechaFinGarantiaEx = Utiles.CalcularFechaFinGarantia(
				fechaSolicitudGarantiaEx,
				producto.getPrecio());
		
		double costoGarantiaEx = Utiles.CalcularPrecioGarantiaExtendida(producto.getPrecio());

        GarantiaExtendida garantiaExtendida = new GarantiaExtendida(
        		producto, 
        		fechaSolicitudGarantiaEx,
        		fechaFinGarantiaEx,
        		costoGarantiaEx,
        		nombreCliente
        		);
        
		repositorioGarantia.agregar(garantiaExtendida);
	}

	public boolean tieneGarantia(String codigo) {
		Producto producto = repositorioGarantia.obtenerProductoConGarantiaPorCodigo(codigo);
		return producto != null;
	}

}

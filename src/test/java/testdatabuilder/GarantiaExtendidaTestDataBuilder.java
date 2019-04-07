package testdatabuilder;

import java.util.Date;

import dominio.GarantiaExtendida;
import dominio.Producto;

public class GarantiaExtendidaTestDataBuilder {
	
	private static final Producto PRODUCTO = new ProductoTestDataBuilder().build();
	private static final Date FECHA_SOLICITUD_GARANTIA = new java.util.Date();
	private static final Date FECHA_FIN_GARANTIA= null;
	private static final double PRECIO_GARANTIA= 0;
	private static final String NOMBRE_CLIENTE= "JOHN DOE";

	
	private Producto producto;
    private Date fechaSolicitudGarantia;
    private Date fechaFinGarantia;
    private double precioGarantia;
    private String nombreCliente;

	
	public GarantiaExtendidaTestDataBuilder() {
		this.producto = PRODUCTO;
		this.fechaSolicitudGarantia = FECHA_SOLICITUD_GARANTIA;
		this.fechaFinGarantia = FECHA_FIN_GARANTIA;
		this.precioGarantia = PRECIO_GARANTIA;
		this.nombreCliente = NOMBRE_CLIENTE;
	}	
	
	public GarantiaExtendida build() {
		return new GarantiaExtendida(
				this.producto,
				this.fechaSolicitudGarantia, 
				this.fechaFinGarantia, 
				this.precioGarantia,
				this.nombreCliente);
	}

	public GarantiaExtendidaTestDataBuilder conProducto(Producto producto) {
		this.producto = producto;
		return this;
	}	
	
	public GarantiaExtendidaTestDataBuilder conFechaSolicitud(Date fechaSol) {
		this.fechaSolicitudGarantia = fechaSol;
		return this;
	}	
	
	public GarantiaExtendidaTestDataBuilder conFechaFinGarantia(Date fechaFin) {
		this.fechaFinGarantia = fechaFin;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conPrecioGarantia(double precio) {
		this.precioGarantia = precio;
		return this;
	}
	
	public GarantiaExtendidaTestDataBuilder conNombreCliente(String nombre) {
		this.nombreCliente = nombre;
		return this;
	}

}

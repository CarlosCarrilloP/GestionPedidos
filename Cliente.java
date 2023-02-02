package carlosPedido;

import java.util.Date;

public class Cliente {

	// Atributos

	String nombre;
	String apellidos;
	Date fechaDeAlta;
	String telefono;
	String direccion;
	String historial;

	// Get and Set

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toLowerCase();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos.toUpperCase();
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		if (fechaDeAlta == null) {
			this.fechaDeAlta = new Date();

		} else {
			this.fechaDeAlta = fechaDeAlta;

		}

	}

	public String getTelefono() {
		return telefono;
	}

	// Metodo setTelefono limita a 9 la longitud del telefono y que empiece por
	// 6,7,8 o 9
	public void setTelefono(String telefono) {
		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			System.out.println("ERROR");
		}

	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getHistorial() {
		return historial;
	}

	public void setHistorial(String historial) {
		this.historial = historial;
	}

	// Constructor vacio

	public Cliente() {
		super();
	}

	// Constructor
	public Cliente(String nombre, String apellidos, Date fechaDeAlta, String telefono, String direccion,
			String historial) {
		super();
		this.nombre = nombre.toLowerCase();
		this.apellidos = apellidos.toUpperCase();
		this.fechaDeAlta = fechaDeAlta;

		if (telefono.length() == 9 && (telefono.startsWith("6") || telefono.startsWith("7") || telefono.startsWith("8")
				|| telefono.startsWith("9"))) {

			this.telefono = telefono;
		} else {
			System.out.println("FORMATO DE TELEFONO INCORRECTO");
		}

		this.direccion = direccion;
		this.historial = historial;
	}

	
	 /* Metodo: Este metodo es el metodo agregarPedido y realizarPedido, ya que en la
	 * practica, los nombra diferentes, y pide lo mismo.
	 */

	public void realizarPedido(Pedido pedido) {

		this.historial = this.historial + pedido.getCodigoPedido();

	}

}

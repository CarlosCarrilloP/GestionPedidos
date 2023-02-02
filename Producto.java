package carlosPedido;

public class Producto {
	// Atributos
	String nombre;
	double precio;
	int cantidad;
	private int stock;

	// Constructor vacío

	public Producto() {
		super();
	}

	// Constructor con parámetros
	public Producto(String nombre, double precio, int cantidad) {
		this.nombre = nombre.toUpperCase();
		this.precio = precio;
		this.cantidad = cantidad;
	}

	// Getters y setters para los atributos de la clase
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre.toUpperCase();
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public int setCantidad(int cantidad) {
		return this.cantidad = cantidad;
	}

	// Metodos para el stock

	public int getStock() {
		return this.stock;
	}

	public void realizarPedido(int cantidad) {
		stock -= cantidad;
	}
}

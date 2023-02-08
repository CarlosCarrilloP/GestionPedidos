package carlosPedido;

public class Producto {
	// Atributos
	String nombre;
	double precio;
	int cantidad;
	int cantidad1 = 0;
	private int stock;
	private int stock1[] = new int[30];
	

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
	//Rellenar stock
	public void rellenarStock() {

		for (int i = 0; i < stock1.length; i++) {

			stock1[i] = 1;
		
		}
		
	}
	public int mostrarStock(){
		//Inicializo la variable a 0 de nuevo porque si no, el valor de cantidad1 es erroneo
		cantidad1 = 0; 
		for (int i = 0; i < stock1.length; i++) {
			
			cantidad1++;
			
		}
		
		return cantidad1;
	}	


	public void realizarPedido(int cantidad) {
		cantidad1 = cantidad1 - cantidad;
	}
}

package carlosPedido;

import java.util.Date;

public class Pedido {


	// Atributos
	 Cliente cliente;
	 Producto producto1;
	 Producto producto2;
	 double importeTotal;
	 PasarelaDePago pago;
	 Estado estado;
	String codigoPedido;

	

	// Constructor vacío
	public Pedido() {
	}

	// Constructor con parámetros
	public Pedido(Cliente cliente, Producto producto1, Producto producto2, double importeTotal, PasarelaDePago pago,
			Estado estado) {
		this.cliente = cliente;
		this.producto1 = producto1;
		this.producto2 = producto2;
		this.importeTotal = importeTotal;
		this.pago = pago;
		this.estado = estado;
		this.codigoPedido = generarCodigoPedido();
	}

	// Getters y setters para los atributos de la clase
	public Cliente getCliente() {
		return cliente;
	}
	public String getCodigoPedido() {
		return codigoPedido;
	}

	public void setCodigoPedido() {
		
		this.codigoPedido = generarCodigoPedido();
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Producto getProducto1() {
		return producto1;
	}

	public void setProducto1(Producto producto1) {
		this.producto1 = producto1;
	}

	public Producto getProducto2() {
		return producto2;
	}

	public void setProducto2(Producto producto2) {
		this.producto2 = producto2;
	}

	public double getImporteTotal() {
		return importeTotal;
	}

	public void setImporteTotal(double importeTotal) {
		this.importeTotal = importeTotal;
	}

	public PasarelaDePago getPago() {
		return pago;
	}

	public void setPago(PasarelaDePago pago) {
		this.pago = pago;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public boolean isPagoRealizado() {
		return pagoRealizado;
	}

	public void setPagoRealizado(boolean pagoRealizado) {
		this.pagoRealizado = pagoRealizado;
	}

	// Metodos

	public enum Estado {
		PAGADO, PREPARANDO, LISTO, SERVIDO
	}

	public enum TipoPago {
		EFECTIVO, TARJETA, CUENTA
	}

	private boolean pagoRealizado = false;

	public void pagar(TipoPago tipoPago) {

		if (pagoRealizado == false) {
			pagoRealizado = true;

		}
	}

	public void agregarCliente(Cliente cliente) {

		this.cliente = cliente;
	}

	public void agregarProducto1(Producto producto1) {

		this.producto1 = producto1;
	}

	public void agregarProducto2(Producto producto2) {

		if (this.producto1 != null) {
			this.producto2 = producto2;
		}

	}

	public Producto eliminarProducto(Producto producto) {
		producto = null;
		return producto;
	}
	//Codigo pedido: es la fecha de hoy
	public String generarCodigoPedido() {
		return String.valueOf(new Date().getTime());

	}

	@Override //Ticket que se imprime por pantalla cuando se realiza el pedido
	public String toString() {
		double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
		double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
		double totalPedido = totalProducto1 + totalProducto2;

		return	" CANTIDAD   PRODUCTO      PRECIO UD.         TOTAL \n" +
				producto1.getCantidad() + "               " + producto1.getNombre() + "             " + producto1.getPrecio() + "           "
				+ totalProducto1 + " € \n" + producto2.getCantidad() + "               " + producto2.getNombre() + "             "
				+ producto2.getPrecio() + "           " + totalProducto2 + " € \n" + " TOTAL -------------------------------> " + totalPedido + " € \n ";

		
	} 
	public double toString2() {
		
		double totalProducto1 = producto1.getCantidad() * producto1.getPrecio();
		double totalProducto2 = producto2.getCantidad() * producto2.getPrecio();
		double totalPedido = totalProducto1 + totalProducto2;
		
		return totalPedido;
		
	}

}

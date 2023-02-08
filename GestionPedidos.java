package carlosPedido;

import java.util.Scanner;

/**
 * @author Carlos Carrillo V 0.1 Añadida la funcionalidad de stockaje
 *
 */
public class GestionPedidos {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		double totalefectivo = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("#####MENU INICIAL#####");
		System.out.println("Debes de crear 3 clientes ");
		System.out.println("Y 5 productos");
		System.out.println("Pulsa intro para continuar");
		String a = sc.nextLine();

		// Creacion de los clientes

		System.out.print("Ingresa el nombre del Cliente 1: ");

		String nombre1 = sc.nextLine();
		System.out.print("Ingresa el apellido del Cliente 1: ");
		String apellido1 = sc.nextLine();
		System.out.print("Ingresa el telefono del Cliente 1: ");
		String telefono1 = sc.nextLine();
		System.out.print("Ingresa la dirección del Cliente 1: ");
		String direccion1 = sc.nextLine();

		Cliente cliente1 = new Cliente(nombre1, apellido1, null, telefono1, direccion1, null);

		System.out.print("Ingresa el nombre del Cliente 2: ");
		String nombre2 = sc.nextLine();
		System.out.print("Ingresa el apellido del Cliente 2: ");
		String apellido2 = sc.nextLine();
		System.out.print("Ingresa el telefono del Cliente 2: ");
		String telefono2 = sc.nextLine();
		System.out.print("Ingresa la dirección del Cliente 2: ");
		String direccion2 = sc.nextLine();

		Cliente cliente2 = new Cliente(nombre2, apellido2, null, telefono2, direccion2, null);

		System.out.print("Ingresa el nombre del Cliente 3: ");
		String nombre3 = sc.nextLine();
		System.out.print("Ingresa el apellido del Cliente 3: ");
		String apellido3 = sc.nextLine();
		System.out.print("Ingresa el telefono del Cliente 3: ");
		String telefono3 = sc.nextLine();
		System.out.print("Ingresa la dirección del Cliente 3: ");
		String direccion3 = sc.nextLine();

		Cliente cliente3 = new Cliente(nombre3, apellido3, null, telefono3, direccion3, null);

		// Relleno de stock a 30 unidades llamando al metodo

		// Productos
		System.out.print("Ingresa el producto 1: ");
		String nproducto1 = sc.nextLine();

		Producto producto1 = new Producto(nproducto1, 9.99, 1);

		System.out.print("Ingresa el producto 2: ");
		String nproducto2 = sc.nextLine();

		Producto producto2 = new Producto(nproducto2, 12.99, 0);

		System.out.print("Ingresa el producto 3: ");
		String nproducto3 = sc.nextLine();

		Producto producto3 = new Producto(nproducto3, 15.99, 1);

		System.out.print("Ingresa el producto 4: ");
		String nproducto4 = sc.nextLine();

		Producto producto4 = new Producto(nproducto4, 1.99, 1);

		System.out.print("Ingresa el producto 5: ");
		String nproducto5 = sc.nextLine();

		Producto producto5 = new Producto(nproducto5, 4.99, 1);

		// MENU PEDIDOS

		System.out.println("#####MENU PEDIDOS#####");
		System.out.println("1.Realizar Pedidos");

		/*
		 * En realizar pedidos, primero nos pedirá el cliente con el teléfono y luego el
		 * producto o los productos si son mas de uno
		 */

		System.out.println("Introduce el telefono del cliente");
		// Boolean para comprobar cliente
		String telefono = sc.nextLine();
		boolean esCliente1 = false;
		boolean esCliente2 = false;
		boolean esCliente3 = false;

		if (telefono.equals(cliente1.getTelefono())) {
			System.out.println("Hola Cliente1:");
			esCliente1 = true;
		} else if (telefono.equals(cliente2.getTelefono())) {
			System.out.println("Hola Cliente2:");
			esCliente2 = true;
		} else if (telefono.equals(cliente3.getTelefono())) {
			System.out.println("Hola Cliente3:");
			esCliente3 = true;
		} else {
			System.out.println("No existe ese cliente");
		}
		// Submenu
		if (esCliente1 || esCliente2 || esCliente3) {

			System.out.println("###Seleccione el producto que desea:");

			System.out.println("1.Producto 1: " + producto1.getNombre() + " " + producto1.getPrecio() + "€");
			System.out.println("2.Producto 2: " + producto2.getNombre() + " " + producto2.getPrecio() + "€");
			System.out.println("3.Producto 3: " + producto3.getNombre() + " " + producto3.getPrecio() + "€");
			System.out.println("4.Producto 4: " + producto4.getNombre() + " " + producto4.getPrecio() + "€");
			System.out.println("5.Producto 5: " + producto5.getNombre() + " " + producto5.getPrecio() + "€");
			int p;
			Pedido pedido = new Pedido();
			int stockRestante = 0;
			do {
				
				if (stockRestante < 0) {
					break;
				}else {
							
					System.out.println("Dime el numero del producto o 0 para finalizar");
				p = sc.nextInt();

				
				switch (p) {

				case 0: {

					if (esCliente1) {
						cliente1.realizarPedido(pedido);

					} else if (esCliente2) {
						cliente2.realizarPedido(pedido);

					} else if (esCliente3) {
						cliente3.realizarPedido(pedido);

					}

					// Metodo del ticket
					totalefectivo = pedido.toString2();
					System.out.println(pedido.toString());
					break;
				}
				// Submenu productos, se le resta 30 al stock, si es menor de 5, sale un mensaje
				// en pantalla.
				case 1: {
					System.out.println("¿Cuánta cantidad de " + producto1.getNombre() + " deseas?");
					int cantidad = sc.nextInt();
					int i;
					producto1.realizarPedido(cantidad);
					producto1.setCantidad(cantidad);

					 stockRestante = producto2.mostrarStock() - cantidad;

					if (stockRestante > 5 && stockRestante <= 30) {
						System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
					} else if (stockRestante <= 5 && stockRestante >= 0) {
						System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
					} else {
						System.out.println("No hay suficiente Stock");
						break;
					}

				}

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto1);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto1);
					}

					break;

				case 2: {
					System.out.println("¿Cuánta cantidad de " + producto2.getNombre() + " deseas?");
					int cantidad = sc.nextInt();
					int i;
					producto2.realizarPedido(cantidad);
					producto2.setCantidad(cantidad);

					stockRestante = producto2.mostrarStock() - cantidad;

					if (stockRestante > 5 && stockRestante <= 30) {
						System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
					} else if (stockRestante <= 5 && stockRestante >= 0) {
						System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
					} else {
						System.out.println("No hay suficiente Stock");
						break;
					}

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto2);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto2);
					}
					break;
				}
				case 3: {
					System.out.println("¿Cuánta cantidad de " + producto3.getNombre() + " deseas?");
					int cantidad = sc.nextInt();
					int i;
					producto3.realizarPedido(cantidad);
					producto3.setCantidad(cantidad);

					stockRestante = producto2.mostrarStock() - cantidad;

					if (stockRestante > 5 && stockRestante <= 30) {
						System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
					} else if (stockRestante <= 5 && stockRestante >= 0) {
						System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
					} else {
						System.out.println("No hay suficiente Stock");
					}

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto3);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto3);
					}
					break;
				}
				case 4: {
					System.out.println("¿Cuánta cantidad de " + producto4.getNombre() + " deseas?");
					int cantidad = sc.nextInt();
					int i;
					producto4.realizarPedido(cantidad);
					producto4.setCantidad(cantidad);

					stockRestante = producto2.mostrarStock() - cantidad;

					if (stockRestante > 5 && stockRestante <= 30) {
						System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
					} else if (stockRestante <= 5 && stockRestante >= 0) {
						System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
					} else {
						System.out.println("No hay suficiente Stock");
					}

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto4);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto4);
					}
					break;
				}
				case 5: {
					System.out.println("¿Cuánta cantidad de " + producto5.getNombre() + " deseas?");
					int cantidad = sc.nextInt();
					int i;
					producto5.realizarPedido(cantidad);
					producto5.setCantidad(cantidad);

					stockRestante = producto2.mostrarStock() - cantidad;

					if (stockRestante > 5 && stockRestante <= 30) {
						System.out.println("Stock restante de " + producto1.getNombre() + ": " + stockRestante);
					} else if (stockRestante <= 5 && stockRestante >= 0) {
						System.out.println("Quedan menos de 5 unidades de " + producto1.getNombre());
					} else {
						System.out.println("No hay suficiente Stock");
					}

					if (pedido.getProducto1() == null) {
						pedido.agregarProducto1(producto5);
					} else if (pedido.getProducto2() == null) {
						pedido.agregarProducto2(producto5);
					}
					break;
				}
				default:

					break;
				}
			}
			} while (p != 0);

		}
		PasarelaDePago efectivo = new PasarelaDePago();

		efectivo.efectivopago(totalefectivo);
		sc.close();

	}
}

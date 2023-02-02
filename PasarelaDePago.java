package carlosPedido;

import java.util.Date;
import java.util.Scanner;

public class PasarelaDePago {

	// Atributos
	Double importe; // Limitar a dos decimales.
	String codigoPago;

	// Get and Set

	public Double getImporte() {
		return importe;
	}

	public void setImporte(Double importe) {
		this.importe = importe;
	}

	public String getCodigoPago() {
		return codigoPago;
	}

	public void setCodigoPago() {

		this.codigoPago = this.generarCodigoPago();

	}

	// Constructores
	public PasarelaDePago() {

	}

	public PasarelaDePago(Double importe) {

		this.importe = importe;
		this.codigoPago = this.generarCodigoPago();
	}

	// Metodos

	// Efectivo
	
	public void efectivopago(Double efectivo1) {
		this.importe = efectivo1;
		this.codigoPago = this.generarCodigoPago();

		Scanner sc = new Scanner(System.in);
		System.out.println("Ha elegido efectivo");
		
		double cantidad = efectivo1;
		System.out.println("El total es de " + cantidad + "€");
		System.out.println("Necesitas:");

		if (cantidad >= 50) {
			int i = 0;
			while (cantidad >= 50) {

				cantidad = cantidad - 50;
				i++;
			}
			System.out.println(i + " Billetes de 50€");
		}
		if (cantidad <= 50 && cantidad >= 20) {
			int v = 0;
			while (cantidad >= 20) {

				cantidad = cantidad - 20;
				v++;
			}
			System.out.println(v + " Billetes de 20€");
		}
		if (cantidad <= 20 && cantidad >= 10) {
			int d = 0;
			while (cantidad >= 10) {

				cantidad = cantidad - 10;
				d++;
			}
			System.out.println(d + " Billetes de 10€");
		}
		if (cantidad <= 10 && cantidad >= 5) {
			int e = 0;
			while (cantidad >= 5) {

				cantidad = cantidad - 5;
				e++;
			}
			System.out.println(e + " Billetes de 5€");
		}
		if (cantidad <= 5 && cantidad >= 2) {
			int r = 0;
			while (cantidad >= 2) {

				cantidad = cantidad - 2;
				r++;
			}
			System.out.println(r + " Monedas de 2€");
		}
		if (cantidad <= 2 && cantidad >= 1) {
			int t = 0;
			while (cantidad >= 1) {

				cantidad = cantidad - 1;
				t++;
			}
			System.out.println(t + " Monedas de 1€");
		}
		if (cantidad <= 1 && cantidad >= 0.5) {
			int q = 0;
			while (cantidad >= 0.5) {

				cantidad = (float) (cantidad - 0.5);
				q++;
			}
			System.out.println(q + " Monedas de 0.50€");
		}
		if (cantidad <= 0.5 && cantidad >= 0.2) {
			int y = 0;
			while (cantidad >= 0.2) {

				cantidad = (float) (cantidad - 0.2);
				y++;
			}
			System.out.println(y + " Monedas de 0.20€");
		}
		if (cantidad <= 0.2 && cantidad >= 0.1) {
			int u = 0;
			while (cantidad >= 0.1) {

				cantidad = (float) (cantidad - 0.1);
				u++;
			}
			System.out.println(u + " Monedas de 0.10€");
		}
		if (cantidad <= 0.1 && cantidad >= 0.05) {
			int p = 0;
			while (cantidad >= 0.05) {

				cantidad = (float) (cantidad - 0.05);
				p++;
			}
			System.out.println(p + " Monedas de 0.05€");
		}
		if (cantidad <= 0.05 && cantidad >= 0.02) {
			int o = 0;
			while (cantidad >= 0.02) {

				cantidad = (float) (cantidad - 0.02);
				o++;
			}
			System.out.println(o + " Monedas de 0.02€");
		}
		if (cantidad <= 0.02 && cantidad >= 0.01) {
			int l = 0;
			while (cantidad >= 0.01) {

				cantidad = (float) (cantidad - 0.01);
				l++;
			}
			System.out.println(l + " Monedas de 0.01€");

		}
	}

	// Tarjeta
	public void tarjeta(String numeroTarjeta) {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();
		System.out.println("Ha elegido tarjeta");

		System.out.println("Escriba el numero de su tarjeta");
		Scanner sc = new Scanner(System.in);
		String tarjeta = sc.nextLine();
		char var = tarjeta.charAt(0);

		switch (var) {
		case '3': // 16 dígitos Para VISA y Mastercard separados de 4 en 4 dígitos.
			System.out.println("La tarjeta es American Express");
			if (var == '3') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);

				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;

		case '4':
			System.out.println("La tarjeta es Visa");
			if (var == '4') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 16) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 8);
					String distancia3 = cadenaString.substring(8, 12);
					String distancia4 = cadenaString.substring(12, 16);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3
							+ " " + distancia4);
				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;
		case '5': // Para American Express debe aceptar 15 dígitos y estar separados por 4, 6 y 5
					// dígitos.
			System.out.println("La tarjeta es Mastercard");
			if (var == '5') {
				String cadenaString = tarjeta;
				int tamano = cadenaString.length();

				if (tamano == 15) {
					String distancia1 = cadenaString.substring(0, 4);
					String distancia2 = cadenaString.substring(4, 10);
					String distancia3 = cadenaString.substring(10, 15);

					System.out.println("Su numero de tarjeta es " + distancia1 + " " + distancia2 + " " + distancia3);

				} else {
					System.out.println("Su numero de tarjeta no es valido");
				}
			} else {
				System.out.println("Su numero de tarjeta no es valido");
			}
			break;
		default:
			System.out.println("La tarjeta introducida no es valida");

		}

	}

	// Cuenta
	public void cuenta(String numeroCuenta) {

		this.importe = 0.0;
		this.codigoPago = this.generarCodigoPago();

	}

	public String generarCodigoPago() {
		return String.valueOf(new Date().getTime());

	}

}

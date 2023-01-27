package org.iesalandalus.programacion.clientesempresa.vista;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;
import org.iesalandalus.programacion.utilidades.Entrada;

public class Consola {
	
	
private Consola() {
		
	}
	
public static void mostrarMenu() {
	System.out.println("Bienvenido/a a la gestión de Clientes, ¿que operación quiere hacer?");
	System.out.println("1. Insertar u cliente.");
	System.out.println("2. Buscar un cliente.");
	System.out.println("3. Borrar una cliente.");
	System.out.println("4. Ver todos los clientes.");
	System.out.println("5. Ver clientes nacidos en una fecha concreta.");
	System.out.println("0. Salir.");
}

	
	public static Opcion elegirOpcion() {
		Opcion[] opcion = Opcion.values();
		System.out.println("--------------------------");
		System.out.println("---- Elija una opción ----");
		System.out.println("--------------------------");
		int opcionElegida = Entrada.entero();
		while(opcionElegida < 0 || opcionElegida > 5) {
			System.out.println("Elija una opción entre 0 y 5: ");
			opcionElegida = Entrada.entero();
		}
		return opcion[opcionElegida];
	}
	
	
	
	public static Cliente leerClienteDni() throws OperationNotSupportedException {	
		System.out.println("Introduzca el dni:");
		String dni = Entrada.cadena();
				Cliente cliente = new Cliente(leerCliente());
		return cliente;
	}
	
	
	public static Cliente leerCliente() throws OperationNotSupportedException {
	Cliente cliente = null;
		System.out.println("Introduzca el nombre:");
		String nombre = Entrada.cadena();
		System.out.println("Introduzca el dni:");
		String dni = Entrada.cadena();
		System.out.println("Introduzca el correo electrónico:");
		String correo = Entrada.cadena();
		System.out.println("Introduzca el número de teléfono:");
		String telefono = Entrada.cadena();
		System.out.println("Introduzca una fecha dd/mm/aaaa:");
		LocalDate fechaNacimiento = LocalDate.parse(Entrada.cadena(), cliente.FORMATO_FECHA);
			cliente = new Cliente(nombre, dni, correo, telefono, fechaNacimiento);
		return cliente;
	}
	
	
	
	public static LocalDate leerFechaNacimiento() {
	int dia = 0, mes = 0, ano=0;
			do {
				System.out.println("Introduzca el día: ");
				Entrada.entero();
			
		} while (dia <= 0 && dia > 31);
			do {
				System.out.println("Introduzca el día: ");
				Entrada.entero();
				
		} while (mes<= 0 && mes > 12);
			do {
				System.out.println("Introduzca el día: ");
				ano=Entrada.entero();
				
			
		} while (ano <= 0 && ano > 2023);
			
		return LocalDate.now();
	}


}

package org.iesalandalus.programacion.clientesempresa.modelo.negocio;

import javax.naming.OperationNotSupportedException;

import org.iesalandalus.programacion.clientesempresa.modelo.dominio.Cliente;

public class Clientes {

	public Cliente[] coleccionClientes;
	private int capacidad;
	private int tamano;

	public Clientes(int capacidad) {
		if (capacidad<0) {
			throw new IllegalArgumentException("ERROR: No se puede crear una capacidad negativa.");
		}else {
		this.capacidad = capacidad;
		this.tamano = 0;
		this.coleccionClientes = new Cliente[capacidad];
		}
		}

	public void borrar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede borrar un cliente nulo. ");
		}
		int indice = buscarIndice(cliente);
		if (indice == -1) {
			throw new OperationNotSupportedException("ERROR: No se encuentra el cliente a borrar.");
		}else if(indice == -1){
		desplazarUnaPosicionHaciaIzquierda(indice);
		tamano--;
		}
		}
	
	

	public void buscar(Cliente cliente) throws OperationNotSupportedException {
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede buscar un cliente nulo.");
		}
		
		boolean encontrado = false;
		for (int i = 0; i < coleccionClientes.length; i++) {
			if (cliente.equals(coleccionClientes[i])) {
				encontrado = true;
			}

		}
		if (encontrado == true) {
			int indice=buscarIndice(cliente);
			if (indice==-1) {
				throw new OperationNotSupportedException("ERROR: El cliente que busca no ha sido encontrado.");
			}
				
			}
		
	}

	private int buscarIndice(Cliente cliente) {
		boolean encontrado = false;
		int indice = -1;
		for (int i = 0; i < coleccionClientes.length; i++) {
			if (cliente.equals(coleccionClientes[i])) {
				encontrado = true;
				indice = i;
			}
		}
		if (encontrado == true) {
			return indice;
		} else {
			return tamano++;
		}

		

	}

	private boolean capacidadSuperada(int indice) {
		if (indice >= capacidad) {
			return true;
		}
		return false;
	}

	private Cliente[] copiaProfundaClientes() {
		
		Cliente[] copiaProfunda= new Cliente[tamano];
		for (int i= 0; i< coleccionClientes.length; i++) {
			copiaProfunda[i]= new Cliente(coleccionClientes[i]);
		}
			
		return copiaProfunda;

	}

	private void desplazarUnaPosicionHaciaIzquierda(int indice) {
		for (int i = indice + 1; i < coleccionClientes.length-1; i++) {
			coleccionClientes[i] = coleccionClientes[i+1];
		}
	}

	public void insertar(Cliente cliente) throws OperationNotSupportedException {
		int hueco= buscarIndice(cliente);
		if (cliente == null) {
			throw new NullPointerException("ERROR: No se puede insertar un cliente nulo.");
		}else if(capacidadSuperada(capacidad)){
			throw new OperationNotSupportedException("ERROR: No existe ningún cliente como el indicado.");
		}else if(tamanoSuperado(hueco)){
			coleccionClientes[tamano] = new Cliente(cliente);
			tamano++;			
		}else {
			throw new OperationNotSupportedException("ERROR: Ya existe un cliente con ese dni.");
		}
			
	}

	private boolean tamanoSuperado(int indice) {
		if (indice >= tamano) {
			return true;
		}
		return false;
	}

	// Métodos Getters

	public int getCapacidad() {
		return capacidad;
	}

	public Cliente[] get() {
		return copiaProfundaClientes();
	}

	public int getTamano() {
		return tamano;
	}

}

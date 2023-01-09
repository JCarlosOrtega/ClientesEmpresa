package org.iesalandalus.programacion.clientesempresa.modelo.dominio;

import java.time.LocalDate;

public class Cliente {

	private String ER_Correo, ER_DNI, ER_TELEFONO;
	public String FORMATO_FECHA;
	private String nombre, dni, correo, telefono;
	private LocalDate fechaNacimiento;
	
	
	private String formateaNombre (String nombre) {
		return nombre;
		
	}
	private boolean comprobarLetraDni (String nombre) {
		return false;
		
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getDni() {
		return dni;
	}
	private void setDni(String dni) {
		this.dni = dni;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

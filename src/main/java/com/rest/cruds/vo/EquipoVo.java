package com.rest.cruds.vo;

public class EquipoVo {

	private int id;
	private String nombre;
	private String departamento;
	private String estadio;
	
	
	
	public EquipoVo() {
		super();
	}
	
	public EquipoVo(int id, String nombre, String departamento, String estadio) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.departamento = departamento;
		this.estadio = estadio;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDepartamento() {
		return departamento;
	}
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
	public String getEstadio() {
		return estadio;
	}
	public void setEstadio(String estadio) {
		this.estadio = estadio;
	}
	

	
}

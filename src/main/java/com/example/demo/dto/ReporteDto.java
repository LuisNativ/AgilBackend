package com.example.demo.dto;

public class ReporteDto {

	private String codigo;
	private String nombres;
	private int practica1;
	private int practica2;
	private int practica3;
	private int practica4;
	private int examenFinal;
	
	
	public ReporteDto() {
		
	}
	
	
	
	public ReporteDto(String codigo, String nombres, int practica1, int practica2, int practica3, int practica4,
			int examenFinal) {
		super();
		this.codigo = codigo;
		this.nombres = nombres;
		this.practica1 = practica1;
		this.practica2 = practica2;
		this.practica3 = practica3;
		this.practica4 = practica4;
		this.examenFinal = examenFinal;
	}



	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public int getPractica1() {
		return practica1;
	}
	public void setPractica1(int practica1) {
		this.practica1 = practica1;
	}
	public int getPractica2() {
		return practica2;
	}
	public void setPractica2(int practica2) {
		this.practica2 = practica2;
	}
	public int getPractica3() {
		return practica3;
	}
	public void setPractica3(int practica3) {
		this.practica3 = practica3;
	}
	public int getPractica4() {
		return practica4;
	}
	public void setPractica4(int practica4) {
		this.practica4 = practica4;
	}
	public int getExamenFinal() {
		return examenFinal;
	}
	public void setExamenFinal(int examenFinal) {
		this.examenFinal = examenFinal;
	}
	
	
}

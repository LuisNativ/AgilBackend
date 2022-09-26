package com.example.demo.dto;

public class ReporteAsistenciaDto {

	private int nro;
	private String codigo;
	private String nombres;
	private int dictadas;
	private int asistidas;
	private int noasistida;
	
	
	public ReporteAsistenciaDto() {
		
	}
	
	


	public ReporteAsistenciaDto(int nro, String codigo, String nombres, int dictadas, int asistidas, int noasistida) {
		super();
		this.nro = nro;
		this.codigo = codigo;
		this.nombres = nombres;
		this.dictadas = dictadas;
		this.asistidas = asistidas;
		this.noasistida = noasistida;
	}




	public int getNro() {
		return nro;
	}


	public void setNro(int nro) {
		this.nro = nro;
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


	public int getDictadas() {
		return dictadas;
	}


	public void setDictadas(int dictadas) {
		this.dictadas = dictadas;
	}


	public int getAsistidas() {
		return asistidas;
	}


	public void setAsistidas(int asistidas) {
		this.asistidas = asistidas;
	}


	public int getNoasistida() {
		return noasistida;
	}


	public void setNoasistida(int noasistida) {
		this.noasistida = noasistida;
	}
	
	
	
	
	
	
}

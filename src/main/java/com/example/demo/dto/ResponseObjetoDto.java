package com.example.demo.dto;
 
public class ResponseObjetoDto {
	public String codigo;
	public String descripcion;
	public String mensaje;
	public Object object;
	
	public ResponseObjetoDto() {
		
	}

	public ResponseObjetoDto(String codigo, String mensaje, Object object) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.object = object;
	}
	public ResponseObjetoDto(String codigo, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
	}

	public ResponseObjetoDto(String codigo, String descripcion, String mensaje) {
		this.codigo = codigo;
		this.mensaje = mensaje;
		this.descripcion = descripcion;
	}

	public ResponseObjetoDto(String codigo, String descripcion, String mensaje, Object object) {
		super();
		this.codigo = codigo;
		this.descripcion = descripcion;
		this.mensaje = mensaje;
		this.object = object;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Object getObject() {
		return object;
	}

	public void setObject(Object object) {
		this.object = object;
	}		
	
}

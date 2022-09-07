package com.uce.demo.repository.modelo;

import java.io.Serializable;

public class ProductoSimple implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String codigoBarras;
	
	private String categoria;
	
	private Integer cantidad;
	
	public ProductoSimple() {}

	public ProductoSimple(String codigoBarras, String categoria, Integer cantidad) {
		super();
		this.codigoBarras = codigoBarras;
		this.categoria = categoria;
		this.cantidad = cantidad;
	}
	
	

	@Override
	public String toString() {
		return "\nStock de Producto: " + codigoBarras + ", categoria: " + categoria + ", STOCK: " + cantidad;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}
}

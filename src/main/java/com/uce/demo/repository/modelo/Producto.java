package com.uce.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;




@Entity
@Table(name = "p_producto")
public class Producto {
	
	@Id
	@Column(name = "pro_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pro_seq_id")
	@SequenceGenerator(name = "pro_seq_id", sequenceName = "pro_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "pro_codigo_barras")
	private String codigoBarras;	
	
	@Column(name = "pro_nombre")
	private String nombre;
	
	@Column(name = "pro_categoria")
	private String categoria;
	
	@Column(name = "pro_precio")
	private BigDecimal precio;
	
	@Column(name = "pro_stock")
	private Integer stock;
	
	@OneToMany(mappedBy = "producto")
	private List <DetalleVenta> detalles;

//get set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigoBarras() {
		return codigoBarras;
	}

	public void setCodigoBarras(String codigoBarras) {
		this.codigoBarras = codigoBarras;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
}

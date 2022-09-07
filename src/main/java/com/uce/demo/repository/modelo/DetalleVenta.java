package com.uce.demo.repository.modelo;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "p_detalle_venta")
public class DetalleVenta {
	
	@Id
	@Column(name = "det_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "det_seq_id")
	@SequenceGenerator(name = "det_seq_id", sequenceName = "det_seq_id", allocationSize = 1)
	private Integer id;

	@Column(name = "det_cantidad")
	private Integer cantidad;

	@Column(name = "det_subTotal")
	private BigDecimal subTotal;
	
	@ManyToOne
	@JoinColumn(name = "det_id_venta")
	private Venta venta;
	
	@ManyToOne
	@JoinColumn(name = "det_id_producto")
	private Producto producto;
//get set

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubTotal() {
		return subTotal;
	}

	public void setSubTotal(BigDecimal subTotal) {
		this.subTotal = subTotal;
	}

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}
}

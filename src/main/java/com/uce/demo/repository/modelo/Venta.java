package com.uce.demo.repository.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "p_venta")
public class Venta {

	@Id
	@Column(name = "vent_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vent_seq_id")
	@SequenceGenerator(name = "vent_seq_id", sequenceName = "vent_seq_id", allocationSize = 1)
	private Integer id;
	
	@Column(name = "vent_numero")
	private String numero;
	
	@Column(name = "vent_fecha")
	private LocalDateTime fecha;
	
	@Column(name = "vent_cedula_cliente")
	private String cedulaC;
	
	@Column(name = "vent_venta_total")
	private BigDecimal ventaTotal;

	
	@OneToMany(mappedBy = "venta", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<DetalleVenta> detalles;

	
//get set
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedulaC() {
		return cedulaC;
	}

	public void setCedulaC(String cedulaC) {
		this.cedulaC = cedulaC;
	}

	public BigDecimal getVentaTotal() {
		return ventaTotal;
	}

	public void setVentaTotal(BigDecimal ventaTotal) {
		this.ventaTotal = ventaTotal;
	}

	public List<DetalleVenta> getDetalles() {
		return detalles;
	}

	public void setDetalles(List<DetalleVenta> detalles) {
		this.detalles = detalles;
	}
}

package com.uce.demo.service;

import java.util.List;

import com.uce.demo.repository.modelo.ListaCompras;

public interface IVentaService {
	
	public void Venta(List<ListaCompras> productos, String cedula, String numVenta);

}

package com.uce.demo.service;

import java.sql.SQLException;
import java.util.List;

import com.uce.demo.repository.modelo.ListaCompras;
import com.uce.demo.repository.modelo.Producto;

public interface IGestorService {
	
	public void ingresarProducto (Producto producto) throws SQLException;
	
	public void realizarVenta (List<ListaCompras> productos, String cedula, String numVenta);
	
	public void consultarStock (String codigoB);
}

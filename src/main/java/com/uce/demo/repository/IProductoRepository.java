package com.uce.demo.repository;

import com.uce.demo.repository.modelo.Producto;
import com.uce.demo.repository.modelo.ProductoSimple;

public interface IProductoRepository {
	
	public void insertar (Producto producto);
	public void actualizarP (Producto producto);
	public Producto buscarCodigoB (String codigoB);
	
	public ProductoSimple buscarStock(String codigoB);
}


package com.uce.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo.repository.IProductoRepository;
import com.uce.demo.repository.IVentaRepository;
import com.uce.demo.repository.modelo.DetalleVenta;
import com.uce.demo.repository.modelo.ListaCompras;
import com.uce.demo.repository.modelo.Producto;
import com.uce.demo.repository.modelo.Venta;

@Service
public class VentaServiceImpl implements IVentaService{
	
	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IVentaRepository ventaRepository;
	
	@Autowired
	private IProductoRepository productoRepository;
	

	
	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void Venta(List<ListaCompras> productos, String cedula, String numVenta) {
		// TODO Auto-generated method stub
		Venta venta= new Venta();
		venta.setFecha(LocalDateTime.now());
		venta.setCedulaC(cedula);
		venta.setNumero(numVenta);
		this.ventaRepository.insertar(venta);
		
		BigDecimal ventafinal = new BigDecimal(0);
		List<DetalleVenta> detalles = new ArrayList<>();
		
		for (ListaCompras lista : productos) {

				Producto producto=this.productoRepository.buscarCodigoB(lista.getCodigoBarras());

				if (producto.getStock()!=0) {
					Log.info("\nEntro3");
					if(lista.getCantidad() <= producto.getStock()) {
						
						DetalleVenta dv = new DetalleVenta();
							dv.setCantidad(lista.getCantidad());
							dv.setSubTotal(producto.getPrecio().multiply(new BigDecimal(lista.getCantidad())));
							dv.setVenta(venta);
							dv.setProducto(producto);
						detalles.add(dv);
						producto.setStock(producto.getStock()-lista.getCantidad());
						
						ventafinal.add(producto.getPrecio().multiply(new BigDecimal(lista.getCantidad())));
						this.productoRepository.actualizarP(producto);
						
					}
					else {
						Log.info("\nStock insuficiente");
					}
				}
				else {
					Log.warn("\nYa no hay stock disponible");	
				}	

		}

		venta.setVentaTotal(ventafinal);
		venta.setDetalles(detalles);
		
		this.ventaRepository.insertar(venta);
	}
	
}

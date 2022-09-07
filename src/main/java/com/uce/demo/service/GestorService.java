package com.uce.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.demo.repository.IProductoRepository;
import com.uce.demo.repository.modelo.ListaCompras;
import com.uce.demo.repository.modelo.Producto;
import com.uce.demo.repository.modelo.ProductoSimple;


@Service
public class GestorService implements IGestorService{

	Logger Log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
	
	@Autowired
	private IProductoRepository productoRepository;
	
	@Autowired
	private IVentaService iVentaService;
	
	@Override
	public void ingresarProducto(Producto producto) {
		// TODO Auto-generated method stub
		Producto proIns = this.productoRepository.buscarCodigoB(producto.getCodigoBarras());
		
		if (proIns==null){
			Log.info("\nIngresando Producto nuevo");
			this.productoRepository.insertar(producto);
		}else {
			Log.info("\nAñadiendo al stock de los Productos");
			Integer stock = proIns.getStock() + producto.getStock();
			proIns.setStock(stock);
			this.productoRepository.actualizarP(proIns);
		}
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void realizarVenta(List<ListaCompras> productos, String cedula, String numVenta) {
		// TODO Auto-generated method stub
		this.iVentaService.Venta(productos, cedula, numVenta);
	}

	@Override
	public void consultarStock(String codigoB) {
		// TODO Auto-generated method stub
		ProductoSimple proS = this.productoRepository.buscarStock(codigoB);
		Log.info("\nConsulta de stock" + proS);
	}

}

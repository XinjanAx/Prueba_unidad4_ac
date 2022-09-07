package com.uce.demo.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.demo.repository.modelo.ListaCompras;
import com.uce.demo.repository.modelo.Producto;
import com.uce.demo.repository.modelo.Venta;
import com.uce.demo.service.IGestorService;

@Controller
@RequestMapping("/productos")
public class VentaController {
	
	@Autowired
	private IGestorService gestorService;
	
    @GetMapping("/menu")
    public String menu(Producto producto) {
        return "vistaMenu";
    }
	
    @GetMapping("/nuevo_producto")
    public String ingresarProducto(Producto producto) {
        return "vistaAgregarProducto";
    }
	
    @PostMapping("/insertar")
    public String insertarPersona(Producto producto) throws SQLException {
        this.gestorService.ingresarProducto(producto);
        return "vistaAgregarProducto";
    }
    
    
    @GetMapping("/venta")
    public String venta(Venta venta) {
    	System.out.println("llego");
        return "vistaRealizarVenta";
    }
    
    @PostMapping("/insertar_venta")
    public String realizarVenta(ListaCompras compras){
    	
        return "vistaRealizarVenta";
    }
    
    @PostMapping("/venta_realizada")
    public String realizarVenta(List<ListaCompras> compras, String cedula, String numVenta){
        this.gestorService.realizarVenta(compras, cedula, numVenta);
        return "vistaRealizarVenta";
    }
}

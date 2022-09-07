package com.uce.demo.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.uce.demo.repository.modelo.Producto;
import com.uce.demo.repository.modelo.ProductoSimple;



@Repository
@Transactional
public class ProductoRepositoryImpl implements IProductoRepository{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public void insertar(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.persist(producto);
	}

	@Override
	public void actualizarP(Producto producto) {
		// TODO Auto-generated method stub
		this.entityManager.merge(producto);
	}

	@Override
	public Producto buscarCodigoB(String codigoB) {
		try {
			TypedQuery<Producto> myTypedQuery = this.entityManager
					.createQuery("SELECT p FROM Producto p  WHERE p.codigoBarras = :datoBarras", Producto.class)
					.setParameter("datoBarras", codigoB);
			return myTypedQuery.getSingleResult();			
			
		}catch(Exception e){
			return null;
		}
	}
	

	@Override
	public ProductoSimple buscarStock(String codigoB) {
		TypedQuery<ProductoSimple> myTypedQuery = this.entityManager
				.createQuery("SELECT NEW com.uce.demo3.prueba3.repository.modelo.ProductoSimple(p.codigoBarras, p.categoria, p.stock) FROM Producto p WHERE p.codigoBarras = :datoBarras", ProductoSimple.class)
				.setParameter("datoBarras", codigoB);
		return myTypedQuery.getSingleResult();	
	}
	
	

}

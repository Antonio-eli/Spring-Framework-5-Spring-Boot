package com.mx.roancoder.app.productos.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.mx.roancoder.app.productos.models.entity.Producto;

public interface IProductoDao extends CrudRepository<Producto, Long>{
	
}

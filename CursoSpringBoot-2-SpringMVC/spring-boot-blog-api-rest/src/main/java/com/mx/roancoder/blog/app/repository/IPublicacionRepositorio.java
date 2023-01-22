package com.mx.roancoder.blog.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mx.roancoder.blog.app.entity.Publicacion;

public interface IPublicacionRepositorio extends JpaRepository<Publicacion, Long>{

}

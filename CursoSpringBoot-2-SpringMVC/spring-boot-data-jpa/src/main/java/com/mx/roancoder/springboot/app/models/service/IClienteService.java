package com.mx.roancoder.springboot.app.models.service;

import java.util.List;

import com.mx.roancoder.springboot.app.models.entity.Cliente;

public interface IClienteService {
	public List<Cliente> findAll();
	public void save(Cliente cliente);
	public Cliente clienteId(Long id);
	public void delete(Long id);
}

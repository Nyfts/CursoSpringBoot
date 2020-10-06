package com.jesusluan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusluan.cursomc.domain.Pedido;
import com.jesusluan.cursomc.repositories.PedidoRepository;
import com.jesusluan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;

	public Pedido buscar(Integer id) throws ObjectNotFoundException {

		Optional<Pedido> c = repo.findById(id);

		return c.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName()));
	}

}

package com.jesusluan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusluan.cursomc.domain.Estado;
import com.jesusluan.cursomc.repositories.EstadoRepository;
import com.jesusluan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class EstadoService {

	@Autowired
	private EstadoRepository repo;

	public Estado buscar(Integer id) throws ObjectNotFoundException {

		Optional<Estado> c = repo.findById(id);

		return c.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

}

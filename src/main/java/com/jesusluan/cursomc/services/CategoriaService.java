package com.jesusluan.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jesusluan.cursomc.domain.Categoria;
import com.jesusluan.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repo;

	public Categoria categoriaPorId(Integer id) {
		
		Optional<Categoria> c = repo.findById(id);		
		
		return c.orElse(null);
	}

}

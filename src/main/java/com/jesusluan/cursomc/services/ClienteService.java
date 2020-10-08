package com.jesusluan.cursomc.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.jesusluan.cursomc.domain.Cliente;
import com.jesusluan.cursomc.dto.ClienteDTO;
import com.jesusluan.cursomc.repositories.ClienteRepository;
import com.jesusluan.cursomc.services.exceptions.DataIntegrityException;
import com.jesusluan.cursomc.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;

	public Cliente find(Integer id) throws ObjectNotFoundException {

		Optional<Cliente> c = repo.findById(id);

		return c.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	public Cliente update(Cliente obj) {

		Cliente newObj = find(obj.getId());
		
		updateData(newObj, obj);

		return repo.save(newObj);
	}

	public void delete(Integer id) {

		find(id);

		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException ex) {
			throw new DataIntegrityException("Não é possível excluir um cliente que possui pedidos");
		}

	}

	public List<Cliente> findAll() {
		List<Cliente> lista = repo.findAll();
		return lista;
	}

	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Cliente fromDTO(ClienteDTO objDto) {
		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null);
	}
	
	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}

}

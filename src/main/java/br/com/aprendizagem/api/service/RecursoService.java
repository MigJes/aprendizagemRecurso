package br.com.aprendizagem.api.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.repository.RecursoRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class RecursoService {
	
	@Autowired
	private RecursoRepository repo;
	
	public List<Recurso> buscarRecursoPorUsuario(String usuarioId){
		return repo.findAllByUsuarioId(usuarioId);
	}

}

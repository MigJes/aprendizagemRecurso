package br.com.aprendizagem.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.aprendizagem.api.entity.Recurso;

@Repository
public interface  RecursoRepository extends JpaRepository<Recurso, Long> {
	List<Recurso> findAllByUsuarioId(String usuarioId);
	

}

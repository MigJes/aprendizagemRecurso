package br.com.aprendizagem.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.aprendizagem.api.entity.Recurso;
import br.com.aprendizagem.api.service.RecursoService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
@AllArgsConstructor
@NoArgsConstructor
@RequestMapping("recurso")
public class RecursoController {
	
	@Autowired
	private RecursoService rcService;
	
	@GetMapping("/usuario/{usuarioId}")
	@ApiOperation(value = "Listar recurso por usuario.")
	@ApiResponses({
			@ApiResponse(code = 200, message = "Recurso encontrado."),
			@ApiResponse(code = 404, message = "Nenhum recurso encontrado."),
	})
	
	public ResponseEntity<List<Recurso>> buscarRecursoPorUsuario(@PathVariable String usuarioId){
		
		List<Recurso> rcLista = rcService.buscarRecursoPorUsuario(usuarioId);
		
		if(rcLista.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(rcLista);
	}

}

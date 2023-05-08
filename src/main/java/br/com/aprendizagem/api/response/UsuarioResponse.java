package br.com.aprendizagem.api.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;

import br.com.aprendizagem.api.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioResponse {
	private String id;
	private String cpf;
	private String nomeCompleto;
	private String apelido;
	private String email;
	private LocalDateTime dataNascimento;
	private Integer status;
	
	public static UsuarioResponse of(Usuario usuario) {
		return UsuarioResponse.builder()
				.id(usuario.getId())
				.cpf(usuario.getCpf())
				.nomeCompleto(usuario.getNomeCompleto())
				.apelido(usuario.getApelido())
				.email(usuario.getEmail())
				.dataNascimento(usuario.getDataNascimento())
				.status(usuario.getStatus())
				.build();
	}

	public static List<UsuarioResponse> of(List<Usuario> usuarios) {
		List<UsuarioResponse> usuarioResponses = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuarioResponses.add(of(usuario));
		}
		return usuarioResponses;
	}	
	
	
	public static Page<UsuarioResponse> of(Page<Usuario> usuarios) {
		List<UsuarioResponse> usuarioResponses = new ArrayList<>();
		for (Usuario usuario : usuarios) {
			usuarioResponses.add(of(usuario));
		}
		return new PageImpl<UsuarioResponse>(
					usuarioResponses, 
					usuarios.getPageable(),
					usuarios.getTotalElements()
				);
	}
	
	
}

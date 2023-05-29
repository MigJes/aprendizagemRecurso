package br.com.aprendizagem.api.entity;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "recurso")
public class Recurso {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "recurso_id", nullable = false)
	private Long id;
	@Column(name = "recurso_descricao", nullable = false)
	private String discricao;
	@Column(name = "recurso_nome_arquivo", nullable = false)
	private String nomeArquivo;
	@JsonIgnore
	@Lob
	@Column(name = "recurso_arquivo", nullable = false)	
	private byte[] recursoArquivo;
	@Column(name = "recurso_data_cadastro", nullable = false)	
	private Date recursoDataCadastro;
	@Column(name = "recurso_status", nullable = false)	
	private int recursoStatus;
	@ManyToOne
	@JoinColumn(name = "usuario_id", nullable = false)
	private Usuario usuario;

}

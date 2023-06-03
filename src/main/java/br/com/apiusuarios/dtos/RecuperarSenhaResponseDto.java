package br.com.apiusuarios.dtos;

import java.time.Instant;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class RecuperarSenhaResponseDto {

	private Integer idUsuario;
	private String nome;
	private String email;
	private Instant dataHoraRecuperacaoDeSenha;
}

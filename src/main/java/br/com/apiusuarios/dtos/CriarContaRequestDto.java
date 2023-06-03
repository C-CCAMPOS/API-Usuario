package br.com.apiusuarios.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CriarContaRequestDto {

	private String nome;
	private String email;
	private String senha;
	private String senhaConfirmação;
	
}

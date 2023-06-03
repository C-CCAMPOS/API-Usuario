package br.com.apiusuarios.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiusuarios.dtos.AutenticarRequestDto;
import br.com.apiusuarios.dtos.AutenticarResponseDto;
import br.com.apiusuarios.dtos.CriarContaRequestDto;
import br.com.apiusuarios.dtos.CriarContaResponseDto;
import br.com.apiusuarios.dtos.RecuperarSenhaRequestDto;
import br.com.apiusuarios.dtos.RecuperarSenhaResponseDto;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

	@PostMapping("autenticar")
	public ResponseEntity<AutenticarResponseDto> autenticar(@RequestBody AutenticarRequestDto dto) {

		return null;
	}

	@PostMapping("criar-conta")
	public ResponseEntity<CriarContaResponseDto> criarConta(@RequestBody CriarContaRequestDto dto) {

		return null;
	}

	@PostMapping("recuperar-senha")
	public ResponseEntity<RecuperarSenhaResponseDto> RecuperarSenha(@RequestBody RecuperarSenhaRequestDto dto) {

		return null;
	}

}

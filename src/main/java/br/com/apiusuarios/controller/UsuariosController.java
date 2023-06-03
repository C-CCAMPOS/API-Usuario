package br.com.apiusuarios.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiusuario.helpers.MD5Helper;
import br.com.apiusuarios.dtos.AutenticarRequestDto;
import br.com.apiusuarios.dtos.AutenticarResponseDto;
import br.com.apiusuarios.dtos.CriarContaRequestDto;
import br.com.apiusuarios.dtos.CriarContaResponseDto;
import br.com.apiusuarios.dtos.RecuperarSenhaRequestDto;
import br.com.apiusuarios.dtos.RecuperarSenhaResponseDto;
import br.com.apiusuarios.entities.Usuario;
import br.com.apiusuarios.repositories.UsuarioRepository;

@RestController
@RequestMapping("api/usuarios")
public class UsuariosController {

	@Autowired // inicialização automatica
	private UsuarioRepository usuarioRepository;

	@PostMapping("autenticar")
	public ResponseEntity<AutenticarResponseDto> autenticar(@RequestBody AutenticarRequestDto dto) {

		return null;
	}

	@PostMapping("criar-conta")
	public ResponseEntity<CriarContaResponseDto> criarConta(@RequestBody CriarContaRequestDto dto) {

		try {

			Usuario usuario = new Usuario();

			usuario.setNome(dto.getNome());
			usuario.setEmail(dto.getEmail());
			usuario.setSenha(MD5Helper.encryptMD5(dto.getSenha()));
			
			
			//gravando no banco de dados
			usuarioRepository.save(usuario);
			
			//criando os dados de resposta
			CriarContaResponseDto response = new CriarContaResponseDto();
			response.setIdUsuario(usuario.getIdUsuario());
			response.setNome(usuario.getNome());
			response.setEmail(usuario.getEmail());
			response.setDataHoraCriacao(Instant.now());
			
			//HTTP STATUS 201(Created)
			return ResponseEntity.status(201).body(response);
			
		} catch (Exception e) {
			// HTTP STATUS 500 (Internal Server Error
			return ResponseEntity.status(500).body(null);

		}
		
	}

	@PostMapping("recuperar-senha")
	public ResponseEntity<RecuperarSenhaResponseDto> RecuperarSenha(@RequestBody RecuperarSenhaRequestDto dto) {

		return null;
	}

}

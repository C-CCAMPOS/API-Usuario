package br.com.apiusuarios;

import static org.assertj.core.api.Assertions.fail;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import br.com.apiusuarios.dtos.AutenticarRequestDto;
import br.com.apiusuarios.dtos.CriarContaRequestDto;
import br.com.apiusuarios.dtos.RecuperarSenhaRequestDto;

@SpringBootTest
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class SistemaApiusuariosApplicationTests {
	@Autowired // inicialização automática!
	private MockMvc mockMvc;
	@Autowired // inicialização automática!
	private ObjectMapper objectMapper;

	// atributos
	private static String emailUsuario;
	private static String senhaUsuario;

	@Test
	@Order(1)
	public void criarContaTest() throws Exception {
		Faker faker = new Faker();

		CriarContaRequestDto dto = new CriarContaRequestDto();
		dto.setNome(faker.name().fullName());
		dto.setEmail(faker.internet().emailAddress());
		dto.setSenha("@Teste1234");

		mockMvc.perform(post("/api/usuarios/criar-conta").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isCreated());

		emailUsuario = dto.getEmail();
		senhaUsuario = dto.getSenha();
	}

	@Test
	@Order(2)
	public void autenticarTest() throws Exception {

		AutenticarRequestDto dto = new AutenticarRequestDto();
		dto.setEmail(emailUsuario);
		dto.setSenha(senhaUsuario);

		mockMvc.perform(post("/api/usuarios/autenticar").contentType("application/json")
				.content(objectMapper.writeValueAsString(dto))).andExpect(status().isOk());
	}

	@Test
	@Order(3)
	public void recuperarSenhaTest() throws Exception{
		
		RecuperarSenhaRequestDto dto = new RecuperarSenhaRequestDto();
		dto.setEmail(emailUsuario);
		
		mockMvc.perform(post("/api/usuarios/recuperar-senha")
				.contentType("application/json")
				.content(objectMapper.writeValueAsString(dto)))
				.andExpect(status().isOk());
	}
}


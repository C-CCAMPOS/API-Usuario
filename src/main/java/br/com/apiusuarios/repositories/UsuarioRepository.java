package br.com.apiusuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.apiusuarios.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	/*
	 
	 Método para consultar 1 usuário no banco de dados através do email(Linguagem JPQL - Java Persistence Query Language) 
	 
	 */
	
	@Query("from Usuario usuario where usuario.email = :pEmail")
	Usuario findByEmail(@Param("pEmail")String email) throws Exception;
	
	/*
	 
	 Método para consultar 1 usuário no banco de dados através do email e da senha(Linguagem JPQL - Java Persistence Query Language) 
	 
	 */
	
	@Query("from Usuario usuario where usuario.email = :pEmail and usuario.senha = :pSenha")
	Usuario findByEmailAndSenha(@Param("pEmail") String email, @Param("pSenha") String senha)  throws Exception;
}

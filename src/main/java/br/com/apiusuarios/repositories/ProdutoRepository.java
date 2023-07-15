package br.com.apiusuarios.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiusuarios.entities.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}

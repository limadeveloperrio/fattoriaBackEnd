package br.com.cotiinformatica.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.cotiinformatica.entities.Produto;

//para a conexao com application.properties
@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer>{

}

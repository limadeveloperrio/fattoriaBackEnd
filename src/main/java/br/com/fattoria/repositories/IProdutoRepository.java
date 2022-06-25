package br.com.fattoria.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.fattoria.entities.Produto;

@Repository
public interface IProdutoRepository extends CrudRepository<Produto, Integer>{

}

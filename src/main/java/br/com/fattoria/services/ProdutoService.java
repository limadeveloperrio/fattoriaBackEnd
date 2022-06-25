package br.com.fattoria.services;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.fattoria.entities.Produto;
import br.com.fattoria.repositories.IProdutoRepository;

@Service
@Transactional
public class ProdutoService {

	@Autowired
	private IProdutoRepository produtoRepository;

	// Método para realizar o cadastro do produto
	public void create(Produto produto) throws Exception {
		// implementar rega de negócio
		produtoRepository.save(produto);
	}

	public void upDate(Produto produto) throws Exception {
		// implementar rega de negócio
		produtoRepository.save(produto);
	}

	public void deletar(Produto produto) {
		// implementar rega de negócio
		produtoRepository.delete(produto);
	}

	public List<Produto> getAll() throws Exception {
		return (List<Produto>) produtoRepository.findAll();
	}

	public Produto getById(Integer idProduto) throws Exception {
		// captura os dados do produto através do id
		Optional<Produto> produto = produtoRepository.findById(idProduto);
		// verificar se o produto foi encontrado
		if (produto != null) {
			return produto.get();
			// retornando os dados do produto
		} else {
			return null; // retornando vazio
		}
	}

}

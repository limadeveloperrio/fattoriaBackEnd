package br.com.fattoria.adapters;

import java.util.ArrayList;
import java.util.List;

import br.com.fattoria.entities.Produto;
import br.com.fattoria.responses.ProdutoResponse;

public class EntityModelAdapter {

	/*
	 * Métodos para receber como argumento um objeto Entity e transferir os seus
	 * dados para um objeto do tipo RESPONSE
	 */
	public static List<ProdutoResponse> map(List<Produto> produtos) {
		List<ProdutoResponse> result = new ArrayList<ProdutoResponse>();
		for (Produto produto : produtos) {
			ProdutoResponse response = new ProdutoResponse();
			response.getProduto().setIdProduto(produto.getIdProduto());
			response.getProduto().setNome(produto.getNome());
			response.getProduto().setPreco(produto.getPreco());
			response.getProduto().setQuantidade(produto.getQuantidade());
			result.add(response);
		}
		return result;
	}
}

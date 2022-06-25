package br.com.fattoria.adapters;


import br.com.fattoria.entities.Produto;
import br.com.fattoria.request.ProdutoPostRequest;

public class ModelEntityAdapter {

	/*
	 * Métodos para receber como argumento um objeto REQUEST e transferir os seus
	 * dados para uma entidade
	 */
	public static Produto map(ProdutoPostRequest request) {
		Produto produto = new Produto();
		produto.setNome(request.getNome());
		produto.setPreco(request.getPreco());
		produto.setQuantidade(request.getQuantidade());		
		return produto;
	}
}

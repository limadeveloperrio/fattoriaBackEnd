package br.com.fattoria.validations;

import java.util.ArrayList;
import java.util.List;
import br.com.fattoria.request.ProdutoPostRequest;

public class ProdutoPostValidation {

	
	/*
	 * Método para validar os dados da requisição de cadastro de cliente
	 */
	public static List<ValidationModel> validate(ProdutoPostRequest request) {
		List<ValidationModel> result = new ArrayList<ValidationModel>();
		if (request.getNome() == null || request.getNome().trim().length() < 6) {
			result.add(new ValidationModel("nome", "Informe no mínimo 6 caracteres."));
		}
		
		if (request.getPreco() == null || request.getPreco()< 0) {
			result.add(new ValidationModel("preco", "Informe valor válido maior para preço."));
		}
		if (request.getQuantidade() == null || request.getQuantidade()< 0) {
			result.add(new ValidationModel("Quantidade", "Informe valor válido para quantidade."));
		}
		if (request.getDataCadastro() == null ) {
			result.add(new ValidationModel("DataCadastro", "Informe a data do cadastro"));
		}
		return result;
	}
}

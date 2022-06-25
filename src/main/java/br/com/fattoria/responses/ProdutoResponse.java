package br.com.fattoria.responses;

import java.util.List;
import br.com.fattoria.entities.Produto;
import br.com.fattoria.validations.ValidationModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoResponse {
	private Produto produto;
	private String mensagem;
	private Integer StatusCode;
	private List<ValidationModel> validationErrors;
}
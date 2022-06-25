package br.com.fattoria.request;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class ProdutoPutRequest {
	private Integer idProduto;
	private String nome;
	private Double preco;
	private Integer quantidade;
	private Date dataCadastro;
}

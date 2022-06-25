package br.com.fattoria.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.fattoria.adapters.EntityModelAdapter;
import br.com.fattoria.adapters.ModelEntityAdapter;
import br.com.fattoria.entities.Produto;
import br.com.fattoria.request.ProdutoPostRequest;
import br.com.fattoria.request.ProdutoPutRequest;
import br.com.fattoria.responses.ProdutoResponse;
import br.com.fattoria.services.ProdutoService;
import br.com.fattoria.validations.ProdutoPostValidation;
import br.com.fattoria.validations.ValidationModel;


@RestController
public class ProdutoController {

	private static final String ENDPOINT = "/api/produtos";
	
	@Autowired
	private ProdutoService produtoService;

	// Método para salvar um produto
	@PostMapping(value = ENDPOINT)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<ProdutoResponse> post(@RequestBody ProdutoPostRequest request) {
		ProdutoResponse response = new ProdutoResponse();
		try {
			// validar os dados do produto
			List<ValidationModel> validation = ProdutoPostValidation.validate(request);
			// verificar se não há erros de validação
			if (validation.isEmpty()) {

				Produto produto = ModelEntityAdapter.map(request);
				// set a data do momento do cadastro e salva usando o serviço
				produto.setDataCadastro(new Date());
				produtoService.create(produto);
				response.setStatusCode(201);
				response.setMensagem("Produto cadastrado com sucesso!");
				return ResponseEntity.status(HttpStatus.CREATED).body(response);
			} else {
				response.setStatusCode(400);
				response.setMensagem("Ocorreram erros de validação no envio dos dados.");
				response.setValidationErrors(validation);
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (IllegalArgumentException e) {
			response.setStatusCode(422);
			response.setMensagem(e.getMessage());
			return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
		} catch (Exception e) {
			response.setStatusCode(500);
			response.setMensagem(e.getMessage());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	// método para atualizar dados do produto
	@CrossOrigin
	@PutMapping(value = ENDPOINT)
	@ResponseBody
	public ResponseEntity<ProdutoResponse> put(@RequestBody ProdutoPutRequest request) {

		ProdutoResponse response = new ProdutoResponse();
		try {
			Produto produto = produtoService.getById(request.getIdProduto());
			if (produto != null) {				
				produto.setNome(request.getNome());
				produto.setPreco(request.getPreco());
				produto.setQuantidade(request.getQuantidade());
				produtoService.upDate(produto);
				response.setStatusCode(200);
				response.setMensagem("Produto atualizada com sucesso");
				response.setProduto(produto);
				return ResponseEntity.status(HttpStatus.OK).body(response);

			} else {
				response.setStatusCode(400);
				response.setMensagem("Produto não encontrada. O ID informado é inválido.");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}

	// Método de serviço da API para consultar todos os produtos
	@GetMapping(value = ENDPOINT)
	@ResponseBody
	@CrossOrigin
	public ResponseEntity<List<Produto>> getAll() {
		try {
			List<Produto> result = produtoService.getAll();
			return ResponseEntity.status(HttpStatus.OK).body(result);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
		}
	}


	@CrossOrigin
	@GetMapping(value = ENDPOINT + "/{id}")
	@ResponseBody
	public ResponseEntity<ProdutoResponse> getById(@PathVariable("id") Integer id) {
		ProdutoResponse response = new ProdutoResponse();
		try {
		
			Produto registro = produtoService.getById(id);
			
			if (registro != null){				
				response.setProduto(registro);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}
	
	@CrossOrigin
	@DeleteMapping(value = ENDPOINT + "/{id}")
	@ResponseBody
	public ResponseEntity<ProdutoResponse> delete(@PathVariable("id") Integer id) {
		ProdutoResponse response = new ProdutoResponse();
		try {			
			Produto registro = produtoService.getById(id);
			
			if (registro != null) {			
			    produtoService.deletar(registro);
				response.setStatusCode(200);
				response.setMensagem("Produto excluído com sucesso");
				response.setProduto(registro);
				return ResponseEntity.status(HttpStatus.OK).body(response);
			} else {
				response.setStatusCode(400);
				response.setMensagem("Empresa não encontrada. O ID informado é inválido.");
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
			}
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
		}
	}


}

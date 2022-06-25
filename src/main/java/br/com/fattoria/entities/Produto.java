package br.com.fattoria.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
@Entity
@Table
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer idProduto;
	
	@Column(length = 150, nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private double preco;
	
	@Column(nullable = false)
	private Integer quantidade;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(nullable = false)
	private Date dataCadastro;
	
}

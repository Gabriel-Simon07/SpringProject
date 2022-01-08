package br.com.alura.spring.data.orm;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "unidade_trabalho")
public class UnidadeTrabalho {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String descricao;
	String endereco;
	@ManyToMany(mappedBy = "unidadeTrabalhos", fetch = FetchType.EAGER)
	private List<Funcionario> funcionarios;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Override
	public String toString() {
		return "Unidade de trabalho: " + "id:" + id + "| descrição:'" + descricao + "| endereço:" + endereco;
	}
}

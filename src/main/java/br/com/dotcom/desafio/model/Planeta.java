package br.com.dotcom.desafio.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;

//@Entity
//@Table(name="TB_Planeta") -Caso queria mapear a tabela com um nome diferente ao nome da Classe
@Document(collection = "planetas")
public class Planeta implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	//@GeneratedValue(strategy=GenerationType.AUTO)
	private String id;
	
	private String nome;
	private String clima;
	private String terreno;
	private String qtdAparicao;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public String getQtdAparicao() {
		return qtdAparicao;
	}
	public void setQtdAparicao(String qtdAparicao) {
		this.qtdAparicao = qtdAparicao;
	}

	
}

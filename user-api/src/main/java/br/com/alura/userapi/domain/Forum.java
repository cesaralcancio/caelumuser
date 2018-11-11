package br.com.alura.userapi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Forum {

	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID uuid;
	private Integer qtdQuestoes;
	private Integer qtdRespostas;
	private Integer qtdSolucoes;

	@OneToOne
	private User user;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getQtdQuestoes() {
		return qtdQuestoes;
	}

	public void setQtdQuestoes(Integer qtdQuestoes) {
		this.qtdQuestoes = qtdQuestoes;
	}

	public Integer getQtdRespostas() {
		return qtdRespostas;
	}

	public void setQtdRespostas(Integer qtdRespostas) {
		this.qtdRespostas = qtdRespostas;
	}

	public Integer getQtdSolucoes() {
		return qtdSolucoes;
	}

	public void setQtdSolucoes(Integer qtdSolucoes) {
		this.qtdSolucoes = qtdSolucoes;
	}

}

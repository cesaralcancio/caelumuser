package br.com.alura.userapi.domain;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class Curso {

	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID uuid;
	private String nome;
	private Integer percentual;
	private boolean completo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getPercentual() {
		return percentual;
	}

	public void setPercentual(Integer percentual) {
		this.percentual = percentual;
	}

	public boolean isCompleto() {
		return completo;
	}

	public void setCompleto(boolean completo) {
		this.completo = completo;
	}

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

}

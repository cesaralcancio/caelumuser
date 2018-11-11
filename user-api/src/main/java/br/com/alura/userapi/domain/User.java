package br.com.alura.userapi.domain;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

@Entity
public class User {

	@Id
	@GeneratedValue(generator="uuid2")
	@GenericGenerator(name="uuid2", strategy="uuid2")
	@Column(columnDefinition="BINARY(16)")
	private UUID uuid;

	private String nome;

	private String email;
	
	private String tipo; //ALUNO ou INSTRUTOR

	@OneToMany(cascade = { javax.persistence.CascadeType.ALL })
	private List<Curso> cursos;

	@OneToOne(cascade = { javax.persistence.CascadeType.ALL })
	private Forum forum;

	public UUID getUuid() {
		return uuid;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Curso> getCursos() {
		return cursos;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public Forum getForum() {
		return forum;
	}

	public void setForum(Forum forum) {
		this.forum = forum;
	}
	
	public String getTipo() {
		return tipo;
	}
	
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}

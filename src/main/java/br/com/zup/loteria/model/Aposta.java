package br.com.zup.loteria.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aposta {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String numerosDaAposta;
	private String email; 

	public Long getId() {
		return id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNumerosDaAposta() {
		return numerosDaAposta;
	}
	public void setNumerosDaAposta(String numerosDaAposta) {
		this.numerosDaAposta = numerosDaAposta;
	}

}

package br.com.zup.loteria.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aposta {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private LocalDateTime dataDaAposta = LocalDateTime.now();
	private String numerosDaAposta;
	private String email; 
	
	public Aposta(){
	}
	
	public Aposta(String numerosDaAposta, String email) {
		this.numerosDaAposta = numerosDaAposta;
		this.email = email;
	}

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

	public LocalDateTime getDataDaAposta() {
		return dataDaAposta;
	}

}

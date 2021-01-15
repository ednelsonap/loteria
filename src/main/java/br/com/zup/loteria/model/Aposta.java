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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Aposta other = (Aposta) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
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

package br.com.zup.loteria.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import br.com.zup.loteria.model.Aposta;

public class ApostaForm {

	@NotNull @NotEmpty
	private String numerosDaAposta;
	
	@NotNull @NotEmpty
	private String email;
	
	public String getNumerosDaAposta() {
		return numerosDaAposta;
	}
	public void setNumerosDaAposta(String numerosDaAposta) {
		this.numerosDaAposta = numerosDaAposta;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Aposta converter() {
		return new Aposta(numerosDaAposta, email);
	}
	
}

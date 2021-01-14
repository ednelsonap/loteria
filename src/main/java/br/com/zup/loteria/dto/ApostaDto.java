package br.com.zup.loteria.dto;

import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.loteria.model.Aposta;

public class ApostaDto {

	private Long id;
	private String numerosDaAposta;
	private String email;
	
	public ApostaDto(Aposta aposta){
		this.id = aposta.getId();
		this.numerosDaAposta = aposta.getNumerosDaAposta();
		this.email = aposta.getEmail();
	}
	
	public Long getId() {
		return id;
	}

	public String getNumerosDaAposta() {
		return numerosDaAposta;
	}

	public String getEmail() {
		return email;
	}

	public static List<ApostaDto> converter(List<Aposta> apostas) {
		// TODO Auto-generated method stub
		return apostas.stream().map(ApostaDto::new).collect(Collectors.toList());
	}

}

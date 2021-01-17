package br.com.zup.loteria.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.zup.loteria.model.Aposta;

public class ApostaDto {

	private Long id;
	private String numerosDaAposta;
	private String email;
	private LocalDateTime dataDaAposta = LocalDateTime.now();
	
	public ApostaDto(Aposta aposta){
		this.id = aposta.getId();
		this.numerosDaAposta = aposta.getNumerosDaAposta();
		this.email = aposta.getEmail();
		this.dataDaAposta = aposta.getDataDaAposta();
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

	public LocalDateTime getDataDaAposta() {
		return dataDaAposta;
	}
	
	public static List<ApostaDto> converter(List<Aposta> apostas) {
		// TODO Auto-generated method stub
		return apostas.stream().map(ApostaDto::new).collect(Collectors.toList());
	}
	
}

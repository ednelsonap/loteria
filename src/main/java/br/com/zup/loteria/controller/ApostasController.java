package br.com.zup.loteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.loteria.dto.ApostaDto;
import br.com.zup.loteria.model.Aposta;
import br.com.zup.loteria.repository.ApostaRepository;

@RestController
public class ApostasController {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@RequestMapping("/apostas")
	public List<ApostaDto> listaDeApostas(String email){
		if(email == null){
			List<Aposta> apostas = apostaRepository.findAll();
			return ApostaDto.converter(apostas);
		} else {
			List<Aposta> apostas = apostaRepository.findByEmail(email);	
			return ApostaDto.converter(apostas);
		}

	}

}

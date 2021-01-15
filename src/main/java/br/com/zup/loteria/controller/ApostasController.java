package br.com.zup.loteria.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.zup.loteria.dto.ApostaDto;
import br.com.zup.loteria.form.ApostaForm;
import br.com.zup.loteria.model.Aposta;
import br.com.zup.loteria.repository.ApostaRepository;
import br.com.zup.loteria.service.ApostaService;

@RestController
@RequestMapping("/apostas")
public class ApostasController {
	
	@Autowired
	private ApostaRepository apostaRepository;
	
	@Autowired
	private ApostaService apostaService;
	
	@GetMapping
	public List<ApostaDto> listarApostas(String email){
		if(email == null){
			List<Aposta> apostas = apostaRepository.findAll();
			return ApostaDto.converter(apostas);
		} else {
			List<Aposta> apostas = apostaRepository.findByEmail(email);	
			return ApostaDto.converter(apostas);
		}
	}
	
	@GetMapping("/gerar/")
	public String gerarAposta(String email){
		Aposta aposta = new Aposta();
		String numeros = apostaService.converterParaString(apostaService.gerarAposta());
		aposta.setEmail(email);
		aposta.setNumerosDaAposta(numeros);
		apostaRepository.save(aposta);
		return numeros;
	}

	@PostMapping
	public ResponseEntity<ApostaDto> gravarAposta(@RequestBody @Valid ApostaForm apostaForm, UriComponentsBuilder uriBuilder){
		Aposta aposta = apostaForm.converter();
		apostaRepository.save(aposta);
		
		URI uri = uriBuilder.path("/apostas/{id}").buildAndExpand(aposta.getId()).toUri();
		return ResponseEntity.created(uri).body(new ApostaDto(aposta));
	}
}

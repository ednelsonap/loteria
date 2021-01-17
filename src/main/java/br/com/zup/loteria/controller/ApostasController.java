package br.com.zup.loteria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.loteria.model.Aposta;
import br.com.zup.loteria.service.ApostaService;

@RestController
@RequestMapping("/apostas")
public class ApostasController {
	
	@Autowired
	private ApostaService apostaService;
	
	@PostMapping("/gerar")
	public ResponseEntity<Aposta> gerar(String email){
		if (email == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		} else {
			String numeros = apostaService.gerarAposta();
			Aposta aposta = new Aposta();
			aposta.setEmail(email);
			aposta.setNumerosDaAposta(numeros);
			apostaService.salvar(aposta);
			return new ResponseEntity<>(aposta,HttpStatus.CREATED);
		}	
	}
	
	@GetMapping("/listar")
	public ResponseEntity<List<Aposta>> listar(String email){
		if(email == null){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);	
		} else{
			List<Aposta> apostas = apostaService.listarPorEmail(email);
			return new ResponseEntity<>(apostas,HttpStatus.OK);
		}
	}
	
}

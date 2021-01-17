package br.com.zup.loteria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.zup.loteria.model.Aposta;
import br.com.zup.loteria.repository.ApostaRepository;

@Service
public class ApostaService {

	@Autowired
	private ApostaRepository apostaRepository;
	
	public String gerarAposta() {		
		Random gerador = new Random();
		List<Integer> numeros = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
			Integer numeroGerado = gerador.nextInt(60) + 1;
			if (!numeros.contains(numeroGerado)) {
				numeros.add(numeroGerado);
			} else {
				i--;
			}
		}
		numeros.sort((n1, n2) -> Integer.compare(n1, n2));
		return numeros.stream().map(String::valueOf).collect(Collectors.joining("-"));
	}
	
	public void salvar(Aposta aposta){
		apostaRepository.save(aposta);
	}
	
	public List<Aposta> listarTodos(){
		return apostaRepository.findAll();
	}
	
	public List<Aposta> listarPorEmail(String email){
		return apostaRepository.findByEmail(email);
	}

	/*public List<Integer> converterParaListaDeInteiros(String texto) {
		List<Integer> numeros = Arrays.stream(texto.split("-")).map(Integer::valueOf).collect(Collectors.toList());
		return numeros;
	}*/
}

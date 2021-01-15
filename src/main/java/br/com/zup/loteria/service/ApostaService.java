package br.com.zup.loteria.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class ApostaService {

	public List<Integer> gerarAposta() {
		Random gerador = new Random();
		List<Integer> numerosDaAposta = new ArrayList<>();
		for (int i = 0; i < 6; i++) {
            numerosDaAposta.add(gerador.nextInt(60) + 1);
        }
		numerosDaAposta.sort(null);
		return numerosDaAposta;
	}
	
	public String converterParaString(List<Integer> numeros) {
		String texto = numeros.stream().map(String::valueOf).collect(Collectors.joining("-"));
		return texto;
	}
	
	public List<Integer> converterParaListaDeInteiros(String texto){
		List<Integer> numeros = Arrays.stream(texto.split("-"))
		        .map(Integer::valueOf)
		        .collect(Collectors.toList());
		return numeros;
	}
}

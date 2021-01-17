package br.com.zup.loteria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.zup.loteria.model.Aposta;

public interface ApostaRepository extends JpaRepository<Aposta, Long> {

	List<Aposta> findByEmail(String email);

}



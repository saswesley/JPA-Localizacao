package io.github.saswesley.localizacao;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.saswesley.localizacao.domain.entity.Cidade;
import io.github.saswesley.localizacao.domain.repository.CidadeRepository;
import jakarta.transaction.Transactional;


@SpringBootApplication
public class LocalizacaoApplication implements CommandLineRunner {

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Override
	public void run(String... args) throws Exception {
		listarCidadesPorNome();
	}
	
	void listarCidadesPorNome() {
		cidadeRepository.findByNome("Porto Velho").forEach(System.out::println);
		cidadeRepository.findByNomeStartingWith("Porto").forEach(System.out::println);
	}
	
	void listarCidadesPorHabitantes() {
		cidadeRepository.findByHabitantes(78787900L).forEach(System.out::println);
	}
	
	@Transactional
	void salvarCidade() {
		var cidade = new Cidade(1L, "São Paulo", 12396372L);
		cidadeRepository.save(cidade);
		
	}
	
	
	void listarCidades() {
		cidadeRepository.findAll().forEach(System.out::println);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(LocalizacaoApplication.class, args);
	}


}

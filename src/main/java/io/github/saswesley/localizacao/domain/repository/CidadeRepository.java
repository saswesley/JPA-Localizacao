package io.github.saswesley.localizacao.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import io.github.saswesley.localizacao.domain.entity.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}

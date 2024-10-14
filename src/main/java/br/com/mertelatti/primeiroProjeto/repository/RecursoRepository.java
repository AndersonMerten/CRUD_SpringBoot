package br.com.mertelatti.primeiroProjeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mertelatti.primeiroProjeto.entity.RecursoEntity;

public interface RecursoRepository extends JpaRepository<RecursoEntity, Long>{

}

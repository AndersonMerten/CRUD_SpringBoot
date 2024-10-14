package br.com.mertelatti.primeiroProjeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mertelatti.primeiroProjeto.entity.PerfilUsuarioEntity;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {

}

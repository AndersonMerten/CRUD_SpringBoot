package br.com.mertelatti.primeiroProjeto.repository;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mertelatti.primeiroProjeto.entity.UsuarioEntity;
import br.com.mertelatti.primeiroProjeto.entity.VerificaUsuarioEntity;

public interface VerificaUsuarioRepository extends JpaRepository<VerificaUsuarioEntity, Long>{
	
	public Optional<VerificaUsuarioEntity> findByUuid(UUID uuid);

}

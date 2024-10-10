package br.com.mertelatti.primeiroProjeto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mertelatti.primeiroProjeto.entity.UsuarioEntity;


//aqui o JPA da um jeito de lidar com o banco, sem tanto stress. faz o crud
// no usuario service, usando os metodos do repository.
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>{

}

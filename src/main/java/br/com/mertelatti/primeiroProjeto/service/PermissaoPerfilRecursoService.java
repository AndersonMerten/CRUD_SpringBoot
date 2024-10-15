package br.com.mertelatti.primeiroProjeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mertelatti.primeiroProjeto.dto.PermissaoPerfilRecursoDTO;
import br.com.mertelatti.primeiroProjeto.entity.PermissaoPerfilRecursoEntity;
import br.com.mertelatti.primeiroProjeto.repository.PermissaoPerfilRecursoRepository;


@Service
public class PermissaoPerfilRecursoService {
	
	@Autowired
	private PermissaoPerfilRecursoRepository permissaoRepository;
	
	public List<PermissaoPerfilRecursoDTO> listarTodos(){
		List<PermissaoPerfilRecursoEntity> permissao = permissaoRepository.findAll();
		return permissao.stream().map(PermissaoPerfilRecursoDTO::new).toList();
	}
	
	public void inserir(PermissaoPerfilRecursoDTO permissao) {
		PermissaoPerfilRecursoEntity permissaoEntity = new PermissaoPerfilRecursoEntity(permissao);
		permissaoRepository.save(permissaoEntity);
	}
	
	public PermissaoPerfilRecursoDTO alterar(PermissaoPerfilRecursoDTO permissao) {
		PermissaoPerfilRecursoEntity permissaoEntity = new PermissaoPerfilRecursoEntity(permissao);
		permissaoRepository.save(permissaoEntity);
		return new PermissaoPerfilRecursoDTO(permissaoEntity);
	}
	
	public void excluir (Long id) {
		PermissaoPerfilRecursoEntity permissaoEntity = permissaoRepository.findById(id).get();
		permissaoRepository.delete(permissaoEntity);
	}
	
	public PermissaoPerfilRecursoDTO buscarPorId (Long id) {
		PermissaoPerfilRecursoDTO permissao = new PermissaoPerfilRecursoDTO(permissaoRepository.findById(id).get());
		return permissao;
	}


}

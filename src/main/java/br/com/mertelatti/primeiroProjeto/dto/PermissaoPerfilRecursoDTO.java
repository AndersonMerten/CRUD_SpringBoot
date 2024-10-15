package br.com.mertelatti.primeiroProjeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.mertelatti.primeiroProjeto.entity.PermissaoPerfilRecursoEntity;


public class PermissaoPerfilRecursoDTO {

	private Long id;
	private PerfilDTO perfil;
	private RecursoDTO recurso;
	
	public PermissaoPerfilRecursoDTO() {
		
	}
	
	public PermissaoPerfilRecursoDTO(PermissaoPerfilRecursoEntity permissao) {
		BeanUtils.copyProperties(permissao, this);
		if(permissao != null && permissao.getPerfil() != null) {
			this.perfil = new PerfilDTO(permissao.getPerfil());
		}
		if(permissao != null && permissao.getRecurso() != null) {
			this.recurso = new RecursoDTO(permissao.getRecurso());
		}
	}
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public PerfilDTO getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilDTO perfil) {
		this.perfil = perfil;
	}
	public RecursoDTO getRecurso() {
		return recurso;
	}
	public void setRecurso(RecursoDTO recurso) {
		this.recurso = recurso;
	}
	
	
}

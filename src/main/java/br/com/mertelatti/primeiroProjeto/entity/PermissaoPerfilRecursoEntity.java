package br.com.mertelatti.primeiroProjeto.entity;

import java.util.Objects;

import org.springframework.beans.BeanUtils;

import br.com.mertelatti.primeiroProjeto.dto.PermissaoPerfilRecursoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Permissao_Perfil_Recurso")
public class PermissaoPerfilRecursoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name="id_perfil")
	private PerfilEntity perfil;
	
	@ManyToOne
	@JoinColumn(name="id_recurso")
	private RecursoEntity recurso;
	
	public PermissaoPerfilRecursoEntity() {
		
	}
	
	public PermissaoPerfilRecursoEntity(PermissaoPerfilRecursoDTO permissao) {
		BeanUtils.copyProperties(permissao, this);
		if(permissao != null && permissao.getPerfil() != null) {
			this.perfil = new PerfilEntity(permissao.getPerfil());
		}
		if(permissao != null && permissao.getRecurso() != null) {
			this.recurso = new RecursoEntity(permissao.getRecurso());
		}		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

	public RecursoEntity getRecurso() {
		return recurso;
	}

	public void setRecurso(RecursoEntity recurso) {
		this.recurso = recurso;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissaoPerfilRecursoEntity other = (PermissaoPerfilRecursoEntity) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	

}

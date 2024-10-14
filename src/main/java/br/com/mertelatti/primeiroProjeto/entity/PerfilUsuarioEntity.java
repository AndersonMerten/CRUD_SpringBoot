package br.com.mertelatti.primeiroProjeto.entity;

import org.springframework.beans.BeanUtils;

import br.com.mertelatti.primeiroProjeto.dto.PerfilUsuarioDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name ="Perfil_Usuario")
public class PerfilUsuarioEntity {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "Id_Usuario")
	private UsuarioEntity usuario;
	
	@ManyToOne
	@JoinColumn(name = "Id_Perfil")
	private PerfilEntity perfil;
	
	public PerfilUsuarioEntity () {
		
	}
	
	public PerfilUsuarioEntity (PerfilUsuarioDTO perfilUsuario) {
		BeanUtils.copyProperties(perfilUsuario, this);
		if(perfilUsuario != null && perfilUsuario.getUsuario() != null) {
			this.usuario = new UsuarioEntity(perfilUsuario.getUsuario());
		}
		if(perfilUsuario != null && perfilUsuario.getPerfil() != null) {
			this.perfil = new PerfilEntity (perfilUsuario.getPerfil());
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}

	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}

	public PerfilEntity getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}
	
	
	

}

package br.com.mertelatti.primeiroProjeto.dto;

import org.springframework.beans.BeanUtils;

import br.com.mertelatti.primeiroProjeto.entity.PerfilEntity;

public class PerfilDTO {

		private Long id;
		
		private String descricao;
		
		public PerfilDTO() {
			
		}
		
		public PerfilDTO (PerfilEntity perfil) {
			BeanUtils.copyProperties(perfil, this);
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}
		
		
}

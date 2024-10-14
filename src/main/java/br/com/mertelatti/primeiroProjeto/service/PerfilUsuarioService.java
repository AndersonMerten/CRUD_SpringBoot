package br.com.mertelatti.primeiroProjeto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.mertelatti.primeiroProjeto.dto.PerfilUsuarioDTO;
import br.com.mertelatti.primeiroProjeto.entity.PerfilUsuarioEntity;
import br.com.mertelatti.primeiroProjeto.repository.PerfilUsuarioRepository;

@Service
public class PerfilUsuarioService {
	
	@Autowired
	private PerfilUsuarioRepository perfilUsuarioRepository;
	
	public List<PerfilUsuarioDTO> listarTodos(){
		List<PerfilUsuarioEntity> perfilUsuarios = perfilUsuarioRepository.findAll();
		return perfilUsuarios.stream().map(PerfilUsuarioDTO::new).toList();
	}
	
	public void inserir(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
	}
	
	public PerfilUsuarioDTO alterar(PerfilUsuarioDTO perfilUsuario) {
		PerfilUsuarioEntity perfilUsuarioEntity = new PerfilUsuarioEntity(perfilUsuario);
		perfilUsuarioRepository.save(perfilUsuarioEntity);
		return new PerfilUsuarioDTO(perfilUsuarioEntity);
	}
	
	public void excluir (Long id) {
		PerfilUsuarioEntity perfilUsuarioEntity = perfilUsuarioRepository.findById(id).get();
		perfilUsuarioRepository.delete(perfilUsuarioEntity);
	}
	
	public PerfilUsuarioDTO buscarPorId (Long id) {
		PerfilUsuarioDTO perfilUsuarioDTO = new PerfilUsuarioDTO(perfilUsuarioRepository.findById(id).get());
		return perfilUsuarioDTO;
	}

}

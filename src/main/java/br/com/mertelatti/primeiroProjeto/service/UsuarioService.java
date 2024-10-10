package br.com.mertelatti.primeiroProjeto.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mertelatti.primeiroProjeto.repository.UsuarioRepository;
import br.com.mertelatti.primeiroProjeto.dto.UsuarioDTO;
import br.com.mertelatti.primeiroProjeto.entity.UsuarioEntity;

//metodos crud implementados
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public List<UsuarioDTO>listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioRepository.save(usuarioEntity);
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		return new UsuarioDTO(usuarioRepository.save(usuarioEntity));
	}
	
	public void excluir(Long id) {
		UsuarioEntity usuarioEntity = usuarioRepository.findById(id).get();
		usuarioRepository.delete(usuarioEntity);		
	}
	
	public UsuarioDTO buscarPorId (Long id) {
		return new UsuarioDTO(usuarioRepository.findById(id).get());
	}
}

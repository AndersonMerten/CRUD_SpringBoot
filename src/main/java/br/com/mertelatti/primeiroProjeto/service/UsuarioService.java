package br.com.mertelatti.primeiroProjeto.service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.mertelatti.primeiroProjeto.repository.UsuarioRepository;
import br.com.mertelatti.primeiroProjeto.repository.VerificaUsuarioRepository;
import br.com.mertelatti.primeiroProjeto.dto.UsuarioDTO;
import br.com.mertelatti.primeiroProjeto.entity.UsuarioEntity;
import br.com.mertelatti.primeiroProjeto.entity.VerificaUsuarioEntity;
import br.com.mertelatti.primeiroProjeto.entity.enums.TipoSituacaoUsuario;

//metodos crud implementados
@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private VerificaUsuarioRepository verificaUsuarioRepository;
	

	
	public List<UsuarioDTO>listarTodos(){
		List<UsuarioEntity> usuarios = usuarioRepository.findAll();
		return usuarios.stream().map(UsuarioDTO::new).toList();
	}
	
	public void inserir(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioRepository.save(usuarioEntity);
	}
	
	public void inserirNovoUsuario (UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
		usuarioEntity.setSituacao(TipoSituacaoUsuario.PENDENTE);
		usuarioEntity.setId(null);
		usuarioRepository.save(usuarioEntity);
		
		VerificaUsuarioEntity verificador = new VerificaUsuarioEntity();
		verificador.setUsuario(usuarioEntity);
		verificador.setUuid(UUID.randomUUID());
		verificador.setDataExpiracao(Instant.now().plusMillis(900000));
		verificaUsuarioRepository.save(verificador);
		
		
		emailService.enviarEmailTexto(usuario.getEmail(), "Novo usuário cadastrado", "Você está recebendo um e-mail de cadastro. Para validar seu e-mail, utilize esse código: " + verificador.getUuid());
		
		
	}
	
	public String verificarCadastro(String uuid) {
		VerificaUsuarioEntity usuarioVerificacao =  verificaUsuarioRepository.findByUuid(UUID.fromString(uuid)).get();
		if(usuarioVerificacao != null) {
			if(usuarioVerificacao.getDataExpiracao().compareTo(Instant.now()) >=0) {
				UsuarioEntity usuario = usuarioVerificacao.getUsuario();
				usuario.setSituacao(TipoSituacaoUsuario.ATIVO);				
				usuarioRepository.save(usuario);
				return "usuario verificado";
			}else {
				verificaUsuarioRepository.delete(usuarioVerificacao);
				return "tempo de verificação expirado";
			}
		}else {
			return "Usuário não verificado";
		}
	}
	
	public UsuarioDTO alterar(UsuarioDTO usuario) {
		UsuarioEntity usuarioEntity = new UsuarioEntity(usuario);
		usuarioEntity.setSenha(passwordEncoder.encode(usuario.getSenha()));
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

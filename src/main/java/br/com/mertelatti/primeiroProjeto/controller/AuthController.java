package br.com.mertelatti.primeiroProjeto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mertelatti.primeiroProjeto.dto.AuthDto;
import br.com.mertelatti.primeiroProjeto.dto.UsuarioDTO;
import br.com.mertelatti.primeiroProjeto.service.AuthService;
import br.com.mertelatti.primeiroProjeto.service.UsuarioService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {
	
	@Autowired
	private AuthService authService;
	
	@Autowired
	private UsuarioService usuarioService;

	@PostMapping(value = "/login")
	public ResponseEntity<?> login(@RequestBody AuthDto authDto) {
		return ResponseEntity.ok(authService.login(authDto));
	}
	
	@PostMapping(value="/novoUsuario")
	public void inserirNovoUsuario (@RequestBody UsuarioDTO novoUsuario){
		usuarioService.inserirNovoUsuario(novoUsuario);		
	}
	
	@GetMapping(value = "/verificarCadastro/{uuid}")
	 public String verificarCadastro(@PathVariable("uuid") String uuid) {
		return usuarioService.verificarCadastro(uuid);

	}
	
}

package br.com.mertelatti.primeiroProjeto.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mertelatti.primeiroProjeto.dto.PerfilUsuarioDTO;
import br.com.mertelatti.primeiroProjeto.dto.PermissaoPerfilRecursoDTO;
import br.com.mertelatti.primeiroProjeto.service.PermissaoPerfilRecursoService;

@RestController
@CrossOrigin
@RequestMapping(value = "/permissao-perfil-recurso")
public class PermissaoPerfilRecursoController {

	@Autowired
	private PermissaoPerfilRecursoService  permissaoService;
	
	@GetMapping
	public List<PermissaoPerfilRecursoDTO> listarTodos(){
		return permissaoService.listarTodos();
	}
	
	@PostMapping
	public void inserir (@RequestBody PermissaoPerfilRecursoDTO permissao) {
		permissaoService.inserir(permissao);
	}
	
	@PutMapping
	public PermissaoPerfilRecursoDTO alterar (@RequestBody PermissaoPerfilRecursoDTO permissao) {
		return permissaoService.alterar(permissao);
	}

	@DeleteMapping("/{id}")
	public void excluir (@PathVariable Long id) {
		permissaoService.excluir(id);
	}
	
	
}

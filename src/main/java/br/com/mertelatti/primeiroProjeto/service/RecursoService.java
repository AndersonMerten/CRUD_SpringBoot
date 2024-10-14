package br.com.mertelatti.primeiroProjeto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mertelatti.primeiroProjeto.dto.RecursoDTO;
import br.com.mertelatti.primeiroProjeto.entity.RecursoEntity;
import br.com.mertelatti.primeiroProjeto.repository.RecursoRepository;

@Service
public class RecursoService {
	
	@Autowired
	private RecursoRepository recursoRepository;
	
	public List<RecursoDTO> listarTodos(){
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDTO::new).toList();
	}
	
	public void inserir(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
		return new RecursoDTO(recursoEntity);
	}
	
	public void excluir (Long id) {
		RecursoEntity recursoEntity = recursoRepository.findById(id).get();
		recursoRepository.delete(recursoEntity);
	}
	
	public RecursoDTO buscarPorId (Long id) {
		RecursoDTO recurso = new RecursoDTO(recursoRepository.findById(id).get());
		return recurso;
	}
	
	
	
}

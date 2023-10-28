package br.com.descomplica.projeto.documentacao.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.descomplica.projeto.documentacao.entity.Turma;
import br.com.descomplica.projeto.documentacao.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	TurmaService turmaService;
	
	@GetMapping
	public ResponseEntity<List<Turma>> getAll(){
		List<Turma> turmas = turmaService.getAll();
		if(!turmas.isEmpty())
			return new ResponseEntity<>(turmas, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Turma> getById(@PathVariable Integer id) {
		Turma turma = turmaService.getById(id);
		if(turma != null)
			return new ResponseEntity<>(turma, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.saveTurma(turma), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Turma> updateTurma(@PathVariable Integer id, @RequestBody Turma turma) {
		Turma turmaAtualizada = turmaService.updateTurma(id, turma);
		if(turmaAtualizada != null)
			return new ResponseEntity<>(turmaAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteTurma(@PathVariable Integer id) {
		if(turmaService.deleteTurma(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}

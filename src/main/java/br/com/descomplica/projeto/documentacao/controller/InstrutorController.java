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

import br.com.descomplica.projeto.documentacao.entity.Instrutor;
import br.com.descomplica.projeto.documentacao.service.InstrutorService;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {
	@Autowired
	InstrutorService instrutorService;
	
	@GetMapping
	public ResponseEntity<List<Instrutor>> getAll(){
		List<Instrutor> instrutors = instrutorService.getAll();
		if(!instrutors.isEmpty())
			return new ResponseEntity<>(instrutors, HttpStatus.OK);
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Instrutor> getById(@PathVariable Integer id) {
		Instrutor instrutor = instrutorService.getById(id);
		if(instrutor != null)
			return new ResponseEntity<>(instrutor, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);		
	}
	
	@PostMapping
	public ResponseEntity<Instrutor> saveInstrutor(@RequestBody Instrutor instrutor) {
		return new ResponseEntity<>(instrutorService.saveInstrutor(instrutor), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Instrutor> updateInstrutor(@PathVariable Integer id, @RequestBody Instrutor instrutor) {
		Instrutor instrutorAtualizada = instrutorService.updateInstrutor(id, instrutor);
		if(instrutorAtualizada != null)
			return new ResponseEntity<>(instrutorAtualizada, HttpStatus.OK); 
		else 
			return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> deleteInstrutor(@PathVariable Integer id) {
		if(instrutorService.deleteInstrutor(id))
			return new ResponseEntity<>(true, HttpStatus.OK);
		else 
			return new ResponseEntity<>(false, HttpStatus.OK);
	}
}

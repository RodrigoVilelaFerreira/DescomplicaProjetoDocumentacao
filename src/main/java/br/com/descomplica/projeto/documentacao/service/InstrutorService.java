package br.com.descomplica.projeto.documentacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.descomplica.projeto.documentacao.entity.Instrutor;
import br.com.descomplica.projeto.documentacao.repository.InstrutorRepository;

@Service
public class InstrutorService {
	@Autowired
	InstrutorRepository instrutorRepository;
	
	public List<Instrutor> getAll(){
		return instrutorRepository.findAll();
	}
	
	public Instrutor getById(Integer id) {
		return instrutorRepository.findById(id).orElse(null) ;
	}
	
	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}
	
	public Instrutor updateInstrutor(Integer id, Instrutor instrutor) {
		Instrutor instrutorAtualizada = instrutorRepository.findById(id).orElse(null);
		if(instrutorAtualizada != null) {
			instrutorAtualizada.setRg(instrutor.getRg());
			instrutorAtualizada.setNome(instrutor.getNome());
			instrutorAtualizada.setNascimento(instrutor.getNascimento());
			instrutorAtualizada.setTitulacao(instrutor.getTitulacao());
			instrutorAtualizada.setTurmas(instrutor.getTurmas());
			return instrutorRepository.save(instrutorAtualizada);
		}else {
			return null;
		}
	}

	public Boolean deleteInstrutor(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).orElse(null);
		if(instrutor != null) {
			instrutorRepository.delete(instrutor);
			return true;
		}else {
			return false;
		}
	}
}

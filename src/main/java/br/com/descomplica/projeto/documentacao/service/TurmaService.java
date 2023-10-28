package br.com.descomplica.projeto.documentacao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.descomplica.projeto.documentacao.entity.Turma;
import br.com.descomplica.projeto.documentacao.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository turmaRepository;
	
	public List<Turma> getAll(){
		return turmaRepository.findAll();
	}
	
	public Turma getById(Integer id) {
		return turmaRepository.findById(id).orElse(null) ;
	}
	
	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}
	
	public Turma updateTurma(Integer id, Turma turma) {
		Turma turmaAtualizado = turmaRepository.findById(id).orElse(null);
		if(turmaAtualizado != null) {
			turmaAtualizado.setHorario(turma.getHorario());
			turmaAtualizado.setDuracao(turma.getDuracao());
			turmaAtualizado.setDataInicio(turma.getDataInicio());
			turmaAtualizado.setDataFim(turma.getDataFim());
			turmaAtualizado.setInstrutor(turma.getInstrutor());
			return turmaRepository.save(turmaAtualizado);
		}else {
			return null;
		}
	}

	public Boolean deleteTurma(Integer id) {
		Turma turma = turmaRepository.findById(id).orElse(null);
		if(turma != null) {
			turmaRepository.delete(turma);
			return true;
		}else {
			return false;
		}
	}
}

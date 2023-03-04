package br.com.domain.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import br.com.domain.model.entity.Tarefa;
import br.com.domain.model.repository.TarefaRepository;
import br.com.domain.model.service.TarefaService;
import jakarta.transaction.Transactional;

@Service
public class TarefaServiceImpl implements TarefaService {

	@Autowired
	private TarefaRepository tarefaRepository;
	@Transactional
	@Override
	public Tarefa salvarTarefa(Tarefa tarefa) {
		return tarefaRepository.save(tarefa);
	}
	
	@Override
	public Tarefa buscarTarefa(Integer id) {
		return tarefaRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Tarefa não encontrada"));
	}

	@Transactional
	@Override
	public Tarefa atualizarTarefa(Integer id, Tarefa tarefa) {
		Tarefa tarefaEncontrada = buscarTarefa(id);
		tarefa.setId(tarefaEncontrada.getId());
		return tarefa;
	}

	@Transactional
	@Override
	public void excluirTarefa(Integer id) {
		Tarefa tarefaEncontrada = buscarTarefa(id);
		tarefaRepository.deleteById(tarefaEncontrada.getId());
	}

	@Override
	public List<Tarefa> buscarTarefasOrdenadasPorData() {
		List<Tarefa> tarefas = tarefaRepository.buscarTarefasByDate();
		if(tarefas.isEmpty())
			throw new RuntimeException("Não há tarefas salvas");
		return tarefas;
	}

}

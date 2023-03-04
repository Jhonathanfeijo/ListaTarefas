package br.com.domain.model.service;

import java.util.List;

import br.com.domain.model.entity.Tarefa;

public interface TarefaService {
	
	public Tarefa salvarTarefa(Tarefa tarefa);
	
	public Tarefa buscarTarefa(Integer id);
	
	public Tarefa atualizarTarefa(Integer id, Tarefa tarefa);
	
	public void excluirTarefa(Integer id);
	
	public List<Tarefa> buscarTarefasOrdenadasPorData();
}

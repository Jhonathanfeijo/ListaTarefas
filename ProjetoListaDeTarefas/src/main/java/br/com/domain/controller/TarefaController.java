package br.com.domain.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.domain.model.entity.Tarefa;
import br.com.domain.model.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {

	@Autowired
	private TarefaService tarefaService;

	@GetMapping("/{id}")
	public Tarefa buscarTarefa(@PathVariable("id") Integer id) {
		return tarefaService.buscarTarefa(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Tarefa salvarTarefa(@RequestBody Tarefa tarefa) {
		return tarefaService.salvarTarefa(tarefa);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public Tarefa atualizarTarefa(@PathVariable("id") Integer id, @RequestBody Tarefa tarefa) {
		return tarefaService.atualizarTarefa(id, tarefa);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void excluirTarefa(@PathVariable("id") Integer id) {
		tarefaService.excluirTarefa(id);
	}

	@GetMapping("/all")
	public List<Tarefa> listarTarefas() {
		return tarefaService.buscarTarefasOrdenadasPorData();
	}

}

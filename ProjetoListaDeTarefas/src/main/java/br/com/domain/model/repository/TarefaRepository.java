package br.com.domain.model.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.domain.model.entity.Tarefa;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Integer> {
	@Query(value = "select * from tarefa t order by t.data_tarefa", nativeQuery = true)
	public List<Tarefa> buscarTarefasByDate();
}

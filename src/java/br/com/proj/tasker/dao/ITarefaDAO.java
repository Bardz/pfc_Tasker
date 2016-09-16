/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Tarefa;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface ITarefaDAO {

    public void cadastrarTarefa(Tarefa tar);

    public void alterarTarefa(Tarefa tar);

    public List<Tarefa> buscaTarProj(Integer id);
    
    public List<Tarefa> buscaTarProjCargo(Integer id, Integer id2);

    public Tarefa listarPorId(Integer id);

}

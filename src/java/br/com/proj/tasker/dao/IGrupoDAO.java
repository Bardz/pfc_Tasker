/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Grupo;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IGrupoDAO {
    
    public void inserirGrupo (Grupo grupo);
    public List<Grupo> buscaGrupoAtivo (Integer id);
    public Grupo listarPorId(Integer id);
    public void alterarGrupo(Grupo grupo);
    public Integer getGrupoProjs(Integer id);
    
}

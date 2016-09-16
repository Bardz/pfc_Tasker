/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Projeto;
import java.util.List;

/**
 *
 * @author Bruno
 */
public interface IProjetoDAO {

    public void cadastrarProjeto(Projeto proj);

    public List<Projeto> buscaProjGru(Integer id);

    public void alterarProjeto(Projeto projeto);
    
    public Projeto listarPorId(Integer id);

    public Integer getProjTars(Integer id);
    
}

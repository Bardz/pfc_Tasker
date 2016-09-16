/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Ativmembros;

/**
 *
 * @author Oswaldo
 */
public interface IAtivMembrosDAO {

    public void regGrupo(Ativmembros am);

    public Integer buscaAut(Integer idGru, Integer idPes);

    public Integer buscaCargo(Integer idGru, Integer idPes);
    
}

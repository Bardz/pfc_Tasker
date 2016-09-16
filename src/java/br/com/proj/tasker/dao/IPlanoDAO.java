/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Plano;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IPlanoDAO {
    
    public List<Plano> buscarTodos(Plano plano);
    public Plano buscarPlano (int i);
    public List<Plano> buscarListPlano(Plano plano);
}

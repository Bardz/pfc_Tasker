/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Cargo;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface ICargoDAO {
    
    public List<Cargo> getCargoUser(Integer id, Integer id2);
    public void inserirCargo(Cargo cargo);
    public List<Cargo> buscaCargosGru(Integer id);
    
}

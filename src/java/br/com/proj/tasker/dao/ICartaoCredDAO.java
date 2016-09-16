/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Cartaocred;
import java.util.List;
/**
 *
 * @author Monteiro
 */
public interface ICartaoCredDAO {
    
    public void inserirCartaoCred (Cartaocred card);
    public void alterarCartaoCred (Cartaocred card);
    public void deletarCartaoCred (Cartaocred card);
    public Cartaocred listarPorId(Integer id);
    public List<Cartaocred> listarTodos();
    public Cartaocred listarPorUser(Integer id);
    
}
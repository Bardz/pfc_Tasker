/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Telefone;
import java.util.List;
/**
 *
 * @author Monteiro
 */
public interface ITelefoneDAO {
    
    public void inserirTelefone (Telefone tel);
    public void alterarTelefone (Telefone tel);
    public void deletarTelefone (Telefone tel);
    public Telefone listarPorId(Integer id);
    public List<Telefone> listarTodos();
    public Telefone listarPorUser(Integer id);
    
}

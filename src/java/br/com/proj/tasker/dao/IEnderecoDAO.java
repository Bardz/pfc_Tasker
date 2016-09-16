/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Endereco;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IEnderecoDAO {
    
    public void inserirEndereco (Endereco end);
    public void alterarEndereco (Endereco end);
    public void deletarEndereco (Endereco end);
    public Endereco listarPorId(Integer id);
    public List<Endereco> listarTodos();
    public Endereco listarPorUser(Integer id);
    
}
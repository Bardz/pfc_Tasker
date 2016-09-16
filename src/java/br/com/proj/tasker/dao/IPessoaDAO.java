/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Pessoa;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IPessoaDAO {
    
    public void inserirPessoa (Pessoa pessoa);
    public void alterarPessoa (Pessoa pessoa);
    public void deletarPessoa (Pessoa pessoa);
    public Pessoa listarPorId(Integer id);
    public Pessoa listarPorIdUser(Integer id);
    public List<Pessoa> listarTodos();
    
}

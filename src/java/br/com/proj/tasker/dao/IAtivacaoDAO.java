/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Ativacao;

/**
 *
 * @author Oswaldo
 */
public interface IAtivacaoDAO {
    
    public void confAtivacao(Ativacao ativ);
    public int getFromChave(String chave);
    public void delAtivacao(Ativacao ativ);
    
}

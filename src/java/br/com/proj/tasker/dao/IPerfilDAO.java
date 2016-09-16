/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Perfil;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IPerfilDAO {
    
    public Perfil buscaAdmin();
    public Perfil buscaGerente();
    public Perfil buscaSuperv();
    public Perfil buscaFunc();
    public List<Perfil> buscarTodos(Perfil perfil);
    
}

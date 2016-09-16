/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao;

import br.com.proj.tasker.model.Usuario;
import java.util.List;

/**
 *
 * @author Oswaldo
 */
public interface IUsuarioDAO {
    
    public void inserirUsuario (Usuario usuario);
    public void alterarUsuario (Usuario usuario);
    public void deletarUsuario (Usuario usuario);
    public Usuario buscarUsuario(Usuario usuario);
    public Usuario buscarPorMail(Usuario usuario);
    public Usuario buscarPorId (Usuario usuario);
    public List<Usuario> buscarTodos(Usuario usuario);
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IPerfilDAO;
import br.com.proj.tasker.dao.impl.PerfilDAO;
import br.com.proj.tasker.model.Perfil;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "perfilBean")
@SessionScoped
public class PerfilBean {
    
    private Perfil perfil;
    private List<Perfil> perfis;
    
    public PerfilBean() {
    }
    
    public Perfil getPerfil() {
        if (perfil == null){
            perfil = new Perfil();
        }
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
    
    public Perfil getPerfAdm(){
        IPerfilDAO dao = new PerfilDAO();
        perfil = dao.buscaAdmin();
        return perfil;
    }
    
    public Perfil getPerfGer(){
        IPerfilDAO dao = new PerfilDAO();
        perfil = dao.buscaGerente();
        return perfil;
    }
    
    public Perfil getPerfSup(){
        IPerfilDAO dao = new PerfilDAO();
        perfil = dao.buscaSuperv();
        return perfil;
    }
    
    public Perfil getPerfFunc(){
        IPerfilDAO dao = new PerfilDAO();
        perfil = dao.buscaFunc();
        return perfil;
    }
    
    public List<Perfil> getPerfis(){
        IPerfilDAO dao = new PerfilDAO();
        perfis = dao.buscarTodos(perfil);
        return perfis;
    }
    
}

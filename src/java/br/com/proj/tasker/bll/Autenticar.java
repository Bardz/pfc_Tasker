/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.bll;

import br.com.proj.tasker.control.PessoaBean;
import br.com.proj.tasker.dao.IAtivMembrosDAO;
import br.com.proj.tasker.dao.impl.AtivMembrosDAO;
import br.com.proj.tasker.model.Grupo;
import br.com.proj.tasker.model.Projeto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "autenticar")
@SessionScoped
public class Autenticar {

    @ManagedProperty(value = "#{pessoaBean}")
    private PessoaBean pessoaBean;

    public Autenticar() {
    }

    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public boolean autenticaPermInserirMGru(Grupo grupo) {
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        int aut = dao.buscaAut(grupo.getIdGrupo(), pessoaBean.getPessoaUser().getIdPes());
        if (aut == 1) {
            return true;
        } else if (aut == 2) {
            return true;
        } else if (aut == 3) {
            return false;
        } else if (aut == 4) {
            return false;
        } else {
            return false;
        }
    }
    
    public boolean autenticaPermExcluirGru(Grupo grupo) {
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        int aut = dao.buscaAut(grupo.getIdGrupo(), pessoaBean.getPessoaUser().getIdPes());
        if (aut == 1) {
            return true;
        } else if (aut == 2) {
            return false;
        } else if (aut == 3) {
            return false;
        } else if (aut == 4) {
            return false;
        } else {
            return false;
        }
    }
    
    public boolean autenticaPermCriarProj(Grupo grupo) {
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        int aut = dao.buscaAut(grupo.getIdGrupo(), pessoaBean.getPessoaUser().getIdPes());
        if (aut == 1) {
            return true;
        } else if (aut == 2) {
            return true;
        } else if (aut == 3) {
            return false;
        } else if (aut == 4) {
            return false;
        } else {
            return false;
        }
    }
    
    public boolean autenticaPermDesatProj(Projeto projeto) {
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        int aut = dao.buscaAut(projeto.getGrupo().getIdGrupo(), pessoaBean.getPessoaUser().getIdPes());
        if (aut == 1) {
            return true;
        } else if (aut == 2) {
            return true;
        } else if (aut == 3) {
            return false;
        } else if (aut == 4) {
            return false;
        } else {
            return false;
        }
    }
    
}

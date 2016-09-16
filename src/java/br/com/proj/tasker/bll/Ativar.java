/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.bll;

import br.com.proj.tasker.control.AtivacaoBean;
import br.com.proj.tasker.control.UsuarioBean;
import br.com.proj.tasker.model.Ativacao;
import br.com.proj.tasker.model.Usuario;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "ativar")
@RequestScoped
public class Ativar {

    @ManagedProperty(value="#{param.chave}")
    private String chave;
    private boolean valid;
    private AtivacaoBean ativBean;
    private UsuarioBean usuBean;
    private Ativacao ativ;
    private Usuario usu;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public AtivacaoBean getAtivBean() {
        return ativBean;
    }

    public void setAtivBean(AtivacaoBean ativBean) {
        this.ativBean = ativBean;
    }

    public UsuarioBean getUsuBean() {
        return usuBean;
    }

    public void setUsuBean(UsuarioBean usuBean) {
        this.usuBean = usuBean;
    }

    public Ativacao getAtiv() {
        return ativ;
    }

    public void setAtiv(Ativacao ativ) {
        this.ativ = ativ;
    }

    @PostConstruct
    public void init() {
        // Get User based on activation key.
        ativBean = new AtivacaoBean();
        usuBean = new UsuarioBean();
        ativ = new Ativacao();
        usu = new Usuario();
        int id = ativBean.retAtiva(chave);
        usu.setIdUser(id);
        usuBean.ativarUsuario(usu);
        usuBean.setUsuario(usu);
        // Delete activation key from database.
        ativ.setChave(chave);
        ativBean.deletaAtiva(ativ);
        // Login user.
        setValid(true);
    }

    }

    // ...
    

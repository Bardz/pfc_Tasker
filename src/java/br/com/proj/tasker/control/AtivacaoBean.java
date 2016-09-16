/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.bll.Email;
import br.com.proj.tasker.dao.IAtivacaoDAO;
import br.com.proj.tasker.dao.impl.AtivacaoDAO;
import br.com.proj.tasker.model.Ativacao;
import br.com.proj.tasker.model.Usuario;
import java.util.UUID;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Oswaldo
 */

@ManagedBean(name ="ativacaoBean")
@SessionScoped
public class AtivacaoBean {
    
    private Ativacao ativ;

    public AtivacaoBean() {
    }

    public Ativacao getAtiv() {
        if (ativ == null){
            ativ = new Ativacao();
        }
        return ativ;
    }

    public void setAtiv(Ativacao ativ) {
        this.ativ = ativ;
    }

    public void prepararAtivacao(){
        ativ = new Ativacao();
    }
    
    public void cadAtivacao(Usuario user) throws EmailException{
        IAtivacaoDAO dao = new AtivacaoDAO();
        Email mail = new Email();
        ativ = new Ativacao();
        String uuid = UUID.randomUUID().toString();
        ativ.setChave(uuid);
        ativ.setUsuario(user);
        dao.confAtivacao(ativ);
        mail.regConfMail(ativ);
        ativ = new Ativacao();
    }
    
    public int retAtiva(String chave){
        IAtivacaoDAO dao = new AtivacaoDAO();
        int id = dao.getFromChave(chave);
        return id;
    }
    
    public void deletaAtiva(Ativacao ativ){
        IAtivacaoDAO dao = new AtivacaoDAO();
        dao.delAtivacao(ativ);
    }
    
}

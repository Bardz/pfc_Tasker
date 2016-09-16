/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.ITelefoneDAO;
import br.com.proj.tasker.dao.impl.TelefoneDAO;
import br.com.proj.tasker.model.Telefone;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
/**
 *
 * @author Monteiro
 */

@ManagedBean(name = "telefoneBean")
@SessionScoped
public class TelefoneBean {
    
    @ManagedProperty(value="#{pessoaBean}")
    private PessoaBean pessoaBean;
    private Telefone tel;
    private List<Telefone> tels;
    
    public TelefoneBean(){    
    }
    
    public Telefone getTelefone(){
        if(tel == null){
            tel = new Telefone();
        }
        return tel;
    }
    
    public void setTelefone(Telefone tel){
        this.tel = tel;
    }
    
    public List<Telefone> getTelefones(){
        ITelefoneDAO dao = new TelefoneDAO();
        tels = dao.listarTodos();
        return tels;
    }
    
    public Telefone getTelefoneUser(){
        ITelefoneDAO dao = new TelefoneDAO();
        tel = dao.listarPorUser(pessoaBean.getPessoaUser().getIdPes());
        return tel;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }
    
    public void prepararInserir(){
        tel = new Telefone();
    }
    
    public void inserir(){
        ITelefoneDAO dao = new TelefoneDAO();
        tel.setPessoa(pessoaBean.getPessoaUser());
        dao.inserirTelefone(tel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso","O Telefone foi adicionado com sucesso!"));
        tel = new Telefone();
    }
    
    public void prepararAtualizar(Integer id){
        ITelefoneDAO dao = new TelefoneDAO();
        tel = dao.listarPorId(id);
    }
    
    public void atualizar(){
        ITelefoneDAO dao = new TelefoneDAO();
        dao.alterarTelefone(tel);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Telefone foi deletado com sucesso!"));
        tel = new Telefone();
    }
    
    public void eliminar(){
        ITelefoneDAO dao = new TelefoneDAO();
        dao.deletarTelefone(tel);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "O Endereço foi deletado com Sucesso!"));
        tel = new Telefone();
    }
    
}

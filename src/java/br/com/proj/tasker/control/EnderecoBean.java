/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IEnderecoDAO;
import br.com.proj.tasker.dao.impl.EnderecoDAO;
import br.com.proj.tasker.model.Endereco;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "enderecoBean")
@SessionScoped
public class EnderecoBean {

    @ManagedProperty(value="#{pessoaBean}")
    private PessoaBean pessoaBean;
    private Endereco end;
    private List<Endereco> ends;
      
    public EnderecoBean() {
    }
    
    public Endereco getEndereco() {
        if (end == null){
            end = new Endereco();
        }
        return end;
    }

    public void setEndereco(Endereco end) {
        this.end = end;
    }
    
    public List<Endereco> getEnderecos() {
        IEnderecoDAO dao = new EnderecoDAO();
        ends = dao.listarTodos();
        return ends;
    }
    
    public Endereco getEnderecoUser(){
        IEnderecoDAO dao = new EnderecoDAO();
        end = dao.listarPorUser(pessoaBean.getPessoaUser().getIdPes());
        return end;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }
    
    public void prepararInserir(){
        end = new Endereco();
    }
    
    public void inserir(){
        IEnderecoDAO dao = new EnderecoDAO();
        end.setPessoa(pessoaBean.getPessoaUser());
        dao.inserirEndereco(end);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "O Endereço foi adicionado com Sucesso!"));
        end = new Endereco();
    }
    
    public void prepararAtualizar(Integer id){
        IEnderecoDAO dao = new EnderecoDAO();
        end = dao.listarPorId(id);
    }
    
    public void atualizar(){
        IEnderecoDAO dao = new EnderecoDAO();
        dao.alterarEndereco(end);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "O Endereço foi alterado com Sucesso!")); 
        end = new Endereco();
    }
    
    public void eliminar(){
        IEnderecoDAO dao = new EnderecoDAO();
        dao.deletarEndereco(end);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "O Endereço foi deletado com Sucesso!"));
        end = new Endereco();
    }
    
}


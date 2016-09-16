/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IPessoaDAO;
import br.com.proj.tasker.dao.impl.PessoaDAO;
import br.com.proj.tasker.model.Pessoa;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean {

    @ManagedProperty(value="#{usuarioBean}")
    private UsuarioBean usuarioBean;
    private Pessoa pessoa;
    private List<Pessoa> pessoas;
      
    public PessoaBean() {
    }
    
    public Pessoa getPessoa() {
        if (pessoa == null){
            pessoa = new Pessoa();
        }
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public Pessoa getPessoaUser(){
        IPessoaDAO dao = new PessoaDAO();
        pessoa = dao.listarPorIdUser(usuarioBean.getUsuario().getIdUser());
        return pessoa;
    }
    
    public Pessoa getPessoaMail(String mail){
        IPessoaDAO dao = new PessoaDAO();
        pessoa = new Pessoa();
        pessoa = dao.listarPorIdUser(usuarioBean.getUsuarioMail(mail).getIdUser());
        return pessoa;
    }
    
    public List<Pessoa> getPessoas() {
        IPessoaDAO dao = new PessoaDAO();
        pessoas = dao.listarTodos();
        return pessoas;
    }

    public void setUsuarioBean(UsuarioBean usuarioBean) {
        this.usuarioBean = usuarioBean;
    }
    
    public void prepararInserir(){
        pessoa = new Pessoa();
    }
    
    public void inserir(){
        IPessoaDAO dao = new PessoaDAO();
        pessoa.setUsuario(usuarioBean.getUsuario());
        dao.inserirPessoa(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "A Pessoa foi adicionado com Sucesso!"));
        pessoa = new Pessoa();
    }
    
    public void prepararAtualizar(Integer id){
        IPessoaDAO dao = new PessoaDAO();
        pessoa = dao.listarPorId(id);
    }
    
    public void atualizar(){
        IPessoaDAO dao = new PessoaDAO();
        dao.alterarPessoa(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "A Pessoa foi alterado com Sucesso!")); 
        pessoa = new Pessoa();
    }
    
    public void eliminar(){
        IPessoaDAO dao = new PessoaDAO();
        dao.deletarPessoa(pessoa);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "A Pessoa foi deletado com Sucesso!"));
        pessoa = new Pessoa();
    }
    
    public void verificaPessoa() {
        pessoa = getPessoaUser();
        FacesMessage msg = null;
        if (pessoa == null) {
            try{
                FacesContext.getCurrentInstance().getExternalContext().redirect("/pfcTasker/termcad.xhtml");
            } catch(Exception e){
                
            }
        }
    }
    
        
    public void dialog(){
        FacesMessage msg = null;
        msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Termine seu cadastro", "Seu cadastro está incompleto, termine-o antes de acessar a área de usuário!");
        RequestContext.getCurrentInstance().showMessageInDialog(msg);
    }
        
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.ICartaoCredDAO;
import br.com.proj.tasker.dao.impl.CartaoCredDAO;
import br.com.proj.tasker.model.Cartaocred;
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

@ManagedBean(name = "cartaoCredBean")
@SessionScoped
public class CartaoCredBean {
    
    @ManagedProperty(value="#{pessoaBean}")
    private PessoaBean pessoaBean;
    private Cartaocred card;
    private List<Cartaocred> cards;
    
    public CartaoCredBean(){    
    }

    public Cartaocred getCard() {
        if(card == null){
            card = new Cartaocred();
        }
        return card;
    }
    
    public void setCartaoCred(Cartaocred card){
        this.card = card;
    }
    
    public List<Cartaocred> getCards(){
        ICartaoCredDAO dao = new CartaoCredDAO();
        cards = dao.listarTodos();
        return cards;
    }
    
    public Cartaocred getCardsUser(){
        ICartaoCredDAO dao = new CartaoCredDAO();
        card = dao.listarPorUser(pessoaBean.getPessoaUser().getIdPes());
        return card;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }
    
    public void prepararInserir(){
        card = new Cartaocred();
    }
    
    public void inserir(){
        ICartaoCredDAO dao = new CartaoCredDAO();
        card.setPessoa(pessoaBean.getPessoaUser());
        dao.inserirCartaoCred(card);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso","O Cartão de Crédito foi adicionado com sucesso!"));
        card = new Cartaocred();
    }
    
    public void prepararAtualizar(Integer id){
        ICartaoCredDAO dao = new CartaoCredDAO();
        card = dao.listarPorId(id);
    }
    
    public void atualizar(){
        ICartaoCredDAO dao = new CartaoCredDAO();
        dao.alterarCartaoCred(card);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Cartão de Crédito foi deletado com sucesso!"));
        card = new Cartaocred();
    }
    
        public void eliminar(){
        ICartaoCredDAO dao = new CartaoCredDAO();
        dao.deletarCartaoCred(card);
        FacesContext context = FacesContext.getCurrentInstance();  
        context.addMessage(null, new FacesMessage("Sucesso", "O Endereço foi deletado com Sucesso!"));
        card = new Cartaocred();
    }
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IProjetoDAO;
import br.com.proj.tasker.dao.impl.ProjetoDAO;
import br.com.proj.tasker.model.Grupo;
import br.com.proj.tasker.model.Projeto;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.primefaces.event.SelectEvent;

/**
 *
 * @author Bruno
 */
@ManagedBean(name = "projetoBean")
@SessionScoped
public class ProjetoBean {

    @ManagedProperty(value = "#{grupoBean.grupo}")
    private Grupo grupo;
    private Projeto projeto;
    private List<Projeto> projetos;

    public ProjetoBean() {
    }

    public Projeto getProjeto() {
        if (projeto == null) {
            projeto = new Projeto();
        }
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Grupo getGrupo() {
        return grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public List<Projeto> getProjs() {
        return projetos;
    }

    public void setProjs(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public void prepararCadastrar() {
        projeto = new Projeto();
    }

    public void onRowSelect(SelectEvent event) {
        grupo = ((Grupo) event.getObject());
    }

    public List<Projeto> getProjetosGrupo() {
        IProjetoDAO dao = new ProjetoDAO();
        projetos = dao.buscaProjGru(grupo.getIdGrupo());
        return projetos;
    }

    public void preparar(Integer id) {
        IProjetoDAO dao = new ProjetoDAO();
        projeto = dao.listarPorId(id);
    }
    
    public void inserir() {
        IProjetoDAO dao = new ProjetoDAO();
        Date data = new Date();
        projeto.setDataCri(data);
        projeto.setAtivo(true);
        projeto.setGrupo(grupo);
        dao.cadastrarProjeto(projeto);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Projeto foi adicionado com Sucesso!"));
        projeto = new Projeto();
    }

    public void desativar() {
        IProjetoDAO dao = new ProjetoDAO();
        Date data = new Date();
        int cont = dao.getProjTars(projeto.getIdProj());
        if (cont < 1) { 
            projeto.setAtivo(false);
            projeto.setDataDesat(data);
            dao.alterarProjeto(projeto);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso", "O Projeto foi desativado com Sucesso!"));
            projeto = new Projeto();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro", "O Projeto não pode ser desativado enquanto houver Tarefas Pendentes ou Em Andamento!!!"));
        }
    }

}

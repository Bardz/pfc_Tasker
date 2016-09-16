/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.ITarefaDAO;
import br.com.proj.tasker.dao.impl.TarefaDAO;
import br.com.proj.tasker.model.Projeto;
import br.com.proj.tasker.model.Tarefa;
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
@ManagedBean(name = "tarefaBean")
@SessionScoped
public class TarefaBean {

    @ManagedProperty(value = "#{projetoBean.projeto}")
    private Projeto projeto;
    @ManagedProperty(value = "#{grupoBean}")
    private GrupoBean gruBean;
    @ManagedProperty(value = "#{ativmembrosBean}")
    private AtivMembrosBean amBean;
    @ManagedProperty(value = "#{logrelBean}")
    private logRelBean lgBean;
    private Tarefa tar;
    private List<Tarefa> tars;

    public TarefaBean() {
    }

    public Tarefa getTarefa() {
        if (tar == null) {
            tar = new Tarefa();
        }
        return tar;
    }

    public void setTarefa(Tarefa tar) {
        this.tar = tar;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public AtivMembrosBean getAmBean() {
        return amBean;
    }

    public void setAmBean(AtivMembrosBean amBean) {
        this.amBean = amBean;
    }

    public GrupoBean getGruBean() {
        return gruBean;
    }

    public void setGruBean(GrupoBean gruBean) {
        this.gruBean = gruBean;
    }

    public logRelBean getLgBean() {
        return lgBean;
    }

    public void setLgBean(logRelBean lgBean) {
        this.lgBean = lgBean;
    }

    public void Prepararcadastrar() {
        tar = new Tarefa();
    }

    public List<Tarefa> getTarefasProjeto() {
        ITarefaDAO dao = new TarefaDAO();
        int idcargo = amBean.getidCargoUser(projeto.getGrupo());
        if (idcargo == 0) {
            tars = dao.buscaTarProj(projeto.getIdProj());
        } else {
            tars = dao.buscaTarProjCargo(projeto.getIdProj(),idcargo);
        }
        return tars;
    }

    public void onRowSelect(SelectEvent event) {
        projeto = ((Projeto) event.getObject());
    }

    public void preparar(Integer id) {
        ITarefaDAO dao = new TarefaDAO();
        tar = dao.listarPorId(id);
    }

    public void cadastrar() {
        ITarefaDAO dao = new TarefaDAO();
        Date data = new Date();
        tar.setDataCri(data);
        tar.setStatus("Pendente");
        tar.setProjeto(projeto);
        dao.cadastrarTarefa(tar);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "A Tarefa foi adicionada com Sucesso!"));
        tar = new Tarefa();
    }

    public void desativar() {
        ITarefaDAO dao = new TarefaDAO();
        tar.setStatus("Desativada");
        dao.alterarTarefa(tar);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "A Tarefa foi desativada com Sucesso!"));
        tar = new Tarefa();
    }

    public void iniciar() {
        ITarefaDAO dao = new TarefaDAO();
        tar.setStatus("Em Andamento");
        Date data = new Date();
        tar.setDataIni(data);
        dao.alterarTarefa(tar);
        lgBean.logTar(tar);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Iniciada", "A Tarefa foi Iniciada"));
        tar = new Tarefa();
    }

    public void finalizar() {
        ITarefaDAO dao = new TarefaDAO();
        tar.setStatus("Finalizada");
        Date data = new Date();
        tar.setDataFin(data);
        dao.alterarTarefa(tar);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Finalizada", "A Tarefa foi Finalizada"));
        tar = new Tarefa();
    }

    public void classificar() {
        ITarefaDAO dao = new TarefaDAO();
        dao.alterarTarefa(tar);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Classificada", "A Tarefa foi Classificada"));
        tar = new Tarefa();
    }

    public void prepararCargo() {
        gruBean.prepararInserirMembro(projeto.getGrupo().getIdGrupo());
    }

    public boolean btnIniciar(Tarefa tar){
        return tar.getStatus().equals("Pendente");
    }
    
    public boolean btnFinalizar(Tarefa tar){
        return tar.getStatus().equals("Em Andamento");
    }
    
    public boolean btnClassificar(Tarefa tar){
        return tar.getStatus().equals("Finalizada");
    }
    
}

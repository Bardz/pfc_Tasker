/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IGrupoDAO;
import br.com.proj.tasker.dao.impl.GrupoDAO;
import br.com.proj.tasker.model.Grupo;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.commons.mail.EmailException;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "grupoBean")
@SessionScoped
public class GrupoBean {

    private Grupo grupo;
    @ManagedProperty(value = "#{ativmembrosBean}")
    private AtivMembrosBean amBean;
    @ManagedProperty(value = "#{pessoaBean}")
    private PessoaBean pessoaBean;
    private List<Grupo> grus;

    public GrupoBean() {
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        if (grupo == null) {
            grupo = new Grupo();
        }
        return grupo;
    }

    public AtivMembrosBean getAmBean() {
        return amBean;
    }

    public void setAmBean(AtivMembrosBean amBean) {
        this.amBean = amBean;
    }

    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public void prepararInserir() {
        grupo = new Grupo();
    }

    public List<Grupo> getGruposAdm() {
        IGrupoDAO dao = new GrupoDAO();
        grus = dao.buscaGrupoAtivo(pessoaBean.getPessoaUser().getIdPes());
        return grus;
    }

    public void inserir() {
        Date data = new Date();
        IGrupoDAO dao = new GrupoDAO();
        grupo.setDataCri(data);
        grupo.setAtivo(true);
        dao.inserirGrupo(grupo);
        amBean.regGrupo(grupo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Grupo foi criado com Sucesso!"));
        grupo = new Grupo();
    }

    public void prepararInserirMembro(Integer id) {
        IGrupoDAO dao = new GrupoDAO();
        grupo = dao.listarPorId(id);
    }

    public void inserirMembro(String mail) throws EmailException {
        amBean.insereMembro(grupo, mail);
        grupo = new Grupo();
    }

    public void desativar() {
        IGrupoDAO dao = new GrupoDAO();
        int cont = dao.getGrupoProjs(grupo.getIdGrupo());
        if (cont < 1) {
            grupo.setAtivo(false);
            dao.alterarGrupo(grupo);
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Sucesso", "O Grupo foi desativado com Sucesso!"));
            grupo = new Grupo();
        } else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Erro", "O Grupo não pode ser desativado enquanto tiver Projetos ativos!!!"));
        }
    }

}

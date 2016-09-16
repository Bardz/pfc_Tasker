/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.bll.Email;
import br.com.proj.tasker.dao.IAtivMembrosDAO;
import br.com.proj.tasker.dao.impl.AtivMembrosDAO;
import br.com.proj.tasker.model.Ativmembros;
import br.com.proj.tasker.model.Grupo;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import org.apache.commons.mail.EmailException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "ativmembrosBean")
@SessionScoped
public class AtivMembrosBean {

    @ManagedProperty(value = "#{pessoaBean}")
    private PessoaBean pessoaBean;
    @ManagedProperty(value = "#{perfilBean}")
    private PerfilBean perfilBean;
    private UsuarioBean usuBean;
    private Ativmembros am;
    private Email email;

    public AtivMembrosBean() {
    }

    public Ativmembros getAtivMembros() {
        if (am == null) {
            am = new Ativmembros();
        }
        return am;
    }

    public void setAtivMembros(Ativmembros am) {
        this.am = am;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public void setPerfilBean(PerfilBean perfilBean) {
        this.perfilBean = perfilBean;
    }

    public void setAm(Ativmembros am) {
        this.am = am;
    }

    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public PerfilBean getPerfilBean() {
        return perfilBean;
    }

    public Ativmembros getAm() {
        return am;
    }

    public void regGrupo(Grupo gru) {
        am = new Ativmembros();
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        am.setPessoa(pessoaBean.getPessoaUser());
        am.setPerfil(perfilBean.getPerfAdm());
        am.setGrupo(gru);
        am.getCargo().setIdCargo(0);
        dao.regGrupo(am);
        am = new Ativmembros();
    }
    
    public Integer getidCargoUser(Grupo grupo){
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        int cargoid = dao.buscaCargo(grupo.getIdGrupo(), pessoaBean.getPessoaUser().getIdPes());
        return cargoid;
    }

    public void insereMembro(Grupo gru, String mail) throws EmailException {
        FacesMessage msg = null;
        email = new Email();
        usuBean = new UsuarioBean();
        IAtivMembrosDAO dao = new AtivMembrosDAO();
        am.setPessoa(pessoaBean.getPessoaMail(mail));
        if (usuBean.getUsuarioMail(mail).getAtivado().equals("v")) {
            if (am.getPessoa() != null) {
                am.setGrupo(gru);
                dao.regGrupo(am);
                email.addMembroEmail(usuBean.getUsuarioMail(mail));
                am = new Ativmembros();
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "O Membro foi inserido no grupo!");
                RequestContext.getCurrentInstance().showMessageInDialog(msg);
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Houve algum erro!");
                RequestContext.getCurrentInstance().showMessageInDialog(msg);
            }
        } else {
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Este Membro ainda não ativou seu cadastro!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg);
        }
    }

}

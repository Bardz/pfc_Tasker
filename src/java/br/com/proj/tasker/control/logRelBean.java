/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IlogRelDAO;
import br.com.proj.tasker.dao.impl.logRelDAO;
import br.com.proj.tasker.model.Logrealizacao;
import br.com.proj.tasker.model.Tarefa;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "logrelBean")
@SessionScoped
public class logRelBean {

    @ManagedProperty(value = "#{pessoaBean}")
    private PessoaBean pessoaBean;
    private Logrealizacao log;

    public logRelBean() {
    }

    public Logrealizacao getLogrealizacao() {
        if (log == null) {
            log = new Logrealizacao();
        }
        return log;
    }

    public void setLogrealizacao(Logrealizacao log) {
        this.log = log;
    }

    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public void logTar(Tarefa tar) {
        IlogRelDAO dao = new logRelDAO();
        log = new Logrealizacao();
        log.setPessoa(pessoaBean.getPessoaUser());
        log.setTarefa(tar);
        dao.logTar(log);
        log = new Logrealizacao();
    }

}

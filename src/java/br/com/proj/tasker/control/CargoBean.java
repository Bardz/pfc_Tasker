/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.ICargoDAO;
import br.com.proj.tasker.dao.impl.CargoDAO;
import br.com.proj.tasker.model.Cargo;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "cargoBean")
@SessionScoped
public class CargoBean {

    @ManagedProperty(value = "#{pessoaBean}")
    private PessoaBean pessoaBean;
    @ManagedProperty(value = "#{grupoBean}")
    private GrupoBean grupoBean;
    private Cargo cargo;
    private List<Cargo> cargos;

    public CargoBean() {
    }

    public PessoaBean getPessoaBean() {
        return pessoaBean;
    }

    public void setPessoaBean(PessoaBean pessoaBean) {
        this.pessoaBean = pessoaBean;
    }

    public GrupoBean getGrupoBean() {
        return grupoBean;
    }

    public void setGrupoBean(GrupoBean grupoBean) {
        this.grupoBean = grupoBean;
    }

    public Cargo getCargo() {
        if (cargo == null) {
            cargo = new Cargo();
        }
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public List<Cargo> getCargos() {
        return cargos;
    }

    public void setCargos(List<Cargo> cargos) {
        this.cargos = cargos;
    }

    public List<Cargo> getCargoUser() {
        ICargoDAO dao = new CargoDAO();
        cargos = dao.getCargoUser(pessoaBean.getPessoaUser().getIdPes(), grupoBean.getGrupo().getIdGrupo());
        return cargos;
    }

    public void inserir() {
        ICargoDAO dao = new CargoDAO();
        cargo.setPessoa(pessoaBean.getPessoaUser());
        cargo.setGrupo(grupoBean.getGrupo());
        dao.inserirCargo(cargo);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Cargo foi criado com Sucesso!"));
        cargo = new Cargo();
    }

}

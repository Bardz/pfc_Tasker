/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IPlanoDAO;
import br.com.proj.tasker.dao.impl.PlanoDAO;
import br.com.proj.tasker.model.Plano;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "planoBean")
@SessionScoped
public class PlanoBean {

    private Plano plano;
    private List<Plano> planos;
  
    public PlanoBean() {
    }
    
    public Plano getPlano() {
        if (plano == null){
            plano = new Plano();
        }
        return plano;
    }

    public void setPlano(Plano plano) {
        this.plano = plano;
    }

    public List<Plano> getPlanos(){
        IPlanoDAO dao = new PlanoDAO();
        planos = dao.buscarTodos(plano);
        return planos;
    }
    
    public Plano getSelectPlano(int i){
        IPlanoDAO dao = new PlanoDAO();
        plano = dao.buscarPlano(i);
        return plano;
    }
}
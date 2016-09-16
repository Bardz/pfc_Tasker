/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IPerfilDAO;
import br.com.proj.tasker.model.Perfil;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class PerfilDAO implements IPerfilDAO {

    @Override
    public Perfil buscaAdmin() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Perfil perfil = (Perfil) session.createQuery("from Perfil where id_perf = 1").uniqueResult();
        session.close();
    return perfil;
    }

    @Override
    public Perfil buscaGerente() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Perfil perfil = (Perfil) session.createQuery("from Perfil where id_perf = 2").uniqueResult();
        session.close();
    return perfil;    
    }

    @Override
    public Perfil buscaSuperv() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Perfil perfil = (Perfil) session.createQuery("from Perfil where id_perf = 3").uniqueResult();
        session.close();
    return perfil;
    }

    @Override
    public Perfil buscaFunc() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Perfil perfil = (Perfil) session.createQuery("from Perfil where id_perf = 4").uniqueResult();
        session.close();
    return perfil;
    }
    
    @Override
    public List<Perfil> buscarTodos(Perfil perfil) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Perfil").list();
    }
    
}

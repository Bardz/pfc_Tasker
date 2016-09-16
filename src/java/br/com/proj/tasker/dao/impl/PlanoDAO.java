/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IPlanoDAO;
import br.com.proj.tasker.model.Plano;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class PlanoDAO implements IPlanoDAO {

    @Override
    public List<Plano> buscarTodos(Plano plano) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from Plano").list();
    }
    
    @Override
    public List<Plano> buscarListPlano(Plano plano){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return session.createQuery("from plano where id_plan = :id").list();
    }
    
    @Override
    public Plano buscarPlano(int i){
        Session session = HibernateUtil.getSessionFactory().openSession();
        return (Plano)session.createQuery("from Plano where id_plan = :id").setParameter("id", i).uniqueResult();
    }
    
    
}

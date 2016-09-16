/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IlogRelDAO;
import br.com.proj.tasker.model.Logrealizacao;
import br.com.proj.tasker.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class logRelDAO implements IlogRelDAO {

    @Override
    public void logTar(Logrealizacao log) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(log);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

}

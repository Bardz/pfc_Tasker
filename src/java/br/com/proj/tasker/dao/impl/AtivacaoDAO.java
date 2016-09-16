/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IAtivacaoDAO;
import br.com.proj.tasker.model.Ativacao;
import br.com.proj.tasker.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class AtivacaoDAO implements IAtivacaoDAO {

    @Override
    public void confAtivacao(Ativacao ativ) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(ativ);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public int getFromChave(String chave) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int id = (int) session.createSQLQuery("Select user_id from Ativacao where chave = :chave").setParameter("chave", chave).uniqueResult();
        session.close();
        return id;
    }
    
   @Override
   public void delAtivacao(Ativacao ativ){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(ativ);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

}
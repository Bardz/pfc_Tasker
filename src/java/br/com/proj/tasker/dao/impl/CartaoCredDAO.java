/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.ICartaoCredDAO;
import br.com.proj.tasker.model.Cartaocred;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Monteiro
 */
public class CartaoCredDAO implements ICartaoCredDAO {
    
    @Override
    public void inserirCartaoCred(Cartaocred card){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(card);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void alterarCartaoCred(Cartaocred card) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.update(card);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Alterar: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void deletarCartaoCred(Cartaocred card){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(card);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Cartaocred listarPorId(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cartaocred card = (Cartaocred) session.get(Cartaocred.class, id);
        session.close();
        return card; 
    }
    
    @Override
    public List<Cartaocred> listarTodos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Cartaocred> cards = session.createQuery("from Cartaocred").list();
        session.close();
        return cards;
    }
    
    @Override
    public Cartaocred listarPorUser(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Cartaocred card = (Cartaocred) session.createQuery("from Cartaocred where id_pes = :id").setParameter("id", id).uniqueResult();
        session.close();
        return card;
    }
    
}
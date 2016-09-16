/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.ITelefoneDAO;
import br.com.proj.tasker.model.Telefone;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Monteiro
 */
public class TelefoneDAO implements ITelefoneDAO {
    
    @Override
    public void inserirTelefone(Telefone tel){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(tel);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void alterarTelefone(Telefone tel){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(tel);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Alterar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void deletarTelefone(Telefone tel){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(tel);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Telefone listarPorId(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Telefone tel = (Telefone) session.get(Telefone.class, id);
        session.close();
        return tel;
    }
    
    @Override
    public List<Telefone> listarTodos(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Telefone> tels = session.createQuery("from Telefone").list();
        session.close();
        return tels;
    }

    @Override
    public Telefone listarPorUser(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Telefone tel = (Telefone) session.createQuery("from Telefone where id_pes = :id").setParameter("id", id).uniqueResult();
        session.close();
        return tel;
    }
    
}

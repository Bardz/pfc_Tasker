/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IEnderecoDAO;
import br.com.proj.tasker.model.Endereco;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class EnderecoDAO implements IEnderecoDAO {

    @Override
    public void inserirEndereco(Endereco end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(end);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void alterarEndereco(Endereco end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(end);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao atualizar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deletarEndereco(Endereco end) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(end);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Endereco listarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco end = (Endereco) session.get(Endereco.class, id);
        session.close();
        return end;
    }

    @Override
    public List<Endereco> listarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Endereco> ends = session.createQuery("from Endereco").list();
        session.close();
        return ends;
    }
    
    @Override
    public Endereco listarPorUser(Integer id){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Endereco end = (Endereco) session.createQuery("from Endereco where id_pes = :id").setParameter("id", id).uniqueResult();
        session.close();
        return end;
    }
    
}
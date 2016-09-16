/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.ITarefaDAO;
import br.com.proj.tasker.model.Tarefa;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class TarefaDAO implements ITarefaDAO {
    
    @Override
    public void cadastrarTarefa(Tarefa tar){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(tar);
            session.getTransaction().commit();
        }catch (Exception e){
            System.out.println("Erro ao Cadastrar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public void alterarTarefa(Tarefa tar){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(tar);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public List<Tarefa> buscaTarProj(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Tarefa> tars = session.createQuery("Select tar from Tarefa as tar JOIN tar.projeto as pro WHERE pro.idProj = :id AND tar.status<>'Desativada'").setParameter("id", id).list();
        session.close();
        return tars;
    }
    
    @Override
    public List<Tarefa> buscaTarProjCargo(Integer id, Integer id2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("Select tar from Tarefa as tar JOIN tar.projeto as pro WHERE pro.idProj = :id AND tar.status<>'Desativada' AND tar.status<>'Finalizada' AND tar.cargo.idCargo = :id2");
        query.setParameter("id", id);
        query.setParameter("id2", id2);
        List<Tarefa> tars = query.list();
        session.close();
        return tars;
    }
    
    @Override
    public Tarefa listarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Tarefa tar = (Tarefa) session.get(Tarefa.class, id);
        session.close();
        return tar;
    }
    
}

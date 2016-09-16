/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IProjetoDAO;
import br.com.proj.tasker.model.Projeto;
import br.com.proj.tasker.util.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Bruno
 */
public class ProjetoDAO implements IProjetoDAO {

    @Override
    public void cadastrarProjeto(Projeto proj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(proj);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Cadastrar: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void alterarProjeto(Projeto projeto) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.update(projeto);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Alterar: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Projeto listarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Projeto proj = (Projeto) session.get(Projeto.class, id);
        session.close();
        return proj;
    }

    @Override
    public List<Projeto> buscaProjGru(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Projeto> projs = session.createQuery("Select pro from Projeto as pro JOIN pro.grupo as gru WHERE gru.idGrupo = :id AND pro.ativo = 't'").setParameter("id", id).list();
        session.close();
        return projs;
    }

    @Override
    public Integer getProjTars(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        int cont = ((BigInteger) session.createSQLQuery("SELECT count(status) from tarefa WHERE tarefa.id_proj = :id AND (tarefa.status = 'Pendente' OR tarefa.status = 'Em Andamento')").setParameter("id", id).uniqueResult()).intValue();
        session.close();
        return cont;
    }

}

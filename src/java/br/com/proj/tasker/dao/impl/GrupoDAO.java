/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IGrupoDAO;
import br.com.proj.tasker.model.Grupo;
import br.com.proj.tasker.util.HibernateUtil;
import java.math.BigInteger;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class GrupoDAO implements IGrupoDAO {

    @Override
    public void inserirGrupo(Grupo grupo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(grupo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public List<Grupo> buscaGrupoAtivo(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Grupo> grupos = session.createQuery("Select gru from Grupo as gru JOIN gru.ativmembroses as ativ WHERE ativ.pessoa.idPes = :id AND gru.ativo = 't'").setParameter("id", id).list();
        session.close();
        return grupos;
    }

    @Override
    public Grupo listarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Grupo grupo = (Grupo) session.get(Grupo.class, id);
        session.close();
        return grupo;
    }
    
    @Override
    public void alterarGrupo(Grupo grupo){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(grupo);
            session.getTransaction().commit();
        }catch(Exception e){
            System.out.println("Erro ao Alterar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Integer getGrupoProjs(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Integer cont = ((BigInteger) session.createSQLQuery("SELECT count(ativo) from projeto WHERE projeto.id_grupo = :id AND projeto.ativo = TRUE").setParameter("id", id).uniqueResult()).intValue();
        session.close();
        return cont;
    }
    
}

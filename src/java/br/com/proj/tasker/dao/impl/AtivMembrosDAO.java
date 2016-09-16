/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IAtivMembrosDAO;
import br.com.proj.tasker.model.Ativmembros;
import br.com.proj.tasker.util.HibernateUtil;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class AtivMembrosDAO implements IAtivMembrosDAO {

    @Override
    public void regGrupo(Ativmembros am) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(am);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public Integer buscaAut(Integer idGru, Integer idPes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("Select id_perfil From ativmembros WHERE id_membro = :idpes AND id_grupo = :idgrupo");
        query.setParameter("idpes", idPes);
        query.setParameter("idgrupo", idGru);
        Integer aut = (Integer) query.uniqueResult();
        session.close();
        return aut;
    }

    @Override
    public Integer buscaCargo(Integer idGru, Integer idPes) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createSQLQuery("Select id_cargo From ativmembros WHERE id_membro = :idpes AND id_grupo = :idgrupo");
        query.setParameter("idpes", idPes);
        query.setParameter("idgrupo", idGru);
        Integer cargo = (Integer) query.uniqueResult();
        if (cargo == null) {
            cargo = 0;
        }
        session.close();
        return cargo;
    }

}

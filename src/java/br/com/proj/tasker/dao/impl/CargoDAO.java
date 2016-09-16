/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.ICargoDAO;
import br.com.proj.tasker.model.Cargo;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class CargoDAO implements ICargoDAO {

    @Override
    public List<Cargo> getCargoUser(Integer id, Integer id2) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Query query = session.createQuery("from Cargo where id_admin = :id AND id_grupo = :id2");
        query.setParameter("id", id);
        query.setParameter("id2", id2);
        List<Cargo> cargos = query.list();
        return cargos;
    }

    @Override
    public void inserirCargo(Cargo cargo) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.getTransaction().begin();
            session.save(cargo);
            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Erro ao Inserir: " + e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    
    @Override  
    public List<Cargo> buscaCargosGru(Integer id){
        Session session = HibernateUtil.createSessionFactory().openSession();
        Query query = session.createQuery("from Cargo where id_grupo = :id");
        query.setParameter("id", id);
        List<Cargo> cargos = query.list();
        return cargos;
    }

}

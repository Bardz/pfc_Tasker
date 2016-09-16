/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IPessoaDAO;
import br.com.proj.tasker.model.Pessoa;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class PessoaDAO implements IPessoaDAO {

    @Override
    public void inserirPessoa(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(pessoa);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void alterarPessoa(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(pessoa);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao atualizar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deletarPessoa(Pessoa pessoa) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(pessoa);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public Pessoa listarPorId(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pessoa pessoa = (Pessoa) session.get(Pessoa.class, id);
        session.close();
        return pessoa;
    }
    
    @Override
    public Pessoa listarPorIdUser(Integer id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Pessoa pessoa = (Pessoa) session.createQuery("from Pessoa where id_user = :id").setParameter("id", id).uniqueResult();
        session.close();
        return pessoa;
    }

    @Override
    public List<Pessoa> listarTodos() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Pessoa> pessoas = session.createQuery("from Pessoa").list();
        session.close();
        return pessoas;
    }

}
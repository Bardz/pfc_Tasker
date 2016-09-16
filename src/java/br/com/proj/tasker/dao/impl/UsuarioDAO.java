/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.com.proj.tasker.dao.impl;

import br.com.proj.tasker.dao.IUsuarioDAO;
import br.com.proj.tasker.model.Usuario;
import br.com.proj.tasker.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author Oswaldo
 */
public class UsuarioDAO implements IUsuarioDAO {

    @Override
    public void inserirUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.save(usuario);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao Inserir: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void alterarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.update(usuario);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao atualizar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deletarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try{
            session.getTransaction().begin();
            session.delete(usuario);
            session.getTransaction().commit();
        } catch (Exception e){
            System.out.println("Erro ao deletar: "+e.getMessage());
            session.getTransaction().rollback();
        }
    }
    
    @Override
    public Usuario buscarUsuario(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        String sql = "Select u from Usuario u where email=:email and senha=:pass";
        Query query = session.createQuery(sql);
        query.setString("email", usuario.getEmail());
        query.setString("pass", usuario.getSenha());
        Usuario user = (Usuario) query.uniqueResult();
        session.close();
        return user;
    }
    
    @Override
    public List<Usuario> buscarTodos(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Usuario> users = session.createQuery("from Usuario").list();
        session.close();
        return users;
    }
    
    @Override
    public Usuario buscarPorMail(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario user = (Usuario) session.createQuery("from Usuario where email = :mail").setParameter("mail", usuario.getEmail()).uniqueResult();
        session.close();
        return user;
    }

    @Override
    public Usuario buscarPorId(Usuario usuario) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Usuario user = (Usuario) session.createQuery("from Usuario where id_user = :id").setParameter("id", usuario.getIdUser()).uniqueResult();
        session.close();
        return user;
    }
   
}

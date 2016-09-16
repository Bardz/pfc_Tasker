/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.control;

import br.com.proj.tasker.dao.IUsuarioDAO;
import br.com.proj.tasker.dao.impl.UsuarioDAO;
import br.com.proj.tasker.model.Usuario;
import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import org.apache.commons.mail.EmailException;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Oswaldo
 */
@ManagedBean(name = "usuarioBean")
@SessionScoped
public class UsuarioBean {

    private Usuario usuario;
    private List<Usuario> usuarios;
    private AtivacaoBean ativBean;

    public UsuarioBean() {
    }

    public Usuario getUsuario() {
        if (usuario == null) {
            usuario = new Usuario();
        }
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void login(ActionEvent actionEvent) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage msg = null;
        boolean loggedIn = false;

        IUsuarioDAO dao = new UsuarioDAO();
        usuario.setSenha(coverterMD5(usuario.getSenha()));
        usuario = dao.buscarUsuario(usuario);

        if (usuario != null) {
            if (usuario.getAtivado().equals("v")) {
                loggedIn = true;
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bem-Vindo", usuario.getEmail());
                FacesContext.getCurrentInstance().addMessage(null, msg);
                context.addCallbackParam("loggedIn", loggedIn);
            } else {
                msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Erro no Login", "Sua conta não está ativa, favor checar email!");
                loggedIn = false;
                RequestContext.getCurrentInstance().showMessageInDialog(msg);
                context.addCallbackParam("loggedIn", loggedIn);
            }
        } else {
            loggedIn = false;
            msg = new FacesMessage(FacesMessage.SEVERITY_WARN, "Erro no Login", "E-mail e/ou Senha incorretos ou não existem!");
            RequestContext.getCurrentInstance().showMessageInDialog(msg);
            context.addCallbackParam("loggedIn", loggedIn);
        }

    }

    public void logout(ActionEvent actionEvent) {
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/pfcTasker/index.xhtml");
        } catch (IOException ex) {
            Logger.getLogger(UsuarioBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Usuario getUsuarioMail(String mail) {
        IUsuarioDAO dao = new UsuarioDAO();
        Usuario usuario = new Usuario();
        usuario.setEmail(mail);
        usuario = dao.buscarPorMail(usuario);
        return usuario;
    }

    public void prepararInserir() {
        usuario = new Usuario();
    }

    public void inserir() throws EmailException {
        IUsuarioDAO dao = new UsuarioDAO();
        ativBean = new AtivacaoBean();
        usuario.setAtivado("f");
        usuario.setSenha(coverterMD5(usuario.getSenha()));
        dao.inserirUsuario(usuario);
        ativBean.cadAtivacao(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Usuario foi adicionado com Sucesso!"));
        usuario = new Usuario();
    }

    public void prepararAtualizar(Integer id) {
        IUsuarioDAO dao = new UsuarioDAO();
        usuario = dao.buscarUsuario(usuario);
    }

    public void atualizar() {
        IUsuarioDAO dao = new UsuarioDAO();
        dao.alterarUsuario(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Usuario foi alterado com Sucesso!"));
        usuario = new Usuario();
    }

    public void eliminar() {
        IUsuarioDAO dao = new UsuarioDAO();
        dao.deletarUsuario(usuario);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Sucesso", "O Usuario foi deletado com Sucesso!"));
        usuario = new Usuario();
    }

    public List<Usuario> getUsuarios() {
        IUsuarioDAO dao = new UsuarioDAO();
        usuarios = dao.buscarTodos(usuario);
        return usuarios;
    }

    public void ativarUsuario(Usuario usu) {
        IUsuarioDAO dao = new UsuarioDAO();
        usu = dao.buscarPorId(usu);
        usu.setAtivado("v");
        dao.alterarUsuario(usu);
    }
    
    public String coverterMD5(String senha){  
        String sen = "";  
        MessageDigest md = null;  
        try {  
            md = MessageDigest.getInstance("MD5");  
        } catch (NoSuchAlgorithmException e) {  
            e.printStackTrace();  
        }  
        BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));  
        sen = hash.toString(16);              
        return sen;  
    }  

}

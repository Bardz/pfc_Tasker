/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.proj.tasker.bll;

import br.com.proj.tasker.model.Ativacao;
import br.com.proj.tasker.model.Usuario;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

/**
 *
 * @author Oswaldo
 */
public class Email {

    public void regConfMail(Ativacao ativ) throws EmailException {
        try {

            SimpleEmail email = new SimpleEmail();

            String to = ativ.getUsuario().getEmail();
            String from = "teste2tasker@gmail.com";
            String subject = "Confirme seu Cadastro no TaskMaster";
            String msg = "O Seu E-Mail foi cadastrado recentemente no site TaskMaster, esta é uma mensagem de confirmação.<br> "
                    + "Por Favor, "
                    + " <a href=http://localhost:8080/pfcTasker/ativar.xhtml?chave=" + ativ.getChave() + ">Clique Aqui</a>";
            String user = "teste2tasker@gmail.com ";
            String pass = "senhadificil";

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.addTo(to);
            email.setFrom(from);
            email.setSubject(subject);
            email.setContent(msg,"text/html");
            email.setSSLOnConnect(true);
            email.setAuthentication(user, pass);
            email.send();

        } catch (EmailException e) {
            System.out.println("Erro: " + e);
        }
    }

    public void addMembroEmail(Usuario usuario) throws EmailException {
        try {

            SimpleEmail email = new SimpleEmail();

            String to = usuario.getEmail();
            String from = "teste2tasker@gmail.com";
            String subject = "Você foi Adicionado a um Grupo";
            String msg = "O Administrador de um Grupo lhe adicionou como membro do mesmo!";
            String user = "teste2tasker@gmail.com ";
            String pass = "senhadificil";

            email.setHostName("smtp.gmail.com");
            email.setSmtpPort(587);
            email.addTo(to);
            email.setFrom(from);
            email.setSubject(subject);
            email.setMsg(msg);
            email.setSSLOnConnect(true);
            email.setAuthentication(user, pass);
            email.send();

        } catch (EmailException e) {
            System.out.println("Erro: " + e);
        }
    }
}

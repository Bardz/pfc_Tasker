package br.com.proj.tasker.model;
// Generated Nov 11, 2014 9:57:20 PM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Projeto generated by hbm2java
 */
public class Projeto  implements java.io.Serializable {


     private int idProj;
     private Grupo grupo;
     private String nome;
     private String descricao;
     private Date dataCri;
     private boolean ativo;
     private Date dataDesat;
     private Set tarefas = new HashSet(0);

    public Projeto() {
    }

	
    public Projeto(int idProj, Grupo grupo, String nome, String descricao, Date dataCri, boolean ativo) {
        this.idProj = idProj;
        this.grupo = grupo;
        this.nome = nome;
        this.descricao = descricao;
        this.dataCri = dataCri;
        this.ativo = ativo;
    }
    public Projeto(int idProj, Grupo grupo, String nome, String descricao, Date dataCri, boolean ativo, Date dataDesat, Set tarefas) {
       this.idProj = idProj;
       this.grupo = grupo;
       this.nome = nome;
       this.descricao = descricao;
       this.dataCri = dataCri;
       this.ativo = ativo;
       this.dataDesat = dataDesat;
       this.tarefas = tarefas;
    }
   
    public int getIdProj() {
        return this.idProj;
    }
    
    public void setIdProj(int idProj) {
        this.idProj = idProj;
    }
    public Grupo getGrupo() {
        if (grupo == null) {
            grupo = new Grupo();
        }
        return this.grupo;
    }
    
    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }
    public String getNome() {
        return this.nome;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDescricao() {
        return this.descricao;
    }
    
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Date getDataCri() {
        return this.dataCri;
    }
    
    public void setDataCri(Date dataCri) {
        this.dataCri = dataCri;
    }
    public boolean isAtivo() {
        return this.ativo;
    }
    
    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }
    public Date getDataDesat() {
        return this.dataDesat;
    }
    
    public void setDataDesat(Date dataDesat) {
        this.dataDesat = dataDesat;
    }
    public Set getTarefas() {
        return this.tarefas;
    }
    
    public void setTarefas(Set tarefas) {
        this.tarefas = tarefas;
    }




}


package br.com.proj.tasker.model;
// Generated Oct 21, 2014 12:16:00 AM by Hibernate Tools 3.6.0


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Grupo generated by hbm2java
 */
public class Grupo  implements java.io.Serializable {


     private int idGrupo;
     private String nome;
     private String descricao;
     private Date dataCri;
     private boolean ativo;
     private Set ativmembroses = new HashSet(0);
     private Set projetos = new HashSet(0);
     private Set cargos = new HashSet(0);
     
    public Grupo() {
    }

	
    public Grupo(String nome, String descricao, Date dataCri, boolean ativo) {
        this.nome = nome;
        this.descricao = descricao;
        this.dataCri = dataCri;
        this.ativo = ativo;
    }
    public Grupo(int idGrupo, String nome, String descricao, Date dataCri, boolean ativo, Set ativmembroses, Set projetos, Set cargos) {
       this.idGrupo = idGrupo;
       this.nome = nome;
       this.descricao = descricao;
       this.dataCri = dataCri;
       this.ativo = ativo;
       this.ativmembroses = ativmembroses;
       this.projetos = projetos;
       this.cargos = cargos;
    }
   
    public int getIdGrupo() {
        return this.idGrupo;
    }
    
    public void setIdGrupo(int idGrupo) {
        this.idGrupo = idGrupo;
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
    
    public Set getAtivmembroses() {
        return this.ativmembroses;
    }
    
    public void setAtivmembroses(Set ativmembroses) {
        this.ativmembroses = ativmembroses;
    }
    public Set getProjetos() {
        return this.projetos;
    }
    
    public void setProjetos(Set projetos) {
        this.projetos = projetos;
    }
    
    public Set getCargos() {
        return this.cargos;
    }
    
    public void setCargos(Set cargos) {
        this.cargos = cargos;
    }



}



package br.com.descomplica.projeto.documentacao.entity;

import java.util.Set;
import javax.persistence.*;


@Entity
@Table(name = "instrutor")
public class Instrutor {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "idinstrutor")
  private Integer idInstrutor;

  @Column(name = "RG")
  private Integer rg;

  @Column(name = "nome")
  private String nome;

  @Column(name = "nascimento")
  private java.sql.Date nascimento;

  @Column(name = "titulacao")
  private Integer titulacao;

  @OneToMany(mappedBy = "instrutor")
  private Set<Turma> turmas;

  // Getters e Setters
  public Integer getIdInstrutor() {
    return idInstrutor;
  }

  public void setIdInstrutor(Integer idinstrutor) {
    this.idInstrutor = idInstrutor;
  }

  public Integer getRg() {
    return rg;
  }

  public void setRg(Integer rg) {
    this.rg = rg;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public java.sql.Date getNascimento() {
    return nascimento;
  }

  public void setNascimento(java.sql.Date nascimento) {
    this.nascimento = nascimento;
  }

  public Integer getTitulacao() {
    return titulacao;
  }

  public void setTitulacao(Integer titulacao) {
    this.titulacao = titulacao;
  }
  
  public Set<Turma> getTurmas() {
   return turmas;
 }

 public void setTurmas(Set<Turma> turmas) {
   this.turmas = turmas;
 }
}
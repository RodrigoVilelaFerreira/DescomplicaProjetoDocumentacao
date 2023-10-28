package br.com.descomplica.projeto.documentacao.entity;

import javax.persistence.*;


@Entity
@Table(name = "turma")
public class Turma {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 @Column(name = "IdTurma")
 private Long IdTurma;

 @Column(name = "horario")
 private java.sql.Time horario;

 @Column(name = "duracao")
 private Integer duracao;

 @Column(name = "dataInicio")
 private java.sql.Date dataInicio;

 @Column(name = "dataFim")
 private java.sql.Date dataFim;

 @ManyToOne
 @JoinColumn(name = "idinstrutor")
 private Instrutor instrutor;
 
 // Getters e Setters
 public Long getIdTurma() {
   return IdTurma;
 }

 public void setIdTurma(Long IdTurma) {
   this.IdTurma = IdTurma;
 }

 public java.sql.Time getHorario() {
   return horario;
 }

 public void setHorario(java.sql.Time horario) {
   this.horario = horario;
 }

 public Integer getDuracao() {
   return duracao;
 }

 public void setDuracao(Integer duracao) {
   this.duracao = duracao;
 }

 public java.sql.Date getDataInicio() {
   return dataInicio;
 }

 public void setDataInicio(java.sql.Date dataInicio) {
   this.dataInicio = dataInicio;
 }

 public java.sql.Date getDataFim() {
   return dataFim;
 }

 public void setDataFim(java.sql.Date dataFim) {
   this.dataFim = dataFim;
 }

 public Instrutor getInstrutor() {
   return instrutor;
 }

 public void setInstrutor(Instrutor instrutor) {
   this.instrutor = instrutor;
 }
}
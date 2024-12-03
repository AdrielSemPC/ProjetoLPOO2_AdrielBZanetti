/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author adrie
 */

@Entity
@Table(name = "tb_Curso")
public class Curso implements Serializable {
   @Id
   @GeneratedValue(strategy = GenerationType.SEQUENCE)
   private int id;
   
   @Column(nullable = false)
   @Enumerated(EnumType.STRING)
   private Categoria categoria;
   
   @Column(name = "carga_horaria", nullable = false)
   private int carga_horaria;
   
   @Column(name = "data_inicio", nullable = false)
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date data_inicio;
   
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "instrutor_id", nullable = false)
   private Instrutor instrutor;
   
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "aluno_id", nullable = false)
   private Aluno aluno;
   
   @ManyToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "administrativo_id", nullable = false)
   private Administrativo administrativo;
   
   @ElementCollection
   private List<Date> aulas;

   public Curso(){
       this.aulas = new ArrayList<>();
   }
   
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public int getCarga_horaria() {
        return carga_horaria;
    }

    public void setCarga_horaria(int carga_horaria) {
        this.carga_horaria = carga_horaria;
    }

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    
    public List<Date> getAulas() {
        return aulas;
    }

    public void setAulas(List<Date> aulas) {
        this.aulas = aulas;
    }

    public Instrutor getInstrutor() {
        return instrutor;
    }

    public void setInstrutor(Instrutor instrutor) {
        this.instrutor = instrutor;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Administrativo getAdministrativo() {
        return administrativo;
    }

    public void setAdministrativo(Administrativo administrativo) {
        this.administrativo= administrativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}

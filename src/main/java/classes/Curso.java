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
import org.eclipse.persistence.annotations.CascadeOnDelete;

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
   
   @Column(length = 1, nullable = false)
   @Enumerated(EnumType.STRING)
   private Categoria categoria;
   
   @Column(name = "carga_horaria", nullable = false)
   private int carga_horaria;
   
   @Column(name = "data_inicio", nullable = false)
   @Temporal(javax.persistence.TemporalType.DATE)
   private Date data_inicio;
   
   @ManyToOne
   @JoinColumn(name = "instrutor_id")
   private Instrutor instrutor;
   
   @ManyToOne
   @JoinColumn(name = "aluno_id")
   private Aluno aluno;
   
   @ManyToOne
   @JoinColumn(name = "administrativo_id")
   private Administrativo administrativo;
   
   @OneToMany(mappedBy = "curso", cascade = CascadeType.ALL, orphanRemoval = true)
   private List<Aula> aulas;
   
   @Column(name = "finalizado")
   private Boolean finalizado;
   
    public Curso(){
        aulas = new ArrayList<>();
    }
    public void addAula(Aula aula) {
        aulas.add(aula);
        aula.setCurso(this);
    }

    public void removeAula(Aula aula) {
        aulas.remove(aula);
        aula.setCurso(null);
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

    
    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
        for(Aula a : aulas){
            a.setCurso(this);
        }
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

    public Boolean getFinalizado() {
        return finalizado;
    }

    public void setFinalizado(Boolean finalizado) {
        this.finalizado = finalizado;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Curso other = (Curso) obj;
        return this.id == other.id;
    }
    
    public String toString(){
        return ""+id+"";
    }
}

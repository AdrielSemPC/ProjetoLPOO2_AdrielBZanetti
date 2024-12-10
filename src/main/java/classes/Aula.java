/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

/**
 *
 * @author adrie
 */

@Entity
@Table(name = "tb_Aula")
public class Aula implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    
    @Column(name = "dia_aula")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dia_aula;
    
    @Column(name = "aula_concluida")
    private Boolean concluida;
    
    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;
    
    @Override
    public String toString(){
        return ""+id+"";
    }
    
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDia_aula() {
        return dia_aula;
    }

    public void setDia_aula(Date dia_aula) {
        this.dia_aula = dia_aula;
    }

    public Boolean getConcluida() {
        return concluida;
    }

    public void setConcluida(Boolean concluida) {
        this.concluida = concluida;
    }
    
    public void addDia(Date dia_adicionado){
        
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 61 * hash + Objects.hashCode(this.curso);
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
        final Aula other = (Aula) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.curso, other.curso);
    }
}

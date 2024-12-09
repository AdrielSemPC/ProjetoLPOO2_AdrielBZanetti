/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author adrie
 */

@Entity
@Table(name = "tb_Aluno")
@DiscriminatorValue("ALUNO")
public class Aluno extends Pessoa{
    @Column(name = "renach", length = 11, nullable = false)
    private String renach;
    
    @Column(name = "matricula", nullable = false)
    private String matricula;
    
    @OneToMany(mappedBy = "aluno")
    private List<Curso> curso;
    
    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
    
    public void addCurso(Curso curso) {
        this.curso.add(curso);
        curso.setAluno(this);
    }
        
    public Aluno(){
        this.curso = new ArrayList<>();
    }
    
    public String getRenach() {
        return renach;
    }

    public void setRenach(String renach) {
        this.renach= renach;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.renach);
        hash = 59 * hash + Objects.hashCode(this.matricula);
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
        final Aluno other = (Aluno) obj;
        if (!Objects.equals(this.renach, other.renach)) {
            return false;
        }
        return Objects.equals(this.matricula, other.matricula);
    }
}

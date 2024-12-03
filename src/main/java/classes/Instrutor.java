/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

/**
 *
 * @author adrie
 */

@Entity
@Table(name = "tb_Instrutor")
@DiscriminatorValue("INSTRUTOR")
public class Instrutor extends Pessoa{
    @Column(length = 11, nullable = false)
    private String cnh;
    
    @OneToMany(mappedBy = "instrutor")
    private List<Curso> curso;
    
    public Instrutor() {
        this.curso = new ArrayList<>();
    }
    
    public String getCnh() {
        return cnh;
    }
    
    public void addCurso(Curso curso) {
        this.curso.add(curso);
        curso.setInstrutor(this);
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
}

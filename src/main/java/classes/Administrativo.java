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
@Table(name = "tb_Administrativo")
public class Administrativo extends Pessoa{
    
    @Column(name = "cargo", nullable = false)
    @Enumerated(EnumType.STRING)
    private Cargo cargo;

    @OneToMany(mappedBy = "administrativo")
    private List<Curso> curso;
    
    public Administrativo(){
        this.curso = new ArrayList<>();
    }
    
    public void addCurso(Curso curso) {
        this.curso.add(curso);
        curso.setAdministrativo(this);
    }
    
    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }
    
    public List<Curso> getCurso() {
        return curso;
    }

    public void setCurso(List<Curso> curso) {
        this.curso = curso;
    }
}

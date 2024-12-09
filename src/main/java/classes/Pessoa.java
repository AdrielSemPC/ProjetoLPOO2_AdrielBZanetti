/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package classes;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;
import javax.persistence.*;

/**
 *
 * @author adrie
 */

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "tipo_pessoa", length = 15, discriminatorType = DiscriminatorType.STRING)
@Table(name = "tb_Pessoa")
public abstract class Pessoa implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    
    @Column(name = "nome", nullable = false)
    private String nome;
    
    @Column(name = "cpf", length = 11, nullable = false)
    private String cpf;
    
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date data_de_nasc;
    
    @Column(name = "telefone", nullable = false)
    private String telefone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getData_de_nasc() {
        return data_de_nasc;
    }

    public void setData_de_nasc(Date data_de_nasc) {
        this.data_de_nasc = data_de_nasc;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
    
    @Override
    public String toString(){
        return nome;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        hash = 41 * hash + Objects.hashCode(this.cpf);
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
        final Pessoa other = (Pessoa) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }
}

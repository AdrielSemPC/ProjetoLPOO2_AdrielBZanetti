/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpoo.sistemaautoescola.dao;

import classes.*;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author adrie
 */

public class PersistenciaJPA implements InterfaceBD{
    EntityManager entity;
    EntityManagerFactory factory;
    
    public PersistenciaJPA(){
        factory = Persistence.createEntityManagerFactory("LPOO_SistemaAUTOESCOLA_jar_1.0-SNAPSHOTPU");
        entity = factory.createEntityManager();
    }
    
    @Override
    public Boolean conexaoAberta(){
        return entity.isOpen();
    }
    
    @Override
    public void fecharConexao(){
        entity.close();
    }
    
    public Object find(Class c, Object id) throws Exception{
        entity = getEntityManager();
        try{
            return entity.find(c, id);
        } catch (Exception e) {
            
        }
        return null;
    }
    
    @Override
    public void persist(Object o) throws Exception{
        entity = getEntityManager();
        try{
            entity.getTransaction().begin();
            if(!entity.contains(o)){
                o = entity.merge(o);
            }
            entity.persist(o);
            entity.getTransaction().commit();
        }
        catch (Exception e){
            entity.getTransaction().rollback();
        }
    }
    
    public EntityManager getEntityManager(){
        if(entity == null || !entity.isOpen()){
            entity = factory.createEntityManager();
        }
        return entity;
    }
    
    @Override
    public void remover(Object o) throws Exception{
        entity = getEntityManager();
        try {
            entity.getTransaction().begin();
            if(!entity.contains(o)){
                o = entity.merge(o);
            }
            entity.remove(o);
            entity.getTransaction().commit();
        } catch (Exception e) {
            if (entity.getTransaction().isActive()) {
                entity.getTransaction().rollback();
            }
        }
    }
    
    public List<Aluno> getAlunos(){
        entity = getEntityManager();
        try {
            TypedQuery<Aluno> query = entity.createQuery("Select a from Aluno a", Aluno.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Alunos: " + e);
        }
        return null;
    }
    
    public List<Aluno> getAlunos(String arg, int tipo){
        entity = getEntityManager();
        switch (tipo) {
            case 0 -> {
                try {
                    TypedQuery<Aluno> query = entity.createQuery("Select a from Aluno a where lower(a.nome) LIKE :x", Aluno.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Alunos: " + e);
                }
            }
            case 1 -> {
                try {
                    TypedQuery<Aluno> query = entity.createQuery("Select a from Aluno a where lower(a.cpf) LIKE :x",  Aluno.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Alunos: " + e);
                }
            }
            case 2 -> {
                try {
                    TypedQuery<Aluno> query = entity.createQuery("Select a from Aluno a where lower(a.matricula) LIKE :x",  Aluno.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Alunos: " + e);
                }
            }
        }
        return null;
    }
    
    public List<Administrativo> getAdministrativos(String arg, int tipo){
        entity = getEntityManager();
        switch (tipo) {
            case 0 -> {
                try {
                    TypedQuery<Administrativo> query = entity.createQuery("Select adm from Administrativo adm where lower(adm.nome) LIKE :x", Administrativo.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Administrativos: " + e);
                }
            }
            case 1 -> {
                try {
                    TypedQuery<Administrativo> query = entity.createQuery("Select adm from Administrativo adm where lower(adm.cpf) LIKE :x",  Administrativo.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Administrativos: " + e);
                }
            }
        }
        return null;
    }
    
    public List<Administrativo> getAdministrativos(){
        entity = getEntityManager();
        try {
            TypedQuery<Administrativo> query = entity.createQuery("Select a from Administrativo a", Administrativo.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Funcionários: " + e);
        }
        return null;
    }
        
    public List<Instrutor> getInstrutores(){
        entity = getEntityManager();
        try {
            TypedQuery<Instrutor> query = entity.createQuery("Select i from Instrutor i", Instrutor.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Instrutores: " + e);
        }
        return null;
    }
    
    
    
    public List<Instrutor> getInstrutores(String arg, int tipo){
        entity = getEntityManager();
        switch (tipo) {
            case 0 -> {
                try {
                    TypedQuery<Instrutor> query = entity.createQuery("Select i from Instrutor i where lower(i.nome) LIKE :x", Instrutor.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Instrutores: " + e);
                }
            }
            case 1 -> {
                try {
                    TypedQuery<Instrutor> query = entity.createQuery("Select i from Instrutor i where lower(i.cpf) LIKE :x", Instrutor.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Administrativos: " + e);
                }
            }
        }
        return null;
    }
    
    public List<Curso> getCursos(){
        entity = getEntityManager();
        try {
            TypedQuery<Curso> query = entity.createQuery("Select c from Curso c", Curso.class);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Cursos: " + e);
        }
        return null;
    }
    
    public List<Aula> getAulas(int id){
        entity = getEntityManager();
        try {
            TypedQuery<Aula> query = entity.createQuery("Select a from Aula a where a.curso.id =:aux", Aula.class);
            query.setParameter("aux",id);
            return query.getResultList();
        } catch (Exception e) {
            System.err.println("Erro ao buscar Aulas: " + e);
        }
        return null;
    }

    public List<Curso> getCursos(String arg, int tipo) {
        entity = getEntityManager();
        switch (tipo) {
            case 0 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.aluno.nome) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
            case 1 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.aluno.renach) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
            case 2 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.aluno.cpf) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
            case 3 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.instrutor.nome) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
            case 4 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.instrutor.cnh) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
            case 5 -> {
                try {
                    TypedQuery<Curso> query = entity.createQuery("Select c from Curso c where lower(c.instrutor.cpf) LIKE :x", Curso.class);
                    query.setParameter("x", "%" + arg.toLowerCase() + "%");
                    return query.getResultList();
                } catch (Exception e) {
                    System.err.println("Erro ao buscar Cursos: " + e);
                }
            }
        }
        return null;
    }
}

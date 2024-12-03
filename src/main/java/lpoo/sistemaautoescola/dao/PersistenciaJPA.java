/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lpoo.sistemaautoescola.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
}

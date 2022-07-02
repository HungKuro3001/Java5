package DAO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import entities.UsersEntity;
import entities.UsersEntity;
import utils.JpaUtil;


public class UserDAO {
    private EntityManager em;
    public UserDAO() {
        this.em = JpaUtil.getEntityManager();
    }
    public UsersEntity create(UsersEntity entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.persist(entity);
            this.em.flush();
            this. em.getTransaction().commit();
            return entity;
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }
    public List<UsersEntity> all() {
        String jpql = "select obj from UsersEntity obj";
        TypedQuery<UsersEntity> querry = this.em.createQuery(jpql,UsersEntity.class);
        return querry.getResultList();

    }
    public UsersEntity findById(int id) {
    	return this.em.find(UsersEntity.class,id);
    }
    public void delete(UsersEntity entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.remove(entity);
            this. em.getTransaction().commit();
          
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }
    public void update(UsersEntity entity) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.merge(entity);
            this. em.getTransaction().commit();
          
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }
}

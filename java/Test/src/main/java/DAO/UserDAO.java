package DAO;

import entities.UsersEntity;
import utils.JpaUtil;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    private EntityManager em;
    public UserDAO(){
        this.em = JpaUtil.getEntityManager();
    }
    public UsersEntity create(UsersEntity user) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.persist(user);
            this.em.getTransaction().commit();
            return user;
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw e;

        }

    }
    public List<UsersEntity> findAll() {
        String jpql = "select obj from UsersEntity obj";
        TypedQuery<UsersEntity> query = this.em.createQuery(jpql, UsersEntity.class);
        return query.getResultList();
    }
    public UsersEntity findById(int id) {
        return this.em.find(UsersEntity.class, id);
    }
    public void delete(UsersEntity user) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.remove(user);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw e;
        }
    }
    public void update(UsersEntity user) throws Exception {
        try {
            this.em.getTransaction().begin();
            this.em.merge(user);
            this.em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.em.getTransaction().rollback();
            throw e;
        }
    }

}

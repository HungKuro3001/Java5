package DAO;


import Utils.JPAUtils;
import entities.UsersEntity;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class UserDAO {
    EntityManager em;
    public UserDAO(){
        this.em = JPAUtils.getEntityManager();
    }
    public UsersEntity insertUser(UsersEntity user){
        try {
            em.getTransaction().begin();
            em.persist(user);
            this.em.flush();
            em.getTransaction().commit();
            return user;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;

        }
    }
    public UsersEntity updateUser(UsersEntity user){
        try {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
            return user;
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }
    public void deleteUser(UsersEntity user){
        try {
            em.getTransaction().begin();
            em.remove(user);
            em.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            em.getTransaction().rollback();
            throw e;
        }
    }
    public UsersEntity checkLogin(String email){
        String jpql = "select u from UsersEntity u where u.email = :email";
        TypedQuery<UsersEntity> query = em.createQuery(jpql, UsersEntity.class);
        query.setParameter("email", email);
        UsersEntity user = query.getSingleResult();
        return user;
    }

    public UsersEntity findUsersById(int id){
        return this.em.find(UsersEntity.class, id);
    }
    public List<UsersEntity> findAllUsers(){
        String jpql = "select u from UsersEntity u";
        TypedQuery<UsersEntity> query = em.createQuery(jpql, UsersEntity.class);
        return query.getResultList();
    }
    public List<UsersEntity> findUsersByName(String name, int page , int size){
        String jpql = "select u from UsersEntity u where u.hoTen like :name";
        TypedQuery<UsersEntity> query = em.createQuery(jpql, UsersEntity.class);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }
    public long getcount(String name) {
        String jqpl = "select count(u) from UsersEntity u where u.hoTen like :name";
        TypedQuery<Long> query = this.em.createQuery(jqpl, Long.class);
        query.setParameter("name", "%" + name + "%");
        return query.getSingleResult();
    }
}

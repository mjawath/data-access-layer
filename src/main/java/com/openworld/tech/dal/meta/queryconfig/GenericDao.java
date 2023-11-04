package com.openworld.tech.dal.meta.queryconfig;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class GenericDao {

    @PersistenceContext
    private EntityManager entityManager;

    public Object getObject(Class aClass, String id) {
        return entityManager.find(aClass, id);
    }

    @Transactional
    public <T> T insertWithTransaction(T object) {
        entityManager.persist(object);
        return object;
    }

    public <T> T  insertWithoutTransaction(T object) {
        entityManager.persist(object);
        return object;
    }

    public <T> T find(Class<T> aClass,long id) {
        return entityManager.find(aClass, id);
    }



    public <T> List<T> findAll(Class<T> aClass) {
        Query query = entityManager.createQuery(" SELECT c from " + aClass.getSimpleName() + " c ");
        return query.getResultList();
    }

    public <T> List<T> findByQuery(Class<T> aClass,String queryString) {
        Query query = entityManager.createQuery(queryString,aClass);
        return query.getResultList();
    }


    public <T> T findSingleByQuery(Class<T> aClass,String queryString) {
        Query query = entityManager.createQuery(queryString,aClass);
        return (T)query.getSingleResult();
    }
}

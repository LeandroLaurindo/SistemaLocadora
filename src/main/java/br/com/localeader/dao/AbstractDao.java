/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.localeader.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.springframework.data.domain.Page;

/**
 *
 * @author Leandro Laurindo
 * @param <T>
 * @param <PK>
 */
public abstract class AbstractDao<T, PK extends Serializable> {

    private final Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    @PersistenceContext
    private EntityManager entityManager;

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    public void save(T entity) {
        entityManager.persist(entity);
    }

    public void update(T entity) {
        entityManager.merge(entity);
    }

    public void delete(PK id) {
        entityManager.remove(entityManager.getReference(entityClass, id));
    }

    public T findById(PK id) {
        return entityManager.find(entityClass, id);
    }

    @SuppressWarnings("JPQLValidation")
    public List<T> findAll() {
        return entityManager.createQuery("FROM " + entityClass.getSimpleName(), entityClass).getResultList();
    }

    public T buscarEntity(String jpql) {
        return (T) entityManager.createQuery(jpql).getSingleResult();
    }

    public List<T> listarDados(String jpql) {
        return entityManager.createQuery(jpql).getResultList();
    }

            
    protected List<T> createQuery(String jpql, Object... params) {
        TypedQuery<T> query = entityManager.createQuery(jpql, entityClass);
        for (int i = 0; i < params.length; i++) {
            query.setParameter(i + 1, params[i]);
        }
        return query.getResultList();
    }

}

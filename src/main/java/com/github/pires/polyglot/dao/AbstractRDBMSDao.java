/**
 * Copyright (C) Ubiwhere, Lda.
 * 2013
 *
 * The reproduction, transmission or use of this document or its contents is not
 * permitted without express written authorization. All rights, including rights
 * created by patent grant or registration of a utility model or design, are
 * reserved. Modifications made to this document are restricted to authorized
 * personnel only. Technical specifications and features are binding only when
 * specifically and expressly agreed upon in a written contract.
 */
package com.github.pires.polyglot.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.persistence.metamodel.EntityType;

/**
 * Abstract Data-Access Object class to be implemented by all DAO's.
 */
public abstract class AbstractRDBMSDao<T> {
  protected Class<T> entityClass;

  @PersistenceContext(unitName = "RDBMS_PU",
      type = PersistenceContextType.TRANSACTION)
  private EntityManager em;

  public AbstractRDBMSDao(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public EntityManager getEntityManager() {
    return this.em;
  }

  public void setEntityManager(EntityManager em) {
    this.em = em;
  }

  /**
   * Retrieves the meta-model for a certain entity.
   * 
   * @return the meta-model of a certain entity.
   */
  protected EntityType<T> getMetaModel() {
    return getEntityManager().getMetamodel().entity(entityClass);
  }

  public void create(T entity) {
    getEntityManager().persist(entity);
  }

  public T update(T entity) {
    return getEntityManager().merge(entity);
  }

  public void remove(Object entityId) {
    T entity = find(entityId);

    if (entity != null)
      getEntityManager().remove(entity);
  }

  public T find(Object id) {
    return getEntityManager().find(entityClass, id);
  }

  public List<T> findAll() {
    CriteriaQuery<T> cq = getEntityManager().getCriteriaBuilder().createQuery(
        entityClass);
    cq.select(cq.from(entityClass));

    return getEntityManager().createQuery(cq).getResultList();
  }

  public int count() {
    CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
    CriteriaQuery<Long> cq = cb.createQuery(Long.class);
    Root<T> root = cq.from(entityClass);
    cq.select(cb.count(root));
    Long count = getEntityManager().createQuery(cq).getSingleResult();

    return count.intValue();
  }

}
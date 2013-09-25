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

/**
 * Abstract Data-Access Object class to be implemented by all NoSQL DAO's.
 */
public abstract class AbstractNoSQLDao<T> {
  protected Class<T> entityClass;

  @PersistenceContext(unitName = "NOSQL_PU",
      type = PersistenceContextType.TRANSACTION)
  private EntityManager em;

  public AbstractNoSQLDao(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public EntityManager getEntityManager() {
    return this.em;
  }

  public void setEntityManager(EntityManager em) {
    this.em = em;
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
    String cql = "select t from " + entityClass.getSimpleName() + " t";
    return getEntityManager().createQuery(cql).getResultList();
  }

  public int count() {
    List<T> results = findAll();
    return results == null ? 0 : results.size();
  }

}
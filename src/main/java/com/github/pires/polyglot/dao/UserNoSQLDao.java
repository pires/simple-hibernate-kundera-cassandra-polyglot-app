package com.github.pires.polyglot.dao;

import javax.ejb.Local;
import javax.ejb.Stateless;

import com.github.pires.polyglot.model.UserNoSQL;

/**
 * DAO for {@link UserNoSQL} entity.
 */
@Stateless
@Local
public class UserNoSQLDao extends AbstractNoSQLDao<UserNoSQL> {

  public UserNoSQLDao() {
    super(UserNoSQL.class);
  }

}
package com.github.pires.polyglot.dao;

import com.github.pires.polyglot.model.UserNoSQL;

public class UserNoSQLDao extends AbstractNoSQLDao<UserNoSQL> {

  public UserNoSQLDao() {
    super(UserNoSQL.class);
  }

}
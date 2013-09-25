package com.github.pires.polyglot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "PolyglotKS@NOSQL_PU")
public class UserNoSQL {

  @Column
  private String name;

  public UserNoSQL() {
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
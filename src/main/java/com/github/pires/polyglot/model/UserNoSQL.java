package com.github.pires.polyglot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "USERS", schema = "PolyglotKS@NOSQL_PU")
public class UserNoSQL {

  @Id
  private Long id;

  @Column
  private String name;

  public UserNoSQL() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
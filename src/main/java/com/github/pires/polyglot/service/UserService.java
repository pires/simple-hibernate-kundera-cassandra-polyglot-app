package com.github.pires.polyglot.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.github.pires.polyglot.dao.UserNoSQLDao;
import com.github.pires.polyglot.dao.UserRDBMSDao;
import com.github.pires.polyglot.model.UserNoSQL;
import com.github.pires.polyglot.model.UserRDBMS;

@Path("/user")
public class UserService {

  @EJB
  private UserRDBMSDao rdbmsDao;

  @EJB
  private UserNoSQLDao nosqlDao;

  @PUT
  @Path("/{name}")
  public void addUser(@PathParam("name") final String name) {
    UserRDBMS u1 = new UserRDBMS();
    u1.setName(name);
    rdbmsDao.create(u1);

    UserNoSQL u2 = new UserNoSQL();
    u2.setName(name);
    nosqlDao.create(u2);
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public List<String> retrieveUserNames() {
    List<String> names = new ArrayList<String>();

    for (UserRDBMS u : rdbmsDao.findAll())
      names.add(u.getName());

    for (UserNoSQL u : nosqlDao.findAll())
      names.add(u.getName());

    return names;
  }

}
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

import javax.ejb.Stateless;

import com.github.pires.polyglot.model.UserRDBMS;

/**
 * DAO for {@link UserRDBMS} entity.
 */
@Stateless
public class UserRDBMSDao extends AbstractRDBMSDao<UserRDBMS> {

  public UserRDBMSDao() {
    super(UserRDBMS.class);
  }

}
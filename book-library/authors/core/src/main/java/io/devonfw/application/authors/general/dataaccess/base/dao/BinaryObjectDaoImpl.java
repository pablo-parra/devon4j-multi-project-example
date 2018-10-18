package io.devonfw.application.authors.general.dataaccess.base.dao;

import io.devonfw.application.authors.general.dataaccess.api.BinaryObjectEntity;
import io.devonfw.application.authors.general.dataaccess.api.dao.BinaryObjectDao;

import javax.inject.Named;

/**
 * Implementation of {@link BinaryObjectDao}.
 */
@Named
public class BinaryObjectDaoImpl extends ApplicationDaoImpl<BinaryObjectEntity> implements BinaryObjectDao {

  @Override
  public Class<BinaryObjectEntity> getEntityClass() {

    return BinaryObjectEntity.class;
  }

}

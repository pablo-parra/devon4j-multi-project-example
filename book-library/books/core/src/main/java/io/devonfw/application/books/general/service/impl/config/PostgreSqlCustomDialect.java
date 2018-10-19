package io.devonfw.application.books.general.service.impl.config;

import java.sql.Types;

import org.hibernate.dialect.PostgreSQL82Dialect;
import org.hibernate.type.descriptor.sql.BinaryTypeDescriptor;
import org.hibernate.type.descriptor.sql.SqlTypeDescriptor;

/**
 * Custom dialect for Postgresql db to solve BLOB issue
 *
 */
public class PostgreSqlCustomDialect extends PostgreSQL82Dialect {

  public PostgreSqlCustomDialect() {
      super();
      registerColumnType(Types.BLOB, "bytea");
  }

  @Override
  public SqlTypeDescriptor remapSqlTypeDescriptor(SqlTypeDescriptor sqlTypeDescriptor) {
      if (sqlTypeDescriptor.getSqlType() == java.sql.Types.BLOB) {
          return BinaryTypeDescriptor.INSTANCE;
      }
      return super.remapSqlTypeDescriptor(sqlTypeDescriptor);
  }
}

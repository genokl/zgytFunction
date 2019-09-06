package cn.zgyt.dataservice.liquibase;

import java.sql.SQLException;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

import liquibase.Liquibase;
import liquibase.database.Database;
import liquibase.database.DatabaseFactory;
import liquibase.database.jvm.JdbcConnection;
import liquibase.exception.DatabaseException;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.CompositeResourceAccessor;
import liquibase.resource.FileSystemResourceAccessor;
import liquibase.resource.ResourceAccessor;

public class LiquiHelpUtil {

	/**
	 * 通过liquibase执行更新操作
	 * @throws SQLException 
	 * @throws DatabaseException 
	 */
	public static Map<String, Object> excuteUpdate(String file,JdbcTemplate jdbcTemplate) throws Exception {
		ResourceAccessor clFO = new ClassLoaderResourceAccessor();
        ResourceAccessor fsFO = new FileSystemResourceAccessor();
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        ResourceAccessor threadClFO = new ClassLoaderResourceAccessor(contextClassLoader);
		Database database;
		database = DatabaseFactory.getInstance().findCorrectDatabaseImplementation(new JdbcConnection(jdbcTemplate.getDataSource().getConnection()));
		Liquibase l = new Liquibase(file, fsFO, database);
		l.update("");
		return null;
	}
}

package com.epam.travelagency.dao.pool;




import org.springframework.beans.factory.annotation.Autowired;


import com.zaxxer.hikari.HikariDataSource;

public class HikariConnectionPool {
	
	
	
	@Autowired
    private static HikariDataSource ds;
    
 /*   static {
        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        config.addDataSourceProperty( "autoCommit" , "false" );
        config.addDataSourceProperty( "useLocalTransactionState" , "false" );
   	 	ds = new HikariDataSource( config );
    }*/
    

    
    public static HikariDataSource getDataSource() {
    	return ds;
    }
}

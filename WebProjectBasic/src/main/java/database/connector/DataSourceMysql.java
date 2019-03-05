package database.connector;

import com.mysql.cj.jdbc.MysqlDataSource;

public class DataSourceMysql
{
    private MysqlDataSource dataSource = new MysqlDataSource();
    
    public DataSourceMysql()
    {
        try
        {
            dataSource.setServerName("localhost");
            dataSource.setPort(3306);
            dataSource.setDatabaseName("databasebasic");
            dataSource.setUser("root");
            dataSource.setPassword("admin");
            dataSource.setUseSSL(false);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
    public MysqlDataSource getDataSource()
    {
        return dataSource;
    }
}
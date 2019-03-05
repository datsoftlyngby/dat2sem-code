package main;

import database.connector.DataSourceMysql;
import mapper.UserMapper;
import entity.User;

public class Main
{
    public static void main(String[] args)
    {
        UserMapper userMapper = new UserMapper();
        
        DataSourceMysql dataSourceMysql = new DataSourceMysql();
        
        userMapper.setDataSource(dataSourceMysql.getDataSource());
        
        userMapper.registerUser("xyz", "999", 1000, false);
        
        User user = userMapper.validateUser("xyz", "999");
        
        userMapper.increaseBalance(user, 234);
        
        System.out.println("GetUser: " + userMapper.getUser(3));
    }
}
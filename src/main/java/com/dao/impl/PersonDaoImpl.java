package com.dao.impl;

import com.dao.PersonDao;
import com.person.Person;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PersonDaoImpl implements PersonDao {

    public List<Person> findAllPerson() throws Exception{
        List<Person> list = new ArrayList<Person>();
        Connection connection = null;
        PreparedStatement pst = null;
        ResultSet set = null;
        try{
            //加载驱动类
            Class.forName("com.mysql.jdbc.Driver");
             connection = DriverManager.getConnection("jdbc:mysql:///test","root","123456");
             pst = connection.prepareCall("select * from person;");
             set = pst.executeQuery();
            while(set.next()){
                Person p = new Person();
                p.setId(set.getInt("id"));
                p.setName(set.getString("name"));
                list.add(p);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(set != null ){
                set.close();
            }
            if(pst != null){
                pst.close();
            }
            if(connection != null){
                connection.close();
            }
        }
        return list;
    }
}

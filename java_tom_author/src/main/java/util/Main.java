/*
package util;
//import util.DBHelper;
import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import factory.FactoryMakingConnectors;

import java.sql.Connection;
import java.util.Properties;

import static util.DBHelper.getMySqlConfiguration;
import static util.DBHelper.getsessionfactory;

public class Main {
    UserJdbcDAO  connector;
    public static UserDAO dao;
    public static void main(String[] args) {
       // DBHelper dbHelper =new DBHelper();
        B b = new B();
        b.getConnectionNow();
        dao = FactoryMakingConnectors.getUserDAO();
    }
    static class B{

      void getConnectionNow() {
           // new UserJdbcDAO(DBHelper.getConnection());
           new UserHibernateDAO();

       }

    }

}
*/

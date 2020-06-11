package factory;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import org.hibernate.SessionFactory;
import util.DBHelper;
import util.PropertyReader;

import java.sql.Connection;
import java.util.Properties;

public abstract class FactoryMakingConnectors {
    public static UserDAO getUserDAO( ) {

        Properties properties = PropertyReader.getProperties(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        String factory = properties.getProperty("userDao");
       // Connection connection = null;



        UserDAO connector ;
        switch (factory) {
            case "HIBERNATE":
              //  connector = new FactoryHibDAO();
             connector =  new UserHibernateDAO(DBHelper.getsessionfactory());
                System.out.println(factory);
                break;
            case "JDBC":
               connector = new UserJdbcDAO(DBHelper.getConnection());
                System.out.println(factory);
                break;

            default:
                throw new IllegalArgumentException("Wrong connector type:");
        }
        return connector;
    }


   // public abstract UserDAO getUserDao();
   // возврат объект UserDAO
}

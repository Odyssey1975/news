package util;

import model.User;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBHelper {

    private static SessionFactory sessionFactory;
    private static Properties properties;
    private static DBHelper hdbConnection;


   /* public static DBHelper getHDBConnection() {
        if (hdbConnection == null) {
            hdbConnection = new DBHelper();
            properties = PropertyReader.getProperties(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        }
        return hdbConnection;
    }*/
    private static Configuration getMySqlConfiguration() {
        Configuration configuration = new Configuration();
        configuration.addAnnotatedClass(User.class);

        configuration.setProperty("hibernate.dialect", properties.getProperty("dialect"));
        configuration.setProperty("hibernate.connection.driver_class", properties.getProperty("driverClassName"));
        configuration.setProperty("hibernate.connection.url", properties.getProperty("dbUrl"));
        //уcовершенствовал время на серваке
        configuration.setProperty("hibernate.connection.username", properties.getProperty("dbUserName"));
        configuration.setProperty("hibernate.connection.password", properties.getProperty("dbPassword"));
        configuration.setProperty("hibernate.show_sql", "true");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        return configuration;
    }

    public static SessionFactory getConfiguration() { // к Hibernate
        Configuration configuration = getMySqlConfiguration();
        StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder();
        builder.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = builder.build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

    public static Connection getConnection() {  //к JDBC
        Connection connection;
        try {
            String dbUrl=properties.getProperty("dbUrl");
            String dbPassword = properties.getProperty("dbPassword");
            String dbUserName = properties.getProperty("dbUserName");
            String driverClassName = properties.getProperty("driverClassName");
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            return connection;
        } catch (SQLException | ClassNotFoundException e) {
            throw new IllegalStateException();
        }
    }

}

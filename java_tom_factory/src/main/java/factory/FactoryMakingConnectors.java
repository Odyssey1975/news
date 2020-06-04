package factory;

import dao.UserDAO;
import util.DBHelper;
import util.PropertyReader;
import java.util.Properties;

public abstract class FactoryMakingConnectors {
    public static FactoryMakingConnectors getFactoryDAO( )
    {
        Properties properties = PropertyReader.getProperties(DBHelper.class.getClassLoader().getResourceAsStream("db.properties"));
        String factory = properties.getProperty("userDao");

        FactoryMakingConnectors connector ;
        switch (factory) {
            case "HIBERNATE":
                connector = new FactoryHibDAO();
                break;
            case "JDBC":
                connector = new FactoryJDBCDAO();
                break;

            default:
                throw new IllegalArgumentException("Wrong connector type:");
        }
        return connector;
    }
    public abstract UserDAO getUserDao();
}

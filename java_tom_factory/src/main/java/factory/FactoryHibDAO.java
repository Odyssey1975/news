package factory;

import dao.UserDAO;
import dao.UserHibernateDAO;
import dao.UserJdbcDAO;
import util.DBHelper;

//import static util.DBHelper.getConfiguration;
//import static util.DBHelper.getHDBConnection;


public class FactoryHibDAO extends FactoryMakingConnectors {


    @Override
    public UserDAO getUserDao() {
        return new UserHibernateDAO(DBHelper.getConfiguration());
    }
}

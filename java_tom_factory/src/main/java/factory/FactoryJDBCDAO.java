package factory;
import dao.UserDAO;
import dao.UserJdbcDAO;
import util.DBHelper;

public class FactoryJDBCDAO extends FactoryMakingConnectors

{
    @Override
    public UserDAO getUserDao() {

         return new UserJdbcDAO(DBHelper.getConnection());
    }
}

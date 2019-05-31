package contract;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

public interface IDAOMap {

    Connection getConnection();
    void setPlayer();
    ArrayList<Integer> getLevelsList() throws SQLException;
    ILevel getMap(int id) throws SQLException;
    void getComponents(int id) throws SQLException;
}

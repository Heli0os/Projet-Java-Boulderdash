package contract;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * The interface IDAOMap
 * @author Théophile
 */
public interface IDAOMap {

    /**
     * The connection to the Database
     * @return the connection
     */
    Connection getConnection();

    /**
     * set The player
     */
    void setPlayer();

    /**
     * Get the levels list
     * @returnThe the levels list
     * @throws SQLException
     */
    ArrayList<Integer> getLevelsList() throws SQLException;

    /**
     * Get the map with its id
     * @param id The id of the map
     * @return The map
     * @throws SQLException
     */
    ILevel getMap(int id) throws SQLException;

    /**
     * Get the components of the map with its id
     * @param id The id of the map
     * @throws SQLException
     */
    void getComponents(int id) throws SQLException;
}

package model;

import contract.*;
import model.Elements.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMap implements IDAOMap{
/**
 * The class DAOMap
 * @author Clément / Baptiste
 */


    /**
     * The Connection
     */
    private final Connection connection;

    /**
     * The Height
     */
    private int height;

    /**
     * The Width
     */
    private int width;

    /**
     * the Level.
     */
    private ILevel level;

    /**
     * The player.
     */
    private IPlayer player;

    /**
     * The model
     */
    private IModel model;

    /**
     * The list of levels
     */
    private ArrayList<Integer> LevelsList;


    /**
     * Contructor of the DAOMap
     * @param connection The DAOMap
     */
    public DAOMap(Connection connection, Model model) {
        this.connection = connection;
        this.model = model;
        this.player = new Player(1, 1, Direction.NO);
    }


    /**
     * Get the connection
     * @return The connection
     */
    public Connection getConnection() {
        return this.connection;
    }


    /**
     * Get the list of levels
     * @return The list of levels
     * @throws SQLException
     */
    public ArrayList<Integer> getLevelsList() throws SQLException {
        try {
            final String sql = "{CALL GetLevelsList()}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.execute();
            final ResultSet levels = call.getResultSet();
            this.LevelsList = new ArrayList<Integer>();
            while (levels.next()) {
                LevelsList.add(levels.getInt(1));
            }
        }
        catch(final SQLException e){
            e.printStackTrace();
            }
        return this.LevelsList;
    }


    /**
     * Get the level selected
     * @param id The id of the level
     * @return The level
     */
    public ILevel getMap(int id) {
        try {

            final String sql = "{CALL GetLevel(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, id);
            call.execute();
            final ResultSet map = call.getResultSet();
            if (map.first()) {
            this.level = new Level(map.getInt(1), map.getString(2), map.getInt(3), map.getInt(4),this.player, 5);
            //this.level.autoFill();
            //System.err.println("level constructor called");
            }
        }
        catch(final SQLException e){
            e.printStackTrace();
        }
        return this.level;
    }


    /**
     * Get the components of the level
     * @param id The id of the level
     * @return The Components
     * @throws SQLException
     */
    public void getComponents(int id) throws SQLException {
        final String sql = "{CALL GetComponents(?)}";
        final CallableStatement call = this.getConnection().prepareCall(sql);
        call.setInt(1, id);
        call.execute();
        final ResultSet components = call.getResultSet();
        while (components.next()) {
            if (components.getString(1).equals("Dirt")) {
                this.level.setElement( new Dirt(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Rock")) {
                this.level.setElement( new Rocks(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Wall")) {
                this.level.setElement(new Walls(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Diamond")) {
                this.level.setElement(new Diamonds(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Enemy")) {
                this.level.setElement(new Ennemies(components.getInt(2), components.getInt(3), Direction.NO), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Player")) {
                this.level.setElement(new Player(components.getInt(2), components.getInt(3), Direction.NO), components.getInt(2), components.getInt(3));
            }
        }
    }

}

package model;

import contract.Direction;
import contract.IElements;
import model.Elements.*;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAOMap {

    /**
     * Connection
     */
    private final Connection connection;

    private int height;
    private int width;
    /**
     * the Level.
     */
    private Level level;

    /**
     * the Player.
     */
    private Player player;

    private Model model;

    private ArrayList<Integer> LevelsList;

    public DAOMap(Connection connection, Model model) {
        this.connection = connection;
        this.model = model;
    }

    protected Connection getConnection() {
        return this.connection;
    }

    public void getLevelsList() throws SQLException {
        final String sql = "{CALL GetLevelsList()}";
        final CallableStatement call = this.getConnection().prepareCall(sql);
        call.execute();
        final ResultSet levels = call.getResultSet();
        this.model.LevelsList = new ArrayList<>();
        while (levels.next()) {
            this.model.LevelsList.add(levels.getInt(1));
        }
    }

    public void getMap(int id) throws SQLException {
        final String sql = "{CALL GetLevel(?)}";
        final CallableStatement call = this.getConnection().prepareCall(sql);
        call.setInt(1, id);
        call.execute();
        final ResultSet map = call.getResultSet();
        if (map.first()) {
            this.level = new Level(map.getInt(1), map.getString(2), map.getInt(3), map.getInt(4), (IElements) player, 5);
        }
    }

    public void getComponents(int id) throws SQLException {
        final String sql = "{CALL GetComponents(?)}";
        final CallableStatement call = this.getConnection().prepareCall(sql);
        call.setInt(1, id);
        call.execute();
        final ResultSet components = call.getResultSet();
        while (components.next()) {
            if (components.getString(1).equals("Dirt")) {
                this.level.setElement((IElements) new Dirt(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Rock")) {
                this.level.setElement((IElements) new Rocks(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Wall")) {
                this.level.setElement((IElements) new Walls(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Diamond")) {
                this.level.setElement((IElements) new Diamonds(components.getInt(2), components.getInt(3)), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Enemy")) {
                this.level.setElement((IElements) new Ennemies(components.getInt(2), components.getInt(3), Direction.NO), components.getInt(2), components.getInt(3));
            }
            else if (components.getString(1).equals("Player")) {
                this.level.setElement((IElements) new Player(components.getInt(2), components.getInt(3), Direction.NO), components.getInt(2), components.getInt(3));
            }
        }
    }

}

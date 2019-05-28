package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMap {

    /**
     * Connection
     */
    private final Connection connection;

    private int height;
    private int width;

    public DAOMap(Connection connection) {
        this.connection = connection;
    }

    protected Connection getConnection() {
        return this.connection;
    }

    public int[][] getLevel(int ID) throws SQLException {
        getDimension(ID);
        int result[][] = new int[this.height][this.width];

        try {
            final String sql = "{call GetLevel(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, ID);
            call.execute();
            final ResultSet resultSet = call.getResultSet();

            if (resultSet.first()) {
                while (!resultSet.isAfterLast()) {
                    result[resultSet.getInt(1)][resultSet.getInt(2)] = resultSet.getString(3).toCharArray()[0];
                    resultSet.next();
                }
            }
        } catch (final SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


    /**
     * Dimension of the map
     * @param ID
     * @return
     * @throws SQLException
     */
    public int[] getDimension(int ID) throws SQLException {
        int result[] = new int[2];

        try {
            
            final String sql = "{call GetDimension(?)}";
            final CallableStatement call = this.getConnection().prepareCall(sql);
            call.setInt(1, ID);
            call.execute();
            final ResultSet resultSet = call.getResultSet();

            resultSet.first();
            this.height = resultSet.getInt("Height");
            this.width = resultSet.getInt("Width");

            result[0] = this.height;
            result[1] = this.width;

        } catch (final SQLException e) {
            e.printStackTrace();
        }

        return result;
    }
}

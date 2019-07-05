package amar.rx.using;

import amar.rx.jdbcInteraction.RowMapper;
import rx.Observable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SqlHelper {

    public static void execute(Connection c, String sql) {
        Statement s = null;
        try {
            s = c.createStatement();
            s.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {

                }
            }
        }
    }

    public static ResultSet executeQuery(Connection c, String sql) {
        Statement s = null;
        ResultSet resultSet = null;
        try {
            s = c.createStatement();
            resultSet = s.executeQuery(sql);
            return resultSet;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (SQLException e) {

                }
            }
        }
        return resultSet;
    }

    public static <T> Observable<T> executeQuery(ConnectionSubscription connectionSubscription,
                                                 String sqlString, RowMapper<T> rowMapper) throws SQLException {
        List<T> workList = new ArrayList<T>();

        Statement statement = connectionSubscription.getConnection().createStatement();
        connectionSubscription.registerResourceForClose(statement);
        ResultSet resultSet = statement.executeQuery(sqlString);
        connectionSubscription.registerResourceForClose(resultSet);

        while (resultSet.next()) {
            workList.add(rowMapper.call(resultSet));
        }

        return Observable.from(workList);
    }
}

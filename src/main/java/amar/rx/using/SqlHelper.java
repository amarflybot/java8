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

    public static void execute(final Connection c, final String sql) {
        Statement s = null;
        try {
            s = c.createStatement();
            s.execute(sql);
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (final SQLException e) {

                }
            }
        }
    }

    public static ResultSet executeQuery(final Connection c, final String sql) {
        Statement s = null;
        ResultSet resultSet = null;
        try {
            s = c.createStatement();
            resultSet = s.executeQuery(sql);
            return resultSet;
        } catch (final SQLException e) {
            e.printStackTrace();
        } finally {
            if (s != null) {
                try {
                    s.close();
                } catch (final SQLException e) {

                }
            }
        }
        return resultSet;
    }

    public static <T> Observable<T> executeQuery(final ConnectionSubscription connectionSubscription,
                                                 final String sqlString, final RowMapper<T> rowMapper) throws SQLException {
        final List<T> workList = new ArrayList<T>();

        final Statement statement = connectionSubscription.getConnection().createStatement();
        connectionSubscription.registerResourceForClose(statement);
        final ResultSet resultSet = statement.executeQuery(sqlString);
        connectionSubscription.registerResourceForClose(resultSet);

        while (resultSet.next()) {
            workList.add(rowMapper.call(resultSet));
        }

        return Observable.from(workList);
    }
}

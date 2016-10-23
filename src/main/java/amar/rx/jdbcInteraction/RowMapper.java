package amar.rx.jdbcInteraction;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by amarendra on 23/10/16.
 */
@FunctionalInterface
public interface RowMapper<T> {
    public T call(ResultSet resultSet) throws SQLException;
}

package palsta.db;

import java.sql.*;
import java.util.*;

public class QueryMaker<T> {

    private final Connection connection;
    private final Collector<T> collector;

    public QueryMaker(Connection connection, Collector<T> collector) {
        this.connection = connection;
        this.collector = collector;
    }

    public List<T> queryAndCollect(String query) throws SQLException {
        List<T> rows = new ArrayList<>();
        Statement stmt = connection.createStatement();
        ResultSet rs = stmt.executeQuery(query);

        while (rs.next()) {
            rows.add(collector.collect(rs));
        }

        rs.close();
        stmt.close();
        return rows;
    }

    public List<T> queryAndCollect(String query, Object... params) throws SQLException {
        List<T> rows = new ArrayList<>();
        PreparedStatement stmt = connection.prepareStatement(query);
        for (int i = 0; i < params.length; i++) {
            stmt.setObject(i + 1, params[i]);
        }

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            rows.add(collector.collect(rs));
        }

        rs.close();
        stmt.close();
        return rows;
    }

}

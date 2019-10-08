package practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/19
 * time        : 09:47
 * description :
 */
public class JDBCUtil {
    private static JDBCPool pool = new JDBCPool();

    public static Connection getConnection() throws SQLException {
        return pool.getConnection();
    }

    public static void release(Connection conn, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stat != null) {

        }
    }
}

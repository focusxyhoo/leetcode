package practice;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.*;
import java.util.Properties;
import java.util.Vector;
import java.util.logging.Logger;

/**
 * created with IntelliJ IDEA
 * author      : focusxyhoo
 * date        : 2019/9/19
 * time        : 09:12
 * description : 编写数据库连接池
 */
public class JDBCPool implements DataSource {

    private static Vector<Connection> Connections = new Vector<>();

    static {
        InputStream in = JDBCPool.class.getClassLoader().getResourceAsStream("db.properties");
        Properties prop = new Properties();
        try {
            prop.load(in);
            String driver = prop.getProperty("driver");
            String url = prop.getProperty("url");
            String username = prop.getProperty("username");
            String password = prop.getProperty("password");
            int jdbcPoolInitSize = Integer.parseInt(prop.getProperty("jdbcPoolInitSize"));
            Class.forName(driver);
            for (int i = 0; i < jdbcPoolInitSize; i++) {
                Connection conn = DriverManager.getConnection(url, username, password);
                System.out.println("获得到连接" + conn);
                Connections.addElement(conn);
            }
        } catch (SQLException e) {
            System.out.println("创建数据库连接失败！" + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("未找到类文件!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        if (Connections.size() > 0) {
            final Connection conn = Connections.remove(Connections.size() - 1);
            System.out.println("Connections 数据库连接池的大小是：" + Connections.size());
            return (Connection) Proxy.newProxyInstance(JDBCPool.class.getClassLoader(), conn.getClass().getInterfaces(), (proxy, method, args) -> {
                if (!method.getName().equals("close")) {
                    return method.invoke(conn, args);
                } else {
                    Connections.addElement(conn);
                    System.out.println(conn + "被还给了 Connections 数据库连接池了！");
                    System.out.println("数据库连接池的大小为：" + Connections.size());
                    return null;
                }
            });
        } else throw new RuntimeException("对不起，数据库忙！");
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }

    @Override
    public ConnectionBuilder createConnectionBuilder() throws SQLException {
        return null;
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }
}

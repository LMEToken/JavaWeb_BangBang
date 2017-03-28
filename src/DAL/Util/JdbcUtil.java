
package DAL.Util;

import java.sql.*;

/**
 * Created by tom on 2017/3/25.
 */
public class JdbcUtil {



    public static  Connection getConnection(){

        Connection connection=null;
        try {

            Class.forName("com.mysql.jdbc.Driver");	// 加载数据库驱动，注册到驱动管理器
            String url = "jdbc:mysql://localhost:3306/bangbang";	// 数据库连接字符串
            String username = "root";	// 数据库用户名
            String password = "520099";	// 数据库密码
            connection = DriverManager.getConnection(url,username,password);
            // 创建Connection连接 // 判断数据库连接是否为空 if(conn != null){ out.println("数据库连接成功！succuse");	// 输出连接信息 conn.close();	// 关闭数据库连接 }else{ out.println("数据库连接失败！fail");	// 输出连接信息 } } catch (ClassNotFoundException e) { e.printStackTrace();

        }catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return connection;
    }
    //用以关闭连接，释放资源
    public static void releaseConn(Connection connection, Statement statement,
                                   ResultSet resultSet) {
        if(resultSet!=null){
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            resultSet=null;
        }

        if(statement!=null){
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            statement=null;
        }

        if(connection!=null){
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            connection=null;
        }
    }
}

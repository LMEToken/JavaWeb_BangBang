package DAL;

import DAL.Util.JdbcUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by tom on 2017/3/25.
 */
public class UserDB {


    public static String login(String m_id,String m_pwd)
    {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        String jsonStr = null;

        try {
            // 调用工具类中的静态方法来获取连接
            connection = JdbcUtil.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from user where m_id = '"+m_id+"'and m_pwd = '"+m_pwd+"'");

            int id = resultSet.getInt("id");
            String name = resultSet.getString("m_name");
            String m_id1 = resultSet.getString("m_id");
            // String[] values =
            ArrayList list = new ArrayList();
            list.add(name);
            list.add(m_id1);

            HashMap<String,String>hashMap = new HashMap<>();
            hashMap.put("m_name",name);
            hashMap.put("m_id",m_id1);
            for (String key : hashMap.keySet()) {
                String value = hashMap.get(key);
                jsonStr += key + "=" + value + "&";
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 调用工具类中的静态方法来关闭连接，释放资源
            JdbcUtil.releaseConn(connection, statement, resultSet);
        }

        return jsonStr;

    }

}

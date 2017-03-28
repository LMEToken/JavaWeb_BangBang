package Servlet;

import DAL.UserDB;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * Created by tom on 2017/3/25.
 */
public class Servlet extends HttpServlet
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

        Map<String, String[]> params = request.getParameterMap();
        String m_id = "";
        String m_pwd = "";
        for (String key : params.keySet()) {
            String[] values = params.get(key);
            for (int i = 0; i < values.length; i++) {
                String value = values[i];
                if (key == "m_id")
                {
                    m_id = value;

                }else if (key == "m_pwd")
                {
                    m_pwd = value;
                }
            }
        }



        PrintWriter writer = response.getWriter();

        try {
            writer.println(UserDB.login(m_id,m_pwd));
        } catch (Exception e) {
            e.printStackTrace();
        }


//        writer.println("POST " + request.getRequestURL() + " " + queryString);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }


}

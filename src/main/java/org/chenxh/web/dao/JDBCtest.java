package org.chenxh.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JDBCtest {

    public static void main(String[] args) {

        Connection ct = null;

        //创建一个用于发送sql语句的对象
        PreparedStatement ps = null;
        //创建一个用于接收结果集的对象
        ResultSet rs = null;

        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //得到连接
            ct = DriverManager.getConnection
                    ("jdbc:mysql://47.95.214.61:3306/tale?useSSL=false&user=root&password=123456" );

            //查询
            ps = ct.prepareStatement("select * from t_attach");
            //得到结果
            rs = ps.executeQuery();
            //循环输出
            while(rs.next())
            {
                String a = rs.getString(1);
                String b = rs.getString(2);
                System.out.println(a + " " + b);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally
        {
            try {
                //关闭资源
                if(rs != null)
                {
                    rs.close();
                }
                if(ps != null)
                {
                    ps.close();
                }
                if(ct != null)
                {
                    ct.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }

        }
    }
}

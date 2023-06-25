package com.itheima.jdbc;

import javax.swing.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SQL_STU {
    STUDENT Stu = new STUDENT();
    public List<STUDENT> Student = new ArrayList<>();

    /*
    *添加*/

    public void AddTo(JTextField id, JTextField name, JTextField sex, JTextField age, JTextField dept, JTextField gpa) throws Exception {
        Stu.Sno = id.getText();
        Stu.Sname = name.getText();
        Stu.Ssex = sex.getText();
        String _age = age.getText();
        Stu.Sage = Integer.parseInt(_age);
        Stu.Sdept = dept.getText();
        String _gpa = gpa.getText();
        Stu.Sgpa = Float.parseFloat(_gpa);

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.获取链接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Stu_BASE";
        String username = "sa";
        String password = "12345dalaohuf";
        Connection conn = DriverManager.getConnection(url, username, password);
        //4.获取sql对象
        String query = "INSERT Student(Sno,Sname,Ssex,Sage,Sdept,Sgpa) VALUES (?, ?, ?, ?, ?, ?);";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Stu.Sno);
        pstmt.setString(2, Stu.Sname);
        pstmt.setString(3, Stu.Ssex);
        pstmt.setInt(4, Stu.Sage);
        pstmt.setString(5, Stu.Sdept);
        pstmt.setFloat(6, Stu.Sgpa);


        int count = pstmt.executeUpdate();
        System.out.println(count>0);
    }

    /*
    * 删除*/

    public boolean Delete(String id) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.获取链接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Stu_BASE";
        String username = "sa";
        String password = "12345dalaohuf";
        Connection conn = DriverManager.getConnection(url, username, password);
        //4.获取sql对象
        Statement stmt = conn.createStatement();

        //3.定义sql语句
        String query = "DELETE\n" +
                "FROM Student\n" +
                "WHERE Sno = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, id);
        int count = pstmt.executeUpdate();
        System.out.println(count>0);

        return count > 0;
    }

    /*
    * 修改*/
    public void UPDATE(JTextField id, JTextField name, JTextField sex, JTextField age, JTextField dept, JTextField gpa) throws Exception {
        Stu.Sno = id.getText();
        Stu.Sname = name.getText();
        Stu.Ssex = sex.getText();
        String _age = age.getText();
        Stu.Sage = Integer.parseInt(_age);
        Stu.Sdept = dept.getText();
        String _gpa = gpa.getText();
        Stu.Sgpa = Float.parseFloat(_gpa);

        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.获取链接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Stu_BASE";
        String username = "sa";
        String password = "12345dalaohuf";
        Connection conn = DriverManager.getConnection(url, username, password);

        //4.获取sql对象
        String query = "UPDATE Student\n" +
                "SET Sno = ?,\n" +
                "\tSname = ?,\n" +
                "\tSsex = ?,\n" +
                "\tSage = ?,\n" +
                "\tSdept = ?,\n" +
                "\tSgpa = ? \n" +
                "WHERE Sno = ?;";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Stu.Sno);
        pstmt.setString(2, Stu.Sname);
        pstmt.setString(3, Stu.Ssex);
        pstmt.setInt(4, Stu.Sage);
        pstmt.setString(5, Stu.Sdept);
        pstmt.setFloat(6, Stu.Sgpa);
        pstmt.setString(7, Stu.Sno); // 添加学号参数

        int count = pstmt.executeUpdate();
        System.out.println(count>0);
        System.out.println(Stu.Sno+" "+Stu.Sname+" "+Stu.Ssex+" "+Stu.Sage+" "+Stu.Sdept+" "+Stu.Sgpa);

    }


    /*
    * 根据主码获取元组*/
    public STUDENT SelectById(String Key) throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.获取链接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Stu_BASE";
        String username = "sa";
        String password = "12345dalaohuf";
        Connection conn = DriverManager.getConnection(url, username, password);
        //4.获取sql对象
        Statement stmt = conn.createStatement();

        //3.定义sql语句
        String query = "SELECT * FROM Student WHERE Sno = ?";
        PreparedStatement pstmt = conn.prepareStatement(query);
        pstmt.setString(1, Key);
        ResultSet resultSet = pstmt.executeQuery();


         STUDENT selectedStudent = null;
         if (resultSet.next()){
             selectedStudent = new STUDENT();
             selectedStudent.Sno = resultSet.getString("Sno");
             selectedStudent.Sname = resultSet.getString("Sname").replaceAll(" ","");
             selectedStudent.Ssex = resultSet.getString("Ssex");
             selectedStudent.Sage = resultSet.getInt("Sage");
             selectedStudent.Sdept = resultSet.getString("Sdept").replaceAll(" ","");
             selectedStudent.Sgpa = resultSet.getFloat("Sgpa");
         }
         //获取数据
        //7.释放资源
        resultSet.close();
        stmt.close();
        conn.close();

        return selectedStudent;
    }

    /*
    * 查询所有*/
    public void SelectAll() throws Exception {
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

        //2.获取链接
        String url = "jdbc:sqlserver://localhost:1433;databaseName=Stu_BASE";
        String username = "sa";
        String password = "12345dalaohuf";
        Connection conn = DriverManager.getConnection(url, username, password);
        //4.获取sql对象
        Statement stmt = conn.createStatement();

        //3.定义sql语句
        String query = "SELECT * FROM Student;";

        //5.执行sql
        ResultSet resultSet = stmt.executeQuery(query);


        while (resultSet.next()){
            STUDENT Stu = new STUDENT();
            //获取数据
            Stu.Sno = resultSet.getString("Sno");
            Stu.Sname = resultSet.getString("Sname").replaceAll(" ","");
            Stu.Ssex = resultSet.getString("Ssex");
            Stu.Sage = resultSet.getInt("Sage");
            Stu.Sdept = resultSet.getString("Sdept").replaceAll(" ","");
            Stu.Sgpa = resultSet.getFloat("Sgpa");

            Student.add(Stu);


        }


        //7.释放资源
        stmt.close();
        conn.close();
    }
    //返回全部数据集，装入二维数组

    public Object[][] getDataAsArray() throws Exception {
        SelectAll();
        Object[][] data = new Object[Student.size()][6];
        for (int i=0; i<Student.size();i++){
            STUDENT NewStudent = Student.get(i);
            data[i][0] = NewStudent.getSno();
            data[i][1] = NewStudent.getSname();
            data[i][2] = NewStudent.getSsex();
            data[i][3] = NewStudent.getSage();
            data[i][4] = NewStudent.getSdept();
            data[i][5] = NewStudent.getSgpa();
        }
        System.out.println(Student);

        return data;
    }
}

package com.jap;

import java.sql.*;


/**
 * Hello world!
 *
 */
public class DeleteUpdateStudentData
{



    public Connection getConnection() throws SQLException,ClassNotFoundException{

        Class.forName("com.mysql.cj.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/School";
        String user="root";
        String pass="admin";
        Connection connection=DriverManager.getConnection(url,user,pass);
        return connection;

    }

    public void deleteStudentData() throws SQLException,ClassNotFoundException{
      // call getConnection() method
        int row=0;
        Connection connection=getConnection();
        String sql="Delete from Student where rollNo=14";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        row= preparedStatement.executeUpdate();
        //execute delete query
    }

    public void updateStudentData() throws SQLException,ClassNotFoundException{
        // call getConnection() method

        int row=0;
        Connection connection=getConnection();
        String sql="Update Student set address='London' where rollNo=15";
        PreparedStatement preparedStatement= connection.prepareStatement(sql);
        row= preparedStatement.executeUpdate();
        //execute update query
    }

    public static void main(String[] args) {
        DeleteUpdateStudentData salesDataDemo = new DeleteUpdateStudentData();
        try{
            salesDataDemo.deleteStudentData();
            System.out.println("Deleted the row of Roll number 14 " );
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

        try{
            salesDataDemo.updateStudentData();
            System.out.println("Updated Address of Roll number 15 " );
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }

    }
}

import com.mysql.cj.jdbc.Driver;

import java.sql.*;

public class Main {
    private static final String url="jdbc:mysql://127.0.0.1:3306/mydb";
    private static final   String username="root";
    private static final String password="mohit@SQL123";
    public static void main(String[] args){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try {
            Connection connection= DriverManager.getConnection(url,username,password);
            Statement statement=connection.createStatement();
            //String query="select * from students"; this is for print the data
            String query=String.format("insert into students(name,age,marks) values ('%s',%o,%f)","vishal",23,74.5);
            //ResultSet resultSet=statement.executeQuery(query); this is for add new row in our table
            int rowsaffected=statement.executeUpdate(query);
//            while(resultSet.next()){
//                int id=resultSet.getInt("id");
//                String name=resultSet.getString("name");
//                int age=resultSet.getInt("age");
//                int marks=resultSet.getInt("marks");
//                System.out.println("ID:"+id);
//                System.out.println("name:"+name);
//                System.out.println("age:"+age);
//                System.out.println("marks:"+marks);
//            }
            if (rowsaffected>0) System.out.println("data inserted successfully");
            else System.out.println("data not inserted");
        }
        catch (SQLException s){
            System.out.println(s.getMessage());
        }
    }
}
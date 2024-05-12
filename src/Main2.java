import java.sql.*;
public class Main2 {
    private static final String url = "jdbc:mysql://localhost:3306/riteshsaini";
    private static final String username = "root";
    private static final String password = "Myadmin@123";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        try{
            Connection connection = DriverManager.getConnection(url,username,password);
            String query = "SELECT marks FROM students WHERE id = ?";
            PreparedStatement ps = connection.prepareStatement(query);
            //ps.setString(1,"Rahul");
            ps.setInt(1,1);
            //ps.setDouble(3,98.99);
           // Statement statement = connection.createStatement();
            //String query = "select * from students";
            // String query = String.format("INSERT INTO students(name ,age,marks) VALUES ('%s',%o,%f)","Sagar",21,89.0);
            //String query = String.format("UPDATE students SET marks = %f WHERE id = %d ",80.0,3);


            //String query = "DELETE  FROM students WHERE ID = 2 ";






            ResultSet resultSet = ps.executeQuery();
            if(resultSet.next()){
                double marks = resultSet.getDouble("marks");
                System.out.println("Marks :"+marks);
            }
            else{
                System.out.println("Marks not found!!");
            }

           // int rowsAffected = ps.executeUpdate();


            //while(resultSet.next()){
               // int id = resultSet.getInt("id");
               // String name  = resultSet.getString("name");
               // int age = resultSet.getInt("age");
              //  double marks = resultSet.getDouble("marks");
               // System.out.println("ID : "+id);
              //  System.out.println("NAME : "+name);
               // System.out.println("AGE : "+age);
               // System.out.println("MARKS : "+marks);
           // }
           // if(rowsAffected>0){
          //      System.out.println("Data inserted  successfully");
          //  }else{
          //      System.out.println("Data  not inserted  ");
          //  }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

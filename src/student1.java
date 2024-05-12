import java.sql.*;

public class student1 {

    private static final String url = "jdbc:mysql://localhost:3306/riteshsaini";
    private static final String username = "root";
    private static final String password = "Myadmin@123";

    public static void main(String[] args) {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();

            String query = "select *from student1";
           ResultSet rs =  st.executeQuery(query);
           while(rs.next()){
               int id = rs.getInt("id");
               String name = rs.getString("name");
               double marks = rs.getDouble("marks");
               System.out.println("ID = "+id+" NAME = "+name+" MARKS = "+marks);

           }

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}

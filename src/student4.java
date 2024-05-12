

import java.sql.*;

public class student4 {
    private static final String url = "jdbc:mysql://localhost:3306/riteshsaini";
    private static final String username = "root";
    private static final String password = "Myadmin@123";

    public static void main(String[] args) {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();

            String query  = "DELETE FROM student1 WHERE id = 21";

            int rowsAffected =  st.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("update hogaya");
            }
            else{
                System.out.println("Bhi ni hua data update");
            }


        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}

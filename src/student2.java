
import java.sql.*;

public class student2 {

    private static final String url = "jdbc:mysql://localhost:3306/riteshsaini";
    private static final String username = "root";
    private static final String password = "Myadmin@123";

    public static void main(String[] args) {
        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url,username,password);
            Statement st = con.createStatement();

            String query = String.format("INSERT INTO student1(id,name,marks) VALUES(%o,'%s',%f)",34,"Ravi",56.89);

            int rowsAffected =  st.executeUpdate(query);
            if(rowsAffected>0){
                System.out.println("Insert hogaya");
            }
            else{
                System.out.println("Bhi ni hua data update");
            }


        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

}

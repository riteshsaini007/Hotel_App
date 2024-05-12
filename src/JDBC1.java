import java.sql.Connection;
import java.sql.DriverManager;

public class JDBC1 {
    public static void main(String[] args) {
        try {
            Connection obj = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "");
            System.out.println(obj);


            System.out.println(obj);
        } catch (Exception e) {
            System.out.println(e);
        }
    }


}
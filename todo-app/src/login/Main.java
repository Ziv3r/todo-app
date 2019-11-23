package login;
import java.sql.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws SQLException {
        // write your code here

        Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/todo-app", "root", "123456"
        );
        Statement stmt = conn.createStatement();

        //String strSelect = "select * from users";

        //ResultSet rst = stmt.executeQuery(strSelect);

//        while(rst.next()) {
//            final String username = rst.getString("userName");
//            final int id = rst.getInt("id");
//            System.out.println(username + id);
//        }

        Scanner sc = new Scanner(System.in);

        String userName = sc.nextLine();

        String userNameToSql = "\"" + userName + "\"" ;

        String sqlDelete = "delete from books where id >= 3000 and id < 4000";
        System.out.println("The SQL statement is: " + sqlDelete + "\n");  // Echo for debugging
        int countDeleted = stmt.executeUpdate(sqlDelete);

        //add user to db
        String newUser = "insert into users(userName) values(" +userNameToSql+ ")";

        String deleteEx = "delete from users where userName = oran";

        int countDeletedOk = stmt.executeUpdate(sqlDelete);

        System.out.println(countDeletedOk);

        stmt.execute(newUser);

    }
}

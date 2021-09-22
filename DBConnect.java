import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConnect {
    public static void main(String[] args) {

        String driverName = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/test1";
        String user = "root";
        String password = "rootroot";

        try {

            Class.forName(driverName);

            Connection con = DriverManager.getConnection(url,user,password);
            Statement databaseStatement = con.createStatement();


            int row_count = databaseStatement.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values(1,'Emily','emily@test.com','0729029343','Trainee software engineer',25000)");
            int row_count2 = databaseStatement.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values(2,'Arron','Arron@test.com','0729029345','Trainee software engineer',24000)");
            int row_count3 = databaseStatement.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values(3,'John','John@test.com','0729029347','Trainee software engineer',24500)");
            int row_count4 = databaseStatement.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values(4,'Bill','Bill@test.com','0729029349','Trainee software engineer',24600)");
            int row_count5 = databaseStatement.executeUpdate("insert into employee(eid,ename,email,mobile,designation,salary) values(5,'Sarah','Sarah@test.com','0729029357','Trainee software engineer',28000)");

            System.out.println("NEW ROWS INSERTED");
            System.out.println("================================");

            ResultSet rs = databaseStatement.executeQuery("select * from employee");

            while(rs.next()) {
                System.out.println("ID: "+rs.getInt(1));
                System.out.println("Name: "+rs.getString(2));
                System.out.println("Email: "+rs.getString(3));
                System.out.println("Mobile: "+rs.getString(4));
                System.out.println("Designation: "+rs.getString(5));
                System.out.println("Salary: "+rs.getInt(6));

                System.out.println("================================");
            }

        } catch (Exception e) {
            System.out.println("Database error :"+e);

        }

        try {
            Class.forName(driverName);

            Connection con = DriverManager.getConnection(url,user,password);
            Statement databaseStatement = con.createStatement();

            int row_delete = databaseStatement.executeUpdate("DROP TABLE employee");
            System.out.println("*******Database deleted*******");

            // OR JUST TO DELETE THE ENTRIES BUT KEEP THE TABLE
//            int row_delete = databaseStatement.executeUpdate("DELETE FROM employee WHERE eid <= 5");
//            System.out.println("*******All entries deleted*******");

        } catch (Exception e) {
            System.out.println("Database error :"+e);
        }



    }

}

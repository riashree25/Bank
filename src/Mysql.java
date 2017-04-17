import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Mysql {

    public static void insert(int a1, String s1, String s2, String s3, String s4, String s5, double a2, String s6) {

        String query = "insert into Personal values(" + a1 + ",'" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','"
                + s5 + "'," + a2 + ",'" + s6 + "')";

        System.out.println(query);
        System.exit(0);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "friends");
            Statement stmt = con.createStatement();
            int rs = stmt.executeUpdate(query);
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "friends");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Personal");
            while (rs.next())
                System.out.println(
                        rs.getInt("Account_No") + "  " + rs.getString("First_Name") + "  " + rs.getString("Last_Name"));
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        insert(1, "abc", "def", "ghi", "jkl", "mno", 2.3, "pqr");
    }
}

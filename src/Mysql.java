import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Mysql {

    public static void insert(int a1, String s1, String s2, String s3, String s4, String s5, long a2, String s6) {

        String query = "insert into Personal(Aadhar_No,First_Name,Last_Name,Gender,Birth_Date,Address,Mobile_no,Email_Id) values(" + a1 + ",'" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "','"
                + s5 + "'," + a2 + ",'" + s6 + "')";
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

    }
}

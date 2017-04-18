import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

class Mysql {

    public static void insert(int a1, String s1, String s2, String s3, String s4, long a2, String s5, String s6, String s7)
    {

        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "friends");
            Statement stmt = con.createStatement();
            String query1 = "insert into Personal(Aadhar_No,Name,Gender,Birth_Date,Address,Mobile_no,Email_Id) values(" + a1 + ",'" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "',"
                + a2 + ",'" + s5 + "')";
            stmt.executeUpdate(query1);
            ResultSet rs = stmt.executeQuery("select Account_No from Personal where Aadhar_No=" + a1 +";");
            int x=0;
            while(rs.next())
                x = rs.getInt("Account_No");
            String query2="insert into Account(Account_No) values(" + x + ");";
            String query3="insert into UserPwd values('" + s6 + "','" + s7 + "'," + x + ");";
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void select(String s1, String s2) {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "friends");
            Statement stmt = con.createStatement();
            ResultSet rs1 = stmt.executeQuery("select User_Name from UserPwd where User_Name='" + s1 + "';");
            

            con.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

    }
}

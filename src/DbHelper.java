import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DbHelper {

    private static Connection conn;

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Bank", "root", "friends");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertUserData(int a1, String s1, String s2, String s3, String s4, long a2, String s5, String s6,
                                      String s7) {

        try {
            Statement stmt = conn.createStatement();
            String query1 = "insert into Personal(Aadhar_No,Name,Gender,Birth_Date,Address,Mobile_no,Email_Id) values("
                    + a1 + ",'" + s1 + "','" + s2 + "','" + s3 + "','" + s4 + "'," + a2 + ",'" + s5 + "');";
            stmt.executeUpdate(query1);
            ResultSet rs = stmt.executeQuery("select Account_No from Personal where Aadhar_No=" + a1 + ";");
            int x = 0;
            while (rs.next())
                x = rs.getInt("Account_No");
            String query2 = "insert into Account(Account_No) values(" + x + ");";
            String query3 = "insert into UserPwd values('" + s6 + "','" + s7 + "'," + x + ");";
            stmt.executeUpdate(query2);
            stmt.executeUpdate(query3);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet selectFromUserPwd(String userName) {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("select * from UserPwd where User_Name='" + userName + "';");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateData(String address, long mob, String email) {
        try {
            Statement stmt = conn.createStatement();
            String query = "update Personal set Address='" + address + "', Mobile_No=" + mob + ", Email_Id='" + email
                    + "' where Account_no=" + BankApp.accNo + ";";
            stmt.executeUpdate(query);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateBalance(double amount) {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select Balance from Account where Account_No=" + BankApp.accNo + ";");
            rs.next();

            double x = rs.getDouble("Balance");
            x += amount;

            String query1 = "update Account set Balance=" + x + " where Account_no=" + BankApp.accNo + ";";
            stmt.executeUpdate(query1);

            String query2 = "insert into Txn(Account_No,Amount,Updated_Bal,IsDebit) values(" + BankApp.accNo + "," + Math.abs(amount) + "," + x;
            query2 += amount < 0 ? ",true)" : ",false)";

            stmt.executeUpdate(query2);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static ResultSet getAccDetails() {
        try {
            Statement stmt = conn.createStatement();
            return stmt.executeQuery("select p.Account_No,Aadhar_No,Name,Gender,Birth_Date,Balance,Address,Mobile_No,"
                    + "Email_Id from Personal p,Account a where a.Account_No=" + BankApp.accNo
                    + " and p.Account_No = a.Account_No;");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Object[][] selectTransaction() {
        try {
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from Txn where Account_No=" + BankApp.accNo + " order by Time DESC limit 5");

            List<Object[]> data = new ArrayList<>();

            while (rs.next()) {

                data.add(new Object[] {rs.getInt("Txn_Id"), rs.getDouble("Amount"), rs.getBoolean("IsDebit"),
                        rs.getTimestamp("IsDebit")});
            }

            return data.toArray(new Object[][] {});
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}

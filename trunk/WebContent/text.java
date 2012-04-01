import java.sql.*;
import java.util.*;
public class text
{
public static void main(String aa[]) throws SQLException
{
try {
        Class.forName("org.hsqldb.jdbcDriver" );
    } catch (Exception e) {
        System.out.println("ERROR: failed to load HSQLDB JDBC driver.");
        e.printStackTrace();
        }

    Connection c = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost", "sa", "");
Statement st=c.createStatement();
ResultSet rs=st.executeQuery("select * from emp");
while(rs.next())
{
System.out.println("Selected Record is "+rs.getString(1));
}
}
}
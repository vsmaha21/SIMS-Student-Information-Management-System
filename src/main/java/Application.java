import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Application {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		  
		String url="jdbc:postgresql://localhost:5432/MIS";
		String user="postgres";
		String password="2308";
		Connection con = DriverManager.getConnection(url,user,password);
		System.out.println("Connection Done");
		
		
//		st.execute("insert into public.\"StudentClass6\" values(127,'Raj','Delhi',87.80)");
		
		
		
		//
//		
//		PreparedStatement st1 = con.prepareStatement("insert into public.\"StudentClass6\" values(?,?,?,?)");
//		st1.setInt(1, 128);
//		st1.setString(2, "Ram");
//		st1.setString(3, "Delhi");
//		st1.setDouble(4, 99);
//		st1.execute();
		Statement st = con.createStatement();
		ResultSet rs=st.executeQuery("select * from public.\"StudentClass6\" where smarks =(select max(smarks) from public.\"StudentClass6\");");
		
		while(rs.next()) {
			
			System.out.print(rs.getString("sid")+" ");
			System.out.print(rs.getString("sname")+" ");
			System.out.print(rs.getString("saddress")+" ");
			System.out.println(rs.getString("smarks")+" ");
			}
		
		con.close();
		
	}

}

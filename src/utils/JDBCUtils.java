package utils;
import java.sql.*;
public class JDBCUtils {
	public static Connection getConnection(){
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String url="jdbc:mysql://localhost:3306/product?serverTimezone-UTC&useUnicode=true&characterEncoding=utf8";
		String user="root";
		String password="123456";
		try {
			con=DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	public static void release(Statement stat,Connection con){
		if(stat!=null){
			try{
				stat.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			stat=null;
		}
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			con=null;
		}
	}
	public static void release(PreparedStatement stat,Connection con){
		if(stat!=null){
			try{
				stat.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			stat=null;
		}
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			con=null;
		}
	}
	public static void release(ResultSet rs,Statement stat,Connection con){
		if(rs!=null){
			try{
				rs.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			rs=null;
		}
		if(stat!=null){
			try{
				stat.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			stat=null;
		}
		if(con!=null){
			try{
				con.close();
			}
			catch(Exception e){
				e.printStackTrace();
			}
			con=null;
		}
	}
}

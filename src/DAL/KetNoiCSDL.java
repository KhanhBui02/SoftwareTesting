package DAL;

import java.sql.*;

public class KetNoiCSDL {
	protected Connection con;
	public boolean openConnection() {
		try{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String dbURL = "jdbc:sqlserver://DUCTHANG;DatabaseName=QUANLYMAYTINH;integratedSecurity=true;encrypt=true;trustServerCertificate=true;";
			String username ="DUCTHANG";
			String password="";
			con = DriverManager.getConnection(dbURL, username, password);
			return true;
		}
		catch (Exception e){
			System.out.println(e);
			return false;
		}
	}
	public void closeConnection(){
		try{
			if(con!=null)
			con.close();
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}

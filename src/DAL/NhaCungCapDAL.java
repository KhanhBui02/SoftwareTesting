package DAL;

import DTO.NhaCungCapDTO;
import java.sql.*;
import java.util.Vector;

public class NhaCungCapDAL extends KetNoiCSDL {
			  /*
    ============================================================
                     Lấy danh sách nhà cung cấp       
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCap(){
		Vector<NhaCungCapDTO> arr = new Vector<NhaCungCapDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM NHACUNGCAP";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				NhaCungCapDTO NhaCungCap = new NhaCungCapDTO();
				NhaCungCap.setNhaCungCap_ID(rs.getInt("MANCC"));
				NhaCungCap.setNhaCungCap_Name(rs.getString("TENNCC"));
				NhaCungCap.setNhaCungCap_Address(rs.getString("DIACHI"));
				NhaCungCap.setNhaCungCap_PhoneNumber(rs.getString("SDT"));
				arr.add(NhaCungCap);
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			closeConnection();
		} }
		return arr;
	}
			  /*
    ============================================================
                   Lấy danh sách nhà cung cấp theo SDT       
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCapTheoSDT(int SDT){
		Vector<NhaCungCapDTO> arr = new Vector<NhaCungCapDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHACUNGCAP WHERE SDT="+SDT;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					NhaCungCapDTO NhaCungCap = new NhaCungCapDTO();
					NhaCungCap.setNhaCungCap_ID(rs.getInt("MANCC"));
					NhaCungCap.setNhaCungCap_Name(rs.getString("TENNCC"));
					NhaCungCap.setNhaCungCap_Address(rs.getString("DIACHI"));
					NhaCungCap.setNhaCungCap_PhoneNumber(rs.getString("SDT"));
					arr.add(NhaCungCap);
				}	
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { 
				closeConnection(); 
			} }
		return arr;
	}	
			  /*
    ============================================================
                     Lấy danh sách cung cấp theo tên       
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCapTheoTen(String Ten){
		Vector<NhaCungCapDTO> arr = new Vector<NhaCungCapDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHACUNGCAP WHERE TENNCC LIKE N'%"+Ten+"%'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					NhaCungCapDTO NhaCungCap = new NhaCungCapDTO();
					NhaCungCap.setNhaCungCap_ID(rs.getInt("MANCC"));
					NhaCungCap.setNhaCungCap_Name(rs.getString("TENNCC"));
					NhaCungCap.setNhaCungCap_Address(rs.getString("DIACHI"));
					NhaCungCap.setNhaCungCap_PhoneNumber(rs.getString("SDT"));
					arr.add(NhaCungCap);
				}	
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { 
				closeConnection(); 
			} }
		return arr;
	}
			  /*
    ============================================================
                     Kiểm tra nhà cung cấp tồn tại bằng id      
    ============================================================
     */
	public boolean hasNhaCungCap_ID(int ID) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHACUNGCAP WHERE MANCC="+ID;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { 
				closeConnection(); 
			} }
		return result;
	}
				  /*
    ============================================================
                     Kiểm tra nhà cung cấp tồn tại bằng SDT      
    ============================================================
     */
	public boolean hasNhaCungCap_PhoneNumber(int SDT) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHACUNGCAP WHERE SDT="+SDT;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				result = rs.next();
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally { 
				closeConnection(); 
			} }
		return result;
	}
				  /*
    ============================================================
                  Thêm nhà cung cấp     
    ============================================================
     */
	public boolean addNhaCungCap(NhaCungCapDTO NCC) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO NHACUNGCAP VALUES(?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, NCC.getNhaCungCap_Name());
				stmt.setString(2, NCC.getNhaCungCap_PhoneNumber());
				stmt.setString(3, NCC.getNhaCungCap_Address());
			if (stmt.executeUpdate()>=1)
				result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection(); 
			} }
		return result;
	}
				  /*
    ============================================================
          			   Xoá nhà cung cấp     
    ============================================================
     */
	public boolean deleteNhaCungCap(NhaCungCapDTO NCC) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "DELETE NHACUNGCAP WHERE MANCC=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, NCC.getNhaCungCap_ID());
			if (stmt.executeUpdate()>=1)
				result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection(); 
			} }
		return result;
	}
				  /*
    ============================================================
        			    Sửa nhà cung cấp     
    ============================================================
     */
	public boolean editNhaCungCap(NhaCungCapDTO NCC) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "UPDATE NHACUNGCAP SET TENNCC=? , SDT=? , DIACHI=? WHERE MANCC=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, NCC.getNhaCungCap_Name());
				stmt.setString(2, NCC.getNhaCungCap_PhoneNumber());
				stmt.setString(3, NCC.getNhaCungCap_Address());
				stmt.setInt(4, NCC.getNhaCungCap_ID());
			if (stmt.executeUpdate()>=1)
				result = true;
			} catch(SQLException ex){
				System.out.println();
			} finally{
				closeConnection();
			} 
		}		
		return result;
	}
}
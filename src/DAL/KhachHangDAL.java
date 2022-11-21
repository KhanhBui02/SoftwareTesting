package DAL;

import DTO.KhachHangDTO;
import java.sql.*;
import java.util.Vector;

public class KhachHangDAL extends KetNoiCSDL {
			  /*
    ============================================================
                     Lấy danh sách khách hàng       
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHang(){
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM KHACHHANG";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				KhachHangDTO KhachHang = new KhachHangDTO();
				KhachHang.setKhachHang_ID(rs.getInt("MAKH"));
				KhachHang.setKhachHang_Name(rs.getString("HOTEN"));
				KhachHang.setKhachHang_PhoneNumber(rs.getString("SDT"));
				KhachHang.setKhachHang_Address(rs.getString("DCHI"));
				KhachHang.setKhachHang_Email(rs.getString("EMAIL"));
				arr.add(KhachHang);
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
                     Lấy danh sách khách hàng theo SDT        
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHangTheoSDT(int SDT){
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM KHACHHANG WHERE SDT="+SDT;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					KhachHangDTO KhachHang = new KhachHangDTO();
					KhachHang.setKhachHang_ID(rs.getInt("MAKH"));
					KhachHang.setKhachHang_Name(rs.getString("HOTEN"));
					KhachHang.setKhachHang_PhoneNumber(rs.getString("SDT"));
					KhachHang.setKhachHang_Address(rs.getString("DCHI"));
					KhachHang.setKhachHang_Email(rs.getString("EMAIL"));
					arr.add(KhachHang);
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
                     Lấy danh sách khách hàng theo tên        
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHangTheoTen(String Ten){
		Vector<KhachHangDTO> arr = new Vector<KhachHangDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM KHACHHANG WHERE HOTEN LIKE N'%"+Ten+"%'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					KhachHangDTO KhachHang = new KhachHangDTO();
					KhachHang.setKhachHang_ID(rs.getInt("MAKH"));
					KhachHang.setKhachHang_Name(rs.getString("HOTEN"));
					KhachHang.setKhachHang_PhoneNumber(rs.getString("SDT"));
					KhachHang.setKhachHang_Address(rs.getString("DCHI"));
					KhachHang.setKhachHang_Email(rs.getString("EMAIL"));
					arr.add(KhachHang);
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
                    Kiểm tra khách hàng đã tồn tại         
    ============================================================
     */
	public boolean hasKhachHang_ID(int ID) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM KHACHHANG WHERE MAKH="+ID;
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
                    Kiểm tra khách hàng tồn tại theo SDT        
    ============================================================
     */
	public boolean hasKhachHang_PhoneNumber(int SDT) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM KHACHHANG WHERE SDT="+SDT;
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
                     Thêm khách hàng        
    ============================================================
     */
	public boolean addKhachHang(KhachHangDTO KH) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO KHACHHANG VALUES(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, KH.getKhachHang_Name());
				stmt.setString(2, KH.getKhachHang_PhoneNumber());
				stmt.setString(3, KH.getKhachHang_Address());
				stmt.setString(4, KH.getKhachHang_Email());
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
                     Xoá khách hàng        
    ============================================================
     */
	public boolean deleteKhachHang(KhachHangDTO KH) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "DELETE KHACHHANG WHERE MAKH=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, KH.getKhachHang_ID());
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
                    Sửa kháchh hàng         
    ============================================================
     */
	public boolean editKhachHang(KhachHangDTO KH) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "UPDATE KHACHHANG SET HOTEN=? , SDT=? , DCHI=? , EMAIL=? WHERE MAKH=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, KH.getKhachHang_Name());
				stmt.setString(2, KH.getKhachHang_PhoneNumber());
				stmt.setString(3, KH.getKhachHang_Address());
				stmt.setString(4, KH.getKhachHang_Email());
				stmt.setInt(5, KH.getKhachHang_ID());
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
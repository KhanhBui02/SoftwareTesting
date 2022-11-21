package DAL;

import DTO.NhanVienDTO;
import java.sql.*;
import java.util.Vector;

public class NhanVienDAL extends KetNoiCSDL{
				  /*
    ============================================================
            		Lấy danh sách nhân viên  
    ============================================================
     */
	public Vector<NhanVienDTO> LayDSNhanVien(){
		Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM NhanVien";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				NhanVienDTO NhanVien = new NhanVienDTO();
				NhanVien.setNhanVien_ID(rs.getInt("MANV"));
				NhanVien.setNhanVien_Name(rs.getString("TENNV"));
				NhanVien.setNhanVien_PhoneNumber(rs.getString("SDT"));
				NhanVien.setNhanVien_Address(rs.getString("DCHI"));
				NhanVien.setNhanVien_Username(rs.getString("TENDANGNHAP"));
				NhanVien.setNhanVien_Password(rs.getString("MATKHAU"));
				NhanVien.setNhanVien_Type(rs.getInt("LOAINV"));
				arr.add(NhanVien);
			}	
		}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			closeConnection();
		}}
		return arr;
	}
	/*
    ============================================================
                     Lấy danh sách khách hàng theo tên        
    ============================================================
     */
	public Vector<NhanVienDTO> LayDSNhanVienTheoTen(String Ten){
		Vector<NhanVienDTO> arr = new Vector<NhanVienDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHANVIEN WHERE TENNV LIKE N'%"+Ten+"%'";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					NhanVienDTO NhanVien = new NhanVienDTO();
					NhanVien.setNhanVien_ID(rs.getInt("MANV"));
					NhanVien.setNhanVien_Name(rs.getString("TENNV"));
					NhanVien.setNhanVien_PhoneNumber(rs.getString("SDT"));
					NhanVien.setNhanVien_Address(rs.getString("DCHI"));
					NhanVien.setNhanVien_Username(rs.getString("TENDANGNHAP"));
					NhanVien.setNhanVien_Password(rs.getString("MATKHAU"));
					NhanVien.setNhanVien_Type(rs.getInt("LOAINV"));
					arr.add(NhanVien);
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
               				 Đăng nhập      
    ============================================================
     */
	 public NhanVienDTO DangNhap(NhanVienDTO User) {
		 if (openConnection()) {
	        try {
	            String sql = "SELECT * FROM NHANVIEN WHERE TENDANGNHAP=? AND MATKHAU=?";
	            PreparedStatement pre = con.prepareStatement(sql);
	            pre.setString(1, User.getNhanVien_Username());
	            pre.setString(2, User.getNhanVien_Password());
	            ResultSet rs = pre.executeQuery();
	            NhanVienDTO UserLogin = null;
	            if (rs.next()) {
	                UserLogin = User;
	                UserLogin.setNhanVien_ID(rs.getInt("MANV"));
	                UserLogin.setNhanVien_Name(rs.getString("TENNV"));
	                UserLogin.setNhanVien_PhoneNumber(rs.getString("SDT"));
	                UserLogin.setNhanVien_Address(rs.getString("DCHI"));
	                UserLogin.setNhanVien_Type(rs.getInt("LOAINV"));
	            }
	            return UserLogin;
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
				closeConnection();
			} }
		 return User;
	}
	 			  /*
    ============================================================
            Kiểm tra nhân viên tồn tại bằng id     
    ============================================================
     */
	public boolean hasNhanVien_ID(int ID){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM NHANVIEN WHERE MANV="+ID;
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
            			Thêm nhân viên     
    ============================================================
     */
	public boolean addNhanVien(NhanVienDTO NV) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO NHANVIEN VALUES(?,?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, NV.getNhanVien_Name());
				stmt.setString(2, NV.getNhanVien_PhoneNumber());
				stmt.setString(3, NV.getNhanVien_Address());
				stmt.setString(4, NV.getNhanVien_Username());
				stmt.setString(5, NV.getNhanVien_Password());
				stmt.setInt(6, NV.getNhanVien_Type());
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
               			Xoá nhân viên    
    ============================================================
     */
	public boolean deleteNhanVien(NhanVienDTO NV) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "DELETE NHANVIEN WHERE MANV=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, NV.getNhanVien_ID());
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
               			Sửa nhân viên    
    ============================================================
     */
	public boolean editNhanVien(NhanVienDTO NV) {
		boolean result = false;
		if(openConnection()){
			try{
				String sql = "UPDATE NHANVIEN SET TENNV=? , SDT=? , DCHI=? , TENDANGNHAP=? , MATKHAU=? , LOAINV=? WHERE MANV=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setString(1, NV.getNhanVien_Name());
				stmt.setString(2, NV.getNhanVien_PhoneNumber());
				stmt.setString(3, NV.getNhanVien_Address());
				stmt.setString(4, NV.getNhanVien_Username());
				stmt.setString(5, NV.getNhanVien_Password());
				stmt.setInt(6, NV.getNhanVien_Type());
				stmt.setInt(7, NV.getNhanVien_ID());
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
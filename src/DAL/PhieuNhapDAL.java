package DAL;

import DTO.PhieuNhapDTO;
import java.sql.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Vector;

public class PhieuNhapDAL extends KetNoiCSDL{
	/*
    ============================================================
               			Thêm phiếu nhập   
    ============================================================
     */
	public boolean addPhieuNhap(PhieuNhapDTO PhieuNhap) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO PHIEUNHAP VALUES (?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,PhieuNhap.getPhieuNhap_IDNCC());
				stmt.setInt(2,PhieuNhap.getPhieuNhap_IDNV());
				stmt.setDate(3,PhieuNhap.getPhieuNhap_Date());
				stmt.setInt(4,0);	
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
               			Lấy phiếu nhập mới nhất   
    ============================================================
     */
	public int LayPhieuNhapMoiNhat(){
		if (openConnection()) {
			try{
				String sql = "SELECT MAX(MAPN) FROM PHIEUNHAP";
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					int id = rs.getInt(1);	
					return id;
				}
			}
			catch(Exception e){
				System.out.println(e);
			}
			finally{
				closeConnection();
			} 
		}
		return -1;
	}
					  /*
    ============================================================
               			Xoá phiếu nhập  
    ============================================================
     */
	public boolean deletePhieuNhap(int idPhieuNhap){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE PHIEUNHAP WHERE MAPN=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idPhieuNhap);
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
               			Cập nhật tổng tiền
    ============================================================
     */
	public boolean updateTongTien(int idPhieuNhap,int TongTien){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE PHIEUNHAP SET TONGTIEN = ? WHERE MAPN= ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,TongTien);
				stmt.setInt(2, idPhieuNhap);
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
               			Lấy danh sách phiếu nhập   
    ============================================================
     */
	public Vector<PhieuNhapDTO> LayDSPhieuNhap(){
		Vector<PhieuNhapDTO> arr = new Vector<PhieuNhapDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM PHIEUNHAP";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				PhieuNhapDTO PN = new PhieuNhapDTO();
				PN.setPhieuNhap_ID(rs.getInt("MAPN"));
				PN.setPhieuNhap_IDNCC(rs.getInt("MANCC"));
				PN.setPhieuNhap_IDNV(rs.getInt("MANV"));
				PN.setPhieuNhap_Date(rs.getDate("NGPN"));
				PN.setPhieuNhap_Total(rs.getInt("TONGTIEN"));
				arr.add(PN);
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
               		Lấy danh sách phiếu nhập theo ngày   
    ============================================================
     */
	public Vector<PhieuNhapDTO> LayDSPhieuNhapTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		Vector<PhieuNhapDTO> arr = new Vector<PhieuNhapDTO>();
		if (openConnection()) {
			try {
				String sql = ("SELECT * FROM PHIEUNHAP WHERE NGPN BETWEEN ? AND ?");
				PreparedStatement statement = con.prepareStatement(sql);
				statement.setDate(1, dateFrom);
				statement.setDate(2, dateTo);
				ResultSet rs = statement.executeQuery();
				while(rs.next()){
					PhieuNhapDTO PN = new PhieuNhapDTO();
					PN.setPhieuNhap_ID(rs.getInt("MAPN"));
					PN.setPhieuNhap_IDNCC(rs.getInt("MANCC"));
					PN.setPhieuNhap_IDNV(rs.getInt("MANV"));
					PN.setPhieuNhap_Date(rs.getDate("NGPN"));
					PN.setPhieuNhap_Total(rs.getInt("TONGTIEN"));
					arr.add(PN);
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
             	Lấy doanh thu phiếu nhập theo tháng
    ============================================================
     */
    public double getDoanhThuThang(int thang, int nam) {
		if (openConnection()) {
	        try {
	            String thangBD = nam + "-" + thang + "-01";
	            String thangKT = nam + "-" + (thang + 1) + "-01";
	            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	            Date parsed = format.parse(thangBD);
	            java.sql.Date dateFrom = new java.sql.Date(parsed.getTime());
	            Date parsed2 = format.parse(thangKT);
	            java.sql.Date dateTo = new java.sql.Date(parsed2.getTime());
	            String sql = ("SELECT SUM(TONGTIEN) FROM PHIEUNHAP WHERE NGPN BETWEEN ? AND ?");
	            PreparedStatement pre = con.prepareStatement(sql);
	            pre.setDate(1, dateFrom);
	            pre.setDate(2, dateTo);
	            ResultSet rs = pre.executeQuery();
	            while (rs.next()) {
	                return Double.parseDouble(rs.getInt(1) + "");
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
        return -1;
	}
}

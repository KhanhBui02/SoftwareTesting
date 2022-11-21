package DAL;

import DTO.HoaDonBanDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;


public class HoaDonBanDAL extends KetNoiCSDL{
			  /*
    ============================================================
                     Thêm hoá đơn bán         
    ============================================================
     */
public boolean addHoaDon(HoaDonBanDTO HoaDon) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO HOADONBAN VALUES (?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,HoaDon.getHoaDonBan_IDKH());
				stmt.setInt(2,HoaDon.getHoaDonBan_IDNV());
				stmt.setDate(3,HoaDon.getHoaDonBan_DateHD());
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
                     Lấy hoá đơn bán mới nhất       
    ============================================================
     */
	public int LayHoaDonMoiNhat(){
		if (openConnection()) {
			try{
				String sql = "SELECT MAX(MAHDB) FROM HOADONBAN";
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
                     Xoá hoá đơn bán        
    ============================================================
     */
	public boolean deleteHoaDonBan(int idHoaDonBan){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE HOADONBAN WHERE MAHDB=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idHoaDonBan);
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
	public boolean updateTongTien(int idHoaDonBan,int TongTien){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE HOADONBAN SET TONGTIEN = ? WHERE MAHDB= ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,TongTien);
				stmt.setInt(2, idHoaDonBan);
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
                  Lấy danh sách hoá đơn bán       
    ============================================================
     */
	public Vector<HoaDonBanDTO> LayDSHoaDonBan(){
		Vector<HoaDonBanDTO> arr = new Vector<HoaDonBanDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM HOADONBAN";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				HoaDonBanDTO HDB = new HoaDonBanDTO();
				HDB.setHoaDonBan_ID(rs.getInt("MAHDB"));
				HDB.setHoaDonBan_IDKH(rs.getInt("MAKH"));
				HDB.setHoaDonBan_IDNV(rs.getInt("MANV"));
				HDB.setHoaDonBan_DateHD(rs.getDate("NGHDB"));
				HDB.setHoaDonBan_Total(rs.getInt("TONGTIEN"));
				arr.add(HDB);
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
                    Lấy danh sách hoá đơn bán theo ngày        
    ============================================================
     */
	public Vector<HoaDonBanDTO> LayDSHoaDonBanTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		Vector<HoaDonBanDTO> arr = new Vector<HoaDonBanDTO>();
		if (openConnection()) {
			try {
				String sql = ("SELECT * FROM HOADONBAN WHERE NGHDB BETWEEN ? AND ?");
				PreparedStatement statement = con.prepareStatement(sql);
					statement.setDate(1, dateFrom);
					statement.setDate(2, dateTo);
					ResultSet rs = statement.executeQuery();
				while(rs.next()){
					HoaDonBanDTO HDB = new HoaDonBanDTO();
					HDB.setHoaDonBan_ID(rs.getInt("MAHDB"));
					HDB.setHoaDonBan_IDKH(rs.getInt("MAKH"));
					HDB.setHoaDonBan_IDNV(rs.getInt("MANV"));
					HDB.setHoaDonBan_DateHD(rs.getDate("NGHDB"));
					HDB.setHoaDonBan_Total(rs.getInt("TONGTIEN"));
					arr.add(HDB);
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
                     Lấy doanh thu hoá đơn bán theo tháng         
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
	            String sql = ("SELECT SUM(TONGTIEN) FROM HOADONBAN WHERE NGHDB BETWEEN ? AND ?");
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
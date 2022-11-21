package DAL;

import DTO.HoaDonDichVuDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

public class HoaDonDichVuDAL extends KetNoiCSDL{
			  /*
    ============================================================
                     Thêm hoá đơn dịch vụ        
    ============================================================
     */
public boolean addHoaDonDichVu(HoaDonDichVuDTO HoaDonDichVu) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO HOADONDICHVU VALUES (?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,HoaDonDichVu.getHoaDonDichVu_IDKH());
				stmt.setInt(2,HoaDonDichVu.getHoaDonDichVu_IDNV());
				stmt.setDate(3,HoaDonDichVu.getHoaDonDichVu_DateHD());
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
                     Lấy hoá đơn dịch vụ mới nhất      
    ============================================================
     */
	public int LayHoaDonMoiNhat(){
		if (openConnection()) {
			try{
				String sql = "SELECT MAX(MAHDDV) FROM HOADONDICHVU";
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
                     Xoá hoá đơn dịch vụ        
    ============================================================
     */
	public boolean deleteHoaDonDichVu(int idHoaDonDichVu){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE HOADONDICHVU WHERE MAHDDV=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idHoaDonDichVu);
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
                     Cập nhật tổng tiền hoá đơn dịch vụ       
    ============================================================
     */
	public boolean updateTongTien(int idHoaDonDichVu,int TongTien){
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE HOADONDICHVU SET TONGTIEN = ? WHERE MAHDDV= ?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,TongTien);
				stmt.setInt(2, idHoaDonDichVu);
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
                     Lấy danh sách hoá đơn dịch vụ        
    ============================================================
     */
	public Vector<HoaDonDichVuDTO> LayDSHoaDonDichVu(){
		Vector<HoaDonDichVuDTO> arr = new Vector<HoaDonDichVuDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM HOADONDICHVU";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				HoaDonDichVuDTO HDDV = new HoaDonDichVuDTO();
				HDDV.setHoaDonDichVu_ID(rs.getInt("MAHDDV"));
				HDDV.setHoaDonDichVu_IDKH(rs.getInt("MAKH"));
				HDDV.setHoaDonDichVu_IDNV(rs.getInt("MANV"));
				HDDV.setHoaDonDichVu_NGLHD(rs.getDate("NGHDDV"));
				HDDV.setHoaDonDichVu_Total(rs.getInt("TONGTIEN"));
				arr.add(HDDV);
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
                    Lấy danh sách hoá đơn dịch vụ theo ngày       
    ============================================================
     */
	public Vector<HoaDonDichVuDTO> LayDSHoaDonDichVuTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		Vector<HoaDonDichVuDTO> arr = new Vector<HoaDonDichVuDTO>();
		if (openConnection()) {
			try {
				String sql = ("SELECT * FROM HoaDonDichVu WHERE NGHDDV between ? and ?");
				PreparedStatement statement = con.prepareStatement(sql);
					statement.setDate(1, dateFrom);
					statement.setDate(2, dateTo);
					ResultSet rs = statement.executeQuery();
				while(rs.next()){
					HoaDonDichVuDTO HDDV = new HoaDonDichVuDTO();
					HDDV.setHoaDonDichVu_ID(rs.getInt("MAHDDV"));
					HDDV.setHoaDonDichVu_IDKH(rs.getInt("MAKH"));
					HDDV.setHoaDonDichVu_IDNV(rs.getInt("MANV"));
					HDDV.setHoaDonDichVu_NGLHD(rs.getDate("NGHDDV"));
					HDDV.setHoaDonDichVu_Total(rs.getInt("TONGTIEN"));
					arr.add(HDDV);
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
                 Lấy doanh thu hoá đơn dịch vụ theo tháng        
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
	            String sql = ("SELECT SUM(TONGTIEN) FROM HOADONDICHVU WHERE NGHDDV BETWEEN ? AND ?");
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

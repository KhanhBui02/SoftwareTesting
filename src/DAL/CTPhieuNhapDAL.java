package DAL;

import DTO.CTPhieuNhapDTO;
import java.sql.*;
import java.util.Vector;

public class CTPhieuNhapDAL extends KetNoiCSDL{
			  /*
    ============================================================
                    Lấy chi tiết phiếu nhập theo mã phiếu nhập       
    ============================================================
     */
	public Vector<CTPhieuNhapDTO> LayCTPNTheoMaPN(int MAPN){
		Vector<CTPhieuNhapDTO> arr = new Vector<CTPhieuNhapDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM CTPN WHERE MAPN="+MAPN;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					CTPhieuNhapDTO CTPN = new CTPhieuNhapDTO();
					CTPN.setCTPhieuNhap_ID(rs.getInt("MAPN"));
					CTPN.setCTPhieuNhap_IDSP(rs.getString("MASP"));
					CTPN.setCTPhieuNhap_Amount(rs.getInt("SOLUONG"));
					CTPN.setCTPhieuNhap_Price(rs.getInt("DONGIA"));
					CTPN.setCTPhieuNhap_Total(rs.getInt("THANHTIEN"));
					arr.add(CTPN);
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
                     Thêm chi tiết phiếu nhập         
    ============================================================
     */
	public boolean addCTPN(CTPhieuNhapDTO CTPN) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO CTPN VALUES(?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, CTPN.getCTPhieuNhap_ID());
				stmt.setString(2, CTPN.getCTPhieuNhap_IDSP());
				stmt.setInt(3, CTPN.getCTPhieuNhap_Amount());
				stmt.setInt(4, CTPN.getCTPhieuNhap_Price());
				stmt.setInt(5, CTPN.getCTPhieuNhap_Total());
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
                     Xoá phiếu nhập         
    ============================================================
     */
	public boolean deleteCTPN (int idpn, String idsp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE CTPN WHERE MAPN=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idpn);
				stmt.setString(2, idsp);
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
        Lấy số lượng sản phẩm trùng trong chi tiết phiếu nhập       
    ============================================================
     */
	public int laySLSPTrung(int MAPN,String MASP) {
		if (openConnection()) {
			try {
				String sql = "SELECT SOLUONG FROM CTPN WHERE MAPN=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, MAPN);
				stmt.setString(2, MASP);
				ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("SOLUONG");
	            }
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection(); 
			} }
		return -1;
	}
			  /*
    ============================================================
                Cập nhật số lượng sản phẩm trong phiếu nhập        
    ============================================================
     */
	public boolean updateSLCTPN (int MAPN,String MASP,int SL,int THANHTIEN) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE CTPN SET SOLUONG=?, THANHTIEN=? WHERE MAPN=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,SL);
				stmt.setInt(2, THANHTIEN);
				stmt.setInt(3,MAPN);
				stmt.setString(4, MASP);
			if (stmt.executeUpdate()>=1)
				result = true;
			} catch (SQLException ex) {
				System.out.println(ex);
			} finally{
				closeConnection(); 
			} }
		return result;
	}
}
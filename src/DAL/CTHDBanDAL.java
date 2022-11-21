package DAL;

import DTO.CTHDBanDTO;
import java.sql.*;
import java.util.Vector;

public class CTHDBanDAL extends KetNoiCSDL{
			  /*
    ============================================================
                     Lấy danh sách chi tiết hoá đơn bán         
    ============================================================
     */
	public Vector<CTHDBanDTO> LayCTHDTheoMaHDB(int MAHDB){
		Vector<CTHDBanDTO> arr = new Vector<CTHDBanDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM CTHDBAN WHERE MAHDB="+MAHDB;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					CTHDBanDTO CTHDB = new CTHDBanDTO();
					CTHDB.setCTHDBan_ID(rs.getInt("MAHDB"));
					CTHDB.setCTHDBan_IDSP(rs.getString("MASP"));
					CTHDB.setCTHDBan_Amount(rs.getInt("SOLUONG"));
					CTHDB.setCTHDBan_Price(rs.getInt("DONGIA"));
					CTHDB.setCTHDBan_TotalPrice(rs.getInt("THANHTIEN"));
					arr.add(CTHDB);
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
                     Thêm chi tiết hoá đơn bán         
    ============================================================
     */
	public boolean addCTHDBan(CTHDBanDTO CTHD) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO CTHDBAN VALUES(?,?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, CTHD.getCTHDBan_ID());
				stmt.setString(2, CTHD.getCTHDBan_IDSP());
				stmt.setInt(3, CTHD.getCTHDBan_Amount());
				stmt.setInt(4, CTHD.getCTHDBan_Price());
				stmt.setInt(5, CTHD.getCTHDBan_TotalPrice());
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
                     Xoá chi tiết hoá đơn bán         
    ============================================================
     */
	public boolean deleteCTHDBan (int idhdb, String idsp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE CTHDBAN WHERE MAHDB=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idhdb);
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
                     Lấy số lượng sản phẩm trùng         
    ============================================================
     */
	public int laySLSPTrung(int MAHDB,String MASP) {
		if (openConnection()) {
			try {
				String sql = "SELECT SOLUONG FROM CTHDBAN WHERE MAHDB=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, MAHDB);
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
             Cập nhật số lượng trong chi tiết hoá đơn bán         
    ============================================================
     */
	public boolean updateSLCTHDBan (int MAHDB,String MASP,int SL,int THANHTIEN) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE CTHDBAN SET SOLUONG=?, THANHTIEN=? WHERE MAHDB=? AND MASP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1,SL);
				stmt.setInt(2, THANHTIEN);
				stmt.setInt(3,MAHDB);
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

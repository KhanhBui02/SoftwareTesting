package DAL;
import DTO.CTHDDichVuDTO;
import java.sql.*;
import java.util.Vector;

public class CTHDDichVuDAL extends KetNoiCSDL{
			  /*
    ============================================================
        Lấy danh sách chi tiết hoá đơn theo mã hoá đơn dịch vụ       
    ============================================================
     */
	public Vector<CTHDDichVuDTO> LayCTHDTheoMaHDDV(int MAHDDV){
		Vector<CTHDDichVuDTO> arr = new Vector<CTHDDichVuDTO>();
		if (openConnection()) {
			try {
				String sql = "SELECT * FROM CTHDDV WHERE MAHDDV	="+MAHDDV;
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					CTHDDichVuDTO CTHDDV = new CTHDDichVuDTO();
					CTHDDV.setCTHDDichVu_ID(rs.getInt("MAHDDV"));
					CTHDDV.setCTHDDichVu_IDDV(rs.getInt("MADV"));
					CTHDDV.setCTHDDichVu_TenSP(rs.getString("TENSP"));
					CTHDDV.setCTHDDichVu_Price(rs.getInt("GIA"));
					arr.add(CTHDDV);
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
                     Thêm chi tiết hoá đơn dịch vụ        
    ============================================================
     */
	public boolean addCTHDDichVu(CTHDDichVuDTO CTHDDV) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "INSERT INTO CTHDDV VALUES(?,?,?,?)";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, CTHDDV.getCTHDDichVu_ID());
				stmt.setInt(2, CTHDDV.getCTHDDichVu_IDDV());
				stmt.setString(3, CTHDDV.getCTHDDichVu_TenSP());
				stmt.setInt(4, CTHDDV.getCTHDDichVu_Price());
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
                     Xoá chi tiết hoá đơn dịch vụ         
    ============================================================
     */
	public boolean deleteCTHDDichVu (int idhddv, String tensp, int iddv) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "DELETE CTHDDV WHERE MAHDDV=? AND TENSP=? AND MADV =?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idhddv);
				stmt.setString(2, tensp);
				stmt.setInt(3, iddv);
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
            Lấy giá tiền dịch vụ trong chi tiết hoá đơn bán        
    ============================================================
     */
	public int layGiaDVTrung (int idhddv, int iddv, String tensp) {
		if (openConnection()) {
			try {
				String sql = "SELECT GIA FROM CTHDDV WHERE MAHDDV=? AND MADV=? AND TENSP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, idhddv);
				stmt.setInt(2, iddv);
				stmt.setString(3, tensp);
				ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                return rs.getInt("GIA");
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
                     Cập nhật giá theo chi tiết hoá đơn bán        
    ============================================================
     */
	public boolean updateGiaCTHDDV (int gia, int idhddv, int iddv, String tensp) {
		boolean result = false;
		if (openConnection()) {
			try {
				String sql = "UPDATE CTHDDV SET GIA=? WHERE MAHDDV=? AND MADV=? AND TENSP=?";
				PreparedStatement stmt = con.prepareStatement(sql);
				stmt.setInt(1, gia);
				stmt.setInt(2, idhddv);
				stmt.setInt(3, iddv);
				stmt.setString(4, tensp);
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

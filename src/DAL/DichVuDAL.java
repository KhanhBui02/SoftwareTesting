package DAL;
import DTO.DichVuDTO;
import java.sql.*;
import java.util.*;
public class DichVuDAL extends KetNoiCSDL{
			  /*
    ============================================================
                     Lấy danh sách dịch vụ        
    ============================================================
     */
	public ArrayList<DichVuDTO> LayDSDichVu(){
		ArrayList<DichVuDTO> arr = new ArrayList<DichVuDTO>();
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM DICHVU";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				DichVuDTO DichVu = new DichVuDTO();
				DichVu.setDichVu_ID(rs.getString("MADV"));
				DichVu.setDichVu_Name(rs.getString("TENDV"));
				arr.add(DichVu);
				}
			return arr;
			}
		catch(Exception e){
			System.out.println(e);
		}
		finally{
			closeConnection();
		} }
		return null;
	}
}

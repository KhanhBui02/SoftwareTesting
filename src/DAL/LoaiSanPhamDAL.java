package DAL;

import DTO.LoaiSanPhamDTO;
import java.util.ArrayList;
import java.sql.*;

public class LoaiSanPhamDAL extends KetNoiCSDL{
			  /*
    ============================================================
                   Lấy danh sách loại sản phẩm       
    ============================================================
     */
	public ArrayList<LoaiSanPhamDTO> LayDSLoaiSanPham(){
		if (openConnection()) {
		try{
			String sql = "SELECT * FROM LOAISANPHAM";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			ArrayList<LoaiSanPhamDTO> arr = new ArrayList<>();
			while(rs.next()){
				LoaiSanPhamDTO LoaiSanPham = new LoaiSanPhamDTO();
				LoaiSanPham.setLoaiSanPham_ID(rs.getInt("MALOAISP"));
				LoaiSanPham.setLoaiSanPham_Name(rs.getString("LOAISP"));
				arr.add(LoaiSanPham);
			}
			return arr;
		} catch(Exception e){
			System.out.println(e);
		} finally{
			closeConnection();
		} }
		return null;
	}
}

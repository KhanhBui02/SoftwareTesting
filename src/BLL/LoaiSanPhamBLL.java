package BLL;

import DAL.LoaiSanPhamDAL;
import DTO.LoaiSanPhamDTO;
import java.util.*;

public class LoaiSanPhamBLL {
	
	LoaiSanPhamDAL LoaiSanPhamDAL = new LoaiSanPhamDAL();
	ArrayList<LoaiSanPhamDTO> listLoai = null;
	
			  /*
    ============================================================
                     Lấy danh sách loại sản phẩm         
    ============================================================
     */
	public ArrayList<LoaiSanPhamDTO> LayDSLoaiSanPham(){
		return listLoai = LoaiSanPhamDAL.LayDSLoaiSanPham();
	}
			  /*
    ============================================================
                     Lấy tên loại sản phẩm         
    ============================================================
     */
    public String getTenLoai(int ma) {
        for (LoaiSanPhamDTO loai : listLoai) {
            if (loai.getLoaiSanPham_ID() == ma) {
                return loai.getLoaiSanPham_ID() + " - " + loai.getLoaiSanPham_Name();
            }
        }
        return "";
    }
}

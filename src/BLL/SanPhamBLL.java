package BLL;

import DAL.SanPhamDAL;
import DTO.SanPhamDTO;
import java.util.Vector;

public class SanPhamBLL {
	SanPhamDAL SPDAL = new SanPhamDAL();
			  /*
    ============================================================
                     Lấy danh sách sản phẩm         
    ============================================================
     */
	public Vector<SanPhamDTO> LayDSSanPham(){
		return SPDAL.LayDSSanPham();
	}
			  /*
    ============================================================
                     Lấy danh sách sản phẩm theo loại         
    ============================================================
     */
	public Vector<SanPhamDTO> LayDSSanPhamTheoLoai(int Loai){
		return SPDAL.LayDSSanPhamTheoLoai(Loai);
	}
			  /*
    ============================================================
                     Lấy danh sách sản phẩm theo tên         
    ============================================================
     */
	public Vector<SanPhamDTO> LayDSSanPhamTheoTen(String Ten){
		return SPDAL.LayDSSanPhamTheoTen(Ten);
	}
			  /*
    ============================================================
                     Thêm sản phẩm         
    ============================================================
     */
	public String addSanPham(SanPhamDTO SP) {
		if (SPDAL.hasSanPham_ID(SP.getSanPham_ID()))
			return "Mã Sản Phẩm đã tồn tại";
		if (SPDAL.addSanPham(SP))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
			  /*
    ============================================================
                    Xoá sản phẩm        
    ============================================================
     */
	public String deleteSanPham(SanPhamDTO SP){
		if(SPDAL.deleteSanPham(SP))
			return "Xóa thành công";
		return "Xóa thất bại do dữ liệu đang được sử dụng";	
	}
			  /*
    ============================================================
                     Sửa sản phẩm         
    ============================================================
     */
	public String editSanPham(SanPhamDTO SP){
		if (SPDAL.hasSanPham_ID(SP.getSanPham_ID())==false)
			return "Mã Sản Phẩm không tồn tại";
		if(SPDAL.editSanPham(SP))
			return "Sửa thành công";
		return "Sửa thất bại";	
	}
			  /*
    ============================================================
                     Cập nhật số lượng sản phẩm        
    ============================================================
     */
	public boolean UpdateSLSanPham(String MaSP,int TonKhoMoi) {
		if (SPDAL.UpdateSLSanPham(MaSP, TonKhoMoi))
			return true;
		return false;
	}
			  /*
    ============================================================
                    Lấy số lượng sản phẩm theo mã sản phẩm         
    ============================================================
     */
	public int LaySLSPTheoMaSP(String MaSP) {
		return SPDAL.LaySLSPTheoMaSP(MaSP);
	}
}
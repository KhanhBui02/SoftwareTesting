package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.Vector;

public class KhachHangBLL {
	KhachHangDAL KHDAL = new KhachHangDAL();
    /*
    ============================================================
                      Lấy danh sách khách hàng           
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHang(){
		return KHDAL.LayDSKhachHang();
	}
    /*
    ============================================================
                      Kiểm tra SĐT trong danh sách khách hàng           
    ============================================================
     */
	public Boolean hasKhachHang_PhoneNumber(int SDT) {
		if (KHDAL.hasKhachHang_PhoneNumber(SDT))
			return true;
		return false;
	}
    /*
    ============================================================
                      Lấy danh sách khách hàng theo SĐT          
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHangTheoSDT(int SDT){
		return KHDAL.LayDSKhachHangTheoSDT(SDT);
	}
    /*
    ============================================================
                      Lấy danh sách khách hàng theo Tên          
    ============================================================
     */
	public Vector<KhachHangDTO> LayDSKhachHangTheoTen(String Ten){
		return KHDAL.LayDSKhachHangTheoTen(Ten);
	}
    /*
    ============================================================
                      Thêm khách hàng           
    ============================================================
     */
	public String addKhachHang(KhachHangDTO KH) {
		if (KHDAL.hasKhachHang_ID(KH.getKhachHang_ID()))
			return "Mã khách hàng đã tồn tại";
		if (KHDAL.addKhachHang(KH))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
    /*
    ============================================================
                      Sửa khách hàng           
    ============================================================
     */
	public String editKhachHang(KhachHangDTO KH){
        if(KHDAL.editKhachHang(KH))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    /*
    ============================================================
                      Xóa khách hàng           
    ============================================================
     */
	public String deleteKhachHang (KhachHangDTO KH) {
		if (KHDAL.deleteKhachHang(KH))
			return "Xóa thành công";
		return "Xóa thất bại do dữ liệu đang được sử dụng";
	}
}

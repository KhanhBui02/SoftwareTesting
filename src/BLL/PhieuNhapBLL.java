package BLL;

import DTO.PhieuNhapDTO;
import DAL.PhieuNhapDAL;
import java.util.Vector;

public class PhieuNhapBLL {
	PhieuNhapDAL PNDAL = new PhieuNhapDAL();
	
			  /*
    ============================================================
                     Thêm phiếu nhập         
    ============================================================
     */
	public String addPhieuNhap(PhieuNhapDTO PhieuNhap) {
		if (PNDAL.addPhieuNhap(PhieuNhap))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
			  /*
    ============================================================
                     Xoá phiếu nhập         
    ============================================================
     */
	public String deletePhieuNhap() {
		int idPhieuNhap = PNDAL.LayPhieuNhapMoiNhat();
		if(PNDAL.deletePhieuNhap(idPhieuNhap))
			return "Xóa thành công";
		return "Xóa thất bại";	
	}
			  /*
    ============================================================
                     Lấy phiếu nhập mới nhất         
    ============================================================
     */
	public int LayPhieuNhapMoiNhat() {
		return PNDAL.LayPhieuNhapMoiNhat();
	}
			  /*
    ============================================================
                     Thanh toán phiếu nhập         
    ============================================================
     */
	public String ThanhToan(int TongTien){
		int idPhieuNhap = PNDAL.LayPhieuNhapMoiNhat();
		if(PNDAL.updateTongTien(idPhieuNhap, TongTien))
			return "Thanh toán thành công";
		return "Thanh toán thất bại";	
	}
			  /*
    ============================================================
                     Lấy danh sách phiếu nhập         
    ============================================================
     */
	public Vector<PhieuNhapDTO> LayDSPhieuNhap(){
		return PNDAL.LayDSPhieuNhap();
	}
			  /*
    ============================================================
                     Lấy danh sách phiếu nhập theo ngày         
    ============================================================
     */
	public Vector<PhieuNhapDTO> LayDSPhieuNhapTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		return PNDAL.LayDSPhieuNhapTheoNgay(dateFrom,dateTo);
	}
			  /*
    ============================================================
                     Lấy báo cáo doanh thu phiếu nhập         
    ============================================================
     */
    public double getDoanhThuThang(int thang, int nam) {
        return PNDAL.getDoanhThuThang(thang, nam);
    }
}

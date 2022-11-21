package BLL;

import DAL.HoaDonDichVuDAL;
import DTO.HoaDonDichVuDTO;
import java.util.Vector;

public class HoaDonDichVuBLL {
	HoaDonDichVuDAL HoaDonDichVuDAL = new HoaDonDichVuDAL();
			  /*
    ============================================================
                     Thêm hoá đơn dịch vụ        
    ============================================================
     */
	public String addHoaDon(HoaDonDichVuDTO HoaDon) {
		if (HoaDonDichVuDAL.addHoaDonDichVu(HoaDon))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
			  /*
    ============================================================
                     Xoá hoá đơn dịch vụ        
    ============================================================
     */
	public String deleteHoaDon() {
		int idHoaDon = HoaDonDichVuDAL.LayHoaDonMoiNhat();
		if(HoaDonDichVuDAL.deleteHoaDonDichVu(idHoaDon))
			return "Xóa thành công";
		return "Xóa thất bại";	
	}
			  /*
    ============================================================
                     Lấy hoá đơn dịch vụ mới nhất         
    ============================================================
     */
	public int LayHoaDonMoiNhat() {
		return HoaDonDichVuDAL.LayHoaDonMoiNhat();
	}
			  /*
    ============================================================
                     Thanh toán hoá đơn dịch vụ         
    ============================================================
     */
	public String ThanhToan(int TongTien){
		int idHoaDon = HoaDonDichVuDAL.LayHoaDonMoiNhat();
		if(HoaDonDichVuDAL.updateTongTien(idHoaDon, TongTien))
			return "Thanh toán thành công";
		return "Thanh toán thất bại";
	}
			  /*
    ============================================================
                    Lấy danh sách hoá đơn dịch vụ         
    ============================================================
     */
	public Vector<HoaDonDichVuDTO> LayDSHoaDonDichVu(){
		return HoaDonDichVuDAL.LayDSHoaDonDichVu();
	}
			  /*
    ============================================================
                     Lấy danh sách hoá đơn dịch vụ theo ngày         
    ============================================================
     */
	public Vector<HoaDonDichVuDTO> LayDSHoaDonDichVuTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		return HoaDonDichVuDAL.LayDSHoaDonDichVuTheoNgay(dateFrom,dateTo);
	}
			  /*
    ============================================================
                     Lấy doanh thu dịch vụ theo tháng        
    ============================================================
     */
    public double getDoanhThuThang(int thang, int nam) {
        return HoaDonDichVuDAL.getDoanhThuThang(thang, nam);
    }
}

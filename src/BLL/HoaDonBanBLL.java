package BLL;

import DAL.HoaDonBanDAL;
import DTO.HoaDonBanDTO;
import java.util.Vector;

public class HoaDonBanBLL {
	HoaDonBanDAL HoaDonBanDAL = new HoaDonBanDAL();
		  /*
    ============================================================
                     Thêm hoá đơn bán        
    ============================================================
     */
	public String addHoaDon(HoaDonBanDTO HoaDon) {
		if (HoaDonBanDAL.addHoaDon(HoaDon))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
			  /*
    ============================================================
                     Xoá hoá đơn bán        
    ============================================================
     */
	public String deleteHoaDon() {
		int idHoaDon = HoaDonBanDAL.LayHoaDonMoiNhat();
		if(HoaDonBanDAL.deleteHoaDonBan(idHoaDon))
			return "Xóa thành công";
		return "Xóa thất bại";	
	}
			  /*
    ============================================================
                     Lấy hoá đơn bán mới nhất         
    ============================================================
     */
	public int LayHoaDonMoiNhat() {
		return HoaDonBanDAL.LayHoaDonMoiNhat();
	}
			  /*
    ============================================================
                     Thanh toán hoá đơn bán         
    ============================================================
     */
	public String ThanhToan(int TongTien){
		int idHoaDon = HoaDonBanDAL.LayHoaDonMoiNhat();
		if(HoaDonBanDAL.updateTongTien(idHoaDon, TongTien))
			return "Thanh toán thành công";
		return "Thanh toán thất bại";	
	}
			  /*
    ============================================================
                     Lấy danh sách hoá đơn bán         
    ============================================================
     */
	public Vector<HoaDonBanDTO> LayDSHoaDonBan(){
		return HoaDonBanDAL.LayDSHoaDonBan();
	}
			  /*
    ============================================================
                     Lấy danh sách hoá đơn bán theo ngày         
    ============================================================
     */
	public Vector<HoaDonBanDTO> LayDSHoaDonBanTheoNgay(java.sql.Date dateFrom, java.sql.Date dateTo){
		return HoaDonBanDAL.LayDSHoaDonBanTheoNgay(dateFrom,dateTo);
	}
			  /*
    ============================================================
                     Lấy doanh thu hoá đơn bán theo tháng         
    ============================================================
     */
    public double getDoanhThuThang(int thang, int nam) {
        return HoaDonBanDAL.getDoanhThuThang(thang, nam);
    }
}

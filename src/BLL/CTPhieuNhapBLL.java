package BLL;

import DAL.CTPhieuNhapDAL;
import DTO.CTPhieuNhapDTO;
import java.util.Vector;

public class CTPhieuNhapBLL {
	CTPhieuNhapDAL CTPNDAL = new CTPhieuNhapDAL();
		  /*
    ============================================================
               Lấy chi tiết phiếu nhập theo mã phiếu nhập         
    ============================================================
     */
	public Vector<CTPhieuNhapDTO> LayCTPNTheoMaPN(int idpn){
		return CTPNDAL.LayCTPNTheoMaPN(idpn);
	}
		  /*
    ============================================================
                     Thêm vào chi tiết phiếu nhập         
    ============================================================
     */
	public boolean addCTPN(CTPhieuNhapDTO CTPN) {
		if (CTPNDAL.addCTPN(CTPN))
			return true;
		return false;
	}
		  /*
    ============================================================
                     Xoá chi tiết phiếu nhập         
    ============================================================
     */
	public String deleteCTPN(int idpn, String idsp) {
		if (CTPNDAL.deleteCTPN(idpn,idsp))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
		  /*
    ============================================================
                     Kiểm tra chi tiết phiếu nhập         
    ============================================================
     */
	public boolean kiemtraCTPN(CTPhieuNhapDTO CTPN) {
		if (CTPNDAL.laySLSPTrung(CTPN.getCTPhieuNhap_ID(), CTPN.getCTPhieuNhap_IDSP())!=-1) {
			int SL = CTPNDAL.laySLSPTrung(CTPN.getCTPhieuNhap_ID(), CTPN.getCTPhieuNhap_IDSP());
			int SLMoi = CTPN.getCTPhieuNhap_Amount();
			int TongSL = SL + SLMoi;
			int DonGia = CTPN.getCTPhieuNhap_Price();
			int ThanhTien = TongSL * DonGia;
			CTPNDAL.updateSLCTPN(CTPN.getCTPhieuNhap_ID(),CTPN.getCTPhieuNhap_IDSP(),TongSL,ThanhTien);
			return false;
		}
		return true;
	}
}

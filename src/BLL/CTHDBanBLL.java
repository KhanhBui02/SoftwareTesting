package BLL;

import DAL.CTHDBanDAL;
import DTO.CTHDBanDTO;
import java.util.Vector;

public class CTHDBanBLL {
	CTHDBanDAL CTHDBDAL = new CTHDBanDAL();
	
	    /*
    ============================================================
               Lấy chi tiết hoá đơn bán theo mã hoá đơn bán        
    ============================================================
     */
	public Vector<CTHDBanDTO> LayCTHDTheoMAHDB(int MAHDB){
		return CTHDBDAL.LayCTHDTheoMaHDB(MAHDB);
	}
	
		    /*
    ============================================================
                     Thêm vào chi tiết hoá đơn bán       
    ============================================================
     */
	
	public boolean addCTHDBan(CTHDBanDTO CTHD) {
		if (CTHDBDAL.addCTHDBan(CTHD))
			return true;
		return false;
	}
	
			    /*
    ============================================================
                     Xoá chi tiết hoá đơn bán         
    ============================================================
     */
	public String deleteCTHDBan(int idhdb, String idsp) {
		if (CTHDBDAL.deleteCTHDBan(idhdb,idsp))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
	
	  /*
    ============================================================
                     Kiểm tra chi tiết hoá đơn bán          
    ============================================================
     */
	public boolean kiemtraCTHDBan(CTHDBanDTO CTHD) {
		if (CTHDBDAL.laySLSPTrung(CTHD.getCTHDBan_ID(), CTHD.getCTHDBan_IDSP())!=-1) {
			int SL = CTHDBDAL.laySLSPTrung(CTHD.getCTHDBan_ID(), CTHD.getCTHDBan_IDSP());
			int SLMoi = CTHD.getCTHDBan_Amount();
			int TongSL = SL + SLMoi;
			int DonGia = CTHD.getCTHDBan_Price();
			int ThanhTien = TongSL * DonGia;
			CTHDBDAL.updateSLCTHDBan(CTHD.getCTHDBan_ID(), CTHD.getCTHDBan_IDSP(),TongSL,ThanhTien);
			return false;
		}
		return true;
	}
}

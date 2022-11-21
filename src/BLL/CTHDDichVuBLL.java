package BLL;
import DAL.CTHDDichVuDAL;
import DTO.CTHDDichVuDTO;
import java.util.*;

public class CTHDDichVuBLL {
	CTHDDichVuDAL CTHDDVDAL = new CTHDDichVuDAL();
	  /*
    ============================================================
             Lấy chi tiết hoá đơn theo mã hoá đơn dịch vụ         
    ============================================================
     */
	public Vector<CTHDDichVuDTO> LayCTHDTheoMAHDDV(int MAHDDV){
		return CTHDDVDAL.LayCTHDTheoMaHDDV(MAHDDV);
	}
		  /*
    ============================================================
                     Thêm vào chi tiết hoá đơn dịch vụ         
    ============================================================
     */
	public boolean addCTHDDV(CTHDDichVuDTO CTHDDV) {
		if (CTHDDVDAL.addCTHDDichVu(CTHDDV))
			return true;
		return false;
	}
		  /*
    ============================================================
                     Xoá chi tiết hoá đơn dịch vụ         
    ============================================================
     */
	public String deleteCTHDDV(int idhddv, String tensp,int iddv) {
		if (CTHDDVDAL.deleteCTHDDichVu(idhddv,tensp,iddv))
			return "Xóa thành công";
		return "Xóa thất bại";
	}
		  /*
    ============================================================
                     Kiểm tra chi tiết hoá đơn dịch vụ         
    ============================================================
     */
	public boolean kiemtraCTHDDV(CTHDDichVuDTO CTHD) {
		if (CTHDDVDAL.layGiaDVTrung(CTHD.getCTHDDichVu_ID(), CTHD.getCTHDDichVu_IDDV(), CTHD.getCTHDDichVu_TenSP())!=-1) {
			int GiaCu = CTHDDVDAL.layGiaDVTrung(CTHD.getCTHDDichVu_ID(), CTHD.getCTHDDichVu_IDDV(), CTHD.getCTHDDichVu_TenSP());
			int GiaMoi = CTHD.getCTHDDichVu_Price();
			int Gia = GiaCu + GiaMoi;
			CTHDDVDAL.updateGiaCTHDDV(Gia ,CTHD.getCTHDDichVu_ID(), CTHD.getCTHDDichVu_IDDV(), CTHD.getCTHDDichVu_TenSP());
			return false;
		}
		return true;
	}
}

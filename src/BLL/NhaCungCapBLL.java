package BLL;

import DAL.NhaCungCapDAL;
import DTO.NhaCungCapDTO;
import java.util.Vector;

public class NhaCungCapBLL {
	NhaCungCapDAL NCCDAL = new NhaCungCapDAL();
    /*
    ============================================================
                      Lấy danh sách nhà cung cấp           
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCap(){
		return NCCDAL.LayDSNhaCungCap();
	}
    /*
    ============================================================
                      Kiểm tra SĐT trong danh sách nhà cung cấp           
    ============================================================
     */
	public Boolean hasNhaCungCap_PhoneNumber(int SDT) {
		if (NCCDAL.hasNhaCungCap_PhoneNumber(SDT))
			return true;
		return false;
	}
    /*
    ============================================================
                      Lấy danh sách nhà cung cấp theo SĐT          
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCapTheoSDT(int SDT){
		return NCCDAL.LayDSNhaCungCapTheoSDT(SDT);
	}
    /*
    ============================================================
                      Lấy danh sách nhà cung cấp theo Tên          
    ============================================================
     */
	public Vector<NhaCungCapDTO> LayDSNhaCungCapTheoTen(String Ten){
		return NCCDAL.LayDSNhaCungCapTheoTen(Ten);
	}
    /*
    ============================================================
                      Thêm nhà cung cấp           
    ============================================================
     */
	public String addNhaCungCap(NhaCungCapDTO NCC) {
		if (NCCDAL.hasNhaCungCap_ID(NCC.getNhaCungCap_ID()))
			return "Mã nhà cung cấp đã tồn tại";
		if (NCCDAL.addNhaCungCap(NCC))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
    /*
    ============================================================
                      Sửa nhà cung cấp           
    ============================================================
     */
	public String editNhaCungCap(NhaCungCapDTO NCC){
        if(NCCDAL.editNhaCungCap(NCC))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
    /*
    ============================================================
                      Xóa nhà cung cấp           
    ============================================================
     */
	public String deleteNhaCungCap(NhaCungCapDTO NCC) {
		if (NCCDAL.deleteNhaCungCap(NCC))
			return "Xóa thành công";
		return "Xóa thất bại do dữ liệu đang được sử dụng";
	}
}

package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.Vector;
import javax.swing.JOptionPane;

public class NhanVienBLL {
    /*
    ============================================================
                    Lấy toàn bộ danh sách nhân viên           
    ============================================================
     */
	NhanVienDAL NVDAL = new NhanVienDAL();
	
	public Vector<NhanVienDTO> LayDSNhanVien(){
		return NVDAL.LayDSNhanVien();
	}
    /*
    ============================================================
                    Lấy danh sách nhân viên theo Tên           
    ============================================================
     */
	public Vector<NhanVienDTO> LayDSNhanVienTheoTen(String Ten){
		return NVDAL.LayDSNhanVienTheoTen(Ten);
	}
    /*
    ============================================================
                    Lấy thông tin tài khoản đăng nhập           
    ============================================================
     */
    private final static int EMPTY_ERROR = 1;
    private final static int WRONG_ERROR = 2;
    public static NhanVienDTO UserLogin = null;

    public NhanVienDTO GetTaiKhoanDangNhap(String user, String password) {
        if (KiemTraDangNhap(user, password) == EMPTY_ERROR) {
        	JOptionPane.showMessageDialog(null, "Khônh được để trống thông tin");
        	return null;
        }
        NhanVienDTO User = new NhanVienDTO();
        User.setNhanVien_Username(user);
        User.setNhanVien_Password(password);

        NhanVienDAL NhanVienDAL = new NhanVienDAL();
        NhanVienDTO account = NhanVienDAL.DangNhap(User);
        UserLogin = account;

        if (account == null) {
        	JOptionPane.showMessageDialog(null, "Sai thông tin đăng nhập hoặc tài khoản không tồn tại");
        } else {
            JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
        }
        return account;
    }
    /*
    ============================================================
                      Kiểm tra dữ liệu đăng nhập           
    ============================================================
     */
    private int KiemTraDangNhap(String user, String password) {
        user = user.replaceAll("\\s+", "");
        password = password.replaceAll("\\s+", "");
        int result = 0;

        NhanVienDTO User = new NhanVienDTO();
        User.setNhanVien_Username(user);
        User.setNhanVien_Password(password);

        NhanVienDAL NhanVienDAL = new NhanVienDAL();
        NhanVienDTO account = NhanVienDAL.DangNhap(User);

        if (user.length() <= 0 || password.length() <= 0) {
            result = EMPTY_ERROR;
        } else if (account == null) {
            result = WRONG_ERROR;
        }
        return result;
    }
    /*
    ============================================================
                      Thêm nhân viên           
    ============================================================
     */
	public String addNhanVien(NhanVienDTO NV) {
		if (NVDAL.hasNhanVien_ID(NV.getNhanVien_ID()))
			return "Mã NV đã tồn tại";
		if (NVDAL.addNhanVien(NV))
			return "Thêm thành công";
		return "Thêm thất bại";
	}
    /*
    ============================================================
                      Sửa nhân viên           
    ============================================================
     */
	public String editNhanVien(NhanVienDTO NV){
        if(NVDAL.editNhanVien(NV))
            return "Sửa thành công";
        return "Sửa thất bại";
    }
	
    /*
    ============================================================
                      Xóa nhân viên           
    ============================================================
     */
	public String deleteNhanVien (NhanVienDTO NV) {
		if (NVDAL.deleteNhanVien(NV))
			return "Xóa thành công";
		return "Xóa thất bại do dữ liệu đang được sử dụng";
	}
}

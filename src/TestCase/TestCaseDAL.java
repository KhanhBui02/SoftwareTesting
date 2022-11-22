package TestCase;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.util.*;
import junit.framework.*;

class TestCaseDAL{

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử số điện thoại có thông tin khách hàng.
	void testLayDSKhachHangTheoSDT() {
		DAL.KhachHangDAL kh = new DAL.KhachHangDAL();
		String SDT = "0923768231";
		int sdt = Integer.parseInt(SDT);
		Vector<DTO.KhachHangDTO> khachhang = kh.LayDSKhachHangTheoSDT(sdt);
		Assert.assertEquals("Trà Nguyễn Hoàng Minh",khachhang.get(0).getKhachHang_Name());
		Assert.assertEquals("minhhoang@gmail.com",khachhang.get(0).getKhachHang_Email());
		Assert.assertEquals("Quận 8",khachhang.get(0).getKhachHang_Address());
		return;
	}

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử số điện thoại không có thông tin khách hàng.
	void testLayDSKhachHangTheoSDT2() {
		DAL.KhachHangDAL kh = new DAL.KhachHangDAL();
		String SDT = "0923768233";
		int sdt = Integer.parseInt(SDT);
		Vector<DTO.KhachHangDTO> khachhang = kh.LayDSKhachHangTheoSDT(sdt);
		Assert.assertNull(khachhang);
		return;
	}

	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên đầy đủ và có thông tin khách hàng đó trong hệ thống.
	void testLayDSKhachHangTheoTen() {
		DAL.KhachHangDAL kh = new DAL.KhachHangDAL();
		String Ten = "Trà Nguyễn Hoàng Minh";
		Vector<DTO.KhachHangDTO> khachhang = kh.LayDSKhachHangTheoTen(Ten);
		Assert.assertEquals("minhhoang@gmail.com",khachhang.get(0).getKhachHang_Email());
		Assert.assertEquals("Quận 8",khachhang.get(0).getKhachHang_Address());
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên không đầy đủ và có thông tin khách hàng đó trong hệ thống.
	void testLayDSKhachHangTheoTen2() {
		DAL.KhachHangDAL kh = new DAL.KhachHangDAL();
		String Ten = "Nguyễn Hoàng Minh";
		Vector<DTO.KhachHangDTO> khachhang = kh.LayDSKhachHangTheoTen(Ten);
		Assert.assertEquals("minhhoang@gmail.com",khachhang.get(0).getKhachHang_Email());
		Assert.assertEquals("Quận 8",khachhang.get(0).getKhachHang_Address());
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên không có thông tin khách hàng đó trong hệ thống.
	void testLayDSKhachHangTheoTen3() {
		DAL.KhachHangDAL kh = new DAL.KhachHangDAL();
		String Ten = "Huỳnh";
		Vector<DTO.KhachHangDTO> khachhang = kh.LayDSKhachHangTheoTen(Ten);
		Assert.assertNull(khachhang);
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên có thông tin nhân viên đó trong hệ thống
	void testLayDSNhanVienTheoTen() {
		DAL.NhanVienDAL nv = new DAL.NhanVienDAL();
		String Ten = "Hiếu";
		Vector<DTO.NhanVienDTO> nhanvien = nv.LayDSNhanVienTheoTen(Ten);
		Assert.assertEquals("admin",nhanvien.get(0).getNhanVien_Username());
		Assert.assertEquals("Phường 15 Quận 8",nhanvien.get(0).getNhanVien_Address());
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên không có thông tin nhân viên đó trong hệ thống
	void testLayDSNhanVienTheoTen2() {
		DAL.NhanVienDAL nv = new DAL.NhanVienDAL();
		String Ten = "Huy";
		Vector<DTO.NhanVienDTO> nhanvien = nv.LayDSNhanVienTheoTen(Ten);
		Assert.assertNull(nhanvien);
		return;
	}

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử danh sách sản phẩm có loại tồn tại
	void testLayDSSanPhamTheoLoai() {
		DAL.SanPhamDAL sp = new DAL.SanPhamDAL();
		int Loai = 1;
		Vector<DTO.SanPhamDTO> sanpham = sp.LayDSSanPhamTheoLoai(Loai);
		Assert.assertEquals("Laptop Gaming Asus ROG Strix G15 G513IH HN015W",sanpham.get(0).getSanPham_Name());
		return;
	}

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử danh sách sản phẩm có loại không tồn tại
	void testLayDSSanPhamTheoLoai2() {
		DAL.SanPhamDAL sp = new DAL.SanPhamDAL();
		int Loai = 5;
		Vector<DTO.SanPhamDTO> sanpham = sp.LayDSSanPhamTheoLoai(Loai);
		Assert.assertNull(sanpham);
		return;
	}	
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử số điện thoại có thông tin nhà cung cấp.
	void testLayDSNhaCungCapTheoSDT() {
		DAL.NhaCungCapDAL ncc = new DAL.NhaCungCapDAL();
		String SDT = "0989044022";
		int sdt = Integer.parseInt(SDT);
		Vector<DTO.NhaCungCapDTO> nhacungcap = ncc.LayDSNhaCungCapTheoSDT(sdt);
		Assert.assertEquals("CÔNG TY TNHH QUẢNG TIN",nhacungcap.get(0).getNhaCungCap_Name());
		return;
	}

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử số điện thoại không có thông tin nhà cung cấp.
	void testLayDSNhaCungCapTheoSDT2() {
		DAL.NhaCungCapDAL ncc = new DAL.NhaCungCapDAL();
		String SDT = "0989044021";
		int sdt = Integer.parseInt(SDT);
		Vector<DTO.NhaCungCapDTO> nhacungcap = ncc.LayDSNhaCungCapTheoSDT(sdt);
		Assert.assertNull(nhacungcap);
		return;
	}

	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên đầy đủ và có thông tin nhà cung cấp đó trong hệ thống.
	void testLayDSNhaCungCapTheoTen() {
		DAL.NhaCungCapDAL ncc = new DAL.NhaCungCapDAL();
		String Ten = "CÔNG TY TNHH TIN HỌC HKC";
		Vector<DTO.NhaCungCapDTO> nhacungcap = ncc.LayDSNhaCungCapTheoTen(Ten);
		Assert.assertEquals("278 Nguyễn Văn Công, Phường 3, Quận Gò Vấp, Tp. Hồ Chí Minh",nhacungcap.get(0).getNhaCungCap_Address());
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên không đầy đủ và có thông tin nhà cung cấp đó trong hệ thống.
	void testLayDSNhaCungCapTheoTen2() {
		DAL.NhaCungCapDAL ncc = new DAL.NhaCungCapDAL();
		String Ten = "AN PHÁT";
		Vector<DTO.NhaCungCapDTO> nhacungcap = ncc.LayDSNhaCungCapTheoTen(Ten);
		Assert.assertEquals("Số 19, Ngõ 178 Thái Hà - Đống Đa - Tp. Hà Nội",nhacungcap.get(0).getNhaCungCap_Address());
		return;
	}
	
	@SuppressWarnings("deprecation")
	@Test
	// Kiểm thử tên không có thông tin nhà cung cấp đó trong hệ thống.
	void testLayDSNhaCungCapTheoTen3() {
		DAL.NhaCungCapDAL ncc = new DAL.NhaCungCapDAL();
		String Ten = "TUẤN PHÁT";
		Vector<DTO.NhaCungCapDTO> nhacungcap = ncc.LayDSNhaCungCapTheoTen(Ten);
		Assert.assertNull(nhacungcap);
		return;
	}
}

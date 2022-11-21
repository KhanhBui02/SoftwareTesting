package DTO;

import java.sql.Date;

public class HoaDonDichVuDTO {
	private int HoaDonDichVu_ID;
	private int HoaDonDichVu_IDKH;
	private int HoaDonDichVu_IDNV;
	private Date HoaDonDichVu_DateHD;
	private int HoaDonDichVu_Total;
	
	public int getHoaDonDichVu_ID() {
		return HoaDonDichVu_ID;
	}
	public void setHoaDonDichVu_ID(int hoaDonDichVu_ID) {
		HoaDonDichVu_ID = hoaDonDichVu_ID;
	}
	public int getHoaDonDichVu_IDKH() {
		return HoaDonDichVu_IDKH;
	}
	public void setHoaDonDichVu_IDKH(int hoaDonDichVu_IDKH) {
		HoaDonDichVu_IDKH = hoaDonDichVu_IDKH;
	}
	public int getHoaDonDichVu_IDNV() {
		return HoaDonDichVu_IDNV;
	}
	public void setHoaDonDichVu_IDNV(int hoaDonDichVu_IDNV) {
		HoaDonDichVu_IDNV = hoaDonDichVu_IDNV;
	}
	public Date getHoaDonDichVu_DateHD() {
		return HoaDonDichVu_DateHD;
	}
	public void setHoaDonDichVu_NGLHD(Date hoaDonDichVu_DateHD) {
		HoaDonDichVu_DateHD = hoaDonDichVu_DateHD;
	}
	public int getHoaDonDichVu_Total() {
		return HoaDonDichVu_Total;
	}
	public void setHoaDonDichVu_Total(int hoaDonDichVu_Total) {
		HoaDonDichVu_Total = hoaDonDichVu_Total;
	}
}

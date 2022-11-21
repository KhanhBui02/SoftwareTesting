package DTO;

public class KhachHangDTO {
	private int KhachHang_ID;
	private String KhachHang_Name;
	private String KhachHang_Address;
	private String KhachHang_PhoneNumber;
	private String KhachHang_Email;
	
	public int getKhachHang_ID(){
		return KhachHang_ID; 
	}
	public void setKhachHang_ID(int khachHang_ID){
		this.KhachHang_ID = khachHang_ID; 
	}
	public String getKhachHang_Name(){
		return KhachHang_Name;
	}
	public void setKhachHang_Name(String khachHang_Name){
		this.KhachHang_Name = khachHang_Name;
	}
	public String getKhachHang_Address(){
		return KhachHang_Address;
	}
	public void setKhachHang_Address(String khachHang_Address){
		this.KhachHang_Address = khachHang_Address;
	}
	public String getKhachHang_PhoneNumber(){
	return KhachHang_PhoneNumber;
	}
	public void setKhachHang_PhoneNumber(String khachHang_PhoneNumber){
		this.KhachHang_PhoneNumber = khachHang_PhoneNumber;
	}
	public String getKhachHang_Email(){
		return KhachHang_Email;
	}
	public void setKhachHang_Email(String khachHang_Email){
		this.KhachHang_Email = khachHang_Email;
	}
}

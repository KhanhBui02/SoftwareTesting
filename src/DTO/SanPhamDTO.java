package DTO;

public class SanPhamDTO {
	private String SanPham_ID;
	private String SanPham_Name;
	private int SanPham_Type;
	private int SanPham_Price;
	private int SanPham_Amount;
	
	public String getSanPham_ID(){
		return SanPham_ID; 
	}
	public void setSanPham_ID(String sanPham_ID){
		this.SanPham_ID = sanPham_ID; 
	}
	public String getSanPham_Name(){
		return SanPham_Name;
	}
	public void setSanPham_Name(String sanPham_Name){
		this.SanPham_Name = sanPham_Name;
	}
	public int getSanPham_Type(){
		return SanPham_Type;
	}
	public void setSanPham_Type(int sanPham_Type){
		SanPham_Type = sanPham_Type;
	}
	public int getSanPham_Price(){
	return SanPham_Price;
	}
	public void setSanPham_Price(int sanPham_Price){
		this.SanPham_Price = sanPham_Price;
	}
	public int getSanPham_Amount(){
		return SanPham_Amount;
	}
	public void setSanPham_Amount(int sanPham_Amount){
		this.SanPham_Amount = sanPham_Amount;
	}
}

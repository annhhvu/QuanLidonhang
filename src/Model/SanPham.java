package Model;

public class SanPham {
	private String tenSanPham;
	private String maSanPham;
	private int soLuong;
	private double giaSanPham;
	private String maDonHang;

	public SanPham(String tenSanPham, String maSanPham, int soLuong, double giaSanPham, String maDonHang) {

		this.tenSanPham = tenSanPham;
		this.maSanPham = maSanPham;
		this.soLuong = soLuong;
		this.giaSanPham = giaSanPham;
		this.maDonHang = maDonHang;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMaSanPham() {
		return maSanPham;
	}

	public void setMaSanPham(String maSanPham) {
		this.maSanPham = maSanPham;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public double getGiaSanPham() {
		return giaSanPham;
	}

	public void setGiaSanPham(double giaSanPham) {
		this.giaSanPham = giaSanPham;
	}

}

package Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;

public class DonHang {
	private ArrayList<SanPham> dsSanPham;
	private String maDonHang;
	private String tenKhachHang;
	private LocalDateTime thoiGian;
	private float giaDonHang;

	public DonHang() {
		this.dsSanPham = new ArrayList<SanPham>();
	}

	public DonHang(ArrayList<SanPham> dsSanPham, String maDonHang, String tenKhachHang, LocalDateTime thoiGian) {
		this.dsSanPham = dsSanPham;
		this.maDonHang = maDonHang;
		this.tenKhachHang = tenKhachHang;
		this.thoiGian = thoiGian;
	}

	public ArrayList<SanPham> getSanPham() {
		return dsSanPham;
	}

	public LocalDateTime getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDateTime thoiGian) {
		this.thoiGian = thoiGian;
	}

	public void setSanPham(ArrayList<SanPham> sanPham) {
		this.dsSanPham = sanPham;
	}

	public String getMaDonHang() {
		return maDonHang;
	}

	public void setMaDonHang(String maDonHang) {
		this.maDonHang = maDonHang;
	}

	public String getTenKhachHang() {
		return tenKhachHang;
	}

	public void setTenKhachHang(String tenKhachHang) {
		this.tenKhachHang = tenKhachHang;
	}

	public double getGiaDonHang() {
		return giaDonHang;
	}

	public void setGiaDonHang() {
		int tong = 0;
		for (int i = 0; i < this.dsSanPham.size(); i++) {
			tong += this.dsSanPham.get(i).getSoLuong() * this.dsSanPham.get(i).getGiaSanPham();
		}
		this.giaDonHang = tong;
	}

	public ArrayList<SanPham> arrayList() {
		return dsSanPham;
	}

	public void insert(SanPham sanPham) {
		this.dsSanPham.add(sanPham);
	}

	public void delete(SanPham sanPham) {
		this.dsSanPham.remove(sanPham);
	}

	public void update(SanPham sanPham) {
		this.dsSanPham.remove(sanPham);
		this.dsSanPham.add(sanPham);
	}
}

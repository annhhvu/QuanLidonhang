package Model;

import java.util.ArrayList;
import java.util.Objects;

public class QuanLyDonHang {
	private ArrayList<DonHang> dsDonHang;

	public QuanLyDonHang() {
		this.dsDonHang = new ArrayList<DonHang>();
	}

	public QuanLyDonHang(ArrayList<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
	}

	public ArrayList<DonHang> getDsDonHang() {
		return dsDonHang;
	}

	public void setDsDonHang(ArrayList<DonHang> dsDonHang) {
		this.dsDonHang = dsDonHang;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dsDonHang);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		QuanLyDonHang other = (QuanLyDonHang) obj;
		return Objects.equals(dsDonHang, other.dsDonHang);
	}

	public void insert(DonHang donHang) {
		this.dsDonHang.add(donHang);
	}

	public void delete(DonHang donHang) {
		this.dsDonHang.remove(donHang);
	}

	public void update(DonHang donHang) {
		this.dsDonHang.remove(donHang);
		this.dsDonHang.add(donHang);

	}
}
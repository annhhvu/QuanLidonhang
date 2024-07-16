package Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.table.AbstractTableModel;

import View.Trang2;
import View.Trang3;
import View.Trang4;
import View.Trang5;

public class Controller {
	
	private boolean flagSua;
	private String maDonHang1;
	private String maDonHang;
	private Trang4 trang4;
	private Trang3 trang3;
	private Trang2 trang2;
	private Trang5 trang5;

	public Controller(Trang4 trang4, Trang3 trang3,Trang2 trang2, Trang5 trang5) {
		this.trang4 = trang4;
		this.trang3 = trang3;
		this.trang2 = trang2;
		this.trang5 = trang5;
		
		trang2.reset(new resetButton());
		trang2.timKiem(new timKiemButton());
		trang5.xoaSanPham(new suaXoaSanPhamButton());
		trang4.comboBox(new comboBoxButton());
		trang5.luuDonHang(new suaLuuDonHangButton());
		trang5.themSanPham(new suaThemSanPhamButton() , maDonHang1);
		trang2.suaDonHang(new suaDonHangButton());
		trang2.xoaDonHang(new xoaDonHangButton());
		trang3.xoaSanPham(new xoaSanPhamButton());
		trang2.themDonHang(new themDonHangButton());
		trang3.luuDonHang(new luuDonHangButton());
		trang3.themSanPham(new themSanPhamButton(), maDonHang);
		trang4.luuSanPham(new luuSanPhamButton());

	}
// khi bấm nút lưu sản phẩm từ trang 4  
	class luuSanPhamButton implements ActionListener {
		public void actionPerformed(ActionEvent ee) {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			// nếu flagsua đúng thì đang thêm sản phảm từ trang 4  
			if (flagSua == true) {
			
			trang4.luuSanPhamSQL(conn, trang3.getMaDonHang());
			trang3.capNhatTable(conn);
			trang4.thietLapBanDau();
			}
			// nếu flagsuasai thì đang thêm sản phảm từ trang 4  
			else {
				trang4.luuSanPhamSQL(conn, trang5.getMaDonHang());
				trang5.capNhatTable(conn);
				trang4.thietLapBanDau();
			}
		}
	}
// khi bấm nut them san pham tu trang4
	class themSanPhamButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flagSua = true;
			trang4.setVisible(true);
			
		}
	}
// khi chon combobox thì sẽ thiết lập lại ma Sản phảm và giá sản phẩm
	class comboBoxButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			trang4.setTxt();
		}
		
	}
	// khi bấm nút lưu đơn hàng
	class luuDonHangButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ee) {
			// TODO Auto-generated method stub
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stube
				trang3.luuDonHangVaoSQL(conn); // lưu đơn hàng vào SQL
				trang2.capNhatTable(conn);//cập nhật lại table
		}

	}
	// 
	class themDonHangButton implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent ee) {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			trang3.capNhatTable(conn);// cập nhật table 
			trang3.thietLapBanDau();// thiết lập lại giá trị rỗng
			trang3.thietLapMaDonHang(conn);// thiết lập lại mã đơn hàng
			trang3.setVisible(true); //trả về trang 3
			
		}
		
	}
	// khi bấm nút xóa san pham tu trang 3
	class xoaSanPhamButton implements ActionListener{
		public void actionPerformed(ActionEvent ee) {
			// TODO Auto-generated method stub
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trang3.tblXoaSanPham(conn);
			trang3.capNhatTable(conn);
		}
	}
	// khi bấm nút xóa san pham tu trang 2
	class xoaDonHangButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ee) {
			// TODO Auto-generated method stub
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			trang2.tblXoaDonPham(conn);
			trang2.capNhatTable(conn);
		}
		
	}
	
	// khi bấm nút sua san pham tu trang 2
	class suaDonHangButton implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent ee) {
			
			// TODO Auto-generated method stub
			
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			trang5.capNhatDuLieu(conn, trang2.getMaDonHang1());
			trang5.capNhatTable(conn);
			trang5.setVisible(true);
		}
		
	}
	// khi bấm nút luu san pham tu trang5 
	class suaLuuDonHangButton implements ActionListener {
		public void actionPerformed(ActionEvent ee) {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			trang5.luuDonHangVaoSQL(conn);
			trang2.capNhatTable(conn);
			trang5.setVisible(false);
			trang5.thietLapBanDau();
		}
	}
	// khi bấm nút sua san pham tu trang 3
	class suaThemSanPhamButton implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			flagSua = false;
			trang4.setVisible(true);
		}
	}
	
	// khi bấm nút xóa san pham tu trang 5
	class suaXoaSanPhamButton implements ActionListener{
		public void actionPerformed(ActionEvent ee) {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trang5.tblXoaSanPham(conn);
			trang5.capNhatTable(conn);
		}
	}
	// khi bấm nút tim kiem tu trang 2
	class timKiemButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ee) {
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// TODO Auto-generated method stub
			trang2.capNhatDanhSachTimKiem(conn);
		}
		
	}
	
	// khi bấm nút reset tu trang 2
	class resetButton implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent ee) {
			// TODO Auto-generated method stub
			Connection conn = null;
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			trang2.capNhatTable(conn);
		}
		
	}

}

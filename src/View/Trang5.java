package View;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class Trang5 extends JFrame {

	private JButton btnXoaSanPham;
	private JButton btnLuuDonHang;
	private JButton btnThemSanPham;
	private DefaultTableModel tblModel;
	private JPanel contentPane;
	private JTextField txtMaDonHang;
	private JTextField txtKhachHang;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trang5 frame = new Trang5();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Trang5() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(667, 398);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sửa đơn hàng");
		lblNewLabel.setForeground(new Color(255, 11, 11));
		lblNewLabel.setBackground(new Color(255, 255, 255));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(184, 10, 288, 41);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1_1 = new JLabel("Mã đơn hàng:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(42, 61, 132, 35);
		contentPane.add(lblNewLabel_1_1);

		txtMaDonHang = new JTextField();
		txtMaDonHang.setEditable(false);
		txtMaDonHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaDonHang.setColumns(10);
		txtMaDonHang.setBounds(152, 68, 463, 19);
		contentPane.add(txtMaDonHang);

		btnLuuDonHang = new JButton("Lưu");
		btnLuuDonHang.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLuuDonHang.setBackground(new Color(255, 255, 255));
		btnLuuDonHang.setBounds(460, 330, 155, 21);
		contentPane.add(btnLuuDonHang);

		JLabel lblNewLabel_1_1_1 = new JLabel("Khách hàng:");
		lblNewLabel_1_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1_1.setBounds(42, 97, 105, 35);
		contentPane.add(lblNewLabel_1_1_1);

		txtKhachHang = new JTextField();
		txtKhachHang.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(162, 105, 453, 19);
		contentPane.add(txtKhachHang);

		btnThemSanPham = new JButton("Thêm sản phẩm");
		btnThemSanPham.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnThemSanPham.setBackground(new Color(255, 255, 255));
		btnThemSanPham.setBounds(42, 330, 155, 21);
		contentPane.add(btnThemSanPham);

		btnXoaSanPham = new JButton("Xóa sản phẩm");
		btnXoaSanPham.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnXoaSanPham.setBackground(new Color(255, 255, 255));
		btnXoaSanPham.setBounds(253, 330, 155, 21);
		contentPane.add(btnXoaSanPham);

		JLabel lblNewLabel_4 = new JLabel("Danh sách sản phẩm");
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_4.setBounds(40, 142, 185, 21);
		contentPane.add(lblNewLabel_4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(42, 173, 573, 121);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.getTableHeader().setBackground(new Color(0, 0, 255));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(217, 217, 217));
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m",
				"T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n" }));
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		scrollPane.setViewportView(table);
	}
	// cập nhật table từ SQL server
	public void capNhatTable(Connection conn) {
		tblModel = (DefaultTableModel) table.getModel();
		tblModel.setRowCount(0);
		PreparedStatement ptsm;
		Object obj[] = new Object[5];
		try {
			ptsm = conn.prepareStatement("SELECT * FROM SanPham where maDonHang = ?");
			ptsm.setString(1, txtMaDonHang.getText());
			ResultSet rs = ptsm.executeQuery();
			while (rs.next()) {
				obj[0] = table.getRowCount() + 1;
				obj[1] = rs.getString("maSanPham");
				obj[2] = rs.getString("tenSanPham");
				obj[3] = rs.getInt("soLuong");
				obj[4] = rs.getFloat("giaSanPham");
				tblModel.addRow(obj);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Loi truy xuat du lieu");
			e1.printStackTrace();
		}

	}
	// thêm sự kiện của nút bấm thêm sản phẩm
	public void themSanPham(ActionListener listener, String maDonHang) {
		maDonHang = txtMaDonHang.getText();
		btnThemSanPham.addActionListener(listener);
	}
	// thêm sự kiện của nút bấm luu don hang
	public void luuDonHang(ActionListener listener) {
		btnLuuDonHang.addActionListener(listener);
	}
	// thêm sự kiện của nút bấm xoa san pham
	public void xoaSanPham(ActionListener listener) {
		btnXoaSanPham.addActionListener(listener);
	}
	// xóa san pham khi chọn sản phẩm từ table 
	public void tblXoaSanPham(Connection conn) {
		try {

			PreparedStatement ptsm = conn.prepareStatement("DELETE FROM SanPham WHERE maSanPham = ?");
			String maSanPham = (String) table.getValueAt(table.getSelectedRow(), 1);
			ptsm.setString(1, maSanPham);
			ptsm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getMaDonHang() {
		return txtMaDonHang.getText();
	}
	// thêm đơn hàng vào SQL server
	public void luuDonHangVaoSQL(Connection conn) {
		String maDonHang, khachHang;
		Date thoiGian;
		float giaDonHang = 0;

		LocalDate currentDate = LocalDate.now();
		maDonHang = txtMaDonHang.getText();
		khachHang = txtKhachHang.getText();
		thoiGian = Date.valueOf(currentDate);

		try {
			PreparedStatement ptsm = conn.prepareStatement("SELECT * FROM SanPham where maDonHang = ?");
			ptsm.setString(1, maDonHang);
			ResultSet rs = ptsm.executeQuery();
			while (rs.next()) {
				giaDonHang += rs.getFloat("giaSanPham") * rs.getInt("soLuong");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			PreparedStatement ptsm1 = conn.prepareStatement(
					"UPDATE DonHang SET khachHang = ?,thoiGian = ?, giaDonHang = ? where maDonHang = ?");
			ptsm1.setString(1, khachHang);
			ptsm1.setString(4, maDonHang);
			ptsm1.setDate(2, thoiGian);
			ptsm1.setFloat(3, giaDonHang);
			ptsm1.executeUpdate();
			JOptionPane.showMessageDialog(rootPane, "Them vao csdl thanh cong");
			this.setVisible(false);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(rootPane, "Them vao csdl fail");
			e1.printStackTrace();
		}
	}
	// thiết lập lại giá trị rỗng
	public void thietLapBanDau() {
		txtMaDonHang.setText("");
		txtKhachHang.setText("");
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "STT", "M\u00E3 s\u1EA3n ph\u1EA9m",
				"T\u00EAn s\u1EA3n ph\u1EA9m", "S\u1ED1 l\u01B0\u1EE3ng", "Gi\u00E1 ti\u1EC1n" }));
	}
// cập nhật dữ liệu lại vào SQL server
	public void capNhatDuLieu(Connection conn, String maDonHang) {
		try {
			PreparedStatement ptsm = conn.prepareStatement("SELECT * FROM DonHang where maDonHang = ?");
			ptsm.setString(1, maDonHang);
			ResultSet rs = ptsm.executeQuery();
			while (rs.next()) {
				txtMaDonHang.setText(rs.getString("maDonHang"));
				txtKhachHang.setText(rs.getString("khachHang"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

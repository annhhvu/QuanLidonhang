package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import Model.DonHang;
import Model.QuanLyDonHang;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;

public class Trang2 extends JFrame {
	// Khai báo biến
	private JButton btnReset;
	private JButton btnTimKiem;
	private JButton btnSuaDonHang;
	private JButton btnXoaDonHang;
	private JButton btnThemDonHang;
	private JPanel contentPane;
	private JTextField txtMaDonHang;
	private JTable table;
	private DefaultTableModel tblModel;
	private JTextField txtKhachHang;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trang2 frame = new Trang2();
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
	public Trang2() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(952, 444);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		btnThemDonHang = new JButton("THÊM ĐƠN HÀNG");
		btnThemDonHang.setBackground(new Color(255, 255, 255));
		btnThemDonHang.setBounds(60, 372, 164, 25);
		btnThemDonHang.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnXoaDonHang = new JButton("XÓA ĐƠN HÀNG");
		btnXoaDonHang.setBackground(new Color(255, 255, 255));
		btnXoaDonHang.setBounds(290, 372, 153, 25);
		btnXoaDonHang.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnSuaDonHang = new JButton("SỬA ĐƠN HÀNG");
		btnSuaDonHang.setBackground(new Color(255, 255, 255));
		btnSuaDonHang.setBounds(520, 372, 153, 25);
		btnSuaDonHang.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnTimKiem = new JButton("Tìm Kiếm");
		btnTimKiem.setForeground(new Color(0, 0, 0));
		btnTimKiem.setBackground(new Color(255, 255, 255));
		btnTimKiem.setBounds(734, 55, 126, 25);
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 17));

		JLabel lblNewLabel = new JLabel("Danh sách đơn hàng\r\n");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(255, 11, 11));
		lblNewLabel.setBounds(339, 11, 232, 31);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));

		txtMaDonHang = new JTextField();
		txtMaDonHang.setBounds(201, 59, 164, 19);
		txtMaDonHang.setColumns(10);

		btnReset = new JButton("RESET\r\n");
		btnReset.setBackground(new Color(255, 255, 255));
		btnReset.setBounds(750, 372, 153, 25);
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		contentPane.setLayout(null);
		contentPane.add(txtMaDonHang);
		contentPane.add(btnTimKiem);
		contentPane.add(lblNewLabel);
		contentPane.add(btnThemDonHang);
		contentPane.add(btnXoaDonHang);
		contentPane.add(btnSuaDonHang);
		contentPane.add(btnReset);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(106, 101, 726, 255);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setColumnSelectionAllowed(true);
		table.getTableHeader().setBackground(new Color(0, 0, 255));
		table.getTableHeader().setForeground(new Color(255,255,255));
		table.getTableHeader().setFont(new Font("Times New Roman", Font.BOLD, 15));
		table.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		table.setBackground(new Color(217, 217, 217));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"STT", "Ma don hang", "Khach hang", "Thoi gian", "Thanh tien"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(49);
		table.getColumnModel().getColumn(1).setPreferredWidth(136);
		table.getColumnModel().getColumn(2).setPreferredWidth(126);
		table.getColumnModel().getColumn(3).setPreferredWidth(106);
		table.getColumnModel().getColumn(4).setPreferredWidth(169);
		scrollPane.setViewportView(table);

		txtKhachHang = new JTextField();
		txtKhachHang.setColumns(10);
		txtKhachHang.setBounds(539, 59, 164, 19);
		contentPane.add(txtKhachHang);

		JLabel lblNewLabel_1 = new JLabel("Mã đơn hàng:");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setBounds(78, 58, 124, 19);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Khách hàng:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setBounds(430, 59, 101, 19);
		contentPane.add(lblNewLabel_1_1);
		setVisible(true);
	}
	// hàm để cập nhật table từ server SQL
	public void capNhatTable(Connection conn) {
		tblModel = (DefaultTableModel) table.getModel();
		tblModel.setRowCount(0);

		PreparedStatement ptsm;
		Object obj[] = new Object[5];
		try {
			ptsm = conn.prepareStatement("SELECT * FROM DonHang");
			ResultSet rs = ptsm.executeQuery();
			while (rs.next()) {
				obj[0] = table.getRowCount() + 1;
				obj[1] = rs.getString("maDonHang");
				obj[2] = rs.getString("khachHang");
				obj[3] = rs.getDate("thoiGian");
				obj[4] = rs.getFloat("giaDonHang");
				tblModel.addRow(obj);
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(new JFrame(), "Loi truy xuat du lieu");
			e1.printStackTrace();
		}

	}
	// thêm sự kiện của nút bấm thêm đơn hàng 
	public void themDonHang(ActionListener listener) {
		btnThemDonHang.addActionListener(listener);
	}
	// thêm sự kiện của nút bấm xóa đơn hàng 
	public void xoaDonHang(ActionListener listener) {
		btnXoaDonHang.addActionListener(listener);
	}
	// xóa đơn hàng khi chọn đơn hàng từ table 
	public void tblXoaDonPham(Connection conn) {
		try {
			PreparedStatement ptsm = conn.prepareStatement("DELETE FROM DonHang WHERE maDonHang = ?");
			String maDonHang = (String) table.getValueAt(table.getSelectedRow(), 1);
			ptsm.setString(1, maDonHang);
			ptsm.executeUpdate();

			PreparedStatement ptsm1 = conn.prepareStatement("DELETE FROM SanPham WHERE maDonHang = ?");
			ptsm1.setString(1, maDonHang);
			ptsm1.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	// hàm trả về giá trị mã đơn hàng khi chọn đơn hàng từ table
	public String getMaDonHang1() {
		return (String) table.getValueAt(table.getSelectedRow(), 1);
	}
	//thêm sự kiện của nút bấm sửa đơn hàng 
	public void suaDonHang(ActionListener listener) {
		btnSuaDonHang.addActionListener(listener);
	}
	//thêm sự kiện của nút bấm tìm kiếm đơn hàng 
	public void timKiem(ActionListener listener) {
		btnTimKiem.addActionListener(listener);
	}
	//thêm sự kiện của nút bấm reset table
	public void reset(ActionListener listener) {
		btnReset.addActionListener(listener);
	}
	// hàm cập nhật table khi nhấn nút tìm kiếm
	public void capNhatDanhSachTimKiem(Connection conn) {
		String maDonHang = "", khachHang = "";
		boolean isOk = true;
		boolean isKHOk = true, isMDHOk = true;
		try {
			khachHang = txtKhachHang.getText();
			maDonHang = txtMaDonHang.getText();
			// nếu khác hàng và mã đều rỗng thì ko thể tìm kiếm
			if ((khachHang.isEmpty() || khachHang.isBlank()) && (maDonHang.isEmpty() || maDonHang.isBlank())) {
				throw new Exception("Khach hang hoac ma don hang phai co mot cot co gia tri");
			}

			if (khachHang.isEmpty() || khachHang.isBlank()) {
				isKHOk = false;
			}

			if (maDonHang.isEmpty() || maDonHang.isBlank()) {
				isMDHOk = false;
			}

		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			isOk = false;
		}
		//  tìm kiếm khi có mã đơn hàng và tên khác hàng sau đó xuất ra table
		if (isOk) {
			if (isMDHOk && isKHOk) {
				tblModel = (DefaultTableModel) table.getModel();
				tblModel.setRowCount(0);
				PreparedStatement ptsm;
				Object obj[] = new Object[5];
				try {
					ptsm = conn.prepareStatement("SELECT * FROM DonHang where maDonHang = ? and khachHang = ?");
					ptsm.setString(1, maDonHang);
					ptsm.setString(2, khachHang);
					ResultSet rs = ptsm.executeQuery();
					while (rs.next()) {
						obj[0] = table.getRowCount() + 1;
						obj[1] = rs.getString("maDonHang");
						obj[2] = rs.getString("khachHang");
						obj[3] = rs.getDate("thoiGian");
						obj[4] = rs.getFloat("giaDonHang");
						tblModel.addRow(obj);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(), "Loi truy xuat du lieu");
					e1.printStackTrace();
				}
				//tìm kiếm khi có mã đơn hàng sau đó xuất ra table
			} else if (isMDHOk) {
				tblModel = (DefaultTableModel) table.getModel();
				tblModel.setRowCount(0);
				PreparedStatement ptsm;
				Object obj[] = new Object[5];
				try {
					ptsm = conn.prepareStatement("SELECT * FROM DonHang where maDonHang = ?");
					ptsm.setString(1, maDonHang);
					ResultSet rs = ptsm.executeQuery();
					while (rs.next()) {
						obj[0] = table.getRowCount() + 1;
						obj[1] = rs.getString("maDonHang");
						obj[2] = rs.getString("khachHang");
						obj[3] = rs.getDate("thoiGian");
						obj[4] = rs.getFloat("giaDonHang");
						tblModel.addRow(obj);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(), "Loi truy xuat du lieu");
					e1.printStackTrace();
				}
				//tìm kiếm khi có tên khác hàng sau đó xuất ra table
			} else if (isKHOk) {
				tblModel = (DefaultTableModel) table.getModel();
				tblModel.setRowCount(0);
				PreparedStatement ptsm;
				Object obj[] = new Object[5];
				try {
					ptsm = conn.prepareStatement("SELECT * FROM DonHang where khachHang = ?");
					ptsm.setString(1, khachHang);
					ResultSet rs = ptsm.executeQuery();
					while (rs.next()) {
						obj[0] = table.getRowCount() + 1;
						obj[1] = rs.getString("maDonHang");
						obj[2] = rs.getString("khachHang");
						obj[3] = rs.getDate("thoiGian");
						obj[4] = rs.getFloat("giaDonHang");
						tblModel.addRow(obj);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(new JFrame(), "Loi truy xuat du lieu");
					e1.printStackTrace();
				}
			}
		}
	}

}

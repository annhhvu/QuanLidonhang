package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import Model.DonHang;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.ImageIcon;

public class Trang4 extends JFrame {

	private String[] dsSanPham = { "Coca", "Saxi", "7Up", "RedBull", "Coffe" };
	private JComboBox comboBox;
	private DonHang maDonHang;
	private JButton btnLuu;
	private JPanel contentPane;
	private JTextField txtTenSanPham;
	private JTextField txtMaSanPham;
	private JTextField txtGiaSanPham;
	private JTextField txtSoLuong;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trang4 frame = new Trang4();
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
	public Trang4() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(501, 309);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(15, 15, 15, 15));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Thêm Sản Phẩm");
		lblNewLabel.setForeground(new Color(255, 11, 11));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 22));
		lblNewLabel.setBounds(91, 25, 288, 41);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Tên sản phẩm:");
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setBounds(61, 86, 120, 41);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("Mã sản phẩm:");
		lblNewLabel_1_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setBounds(61, 119, 120, 35);
		contentPane.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("Giá tiền:");
		lblNewLabel_1_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setBounds(61, 152, 120, 35);
		contentPane.add(lblNewLabel_1_2);

//		txtTenSanPham = new JTextField();
//		txtTenSanPham.setEditable(false);
//		txtTenSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 15));
//		txtTenSanPham.setBounds(191, 65, 201, 19);
//		contentPane.add(txtTenSanPham);
//		txtTenSanPham.setColumns(10);

		txtMaSanPham = new JTextField();
		txtMaSanPham.setEditable(false);
		txtMaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMaSanPham.setColumns(10);
		txtMaSanPham.setBounds(191, 126, 201, 19);
		contentPane.add(txtMaSanPham);

		txtGiaSanPham = new JTextField();
		txtGiaSanPham.setEditable(false);
		txtGiaSanPham.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtGiaSanPham.setColumns(10);
		txtGiaSanPham.setBounds(191, 159, 201, 19);
		contentPane.add(txtGiaSanPham);

		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnLuu.setForeground(new Color(0, 0, 0));
		btnLuu.setBackground(new Color(255, 255, 255));
		btnLuu.setBounds(191, 229, 101, 32);
		contentPane.add(btnLuu);

		JLabel lblNewLabel_1_2_1 = new JLabel("Số lượng:");
		lblNewLabel_1_2_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_2_1.setBounds(61, 181, 120, 35);
		contentPane.add(lblNewLabel_1_2_1);

		txtSoLuong = new JTextField();
		txtSoLuong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtSoLuong.setColumns(10);
		txtSoLuong.setBounds(191, 188, 201, 19);
		contentPane.add(txtSoLuong);

		comboBox = new JComboBox();
		comboBox.setBounds(191, 94, 201, 21);
		contentPane.add(comboBox);

	}
	// thiết lập mã đơn hàng
	public void setMaDonHang(DonHang maDonHang) {
		this.maDonHang = maDonHang;
	}
	// thêm sự kiện của nút bấm luu sản phẩm
	public void luuSanPham(ActionListener listener) {
		btnLuu.addActionListener(listener);
	}
	// thêm sự kiện combo box
	public void comboBox(ActionListener listener) {
		comboBox.addActionListener(listener);
	}
	// thiết lập combobox
	public void setComboBox() {

		for (int i = 0; i < dsSanPham.length; i++) {
			comboBox.addItem(dsSanPham[i]);
		}
//		
//		

	}
	// thiết lập mã sản phẩm và giá sản phẩm khi chọn tên sản phẩm
	public void setTxt() {
		String[] dsMaSanPham = { "N001", "N002", "N003", "N004", "N005" };
		String[] dsGiaSanPham = { "10000", "8000", "10000", "15000", "10000" };
		for (int i = 0; i < dsGiaSanPham.length; i++) {
			if (comboBox.getSelectedItem() == dsSanPham[i]) {
				txtMaSanPham.setText(dsMaSanPham[i]);
				txtGiaSanPham.setText(dsGiaSanPham[i]);
			}
		}
	}
	// thêm sản phẩm vào SQL server
	public void luuSanPhamSQL(Connection conn, String maDonHang) {
		String maSanPham = "", tenSanPham = "";
		int soLuong = 0;
		float giaSanPham = 0;
		Boolean isOk = true;
		maSanPham = txtMaSanPham.getText();
		tenSanPham = (String) comboBox.getSelectedItem();
		try {
			soLuong = Integer.parseInt(txtSoLuong.getText());
			// số lượng nhỏ ko đc nhỏ hơn hoặc bằng 0
			if (soLuong <= 0) {
				isOk = false;
				throw new Exception("So luong khong duoc nho hon 0");
			}
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, e2.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			JOptionPane.showMessageDialog(rootPane, "So luong phai la so va khong chua ky tu");
			isOk = false;
		}
		try {
			giaSanPham = Float.parseFloat(txtGiaSanPham.getText());
		} catch (Exception e2) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(rootPane, "So luong phai la so va khong chua ky tu");
			isOk = false;
		}
		// 
		if (isOk) {
			//thêm sản phẩm lên SQL khi điều kiển ở trên thảo mãn
			try {
				PreparedStatement ptsm1 = conn.prepareStatement(
						"INSERT INTO SanPham(maSanPham, tenSanPham, soLuong, giaSanPham, maDonHang) values(?,?,?,?,?)");
				ptsm1.setString(1, maSanPham);
				ptsm1.setString(2, tenSanPham);
				ptsm1.setInt(3, soLuong);
				ptsm1.setFloat(4, giaSanPham);
				ptsm1.setString(5, maDonHang);
				ptsm1.executeUpdate();
				JOptionPane.showMessageDialog(rootPane, "Them vao csdl thanh cong");
				this.setVisible(false);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(rootPane, "Them vao csdl fail");
				e1.printStackTrace();
			}
		}
	}
	//thiết lập lại giá trị rỗng
	public void thietLapBanDau() {
		txtSoLuong.setText("");
	}
}

package Run;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Controller.Controller;
import View.Trang2;
import View.Trang3;
import View.Trang4;
import View.Trang5;

public class Run {
	public static void main(String[] args) {
		Connection conn = null;
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			conn = DriverManager.getConnection("jdbc:sqlserver://MSI\\SQLEXPRESS:1433;databaseName=QuanLyDonHang;user=sa;password=123");
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Trang4 trang4 = new Trang4();
		Trang3 trang3 = new Trang3();
		Trang2 trang2 = new Trang2();
		Trang5 trang5 = new Trang5();
		trang2.capNhatTable(conn);
		trang4.setComboBox();
		Controller controller = new Controller(trang4,trang3,trang2, trang5);
	}
}

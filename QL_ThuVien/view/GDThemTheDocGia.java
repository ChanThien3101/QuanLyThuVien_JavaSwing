package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import controller.KetNoiSQL;

public class GDThemTheDocGia extends JFrame {

	private DefaultTableModel table;
	private static JTable tbl;
	KetNoiSQL connn = new KetNoiSQL();

	public GDThemTheDocGia() {

		Container con = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1000, 500);
		setLocationRelativeTo(null);
		setTitle("LIBRARY_VKU");
		con.setLayout(new GridLayout(2, 1));

		JPanel con1 = new JPanel();
		con.add(con1);
		con1.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setBackground(Color.cyan);
		con1.add(north, "North");
		north.setLayout(new BorderLayout());

		JButton back = new JButton("BACK");
		north.add(back, "West");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDTrangChu().setVisible(true);
				dispose();

			}
		});

		JPanel center1 = new JPanel();
		center1.setLayout(new BorderLayout());
		con1.add(center1, "Center");
		// tao vien ngoai
		Border boder = BorderFactory.createLineBorder(Color.BLUE);
		center1.setBorder(boder);

		JPanel tieude = new JPanel();
		center1.add(tieude, "North");

		JLabel tieude1 = new JLabel("THEM THE DOC GIA MOI");
		tieude1.setForeground(Color.BLACK);
		tieude1.setFont(new Font("Tahoma", Font.BOLD, 20));
		tieude.add(tieude1);

		JPanel center2 = new JPanel();
		center1.add(center2, "Center");
		// tao vien ngoai
		Border boder2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder itel2 = BorderFactory.createTitledBorder(boder2, " THONG TIN THE DOC GIA     ");
		center2.setBorder(itel2);

		JPanel nhap = new JPanel();
		nhap.setLayout(new GridLayout(4, 4));
		center2.add(nhap);

		JLabel name = new JLabel("      TEN DOC GIA");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(name);

		JTextField txtName = new JTextField(20);
		nhap.add(txtName);

		JLabel kindOfReader = new JLabel("          LOAI DOC GIA:");
		kindOfReader.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(kindOfReader);

		String arr[] = { "Giang Vien", "Sinh Vien", "Khac" };
		JComboBox loaidocgia = new JComboBox(arr);
		nhap.add(loaidocgia);

		JLabel DateOfBirth = new JLabel("      NGAY SINH:");
		DateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(DateOfBirth);

		JTextField txtDateOfBirth = new JTextField(20);
		nhap.add(txtDateOfBirth);

		JLabel startDate = new JLabel("          NGAY DANG KY THE:");
		startDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(startDate);

		JTextField txtStartDate = new JTextField(20);
		nhap.add(txtStartDate);

		JLabel address = new JLabel("      DIA CHI:");
		address.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(address);

		JTextField txtAddress = new JTextField(20);
		nhap.add(txtAddress);

		JLabel endDate = new JLabel("          NGAY THE HET HAN:");
		endDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(endDate);

		JTextField txtEndDate = new JTextField(20);
		nhap.add(txtEndDate);

		JLabel phoneNumber = new JLabel("      SO DIEN THOAI:");
		phoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(phoneNumber);

		JTextField txtPhoneNumber = new JTextField(20);
		nhap.add(txtPhoneNumber);

		JPanel east = new JPanel();
		center1.add(east, "East");
		// tao vien ngoai
		Border boder3 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder itel3 = BorderFactory.createTitledBorder(boder3, " TAC VU");
		east.setBorder(itel3);

		JPanel button = new JPanel();
		button.setLayout(new GridLayout(4, 1));
		east.add(button);

		JButton moi = new JButton("NEW");
		button.add(moi);
		moi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtName.setText("");
				txtDateOfBirth.setText("");
				txtAddress.setText("");
				txtPhoneNumber.setText("");
				txtStartDate.setText("");
				txtEndDate.setText("");
				loaidocgia.setSelectedIndex(0);

			}
		});

		JButton add = new JButton("ADD");
		button.add(add);

		JButton edit = new JButton("EDIT");
		button.add(edit);

		JButton delete = new JButton("DELETE");
		button.add(delete);

		JPanel con2 = new JPanel();
		con.add(con2);
		con2.setLayout(new BorderLayout());
		// tao vien ngoai
		Border boder4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder itel4 = BorderFactory.createTitledBorder(boder4, "DANH SACH THE DOC GIA   ");
		con2.setBorder(itel4);

		// tao ra 1 bang mac dinh (mô hình bảng được sử dụng bởi một JTable khi không có mô hình bảng được xác định cụ thể)
		/*
		 Lợi thế của việc sử dụng các > DefaultTableModel trên một tùy chỉnh > AbstractTableModel 
		 là bạn không phải mã các phương pháp như thêm, chèn hoặcxóa các hàng và cột. 
		 Chúng đã tồn tại để thay đổi dữ liệu được lưu giữ trong > Vector của > Vectơ. Điều này làm cho nó
		 một mô hình bảng nhanh chóng và dễ  dàng để thực hiện.
		 */
		table = new DefaultTableModel();
		table.addColumn("Ma The Doc Gia");
		table.addColumn("Ten Doc Gia");
		table.addColumn("Ngay Sinh");
		table.addColumn("So Dien Thoai");
		table.addColumn("Dia Chi");
		table.addColumn("Loai Doc Gia");
		table.addColumn("Ngay Dang Ky The");
		table.addColumn("Ngay The Het Han");

		/* tao ra 1 table chua defaultTableModel phia tren
		 Jtable cung cao cho ta cach hien thi du lieu duoi dang bang, Jtable khong chua hay dem du lieu, no don gian chi la
		 cung cap cach xem du  lieu.
		 */
		
		tbl = new JTable(table);
		// tao ra 1 khung chong tran
		JScrollPane js = new JScrollPane(tbl);
		con2.add(js);

		loadData();

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtName.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 1));
				txtDateOfBirth.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 2));
				txtPhoneNumber.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 3));
				txtAddress.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 4));
				loaidocgia.setSelectedItem((String) tbl.getValueAt(tbl.getSelectedRow(), 5));
				txtStartDate.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 6));
				txtEndDate.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 7));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub

			}
		});

		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				table.setRowCount(0);

				try {

					/*chung ta truyen tham so (?) cho cac gia tri. Gia tri cua no se duoc cai dat bang cach
					 goi cac phuong thuc setter cua PreparedStatement.
					 */
					String sql = "INSERT into tblDocGia ( Name , DateOfBirth, PhoneNumber, Address,  KindOfReader, StartDate, EndDate)"
							+ " VALUES (?,?,?,?,?,?,?)";

					//su dung PreparedStatement de thuc hien truy van tham so (?).
					PreparedStatement ps = KetNoiSQL.getCon().prepareStatement(sql);
					
					ps.setString(1, txtName.getText());
					ps.setString(2, txtDateOfBirth.getText());
					ps.setString(3, txtPhoneNumber.getText());
					ps.setString(4, txtAddress.getText());
					ps.setString(5, (String) loaidocgia.getSelectedItem());
					ps.setString(6, txtStartDate.getText());
					ps.setString(7, txtEndDate.getText());
					ps.executeUpdate();

					loadData();
					JOptionPane.showMessageDialog(rootPane, "Them Thanh Cong! ");
				} catch (Exception e2) {
					e2.printStackTrace();
					loadData();
					JOptionPane.showMessageDialog(rootPane, "Them That Bai! ");

				}
			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "delete from tblDocGia where ID=" + "'" + tbl.getValueAt(tbl.getSelectedRow(), 0)
							+ "'";
					KetNoiSQL.getStm().execute(sql);
					table.removeRow(tbl.getSelectedRow());
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String data = "" + loaidocgia.getItemAt(loaidocgia.getSelectedIndex());

					String sql = "Update tblDocGia set Name =" + "'" + txtName.getText() + "'" + ", DateOfBirth=" + "'"
							+ txtDateOfBirth.getText() + "'" + ",PhoneNumber=" + "'" + txtPhoneNumber.getText() + "'"
							+ " , Address=" + "'" + txtAddress.getText() + "'" + ",KindOfReader=" + "'" + data + "'"
							+ ", StartDate=" + "'" + txtStartDate.getText() + "'" + ", EndDate=" + "'"
							+ txtEndDate.getText() + "'" + " where ID=" + "'" + tbl.getValueAt(tbl.getSelectedRow(), 0)
							+ "'";

					if (KetNoiSQL.getStm().executeUpdate(sql) == 1) {
						JOptionPane.showConfirmDialog(null, "EDIT THANH CONG", null, JOptionPane.CLOSED_OPTION);
						table.setRowCount(0);
						loadData();
					}

				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "EDIT THAT BAI", null, JOptionPane.CLOSED_OPTION);
					e2.printStackTrace();
				}

			}
		});

		setVisible(true);
		setResizable(false);

	}

	public void loadData() {
		try {
			table.setRowCount(0);
			ResultSet rst = KetNoiSQL.getStm().executeQuery("select * from tblDocGia");
			while (rst.next()) {
				table.addRow(new Object[] { rst.getInt(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		new GDThemTheDocGia();

	}
}

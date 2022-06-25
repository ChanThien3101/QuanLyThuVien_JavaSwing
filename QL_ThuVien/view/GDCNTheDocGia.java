package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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

public class GDCNTheDocGia extends JFrame {

	private static JTable tbl;
	private String s;
	private JFrame con2;
	private DefaultTableModel table;
	KetNoiSQL connn = new KetNoiSQL();

	public GDCNTheDocGia() {

		Container con = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(990, 500);
		setLocationRelativeTo(null);
		setTitle("LIBRARY_VKU");

		con.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setBackground(Color.cyan);
		con.add(north, "North");
		north.setLayout(new BorderLayout());

		JButton back = new JButton("BACK");
		north.add(back, "West");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDTrangChu().setVisible(true);
				dispose();
			}
		});

		JPanel center = new JPanel();
		con.add(center, "Center");
		center.setLayout(new BorderLayout());

		JPanel tieude = new JPanel();
		center.add(tieude, "North");

		JLabel tieude2 = new JLabel("CAP NHAT THE DOC GIA");
		tieude2.setForeground(Color.BLACK);
		tieude2.setFont(new Font("Tahoma", Font.BOLD, 17));
		tieude.add(tieude2);

		JPanel center2 = new JPanel();
		center.add(center2, "Center");
		center2.setLayout(new BorderLayout());

		JPanel search = new JPanel();
		center2.add(search, "North");

		JButton search2 = new JButton("SEARCH");
		search.add(search2);

		JTextField txtSearch = new JTextField(30);
		search.add(txtSearch);

		String arr[] = { "Search By Name", "Search By ID" };
		JComboBox search3 = new JComboBox(arr);
		search.add(search3);

		// tao vien ngoai
		Border boder = BorderFactory.createLineBorder(Color.red);
		TitledBorder itel = BorderFactory.createTitledBorder(boder, " Danh Sach The Doc Gia  ");
		center2.setBorder(itel);

		// tao ra 1 bang mac dinh (mô hình bảng được sử dụng bởi một JTable khi không có mô hình bảng được xác định cụ thể)
		/*
		 Lợi thế của việc sử dụng các > DefaultTableModel trên một tùy chỉnh > AbstractTableModel 
		 là bạn không phải mã các phương pháp như thêm, chèn hoặcxóa các hàng và cột. 
		 Chúng đã tồn tại để thay đổi dữ liệu được lưu giữ trong > Vector của > Vectơ. Điều này làm cho nó
		 một mô hình bảng nhanh chóng và dễ  dàng để thực hiện.
		 */
		
		table = new DefaultTableModel();
		table.addColumn("ID The");
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
		center2.add(js);
		
		loadData();

//////////////////////////////////////////////////////////////////

		JPanel south = new JPanel();
		center2.add(south, "South");

		JButton sortByName = new JButton("SORT BY NAME");
		south.add(sortByName);
		sortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setRowCount(0);
					ResultSet rst = KetNoiSQL.getStm().executeQuery("Select * from tblDocGia order by Name ");
					while (rst.next()) {
						table.addRow(
								new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
										rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		JButton sortByID = new JButton("SORT BY ID");
		south.add(sortByID);
		sortByID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setRowCount(0);
					ResultSet rst = KetNoiSQL.getStm().executeQuery("Select * from tblDocGia order by ID ");
					while (rst.next()) {
						table.addRow(
								new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
										rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		JButton edit = new JButton(" EDIT ");
		south.add(edit);
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();

			}
		});

		JButton delete = new JButton(" DELETE ");
		south.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String sql = "delete from tblDocGia where ID = " + "'" + tbl.getValueAt(tbl.getSelectedRow(), 0)
							+ "'";
					KetNoiSQL.getStm().execute(sql);
					table.removeRow(tbl.getSelectedRow());
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

/////////////////////////////////////////////////////////////////////

		search2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String data = "" + search3.getItemAt(search3.getSelectedIndex());
				if (data.contentEquals("Search By Name") == true) {
					s = "Name";
				} else if (data.contentEquals("Search By ID") == true) {
					s = "ID";
				}

				try {
					table.setRowCount(0);
					ResultSet rst = KetNoiSQL.getStm()
							.executeQuery("select * from tblDocGia where " + s + "=" + "'" + txtSearch.getText() + "'");
					while (rst.next()) {
						table.addRow(
								new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
										rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
				if(table.getRowCount()==0) {
					JOptionPane.showMessageDialog(rootPane, "Khong Tim Thay");
				}
			}

		});

		setVisible(true);
	}

/////////////////////////////////////////////////////////////////////////////////////

	public void Update() {

		con2 = new JFrame();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		con2.setSize(500, 350);
		con2.setLocationRelativeTo(null);
		con2.setTitle("LIBRARY_VKU");
		con2.setLayout(new BorderLayout());

		JPanel update = new JPanel();
		con2.add(update, "Center");
		update.setLayout(new GridLayout(7, 2));

		JLabel name = new JLabel("          TEN DOC GIA");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(name);

		JTextField txtName = new JTextField(20);
		txtName.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 1));
		update.add(txtName);

		JLabel DateOfBirth = new JLabel("          NGAY SINH:");
		DateOfBirth.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(DateOfBirth);

		JTextField txtDateOfBirth = new JTextField(20);
		txtDateOfBirth.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 2));
		update.add(txtDateOfBirth);

		JLabel phoneNumber = new JLabel("          SO DIEN THOAI:");
		phoneNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(phoneNumber);

		JTextField txtPhoneNumber = new JTextField(20);
		txtPhoneNumber.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 3));
		update.add(txtPhoneNumber);

		JLabel address = new JLabel("          DIA CHI:");
		address.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(address);

		JTextField txtAddress = new JTextField(20);
		txtAddress.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 4));
		update.add(txtAddress);

		JLabel kindOfReader = new JLabel("          LOAI DOC GIA:");
		kindOfReader.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(kindOfReader);

		String arr[] = { "Giang Vien", "Sinh Vien", "Khac" };
		JComboBox loaidocgia = new JComboBox(arr);
		update.add(loaidocgia);

		JLabel startDate = new JLabel("          NGAY DANG KY THE:");
		startDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(startDate);

		JTextField txtStartDate = new JTextField(20);
		txtStartDate.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 6));
		update.add(txtStartDate);

		JLabel endDate = new JLabel("          NGAY HET HAN:");
		endDate.setFont(new Font("Tahoma", Font.BOLD, 14));
		update.add(endDate);

		JTextField txtEndDate = new JTextField(20);
		txtEndDate.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 7));
		update.add(txtEndDate);

		con2.setVisible(true);

		JPanel btn = new JPanel();
		con2.add(btn, "South");

		JButton updates = new JButton(" UPDATE ");
		btn.add(updates);
		updates.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String data = "" + loaidocgia.getItemAt(loaidocgia.getSelectedIndex());

					String sql = "Update tblDocGia set Name = " + "'" + txtName.getText() + "'" + ", DateOfBirth=" + "'"
							+ txtDateOfBirth.getText() + "'" + ",PhoneNumber=" + "'" + txtPhoneNumber.getText() + "'"
							+ ", Address=" + "'" + txtAddress.getText() + "'" + ", KindOfReader=" + "'" + data + "'"
							+ ", StartDate=" + "'" + txtStartDate.getText() + "'" + ", EndDate=" + "'"
							+ txtEndDate.getText() + "'" + " where ID=" + "'" + tbl.getValueAt(tbl.getSelectedRow(), 0)
							+ "'";

					if (KetNoiSQL.getStm().executeUpdate(sql) == 1) {
						JOptionPane.showConfirmDialog(null, "UPDATE THANH CONG", null, JOptionPane.CLOSED_OPTION);
						table.setRowCount(0);
						loadData();
					}
					con2.dispose();
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(null, "UPDATE THAT BAI", null, JOptionPane.CLOSED_OPTION);
					e2.printStackTrace();
				}
			}
		});

		JButton cancel = new JButton(" CANCEL ");
		btn.add(cancel);
		cancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDCNTheDocGia();

			}
		});

	}

	public void loadData() {
		try {
			table.setRowCount(0);
			ResultSet rst = KetNoiSQL.getStm().executeQuery("select * from tblDocGia");
			while (rst.next()) {
				table.addRow(new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
			}
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GDCNTheDocGia();
	}

}

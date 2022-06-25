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

public class GDCNTaiLieu extends JFrame {
	private static JTable tbl;
	private String s;
	private JFrame con2;
	KetNoiSQL connn = new KetNoiSQL();
	private DefaultTableModel table;

	public GDCNTaiLieu() {

		Container con = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(980, 400);
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

		JLabel tieude2 = new JLabel("CAP NHAT TAI LIEU");
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
		Border boder = BorderFactory.createLineBorder(Color.GREEN);
		TitledBorder itel = BorderFactory.createTitledBorder(boder, " Danh Sach Tai Lieu  ");
		center2.setBorder(itel);
		table = new DefaultTableModel();
		// tao ra 1 bang mac dinh
		table.addColumn("Ma Tai Lieu");
		table.addColumn("Ten Tai Lieu");
		table.addColumn("Tac Gia");
		table.addColumn("Loai Tai Lieu");
		table.addColumn("Tinh Trang");
		table.addColumn("Nha Xuat Ban");
		table.addColumn("Gia Tien / Cuon");
		table.addColumn("So Luong Con");

		loadData();

		// tao ra 1 table chua defaultTableModel phia tren
		tbl = new JTable(table);
		// tao ra 1 khung chong tran
		JScrollPane js = new JScrollPane(tbl);
		center2.add(js);

////////////////////////////////////////////////////////////////////////		
		JPanel south = new JPanel();
		center2.add(south, "South");

		JButton sortByName = new JButton("SORT BY NAME");
		south.add(sortByName);
		sortByName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					table.setRowCount(0);
					ResultSet rst = KetNoiSQL.getStm().executeQuery("Select * from tblTaiLieu order by Name");
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
					ResultSet rst = KetNoiSQL.getStm().executeQuery("Select * from tblTaiLieu order by ID");
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

					String sql = "delete from tblTaiLieu where ID = " + "'" + tbl.getValueAt(tbl.getSelectedRow(), 0)
							+ "'";
					KetNoiSQL.getStm().execute(sql);
					table.removeRow(tbl.getSelectedRow());
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});
/////////////////////////////////////////////////////////////////
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
					ResultSet rst = KetNoiSQL.getStm().executeQuery(
							"select * from tblTaiLieu where " + s + "=" + "'" + txtSearch.getText() + "'");
					while (rst.next()) {
						table.addRow(
								new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
										rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
					}
				} catch (Exception e2) {

				}

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Khong Tim Thay");
				}

			}
		});

		setVisible(true);
	}

/////////////////////////////////////////////////////////////////////
	public void Update() {

		con2 = new JFrame();

		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		con2.setSize(500, 350);
		con2.setLocationRelativeTo(null);
		con2.setTitle("LIBRARY_VKU");
		con2.setLayout(new BorderLayout());

		JPanel edit = new JPanel();
		con2.add(edit, "Center");
		edit.setLayout(new GridLayout(7, 2));

		JLabel name = new JLabel("          TEN TAI LIEU:");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(name);

		JTextField txtName = new JTextField(20);
		txtName.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 1));
		edit.add(txtName);

		JLabel author = new JLabel("          TAC GIA:");
		author.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(author);

		JTextField txtAuthor = new JTextField(15);
		txtAuthor.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 2));
		edit.add(txtAuthor);

		JLabel kindOfDocument = new JLabel("          LOAI TAI LIEU:");
		kindOfDocument.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(kindOfDocument);

		String arr[] = { "Sach Giao Khoa", "Sach Tham Khao", "De An", "Truyen", "Bao", "Tap Chi" };
		JComboBox txtKindOfDocument = new JComboBox(arr);
		txtKindOfDocument.setSelectedItem("" + tbl.getValueAt(tbl.getSelectedRow(), 3));
		edit.add(txtKindOfDocument);

		JLabel aspect = new JLabel("          TINH TRANG:");
		aspect.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(aspect);

		JTextField txtAspect = new JTextField(15);
		txtAspect.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 4));
		edit.add(txtAspect);

		JLabel nxb = new JLabel("          NHA XUAT BAN:");
		nxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(nxb);

		JTextField txtNxb = new JTextField(15);
		txtNxb.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 5));
		edit.add(txtNxb);

		JLabel price = new JLabel("          GIA TIEN / CUON:");
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(price);

		JTextField txtPrice = new JTextField(15);
		txtPrice.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 6));
		edit.add(txtPrice);

		JLabel total = new JLabel("          SO LUONG:");
		total.setFont(new Font("Tahoma", Font.BOLD, 14));
		edit.add(total);

		JTextField txtTotal = new JTextField(15);
		txtTotal.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 7));
		edit.add(txtTotal);

		con2.setVisible(true);

		JPanel btn = new JPanel();
		con2.add(btn, "South");

		JButton update = new JButton(" UPDATE ");
		btn.add(update);
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String data = "" + txtKindOfDocument.getItemAt(txtKindOfDocument.getSelectedIndex());

					String sql = "Update tblTaiLieu  set Name =" + "'" + txtName.getText() + "'" + ", Author=" + "'"
							+ txtAuthor.getText() + "'" + " , KindOfDocument=" + "'" + data + "'" + ", Aspect=" + "'"
							+ txtAspect.getText() + "'" + ", Nxb=" + "'" + txtNxb.getText() + "'" + ", Price=" + "'"
							+ txtPrice.getText() + "'" + ", Total=" + "'" + txtTotal.getText() + "'" + " where ID="
							+ "'" + tbl.getValueAt(tbl.getSelectedRow(), 0) + "' ";

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
				new GDCNTaiLieu();
			}
		});
	}

	public void loadData() {
		try {

			table.setRowCount(0);
			ResultSet rst = KetNoiSQL.getStm().executeQuery("select * from tblTaiLieu ");

			while (rst.next()) {
				table.addRow(new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8) });
			}
		} catch (Exception e3) {
			e3.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GDCNTaiLieu();
	}

}

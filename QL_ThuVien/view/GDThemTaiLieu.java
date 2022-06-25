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

public class GDThemTaiLieu extends JFrame {

	private static JTable tbl;
	private DefaultTableModel table;
	KetNoiSQL connn = new KetNoiSQL();

	public GDThemTaiLieu() {

		Container con = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(980, 500);
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

		JLabel tieude1 = new JLabel("THEM TAI LIEU MOI");
		tieude1.setForeground(Color.BLACK);
		tieude1.setFont(new Font("Tahoma", Font.BOLD, 20));
		tieude.add(tieude1);

		JPanel center2 = new JPanel();
		center1.add(center2, "Center");
		// tao vien ngoai
		Border boder2 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder itel2 = BorderFactory.createTitledBorder(boder2, " THONG TIN TAI LIEU  ");
		center2.setBorder(itel2);

		JPanel nhap = new JPanel();
		nhap.setLayout(new GridLayout(4, 4));
		center2.add(nhap);

		JLabel name = new JLabel("       TEN TAI LIEU:");
		name.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(name);

		JTextField txtName = new JTextField(20);
		nhap.add(txtName);

		JLabel nxb = new JLabel("          NHA XUAT BAN:");
		nxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(nxb);

		JTextField txtNxb = new JTextField(20);
		nhap.add(txtNxb);

		JLabel author = new JLabel("       TAC GIA:");
		author.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(author);

		JTextField txtAuthor = new JTextField(20);
		nhap.add(txtAuthor);

		JLabel price = new JLabel("          GIA TIEN / CUON:");
		price.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(price);

		JTextField txtPrice = new JTextField(20);
		nhap.add(txtPrice);

		JLabel kindOfDocument = new JLabel("       LOAI TAI LIEU:");
		kindOfDocument.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(kindOfDocument);

		String arr[] = { "Sach Giao Khoa", "Sach Tham Khao", "De An", "Truyen", "Bao", "Tap Chi", "Khac" };
		JComboBox txtKindOfDocument = new JComboBox(arr);
		nhap.add(txtKindOfDocument);

		JLabel total = new JLabel("          SO LUONG:");
		total.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(total);

		JTextField txtTotal = new JTextField(20);
		nhap.add(txtTotal);

		JLabel aspect = new JLabel("       TINH TRANG:");
		aspect.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(aspect);

		JTextField txtAspect = new JTextField(20);
		nhap.add(txtAspect);

		JPanel east = new JPanel();
		center1.add(east, "East");
		// tao vien ngoai
		Border boder3 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder itel3 = BorderFactory.createTitledBorder(boder3, " TAC VU");
		east.setBorder(itel3);

		JPanel btn = new JPanel();
		btn.setLayout(new GridLayout(4, 1));
		east.add(btn);

		JButton moi = new JButton("NEW");
		btn.add(moi);
		moi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				txtName.setText("");
				txtAuthor.setText("");
				txtAspect.setText("");
				txtNxb.setText("");
				txtPrice.setText("");
				txtTotal.setText("");
				txtKindOfDocument.setSelectedIndex(0);
			}
		});

		JButton add = new JButton("ADD");
		btn.add(add);

		JButton edit = new JButton("EDIT");
		btn.add(edit);

		JButton delete = new JButton("DELETE");
		btn.add(delete);

		JPanel con2 = new JPanel();
		con.add(con2);
		con2.setLayout(new BorderLayout());
		// tao vien ngoai
		Border boder4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder itel4 = BorderFactory.createTitledBorder(boder4, "DANH SACH TAI LIEU");
		con2.setBorder(itel4);

		// tao ra 1 bang mac dinh (An hay ko chua biet)
		table = new DefaultTableModel();
		table.addColumn("Ma Tai Lieu");
		table.addColumn("Ten Tai Lieu");
		table.addColumn("Tac Gia");
		table.addColumn("Loai Tai Lieu");
		table.addColumn("Tinh Trang");
		table.addColumn("Nha Xuat Ban");
		table.addColumn("Gia Tien / Cuon");
		table.addColumn("So Luong");
		// tao ra 1 table chua defaultTableModel phia tren
		tbl = new JTable(table);
		// hien thi bang
		JScrollPane js = new JScrollPane(tbl);
		con2.add(js);

		setVisible(true);

		loadData();

		tbl.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {
				txtName.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 1));
				txtAuthor.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 2));
				txtKindOfDocument.setSelectedItem((String) tbl.getValueAt(tbl.getSelectedRow(), 3));
				txtAspect.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 4));
				txtNxb.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 5));
				txtPrice.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 6));
				txtTotal.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 7));

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
				try {
					table.setRowCount(0);
					String sql = "INSERT into tblTaiLieu (Name, Author, KindOfDocument, Aspect, Nxb, Price, Total) VALUES (?,?,?,?,?,?,?)";
					try {
						PreparedStatement ps = KetNoiSQL.getCon().prepareStatement(sql);
						ps.setString(1, txtName.getText());
						ps.setString(2, txtAuthor.getText());
						ps.setString(3, (String) txtKindOfDocument.getSelectedItem());
						ps.setString(4, txtAspect.getText());
						ps.setString(5, txtNxb.getText());
						ps.setFloat(6, Float.parseFloat(txtPrice.getText()));
						ps.setInt(7, Integer.parseInt(txtTotal.getText()));
						ps.executeUpdate();
						loadData();

						JOptionPane.showMessageDialog(rootPane, "Them Thanh Cong");

					} catch (Exception e2) {
						e2.printStackTrace();

						JOptionPane.showMessageDialog(rootPane, "Them That Bai");

					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String data = "" + txtKindOfDocument.getItemAt(txtKindOfDocument.getSelectedIndex());

					String sql = "Update tblTaiLieu  set Name =" + "'" + txtName.getText() + "'" + ", Author=" + "'"
							+ txtAuthor.getText() + "'" + " , KindOfDocument=" + "'" + data + "'" + ", Aspect=" + "'"
							+ txtAspect.getText() + "'" + ", Nxb=" + "'" + txtNxb.getText() + "'" + ", Price=" + "'"
							+ txtPrice.getText() + "'" + ", Total=" + "'" + txtTotal.getText() + "'" + " where ID="
							+ "'" + tbl.getValueAt(tbl.getSelectedRow(), 0) + "' ";

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
		new GDThemTaiLieu();

	}

}

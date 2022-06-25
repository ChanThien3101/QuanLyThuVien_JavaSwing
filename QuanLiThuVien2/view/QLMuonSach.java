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

import controller.KetNoi_sql;

public class QLMuonSach extends JFrame {

	private int dem = 0;

	KetNoi_sql connn = new KetNoi_sql();
	private static JTable tbl;
	private DefaultTableModel table;

	public QLMuonSach() {

		Container con = getContentPane();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1060, 500);
		setLocationRelativeTo(null);
		setTitle("LIBRARY_VKU");
		con.setLayout(new GridLayout(2, 1));

		JPanel con1 = new JPanel();
		con.add(con1);
		con1.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setBackground(Color.yellow);
		con1.add(north, "North");
		north.setLayout(new BorderLayout());

		JButton back = new JButton("BACK");
		north.add(back, "West");
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GD_TrangChu().setVisible(true);
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

		JLabel tieude1 = new JLabel("QUAN LI MUON SACH");
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
		nhap.setLayout(new GridLayout(6, 4));
		center2.add(nhap);

		JLabel idDocGia = new JLabel("ID DOC GIA:");
		idDocGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(idDocGia);

		JTextField txtIDDocGia = new JTextField(20);
		nhap.add(txtIDDocGia);

		JLabel author = new JLabel("          TAC GIA:");
		author.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(author);

		JTextField txtAuthor = new JTextField(20);
		nhap.add(txtAuthor);

		JLabel tenDocGia = new JLabel("TEN DOC GIA:");
		tenDocGia.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(tenDocGia);

		JTextField txtTenDocGia = new JTextField(20);
		nhap.add(txtTenDocGia);

		JLabel kinOfDocument = new JLabel("          LOAI TAI LIEU:");
		kinOfDocument.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(kinOfDocument);

		String arr[] = { "Sach Giao Khoa", "Sach Tham Khao", "De An", "Truyen", "Bao", "Tap Chi", "Khac" };
		JComboBox txtLoaiTaiLieu = new JComboBox(arr);
		nhap.add(txtLoaiTaiLieu);

		// String data = "" + txtLoaiTaiLieu.getSelectedItem();

		JLabel idTaiLieu = new JLabel("MA TAI LIEU:");
		idTaiLieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(idTaiLieu);

		JTextField txtidTaiLieu = new JTextField(20);
		nhap.add(txtidTaiLieu);

		JLabel aspect = new JLabel("          TINH TRANG:");
		aspect.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(aspect);

		JTextField txtAspect = new JTextField(20);
		nhap.add(txtAspect);

		JLabel nameTaiLieu = new JLabel("TEN TAI LIEU:");
		nameTaiLieu.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(nameTaiLieu);

		JTextField txtNameTaiLieu = new JTextField(20);
		nhap.add(txtNameTaiLieu);

		JLabel nxb = new JLabel("          NHA XUAT BAN:");
		nxb.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(nxb);

		JTextField txtNxb = new JTextField(20);
		nhap.add(txtNxb);

		JLabel ngayMuon = new JLabel("NGAY MUON");
		ngayMuon.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(ngayMuon);

		JTextField txtNgayMuon = new JTextField(20);
		nhap.add(txtNgayMuon);

		JLabel ngayHetHan = new JLabel("          NGAY HET HAN");
		ngayHetHan.setFont(new Font("Tahoma", Font.BOLD, 14));
		nhap.add(ngayHetHan);

		JTextField txtNgayHetHan = new JTextField(20);
		nhap.add(txtNgayHetHan);

		JPanel east = new JPanel();
		center1.add(east, "East");
		// tao vien ngoai
		Border boder3 = BorderFactory.createLineBorder(Color.BLACK);
		TitledBorder itel3 = BorderFactory.createTitledBorder(boder3, " TAC VU");
		east.setBorder(itel3);

		JPanel btn = new JPanel();
		btn.setLayout(new GridLayout(5, 1));
		east.add(btn);

		JButton moi = new JButton("NEW");
		btn.add(moi);
		moi.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtidTaiLieu.setText("");
				txtNameTaiLieu.setText("");
				txtAuthor.setText("");
				txtAspect.setText("");
				txtNxb.setText("");
				txtIDDocGia.setText("");
				txtTenDocGia.setText("");
				txtLoaiTaiLieu.setSelectedIndex(0);
				txtNgayMuon.setText("");
				txtNgayHetHan.setText("");

				txtidTaiLieu.setEditable(true);
				txtIDDocGia.setEditable(true);
			}
		});

		JButton add = new JButton("ADD");
		btn.add(add);

		JButton edit = new JButton("EDIT");
		btn.add(edit);

		JButton delete = new JButton("DELETE");
		btn.add(delete);

		JButton search = new JButton("SEARCH");
		btn.add(search);

		JPanel con2 = new JPanel();
		con.add(con2);
		con2.setLayout(new BorderLayout());
		// tao vien ngoai
		Border boder4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder itel4 = BorderFactory.createTitledBorder(boder4, "DANH SACH TAI LIEU");
		con2.setBorder(itel4);

		// tao ra 1 bang mac dinh (An hay ko chua biet)
		table = new DefaultTableModel();
		table.addColumn("ID Doc Gia");
		table.addColumn("Ten Doc Gia");
		table.addColumn("Ma Tai Lieu");
		table.addColumn("Ten Tai Lieu");
		table.addColumn("Tac Gia");
		table.addColumn("Loai Tai Lieu");
		table.addColumn("Tinh Trang");
		table.addColumn("Nha Xuat Ban");
		table.addColumn("Ngay Muon");
		table.addColumn("Ngay Het Han");

		// tao ra 1 table chua defaultTableModel phia tren
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
				txtIDDocGia.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 0));
				txtTenDocGia.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 1));
				txtidTaiLieu.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 2));
				txtNameTaiLieu.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 3));
				txtAuthor.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 4));
				txtLoaiTaiLieu.setSelectedItem((String) tbl.getValueAt(tbl.getSelectedRow(), 5));
				txtAspect.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 6));
				txtNxb.setText((String) tbl.getValueAt(tbl.getSelectedRow(), 7));
				txtNgayMuon.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 8));
				txtNgayHetHan.setText("" + tbl.getValueAt(tbl.getSelectedRow(), 9));

				txtIDDocGia.setEditable(false);
				txtidTaiLieu.setEditable(false);

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
					ResultSet rs2 = KetNoi_sql.getStm().executeQuery(
							"Select* from tblMuonSach2 Where IDDocGia=" + "'" + txtIDDocGia.getText() + "'");
					while (rs2.next()) {
						dem++;
					}
				} catch (Exception e3) {
					e3.printStackTrace();
				}

				if (dem < 3) {
					table.setRowCount(0);
					String sql = "INSERT into tblMuonSach2 ( IDDocGia, TenDocGia, MaTaiLieu, TenTaiLieu, TacGia, LoaiTaiLieu, TinhTrang, NhaXuatBan, NgayMuon, NgayHetHan) VALUES (?,?,?,?,?,?,?,?,?,?)";

					try {
						PreparedStatement ps = KetNoi_sql.getCon().prepareStatement(sql);
						ps.setString(1, txtIDDocGia.getText());
						ps.setString(2, txtTenDocGia.getText());
						ps.setString(3, txtidTaiLieu.getText());
						ps.setString(4, txtNameTaiLieu.getText());
						ps.setString(5, txtAuthor.getText());
						ps.setString(6, (String) txtLoaiTaiLieu.getSelectedItem());
						ps.setString(7, txtAspect.getText());
						ps.setString(8, txtNxb.getText());
						ps.setString(9, txtNgayMuon.getText());
						ps.setString(10, txtNgayHetHan.getText());
						ps.executeUpdate();

						loadData();
						JOptionPane.showMessageDialog(rootPane, "Them Thanh Cong");

					} catch (Exception k) {
						k.printStackTrace();
						loadData();
						JOptionPane.showMessageDialog(rootPane, "Them That Bai");

					}
				} else {

					JOptionPane.showMessageDialog(rootPane, "Da Dat Gioi Han Muon");
				}
				dem = 0;

			}
		});

		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String sql = "Update tblMuonSach2 set TenDocGia = " + "'" + txtTenDocGia.getText() + "'"
						+ ", TenTaiLieu = " + "'" + txtNameTaiLieu.getText() + "'" + ", TacGia = " + "'"
						+ txtAuthor.getText() + "'" + ", LoaiTaiLieu = " + "'" + txtLoaiTaiLieu.getSelectedItem() + "'"
						+ ", TinhTrang = " + "'" + txtAspect.getText() + "'" + ", NhaXuatBan = " + "'"
						+ txtNxb.getText() + "'" + ", NgayMuon = " + "'" + txtNgayMuon.getText() + "'"
						+ ", NgayHetHan = " + "'" + txtNgayHetHan.getText() + "' where MaTaiLieu =" + "'"
						+ tbl.getValueAt(tbl.getSelectedRow(), 2) + "'";

				try {

					if (KetNoi_sql.getStm().executeUpdate(sql) == 1) {
						JOptionPane.showMessageDialog(rootPane, "EDIT THANH CONG");
					}
					table.setRowCount(0);
					loadData();

				} catch (Exception e2) {
					e2.printStackTrace();
					JOptionPane.showMessageDialog(rootPane, "EDIT THAT BAI");
				}

			}
		});

		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String sql = "delete from tblMuonSach2 where IDDocGia = " + "'"
							+ tbl.getValueAt(tbl.getSelectedRow(), 0) + "'";
					KetNoi_sql.getStm().execute(sql);
					table.removeRow(tbl.getSelectedRow());
				} catch (Exception e2) {
					e2.printStackTrace();
				}

			}
		});

		search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ResultSet rst;

				try {
					String sql = "select * from tblMuonSach2 where IDDocGia=" + "'" + txtIDDocGia.getText() + "'"
							+ " OR TenDocGia =" + "'" + txtTenDocGia.getText() + "'" + " OR MaTaiLieu =" + "'"
							+ txtidTaiLieu.getText() + "'" + " OR TenTaiLieu =" + "'" + txtNameTaiLieu.getText() + "'"
							+ " OR TacGia =" + "'" + txtAuthor.getText() + "'" + " OR LoaiTaiLieu =" + "'"
							+ txtLoaiTaiLieu.getSelectedItem() + "'" + " OR TinhTrang =" + "'" + txtAspect.getText()
							+ "'" + " OR NhaXuatBan =" + "'" + txtNxb.getText() + "'" + "OR NgayMuon =" + "'"
							+ txtNgayMuon.getText() + "'" + " OR NgayHetHan =" + "'" + txtNgayHetHan.getText() + "'";
					rst = KetNoi_sql.getStm().executeQuery(sql);
					System.out.println(sql);
					table.setRowCount(0);
					while (rst.next()) {
						table.addRow(new Object[] { rst.getString(1), rst.getString(2), rst.getString(3),
								rst.getString(4), rst.getString(5), rst.getString(6), rst.getString(7),
								rst.getString(8), rst.getDate(9), rst.getDate(10) });

					}

				} catch (Exception e2) {
					e2.printStackTrace();
				}

				if (table.getRowCount() == 0) {
					JOptionPane.showMessageDialog(rootPane, "Khong Tim Thay");
				}

			}
		});

		setVisible(true);

	}

	public static void main(String[] args) {
		new QLMuonSach();

	}

	public void loadData() {
		try {
			// dung resulset de do du lieu ra bang
			ResultSet rst = KetNoi_sql.getStm().executeQuery("Select* from tblMuonSach2");
			while (rst.next()) {
				table.addRow(new Object[] { rst.getString(1), rst.getString(2), rst.getString(3), rst.getString(4),
						rst.getString(5), rst.getString(6), rst.getString(7), rst.getString(8), rst.getDate(9),
						rst.getDate(10) });
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}

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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

import controller.KetNoiSQL;

public class GDThongKe extends JFrame {

	KetNoiSQL conn = new KetNoiSQL();

	private int demsgk = 0, demsgk2 = 0, demstk = 0, demstk2 = 0, demdean = 0, demdean2 = 0, demtruyen = 0,
			demtruyen2 = 0, dembao = 0, dembao2 = 0, demtapchi = 0, demtapchi2 = 0, demkhac = 0, demkhac2 = 0,
			demtong = 0, demtong2 = 0;

	public GDThongKe() {
		Container con = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(700, 400);
		setLocationRelativeTo(null);
		setTitle("LYBRARY_VKU");
		con.setLayout(new BorderLayout());

		JPanel north = new JPanel();
		north.setLayout(new BorderLayout());
		north.setBackground(Color.cyan);
		con.add(north, "North");
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
		JLabel tieude1 = new JLabel("GIAO DIEN THONG KE");
		tieude1.setForeground(Color.BLACK);
		tieude1.setFont(new Font("Tahoma", Font.BOLD, 20));
		tieude.add(tieude1);

		JPanel center2 = new JPanel();
		center.add(center2, "Center");
		center2.setLayout(new GridLayout(1, 2));
		// ben trai
		JPanel trongkho = new JPanel();
		center2.add(trongkho);
		trongkho.setLayout(new GridLayout(8, 1));

		Border boder1 = BorderFactory.createLineBorder(Color.blue);
		TitledBorder titel1 = BorderFactory.createTitledBorder(boder1, " Thong Ke Tai Lieu Con Trong Thu Vien");
		trongkho.setBorder(titel1);

		LoadTaiLieu();

		JLabel sgk = new JLabel("Tong So Sach Giao Khoa : " + demsgk);
		trongkho.add(sgk);

		JLabel stk = new JLabel("Tong So Sach Tham Khao : " + demstk);
		trongkho.add(stk);

		JLabel dean = new JLabel("Tong So De An : " + demdean);
		trongkho.add(dean);

		JLabel truyen = new JLabel("Tong So Truyen : " + demtruyen);
		trongkho.add(truyen);

		JLabel bao = new JLabel("Tong So Bao : " + dembao);
		trongkho.add(bao);

		JLabel tapchi = new JLabel("Tong So Tap Chi : " + demtapchi);
		trongkho.add(tapchi);

		JLabel khac = new JLabel("Tong So Tai Lieu Khac : " + demkhac);
		trongkho.add(khac);

		JLabel all = new JLabel("TONG SO TAT CA TAI LIEU : " + demtong);
		all.setForeground(Color.red);
		trongkho.add(all);

		JPanel muon = new JPanel();
		center2.add(muon);
		muon.setLayout(new GridLayout(8, 1));

		Border border2 = BorderFactory.createLineBorder(Color.red);
		TitledBorder titel2 = BorderFactory.createTitledBorder(border2, "Thong Ke Tai Lieu Da Cho Muon");
		muon.setBorder(titel2);

		JLabel sgk2 = new JLabel("Tong So Sach Giao Khoa : " + demsgk2);
		muon.add(sgk2);

		JLabel stk2 = new JLabel("Tong So Sach Tham Khao : " + demstk2);
		muon.add(stk2);

		JLabel dean2 = new JLabel("Tong So De An : " + demdean2);
		muon.add(dean2);

		JLabel truyen2 = new JLabel("Tong So Truyen : " + demtruyen2);
		muon.add(truyen2);

		JLabel bao2 = new JLabel("Tong So Bao : " + dembao2);
		muon.add(bao2);

		JLabel tapchi2 = new JLabel("Tong So Tap Chi : " + demtapchi2);
		muon.add(tapchi2);

		JLabel khac2 = new JLabel("Tong So Tai Lieu Khac : " + demkhac2);
		muon.add(khac2);

		JLabel all2 = new JLabel("TONG SO TAT CA TAI LIEU : " + demtong2);
		all2.setForeground(Color.blue);
		muon.add(all2);

//		JPanel south = new JPanel();
//		center.add(south, "South");
//		
//		JButton reset = new JButton("RESET");
//		south.add(reset);

		setVisible(true);
	}

	public void LoadTaiLieu() {
		try {
			ResultSet rst1 = KetNoiSQL.getStm()
					.executeQuery("select * from tblTaiLieu where KindOfDocument = 'Sach Giao Khoa'");
			while (rst1.next()) {
				demsgk += rst1.getInt(8);
			}

			ResultSet rst2 = KetNoiSQL.getStm()
					.executeQuery("select * from tblTaiLieu where KindOfDocument = 'Sach Tham Khao'");
			while (rst2.next()) {
				demstk += rst2.getInt(8);
			}

			ResultSet rst3 = KetNoiSQL.getStm().executeQuery("select * from tblTaiLieu where KindOfDocument = 'De An'");
			while (rst3.next()) {
				demdean += rst3.getInt(8);
			}

			ResultSet rst4 = KetNoiSQL.getStm()
					.executeQuery("select * from tblTaiLieu where KindOfDocument = 'Truyen'");
			while (rst4.next()) {
				demtruyen += rst4.getInt(8);
			}

			ResultSet rst5 = KetNoiSQL.getStm().executeQuery("select * from tblTaiLieu where KindOfDocument = 'Bao'");
			while (rst5.next()) {
				dembao += rst5.getInt(8);
			}

			ResultSet rst6 = KetNoiSQL.getStm()
					.executeQuery("select * from tblTaiLieu where KindOfDocument = 'Tap Chi'");
			while (rst6.next()) {
				demtapchi += rst6.getInt(8);
			}

			ResultSet rst7 = KetNoiSQL.getStm().executeQuery("select * from tblTaiLieu where KindOfDocument = 'Khac'");
			while (rst7.next()) {
				demkhac += rst7.getInt(8);
			}

			ResultSet rst8 = KetNoiSQL.getStm().executeQuery("select * from tblTaiLieu");
			while (rst8.next()) {
				demtong += rst8.getInt(8);
			}

			ResultSet rst9 = KetNoiSQL.getStm()
					.executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Sach Giao Khoa'");
			while (rst9.next()) {
				demsgk2++;
			}

			ResultSet rst10 = KetNoiSQL.getStm()
					.executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Sach Tham Khao'");
			while (rst10.next()) {
				demstk2++;
			}

			ResultSet rst11 = KetNoiSQL.getStm().executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'De An'");
			while (rst11.next()) {
				demdean2++;
			}

			ResultSet rst12 = KetNoiSQL.getStm().executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Truyen'");
			while (rst12.next()) {
				demtruyen2++;
			}

			ResultSet rst13 = KetNoiSQL.getStm().executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Bao'");
			while (rst13.next()) {
				dembao2++;
			}

			ResultSet rst14 = KetNoiSQL.getStm()
					.executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Tap Chi'");
			while (rst14.next()) {
				demtapchi2++;
			}

			ResultSet rst15 = KetNoiSQL.getStm().executeQuery("select * from tblMuonSach where LoaiTaiLieu = 'Khac'");
			while (rst15.next()) {
				demkhac2++;
			}

			ResultSet rst16 = KetNoiSQL.getStm().executeQuery("select * from tblMuonSach");
			while (rst16.next()) {
				demtong2++;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new GDThongKe();
	}
}

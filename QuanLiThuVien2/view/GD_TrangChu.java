package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GD_TrangChu extends JFrame {

	private JPanel con;

	public static void main(String[] args) {
		GD_TrangChu x = new GD_TrangChu();
		x.setVisible(true);
	}

	public GD_TrangChu() {

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		con = new JPanel();
		con.setBackground(Color.GREEN);
		con.setBorder(new EmptyBorder(5, 5, 5, 5));
		con.setLayout(new BorderLayout(0, 0));
		setContentPane(con);
		setLocationRelativeTo(null);

		JLabel con1 = new JLabel("Giao Dien Trang Chu");
		con1.setForeground(Color.RED);
		con1.setHorizontalAlignment(SwingConstants.CENTER);
		con1.setFont(new Font("Tahoma", Font.BOLD, 23));
		con.add(con1, BorderLayout.NORTH);

		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		con.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(5, 1));

		JLabel lb2 = new JLabel("                               ");
		panel.add(lb2);

		JButton btnquanlitailieu = new JButton("QUAN LI TAI LIEU");
		btnquanlitailieu.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnquanlitailieu);
		btnquanlitailieu.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new QLTaiLieu().setVisible(true);
				dispose();
			}
		});

		JButton btnquanlimuonsach = new JButton("QUAN LI MUON SACH");
		btnquanlimuonsach.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnquanlimuonsach);
		btnquanlimuonsach.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new QLMuonSach().setVisible(true);
				dispose();
			}
		});

		JButton btnthoat = new JButton("THOAT");
		btnthoat.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel.add(btnthoat);
		btnthoat.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				new GD_DangNhap().setVisible(true);
				dispose();
			}
		});

		JPanel pn1 = new JPanel();
		pn1.setBackground(Color.YELLOW);
		con.add(pn1, BorderLayout.WEST);

		JLabel lbWest = new JLabel("                               ");
		pn1.add(lbWest);

		JPanel pn2 = new JPanel();
		pn2.setBackground(Color.YELLOW);
		con.add(pn2, BorderLayout.EAST);

		JLabel lbEast = new JLabel("                               ");
		pn2.add(lbEast);
	}

}

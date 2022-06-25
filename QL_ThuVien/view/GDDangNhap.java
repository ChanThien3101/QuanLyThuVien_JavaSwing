package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class GDDangNhap extends JFrame implements ActionListener {
	String s1 = "chanthien";
	String s2 = "123456";

	public GDDangNhap() {
		super();

		Container con = getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 160);
		setLocationRelativeTo(null);
		// setUndecorated(true);

		con.setLayout(new BorderLayout());
		setTitle("LIBRARY_VKU");

		JPanel a = new JPanel();
		a.setBackground(Color.cyan);
		con.add(a, "North");

		JLabel tieude = new JLabel("QUAN LI THU VIEN");
		tieude.setForeground(Color.black);
		tieude.setFont(new Font("Tahoma", Font.BOLD, 17));
		a.add(tieude);

		JPanel b = new JPanel();
		b.setBackground(Color.cyan);
		con.add(b, "Center");

		JPanel tkmk = new JPanel();
		tkmk.setBackground(Color.cyan);
		tkmk.setLayout(new GridLayout(2, 2));
		b.add(tkmk, "Center");

		JLabel user = new JLabel("USER NAME:");
		user.setFont(new Font("Tahoma", Font.BOLD, 14));
		tkmk.add(user);

		JTextField nuser = new JTextField(20);
		tkmk.add(nuser);

		JLabel pass = new JLabel("PASSWORD:");
		pass.setFont(new Font("Tahoma", Font.BOLD, 14));
		tkmk.add(pass);

		JPasswordField npass = new JPasswordField(20);
		tkmk.add(npass);

		JPanel c = new JPanel();
		c.setBackground(Color.cyan);
		con.add(c, "South");

		JButton login = new JButton("LOGIN");
		login.setBackground(Color.WHITE);
		login.setFont(new Font("Tahoma", Font.BOLD, 12));
		c.add(login);
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (nuser.getText().equalsIgnoreCase(s1) && npass.getText().equalsIgnoreCase(s2)) {
					JOptionPane.showMessageDialog(null, " Welcome " + s1, "Sucessful", JOptionPane.INFORMATION_MESSAGE);
					dispose();
					GDTrangChu x = new GDTrangChu();
					x.setLocationRelativeTo(null);
					x.setVisible(true);

				} else
					JOptionPane.showMessageDialog(null, " Dang Nhap That Bai ", "Fail",
							JOptionPane.INFORMATION_MESSAGE);
			}
		});

		JButton exit = new JButton("EXIT");
		exit.addActionListener(this);
		exit.setFont(new Font("Tahoma", Font.BOLD, 12));
		c.add(exit);

		setVisible(true);
		setResizable(false);

	}

	public void actionPerformed(ActionEvent e) {
		if ("EXIT".equals(e.getActionCommand())) {

			if (JOptionPane.showConfirmDialog(rootPane, "Ban co chac chan muon thoat?", "Loign System",
					JOptionPane.YES_NO_OPTION) == JOptionPane.YES_NO_OPTION) {
				System.exit(0);
			}
		}

	}

	public static void main(String[] args) {
		new GDDangNhap();
	}

}

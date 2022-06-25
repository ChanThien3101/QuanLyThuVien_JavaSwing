package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class GDTrangChu extends JFrame {

	public GDTrangChu() {

		Container con = getContentPane();
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1170, 530);
		setLocationRelativeTo(null);
		setTitle("LIBRARY_VKU");
		con.setLayout(new BorderLayout());

		// tao vien ngoai
		Border boder = BorderFactory.createLineBorder(Color.RED);
		((JComponent) con).setBorder(boder);

		// o giua
		JPanel center = new JPanel();
		con.add(center, "Center");

		JLabel anhnen = new JLabel();
		center.add(anhnen);
		anhnen.setIcon(new ImageIcon("C:\\Users\\KIM ANH\\Pictures\\anhdean\\thuvien3.png"));

		// phia ben trai
		JPanel west = new JPanel();
		con.add(west, "West");
		west.setLayout(new BorderLayout());

		// tao vien ngoai
		Border boder2 = BorderFactory.createLineBorder(Color.BLACK);
		west.setBorder(boder2);

		JPanel centerWest = new JPanel();
		west.add(centerWest, "Center");
		centerWest.setLayout(new GridLayout(6, 1));

		JPanel tacvu = new JPanel();
		tacvu.setBackground(Color.cyan);
		centerWest.add(tacvu);

		JLabel tacvu2 = new JLabel("     QUAN LI TAC VU     ");
		tacvu2.setFont(new Font("Tahoma", Font.BOLD, 17));
		tacvu.add(tacvu2);

		JPanel a = new JPanel();
		centerWest.add(a);

		JButton themTheDocGia = new JButton("     THEM THE DOC GIA    ");
		a.add(themTheDocGia);
		themTheDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDThemTheDocGia().setVisible(true);
				dispose();

			}
		});

		JPanel b = new JPanel();
		centerWest.add(b);

		JButton capNhatTheDocGia = new JButton("CAP NHAT THE DOC GIA ");
		b.add(capNhatTheDocGia);
		capNhatTheDocGia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDCNTheDocGia().setVisible(true);
				dispose();

			}
		});

		JPanel c = new JPanel();
		centerWest.add(c);

		JButton themTaiLieu = new JButton("    THEM TAI LIEU MOI     ");
		c.add(themTaiLieu);
		themTaiLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDThemTaiLieu().setVisible(true);
				dispose();

			}
		});

		JPanel d = new JPanel();
		centerWest.add(d);

		JButton capNhatTaiLieu = new JButton("     CAP NHAT TAI LIEU     ");
		d.add(capNhatTaiLieu);
		capNhatTaiLieu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDCNTaiLieu().setVisible(true);
				dispose();

			}
		});

		JPanel e = new JPanel();
		centerWest.add(e);

		JButton quanlimuon = new JButton("   QUAN LI MUON SACH   ");
		e.add(quanlimuon);
		quanlimuon.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDQLMuonSach().setVisible(true);
				dispose();

			}
		});

		// phia ben phai
		JPanel east = new JPanel();
		con.add(east, "East");
		east.setLayout(new BorderLayout());

		// tao vien ngoai
		Border boder3 = BorderFactory.createLineBorder(Color.BLACK);
		east.setBorder(boder3);

		JPanel centerEast = new JPanel();
		east.add(centerEast, "Center");
		centerEast.setLayout(new GridLayout(6, 1));

		JPanel hotro = new JPanel();
		hotro.setBackground(Color.cyan);
		centerEast.add(hotro);

		JLabel hotro2 = new JLabel(" TRUNG TAM TRO GIUP ");
		hotro2.setFont(new Font("Tahoma", Font.BOLD, 17));
		hotro.add(hotro2);

		JPanel gioithieu = new JPanel();
		centerEast.add(gioithieu);

		JButton gioithieu2 = new JButton("   GIOI THIEU VE THU VIEN    ");
		gioithieu.add(gioithieu2);
		gioithieu2.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				gioithieu();
			}
		});

		JPanel thongke = new JPanel();
		centerEast.add(thongke);

		JButton thongke2 = new JButton("        THONG KE TAI LIEU       ");
		thongke.add(thongke2);
		thongke2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDThongKe().setVisible(true);
				dispose();
			}
		});

		JPanel bcsc = new JPanel();
		centerEast.add(bcsc);

		JButton bcsc2 = new JButton("          BAO CAO SU CO           ");
		bcsc.add(bcsc2);
		bcsc2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String URL = "mailto:dhduc.20it5@vku.udn.vn";
					Runtime run = Runtime.getRuntime();
					run.exec("rundll32 url.dll,FileProtocolHandler " + URL);
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});

		JPanel hoidap = new JPanel();
		centerEast.add(hoidap);

		JButton hoidap2 = new JButton("                HOI & DAP                ");
		hoidap.add(hoidap2);
		hoidap2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String URL = "https://m.me/100989705352012";
					Runtime run = Runtime.getRuntime();
					run.exec("rundll32 url.dll,FileProtocolHandler " + URL);
				} catch (Exception e2) {

				}
			}
		});

		JPanel thoat = new JPanel();
		centerEast.add(thoat);

		JButton thoat2 = new JButton("                    THOAT                   ");
		thoat.add(thoat2);
		thoat2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new GDDangNhap().setVisible(true);
				dispose();

			}
		});

		setVisible(true);
	}

	public void gioithieu() {
		JFrame con2 = new JFrame();
		con2.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		con2.setSize(1200, 800);
		con2.setLocationRelativeTo(null);
		con2.setTitle("LIBRARY_VKU");
		con2.setLayout(new BorderLayout());

		JPanel gioithieu2 = new JPanel();
		con2.add(gioithieu2);
		JTextArea gioithieu3 = new JTextArea("" + "\r\n" + "Giới Thiệu Về Thư Viện VKU:\r\n" + "\r\n" + "Chức năng:\r\n"
				+ "\r\n"

				+ "Thư viện là trung tâm thông tin, trung tâm văn hóa, khoa học của trường ĐH CNTT & TT VH. Thư viện có chức năng cung cấp tri thức và thông tin – tư liệu về các lĩnh vực CNTT & TT trong và ngoài nước, \r\n"
				+ "phục vụ hoạt động đào tạo, nghiên cứu khoa học của trường. Thư viện có trách nhiệm tổ chức, quản lý, bổ sung,\r\n"
				+ " thu thập, bảo quản các tài liệu, sách, báo, tạp chí, băng, đĩa, các luận án đã bảo vệ tại trường, các ấn phẩm của trường và các tài liệu lưu trữ khác, hướng dẫn và quản lý công tác quyền sở hữu trí tuệ của trường.\r\n"
				+ "\r\n" + "Nhiệm vụ:\r\n" + "\r\n"
				+ "1. Nghiên cứu đề xuất phương hướng, chủ trương, kế hoạch phát triển nguồn tài nguyên thông tin về các lĩnh vực CNTT & TT trong và ngoài nước phù hợp với nhiệm vụ đào tạo của trường ĐH CNTT & TT VH\r\n"
				+ " đồng thời chịu trách nhiệm bảo quản nguồn tài nguyên thông tin đó.\r\n" + "\r\n"
				+ "2. Tổ chức cho đội ngũ giảng viên, cán bộ công nhân viên, nghiên cứu sinh, học viên cao học, sinh viên của trường khai thác, sử dụng thuận lợi và có hiệu quả  nguồn tài nguyên thông tin do thư viện quản lý:\r\n"
				+ "\r\n"
				+ "           - Tổ chức kho mở theo môn loại tri thức, phân loại và sắp xếp tài liệu theo từng chuyên ngành khoa học - công nghệ;\r\n"
				+ "\r\n"
				+ "           - Xây dựng và hoàn thiện bộ máy tra cứu điện tử để bạn đọc - người dùng tin tìm tài liệu nhanh chóng;\r\n"
				+ "\r\n" + "           - Thông báo kịp thời những tài liệu mới, nguồn tin mới;\r\n" + "\r\n"
				+ "           - Tổ chức các hình thức tuyên truyền, giới thiệu rộng rãi các tài liệu, sách báo, tạp chí, các nguồn tin điện tử;\r\n"
				+ "\r\n"
				+ "           - Tổ chức các CSDL giáo trình, tài liệu tham khảo phục vụ đào tạo theo học chế tín chỉ.           \r\n"
				+ "\r\n"
				+ "           - Biên soạn các loại hình thư mục, ấn phẩm thông tin phục vụ công tác nghiên cứu khoa học, đào tạo và tự học;\r\n"
				+ "\r\n"
				+ "         - Tổ chức hệ thống các phòng phục vụ: phòng đọc sách, báo - tạp chí tại chỗ, phòng mượn, phòng tra cứu dữ liệu, phòng đọc đa phương tiện, phòng đọc tài liệu hạn chế ....\r\n"
				+ "\r\n"
				+ "3. Tổng kết kinh nghiệm thực tiễn và nghiên cứu những vấn đề lý luận của công tác thư viện - thư mục - thông tin trong nước và ngoài nước để góp phần xây dựng lý luận thư viện học, thư mục học và thông tin học của Việt Nam.\r\n"
				+ "\r\n"
				+ "4. Có quy hoạch, kế hoạch đào tạo đội ngũ cán bộ thư viện trở thành các chuyên gia thông tin; chủ động thường xuyên tổ chức bồi dưỡng nâng cao trình độ chuyên môn nghiệp vụ, ngoại ngữ, công nghệ thông tin ... \r\n"
				+ "cho cán bộ thư viện để không ngừng nâng cao chất lượng và hiệu quả phục vụ.\r\n" + "\r\n"
				+ "5. Đặt quan hệ đối ngoại với thư viện các nước để trao đổi tài liệu, kinh nghiệm chuyên môn nghiệp vụ. Tăng cường mở rộng quan hệ hợp tác quốc tế với thư viện đại học nước ngoài.\r\n"
				+ "\r\n"
				+ "6. Có trách nhiệm phối hợp, hợp tác tốt về mặt nghiệp vụ với các thư viện, Trung tâm thông tin lớn ở trung ương như Viện Thông tin CNTT VN, Trung tâm thông tin CNTT & TT quốc gia và Liên hiệp Thư viện các trường đại học;\r\n"
				+ " liên thông với hệ thống thông tin-thư viện của cả nước.\r\n" + "\r\n"
				+ "7. Thu nhận những ấn phẩm do trường xuất bản, các luận văn cao học, luận án tiến sĩ được bảo vệ tại trường hoặc người viết luận văn, luận án là cán bộ của trường.\r\n"
				+ "\r\n" + "8. Kiểm kê tài liệu theo định kỳ hàng năm.\r\n" + "\r\n"
				+ "9. Phối hợp chặt chẽ với các Khoa, các phòng ban chức năng trong trường để hoàn thành tốt nhiệm vụ được giao.");
		gioithieu2.add(gioithieu3);
		gioithieu3.setEditable(false);
		con2.setVisible(true);

	}

	public static void main(String[] args) {
		new GDTrangChu();
	}

}

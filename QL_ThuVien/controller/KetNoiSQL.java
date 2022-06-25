package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class KetNoiSQL {
	private static Connection con;
	private static Statement stm;

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		KetNoiSQL.con = con;
	}

	public static Statement getStm() {
		return stm;
	}

	public static void setStm(Statement stm) {
		KetNoiSQL.stm = stm;
	}

	public KetNoiSQL() {
		super();

		// thiet lap ket noi
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-NJA9E1D:1433;databaseName=DeAn_JaVa_N1;integratedSecurity=true";
			con = DriverManager.getConnection(connectionURL, "sa", "songdeyeuthuong2002");
			KetNoiSQL.stm = KetNoiSQL.con.createStatement();
		} catch (Exception e) {

		}

	}
//	public ArrayList<TaiLieu> selectQuery() {
//		ArrayList<TaiLieu> list = new ArrayList<>();
//		String sql = "SELECT * from tblTaiLieu";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ResultSet rs = ps.executeQuery();
//			// tap ket qua nhan duoc tu cau truy van ma chung ta truyen vao
//			while(rs.next()) {
//				TaiLieu t = new TaiLieu();
//				t.setId(rs.getString(1));
//				t.setName(rs.getString(2));
//				t.setAuthor(rs.getString(3));
//				t.setKindOfDocument(rs.getString(4));
//				t.setAspect(rs.getString(5));
//				t.setNxb(rs.getString(6));
//				t.setPrice(rs.getFloat(7));
//				t.setTotal(rs.getInt(8));
//				list.add(t);
//			}
//				
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return list;
//	}
//	public boolean addNewDocument(TaiLieu t) {
//		String sql = "INSERT into tblTaiLieu ( ID, Name, Author, KindOfDocument, Aspect, Nxb, Price, Total) VALUES (?,?,?,?,?,?,?,?)";
//		try {
//			PreparedStatement ps = con.prepareStatement(sql);
//			ps.setString(1, t.getId());
//			ps.setString(2, t.getName());
//			ps.setString(3, t.getAuthor());
//			ps.setString(4, t.getKindOfDocument());
//			ps.setString(5, t.getAspect());
//			ps.setString(6, t.getNxb());
//			ps.setFloat(7, t.getPrice());
//			ps.setInt(8, t.getTotal());
//			ps.executeUpdate();
//						
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		
//		return false;
//		
//	}

}

package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class KetNoi_sql {
	private static Connection con;
	private static Statement stm;

	public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		KetNoi_sql.con = con;
	}

	public static Statement getStm() {
		return stm;
	}

	public static void setStm(Statement stm) {
		KetNoi_sql.stm = stm;
	}

	public KetNoi_sql() {
		super();

		// thiet lap ket noi
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			String connectionURL = "jdbc:sqlserver://DESKTOP-NJA9E1D:1433;databaseName=DeAn_JaVa_N1;integratedSecurity=true";
			con = DriverManager.getConnection(connectionURL, "sa", "songdeyeuthuong2002");
			KetNoi_sql.stm = KetNoi_sql.con.createStatement();
		} catch (Exception e) {

		}

	}

}

package model;

import java.sql.*;

public class DataBase {
	String URL, user, pass;
	Connection con;
	Statement stmt;
	ResultSet rs;
	
	public DataBase() {
		URL = "jdbc:mysql://localhost/negocio";
		user = "root";
		pass = "root";
	}
	
	public void Abrir() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL, user, pass);
			stmt = con.createStatement();
		} catch(Exception e) {
			System.out.println("ERROR DE CONEXION: "+e.toString());
		}
	}
	
	public void Cerrar() {
		try {
			if (rs != null) {
				rs.close();
				stmt.close();
				con.close();
			}
		} catch (Exception e) {
			System.out.println("ERROR AL CERRAR LA CONEXIÓN: "+e.toString());
		}
	}
	
	public ResultSet ExecuteQuery(String sql) {
		try {
			Abrir();
			rs = stmt.executeQuery(sql);
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
		}
		 return rs;
	}
	
	public void ExecuteUpdate(String sql) {
		try {
			Abrir();
			stmt.executeUpdate(sql);
		} catch (Exception e) {
			System.out.println("ERROR: "+e.toString());
		}
	}
	
	public Connection Con() {
		Abrir();
		return con;
	}
}

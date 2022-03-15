package conexiones;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class Conexiones {
	private static ConfigDir config;
	private static Statement stmt;
	private static ResultSet rs;
	private static Connection con;
	private static String queryList;
	private static String queryAdd;
	private static String queryDelete;
	private static String queryUpdate;
	private static String querySQL;
	private Scanner sc;

	public Conexiones(ConfigDir config) throws SQLException {
		// TODO Auto-generated constructor stubç
		sc = new Scanner(System.in);
		this.config = config;
		ArrayList<String> datos = config.getData();
		con = DriverManager.getConnection(datos.get(0), datos.get(1), datos.get(2));
		queryList = datos.get(3);
		queryAdd= datos.get(4);
		queryDelete = datos.get(5);
		queryUpdate= datos.get(6);
		querySQL= datos.get(7);
	}

	public void getData() throws SQLException {
		stmt = con.createStatement();
		rs = stmt.executeQuery(queryList);

		boolean r = rs.next();
		while (r) {
			System.out.println("ID: " + rs.getString("ID"));
			System.out.println("Perimetro: " + rs.getString("perimetro"));
			System.out.println("Area: " + rs.getString("area"));
			System.out.println("-------------------------------------------");
			r = rs.next();
		}
	}

	public void insertData(int id, double perimetro, double area) throws SQLException {
		PreparedStatement ps;
		ps = con.prepareStatement(queryAdd);
		ps.setInt(1, id);
		ps.setDouble(2, perimetro);
		ps.setDouble(3, area);
		ps.executeUpdate();
	}
	public void modificarEntrada(int id, double nuevoPerimetro, double nuevoArea) throws SQLException {
		PreparedStatement ps = con.prepareStatement(queryUpdate);
		ps.setDouble(1, nuevoPerimetro);
		ps.setDouble(2, nuevoArea);
		ps.setInt(3, id);
		ps.executeUpdate();
	}
	
	
	public void deleteData(int id) throws SQLException {
		PreparedStatement ps = con.prepareStatement(queryDelete);
		ps.setInt(1, id);
		ps.executeUpdate();
	}

}

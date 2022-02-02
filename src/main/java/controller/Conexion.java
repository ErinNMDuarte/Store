package controller;

import java.sql.*;

import javax.swing.JOptionPane;

public class Conexion {
	Connection cnn;
	
	public Connection conexionbd() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			try {
				cnn=DriverManager.getConnection("jdbc:mysql://localhost/tienda","root","");
				JOptionPane.showMessageDialog(null, "conexion ok");
				} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cnn;
		
	}
}

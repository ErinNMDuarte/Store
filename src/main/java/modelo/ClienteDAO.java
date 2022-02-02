package modelo;

import java.sql.*;
import java.util.ArrayList;

import controller.Conexion;

public class ClienteDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ClienteDTO clidto;
	
	public boolean insertarcli(ClienteDTO cli) {
		int r;
		boolean dat=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO clientes Values(?,?,?,?,?)");
			ps.setInt(1, cli.getDoccli());
			ps.setString(2, cli.getNomcli());
			ps.setString(3, cli.getDircli());
			ps.setString(4, cli.getTelcli());
			ps.setString(5, cli.getEmailcli());
			r=ps.executeUpdate();
			if(r>0) {
				dat=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dat;
		
	}
	public ClienteDTO consultarcli(ClienteDTO doc) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, doc.getDoccli());
			rs=ps.executeQuery();
			if(rs.next()) {
				clidto=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return clidto;
		
	}
	
	public int actualizarcli(ClienteDTO cli) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE clientes SET nombre_cliente=?, direccion_cliente=?, telefono_cliente=?, correo_cliente=? WHERE cedula_cliente=?");
			ps.setString(1, cli.getNomcli());
			ps.setString(2, cli.getDircli());
			ps.setString(3, cli.getTelcli());
			ps.setString(4, cli.getEmailcli());
			ps.setInt(5, cli.getDoccli());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public int eliminarcli(ClienteDTO cli) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM clientes WHERE cedula_cliente=?");
			ps.setInt(1, cli.getDoccli());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public ArrayList<ClienteDTO> consultageneralcliente(){
		ArrayList<ClienteDTO> lista=new ArrayList<ClienteDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM clientes");
			rs=ps.executeQuery();
			while(rs.next()) {
				clidto=new ClienteDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(clidto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
	}
	

}

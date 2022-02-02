package modelo;

import java.sql.*;
import java.util.ArrayList;

import controller.Conexion;

public class UsuarioDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	UsuarioDTO usdto;
	
	public boolean insertarus(UsuarioDTO us) {
		int r;
		boolean dat=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO usuarios Values(?,?,?,?,?)");
			ps.setInt(1, us.getDocus());
			ps.setString(3, us.getNomus());
			ps.setString(2, us.getEmailus());
			ps.setString(4, us.getUs());
			ps.setString(5, us.getPassus());
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
	public UsuarioDTO consultarus(UsuarioDTO doc) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, doc.getDocus());
			rs=ps.executeQuery();
			if(rs.next()) {
				usdto=new UsuarioDTO(rs.getInt(1),rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return usdto;		
	}
	
	public int actualizarus(UsuarioDTO usu) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE usuarios SET correo_usuario=?, nombre_usuario=?, usuario=?, contrasena=? WHERE cedula_usuario=?");
			ps.setString(1, usu.getEmailus());
			ps.setString(2, usu.getNomus());
			ps.setString(3, usu.getUs());
			ps.setString(4, usu.getPassus());
			ps.setInt(5, usu.getDocus());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
		
	}
	public int eliminarus(UsuarioDTO usu) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM usuarios WHERE cedula_usuario=?");
			ps.setInt(1, usu.getDocus());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	
	public ArrayList<UsuarioDTO> consultageneralusuario(){
		ArrayList<UsuarioDTO> lista=new ArrayList<UsuarioDTO>();
		try {
			ps=cnn.prepareStatement("SELECT * FROM usuarios");
			rs=ps.executeQuery();
			while(rs.next()) {
				usdto=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				lista.add(usdto);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return lista;
				
		
	}
	
	
	
}


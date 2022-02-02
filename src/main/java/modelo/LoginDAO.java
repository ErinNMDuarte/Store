package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Conexion;

public class LoginDAO {
	
	PreparedStatement ps;
	ResultSet rs;
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	
	public UsuarioDTO login(UsuarioDTO us) {
		UsuarioDTO u=null;
		
		try {
			String sql="SELECT * FROM usuarios WHERE usuario=? and contrasena=?";
			ps=cnn.prepareStatement(sql);
			ps.setString(1, us.getUs());
			ps.setString(2, us.getPassus());
			rs=ps.executeQuery();
			
			if(rs.next()) {
				u=new UsuarioDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return u;
		
	}

}

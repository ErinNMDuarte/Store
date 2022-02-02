package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.Conexion;

public class ProductoDAO {
	
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProductoDTO produdto;
	
	public boolean cargarcredito(String URL) {
		
		JOptionPane.showMessageDialog(null, "en dao"+URL);
		boolean result=false;
		try {
			ps=cnn.prepareStatement("load data infile '"+URL+"' into table productos fields terminated by ';' lines terminated by '\r\n';");
			result=ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Error al registrar productos"+e);
		}
		
		return result;
		
	}
	public ProductoDTO consultarprodu(ProductoDTO pro) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM productos WHERE codigo_producto=?");
			ps.setInt(1, pro.getCodpro());
			rs=ps.executeQuery();
			if(rs.next()) {
				produdto=new ProductoDTO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getInt(5), rs.getInt(6));
			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return produdto;
	}
	
	

}

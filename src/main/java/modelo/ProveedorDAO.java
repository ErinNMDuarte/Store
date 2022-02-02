package modelo;

import java.sql.*;

import controller.Conexion;

public class ProveedorDAO {
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	PreparedStatement ps;
	ResultSet rs;
	ProveedorDTO prodto;
	
	public boolean insertarpro(ProveedorDTO pro) {
		int r;
		boolean dat=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO proveedores Values(?,?,?,?,?)");
			ps.setInt(1, pro.getNitpro());
			ps.setString(2, pro.getNompro());
			ps.setString(3, pro.getDirpro());
			ps.setInt(4, pro.getTelpro());
			ps.setString(5, pro.getCitypro());
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
	
	public ProveedorDTO consultarpro(ProveedorDTO nit) {
		try {
			ps=cnn.prepareStatement("SELECT * FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, nit.getNitpro());
			rs=ps.executeQuery();
			if(rs.next()) {
				prodto=new ProveedorDTO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));

			}
			else {
				return null;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prodto;
		
	}
	public int actualizarpro(ProveedorDTO pro) {
		int x=0;
		try {
			ps=cnn.prepareStatement("UPDATE proveedores SET nombre_proveedor=?, direccion_proveedor=?, telefono_proveedor=?, ciudad_proveedor=? WHERE nitproveedor=?");
			ps.setString(1, pro.getNompro());
			ps.setString(2, pro.getDirpro());
			ps.setInt(3, pro.getTelpro());
			ps.setString(4, pro.getCitypro());
			ps.setInt(5, pro.getNitpro());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	public int eliminarpro(ProveedorDTO pro) {
		int x=0;
		try {
			ps=cnn.prepareStatement("DELETE FROM proveedores WHERE nitproveedor=?");
			ps.setInt(1, pro.getNitpro());
			x=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return x;
	}
	

}

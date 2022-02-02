package modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

import controller.Conexion;

public class DetalleVentaDAO {
	
	PreparedStatement ps=null;
	Resultset rs;
	Conexion con=new Conexion();
	Connection cnn=con.conexionbd();
	
	public boolean insertadetalleventa(DetalleVentaDTO det) {
		boolean resultado=false;
		try {
			ps=cnn.prepareStatement("INSERT INTO detallev(cantidad_producto,codigo_producto,codigo_venta,valor_total,valor_venta,valor_iva) value(?,?,?,?,?,?)");
			ps.setInt(1, det.getCantidadproducto());
			ps.setLong(2, det.getCodigoproducto());
			ps.setLong(3, det.getCodigoventa());
			ps.setDouble(4, det.getValortotal());
			ps.setDouble(5, det.getValorventa());
			ps.setDouble(6, det.getValoriva());
			resultado=ps.executeUpdate()>0;
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "error al insertar el detalle de venta "+e);
		}
		return resultado;
	}

}

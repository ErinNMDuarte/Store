package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import modelo.ProveedorDAO;
import modelo.ProveedorDTO;

/**
 * Servlet implementation class ServletGestionProveedores
 */
@WebServlet("/ServletGestionProveedores")
public class ServletGestionProveedores extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProveedores() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		boolean x;
		int nitprove;
		String nomprove;
		String dirprove;
		int telprove;
		String cityprove;
		ProveedorDTO proveedordto;
		ProveedorDAO proveedordao;
		ProveedorDTO registropro;
		if(request.getParameter("btnin")!=null) {
			nitprove=Integer.parseInt(request.getParameter("nitproveedor"));
			nomprove=request.getParameter("nombreproveedor");
			dirprove=request.getParameter("direccionproveedor");
			telprove=Integer.parseInt(request.getParameter("telefonoproveedor"));
			cityprove=request.getParameter("ciudadproveedor");
			proveedordto=new ProveedorDTO(nitprove, nomprove, dirprove, telprove, cityprove);
			proveedordao=new ProveedorDAO();
			x=proveedordao.insertarpro(proveedordto);
			if(x==true) {
				JOptionPane.showMessageDialog(null,"el proveedor se ha registrado");
				response.sendRedirect("Proveedor.jsp");
			}
		}
		
		if(request.getParameter("btncon")!=null) {
			int nit;
			String nom;
			String dir;
			int tel;
			String city;
			nitprove=Integer.parseInt(request.getParameter("nitproveedor"));
			proveedordto=new ProveedorDTO(nitprove);
			proveedordao=new ProveedorDAO();
			registropro=proveedordao.consultarpro(proveedordto);
			nit=registropro.getNitpro();
			nom=registropro.getNompro();
			dir=registropro.getDirpro();
			tel=registropro.getTelpro();
			city=registropro.getCitypro();
			response.sendRedirect("Proveedor.jsp?ni="+nit+"&&no="+nom+"&&di="+dir+"&&te="+tel+"&&ci="+city);
		}
		
		if(request.getParameter("btnact")!= null) {
			int dat;
			nitprove=Integer.parseInt(request.getParameter("nitproveedor"));
			nomprove=request.getParameter("nombreproveedor");
			dirprove=request.getParameter("direccionproveedor");
			telprove=Integer.parseInt(request.getParameter("telefonoproveedor"));
			cityprove=request.getParameter("ciudadproveedor");
			proveedordto=new ProveedorDTO(nitprove, nomprove, dirprove, telprove, cityprove);
			proveedordao=new ProveedorDAO();
			dat=proveedordao.actualizarpro(proveedordto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "se actualizo el cliente");
			}
			else {
				JOptionPane.showMessageDialog(null, "no se actualizo el cliente");
			}
			response.sendRedirect("Proveedor.jsp");
			
		}
		if(request.getParameter("btneli")!= null) {
			int dat;
			nitprove=Integer.parseInt(request.getParameter("nitproveedor"));
			proveedordto=new ProveedorDTO(nitprove);
			proveedordao=new ProveedorDAO();
			dat=proveedordao.eliminarpro(proveedordto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "proveedor eliminado correctamente");
			}
			else {
				JOptionPane.showMessageDialog(null, "no se elimino el proveedor");
			}
			response.sendRedirect("Proveedor.jsp");
		}
	}

}

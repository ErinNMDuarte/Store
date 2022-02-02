package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.ClienteDAO;
import modelo.ClienteDTO;
import modelo.DetalleVentaDAO;
import modelo.DetalleVentaDTO;
import modelo.ProductoDAO;
import modelo.ProductoDTO;
import modelo.VentasDAO;
import modelo.VentasDTO;

/**
 * Servlet implementation class ServletGestionVentas
 */
@WebServlet("/ServletGestionVentas")
public class ServletGestionVentas extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	double iva,iva1,iva2;
	int cant,cant1,cant2;
	String art1,art2,art3;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionVentas() {
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
		
		HttpSession sesion=request.getSession();
		
		if(request.getParameter("confirmar")!=null) {
			int cedula,ced;
			String nom;
			
			ClienteDTO listado;
			cedula=Integer.parseInt(request.getParameter("cedulacliente"));
			ClienteDAO clidao=new ClienteDAO();
			ClienteDTO clidto=new ClienteDTO(cedula);
			listado=clidao.consultarcli(clidto);
			
			sesion.setAttribute("cliente", listado);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("conpro")!=null) {
			int codpro;
			
			ProductoDTO listado;
			codpro=Integer.parseInt(request.getParameter("codigo"));
			ProductoDAO prodao=new ProductoDAO();
			ProductoDTO prodto=new ProductoDTO(codpro);
			listado=prodao.consultarprodu(prodto);
			
			iva=listado.getIvacom();
			sesion.setAttribute("producto", listado);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
		}
		
		if(request.getParameter("conpro1")!=null) {
			int codpro;
			ProductoDTO listado;
			codpro=Integer.parseInt(request.getParameter("codigo1"));
			ProductoDAO prodao=new ProductoDAO();
			ProductoDTO prodto=new ProductoDTO(codpro);
			listado=prodao.consultarprodu(prodto);
			
			iva1=listado.getIvacom();
			sesion.setAttribute("producto1", listado);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			
		}
		
		if(request.getParameter("conpro2")!=null) {
			int codpro;
			ProductoDTO listado;
			codpro=Integer.parseInt(request.getParameter("codigo2"));
			ProductoDAO prodao=new ProductoDAO();
			ProductoDTO prodto=new ProductoDTO(codpro);
			listado=prodao.consultarprodu(prodto);
			
			iva2=listado.getIvacom();
			sesion.setAttribute("producto2", listado);
			request.getRequestDispatcher("Ventas.jsp").forward(request, response);
			
		}
		double tot,tot1,tot2,res,res1,res2,totalsiniva,totaliva,totaldesiva;
		
		if(request.getParameter("total")!=null) {
			double total1,total2,total3;
			
			cant=Integer.parseInt(request.getParameter("can"));
			cant1=Integer.parseInt(request.getParameter("can1"));
			cant2=Integer.parseInt(request.getParameter("can2"));
			
			tot=Double.parseDouble(request.getParameter("precio"));
			tot1=Double.parseDouble(request.getParameter("precio1"));
			tot2=Double.parseDouble(request.getParameter("precio2"));
			
			res=cant*tot;
			res1=cant1*tot1;
			res2=cant2*tot2;
			total1=res*iva/100;
			total2=res1*iva1/100;
			total3=res2*iva2/100;
			totalsiniva=res+res1+res2;
			totaliva=total1+total2+total3;
			totaldesiva=totalsiniva+totaliva;
			
			int i=JOptionPane.showConfirmDialog(null, "Art1 "+res+"\n"+"Art2 "+res1+"\n"+"Art3 "+res2+"\n"+"\nIVA "+total1+"\n"+"IVA2 "+total2+"\n"+"IVA3 "+total3+"\n"+"\nTotal sin IVA "+totalsiniva+"\n"+"TOTAL IVA "+totaliva+"\n"+"Total a pagar "+totaldesiva+"\n");
			JOptionPane.showMessageDialog(null, "imprimiendo la i"+i);
			if(i==0) {
				String cedcli,cedusu;
				long cc,cu;
				double iva,tv,vv;
				boolean ress;
				cedcli=(request.getParameter("cedulacliente"));
				cedusu=(request.getParameter("docus"));
				iva=totaliva;
				tv=totalsiniva;
				vv=totaldesiva;
				cc=Long.parseLong(cedcli);
				cu=Long.parseLong(cedusu);
				VentasDTO ven=new VentasDTO(cc, cu, iva, tv, vv);
				VentasDAO vendao=new VentasDAO();
				ress=vendao.insertarventa(ven);
				if(ress) {
					JOptionPane.showMessageDialog(null, "Venta registrada");
					int can;
					long cv;
					double iv,dtv,dvv;
					boolean x;
					VentasDTO venn;
					DetalleVentaDTO dd;
					DetalleVentaDAO dedao;
					long codpro=Long.parseLong(request.getParameter("codigo"));
					long codpro1=Long.parseLong(request.getParameter("codigo1"));
					long codpro2=Long.parseLong(request.getParameter("codigo2"));
					VentasDAO vend=new VentasDAO();
					venn=vend.consultarcodventa();
					
					can=cant;
					if(can>0) {
						cv=venn.getCodigo();
						iv=ven.getIvaventa();
						dtv=ven.getTotalventa();
						dvv=ven.getValorventa();
						dd=new DetalleVentaDTO(can, cv, codpro, dtv, dvv ,iv);
						dedao=new DetalleVentaDAO();
						x=dedao.insertadetalleventa(dd);
						if(x) {
							JOptionPane.showMessageDialog(null, "detalle 1 insertado");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No inserto cantidad");
					}
					
					can=cant1;
					if(can>0) {
						cv=venn.getCodigo();
						iv=ven.getIvaventa();
						dtv=ven.getTotalventa();
						dvv=ven.getValorventa();
						dd=new DetalleVentaDTO(can, cv, codpro1, dtv, dvv ,iv);
						dedao=new DetalleVentaDAO();
						x=dedao.insertadetalleventa(dd);
						if(x) {
							JOptionPane.showMessageDialog(null, "detalle 2 insertado");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No inserto cantidad");
					}
					
					can=cant2;
					if(can>0) {
						cv=venn.getCodigo();
						iv=ven.getIvaventa();
						dtv=ven.getTotalventa();
						dvv=ven.getValorventa();
						dd=new DetalleVentaDTO(can, cv, codpro2, dtv, dvv ,iv);
						dedao=new DetalleVentaDAO();
						x=dedao.insertadetalleventa(dd);
						if(x) {
							JOptionPane.showMessageDialog(null, "detalle 3 insertado");
							response.sendRedirect("MenuPrincipal.jsp");
						}
					}
					else {
						JOptionPane.showMessageDialog(null, "No inserto cantidad");
					}
					}
				else {
					JOptionPane.showMessageDialog(null, "venta no registrada");
				}
						
			}
					
		}
			
			
	}
}


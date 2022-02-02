package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

import com.google.gson.Gson;

import modelo.ClienteDAO;
import modelo.ClienteDTO;

/**
 * Servlet implementation class ServletGestionClientes
 */
@WebServlet("/ServletGestionClientes")
public class ServletGestionClientes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionClientes() {
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
		PrintWriter out=response.getWriter();
		boolean x;
		int documentocli;
		String nombrecli;
		String direccioncli;
		String telefonocli;
		String correocli;
		ClienteDTO clientedto;
		ClienteDAO clientedao;
		ClienteDTO registrocli;
		if(request.getParameter("btnin")!=null) {
			documentocli=Integer.parseInt(request.getParameter("cedulacliente"));
			nombrecli=request.getParameter("nombrecliente");
			direccioncli=request.getParameter("direccioncliente");
			telefonocli=request.getParameter("telefonocliente");
			correocli=request.getParameter("emailcliente");
			clientedto=new ClienteDTO(documentocli, nombrecli, direccioncli, telefonocli, correocli);
			clientedao=new ClienteDAO();
			x=clientedao.insertarcli(clientedto);
			if(x==true) {
				JOptionPane.showMessageDialog(null, "el cliente se ha registrado");
				response.sendRedirect("Cliente.jsp");
			}
		}
		
		if(request.getParameter("btncon")!=null) {
			String nom;
			String dir;
			String tel;
			String ema;//correo cliente
			int doc;
			documentocli=Integer.parseInt(request.getParameter("cedulacliente"));
			clientedto=new ClienteDTO(documentocli);
			clientedao=new ClienteDAO();
			registrocli=clientedao.consultarcli(clientedto);
			doc=registrocli.getDoccli();
			nom=registrocli.getNomcli();
			dir=registrocli.getDircli();
			tel=registrocli.getTelcli();
			ema=registrocli.getEmailcli();
			response.sendRedirect("Cliente.jsp?do="+doc+"&&no="+nom+"&&di="+dir+"&&te="+tel+"&&em="+ema);
			
		}
		
		if(request.getParameter("btnact")!= null) {
			int dat;
			documentocli=Integer.parseInt(request.getParameter("cedulacliente"));
			nombrecli=request.getParameter("nombrecliente");
			direccioncli=request.getParameter("direccioncliente");
			telefonocli=request.getParameter("telefonocliente");
			correocli=request.getParameter("emailcliente");
			clientedto=new ClienteDTO(documentocli, nombrecli, direccioncli, telefonocli, correocli);
			clientedao=new ClienteDAO();
			dat=clientedao.actualizarcli(clientedto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "se actualizo el cliente");
			}
			else {
				JOptionPane.showMessageDialog(null, "no se actualizo el cliente");
			}
			response.sendRedirect("Cliente.jsp");
		}
		
		if(request.getParameter("btneli")!= null) {
			int dat;
			documentocli=Integer.parseInt(request.getParameter("cedulacliente"));
			clientedto=new ClienteDTO(documentocli);
			clientedao=new ClienteDAO();
			dat=clientedao.eliminarcli(clientedto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "el registro se elimino");
			}
			else {
				JOptionPane.showMessageDialog(null, "el registro no se elimino");
			}
			response.sendRedirect("Cliente.jsp");
		}
		
		ArrayList<ClienteDTO> lista=new ArrayList<>();
		clientedao=new ClienteDAO();
		lista=clientedao.consultageneralcliente();
		Gson gson=new Gson();
		out.print(gson.toJson(lista));
	}
	

}

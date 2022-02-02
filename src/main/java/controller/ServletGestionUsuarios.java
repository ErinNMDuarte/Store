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

import modelo.UsuarioDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletGestionUsuarios
 */
@WebServlet("/ServletGestionUsuarios")
public class ServletGestionUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionUsuarios() {
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
		int documentous;
		String nombreus;
		String correous;
		String usuario;
		String password;
		UsuarioDTO usuariodto;
		UsuarioDAO usuariodao;
		UsuarioDTO registrous;
		
		if(request.getParameter("btnin")!= null) {
			documentous=Integer.parseInt(request.getParameter("cedula"));
			nombreus=request.getParameter("nombre");
			correous=request.getParameter("correo");
			usuario=request.getParameter("usuario");
			password=request.getParameter("password");
			usuariodto=new UsuarioDTO(documentous, correous, nombreus, usuario, password);
			usuariodao=new UsuarioDAO();
			x=usuariodao.insertarus(usuariodto);
			if(x==true) {
				JOptionPane.showMessageDialog(null, "el usuario se ha registrado");
				response.sendRedirect("Usuario.jsp");
			}
		}
		if(request.getParameter("btncon")!=null) {
			String nom;
			String ema;
			String usu;
			String pass;
			int doc;
			documentous=Integer.parseInt(request.getParameter("cedula"));
			usuariodto=new UsuarioDTO(documentous);
			usuariodao=new UsuarioDAO();
			registrous=usuariodao.consultarus(usuariodto);
			doc=registrous.getDocus();
			nom=registrous.getNomus();
			ema=registrous.getEmailus();
			usu=registrous.getUs();
			pass=registrous.getPassus();
			response.sendRedirect("Usuario.jsp?do="+doc+"&&em="+ema+"&&no="+nom+"&&u="+usu+"&&pa="+pass);
		}
		
		if(request.getParameter("btnact")!= null) {
			int dat;
			documentous=Integer.parseInt(request.getParameter("cedula"));
			nombreus=request.getParameter("nombre");
			correous=request.getParameter("correo");
			usuario=request.getParameter("usuario");
			password=request.getParameter("password");
			usuariodto=new UsuarioDTO(documentous, correous, nombreus, usuario, password);
			usuariodao=new UsuarioDAO();
			dat=usuariodao.actualizarus(usuariodto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "se actualizo el usuario");
			}
			else {
				JOptionPane.showMessageDialog(null, "no se actualizo el usuario");
			}
			response.sendRedirect("Usuario.jsp");
		}
		if(request.getParameter("btneli")!=null) {
			int dat;
			documentous=Integer.parseInt(request.getParameter("cedula"));
			usuariodto=new UsuarioDTO(documentous);
			usuariodao=new UsuarioDAO();
			dat=usuariodao.eliminarus(usuariodto);
			if(dat>0) {
				JOptionPane.showMessageDialog(null, "el registro se elimino");
			}
			else {
				JOptionPane.showMessageDialog(null, "el registro no se elimino");
			}
			response.sendRedirect("Usuario.jsp");
		}
		
		ArrayList<UsuarioDTO> lista=new ArrayList<>();
		usuariodao=new UsuarioDAO();
		lista=usuariodao.consultageneralusuario();
		Gson gson=new Gson();
		out.print(gson.toJson(lista));
		
		
		
	}

}

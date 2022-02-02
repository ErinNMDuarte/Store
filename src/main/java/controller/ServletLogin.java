package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;

import modelo.LoginDAO;
import modelo.UsuarioDTO;

/**
 * Servlet implementation class ServletLogin
 */
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletLogin() {
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
		if(request.getParameter("btnlog")!= null) {
			String u,c;
			UsuarioDTO usdto;
			u=request.getParameter("usu");
			c=request.getParameter("pass");
			UsuarioDTO lo=new UsuarioDTO(u, c);
			LoginDAO lodao=new LoginDAO();
			usdto=lodao.login(lo);
			String usss=usdto.getUs();
			
			if(usdto.getUs().equals(u) && usdto.getPassus().equals(c)) {
				sesion.setAttribute("usuario", usss);
				sesion.setAttribute("vs", usdto);
				request.getRequestDispatcher("MenuPrincipal.jsp").forward(request, response);
				
			}
			else {
				JOptionPane.showMessageDialog(null, "Datos incorrectos");
				response.sendRedirect("Login.jsp");			
			
		}
		
			
		}
				
	}

}

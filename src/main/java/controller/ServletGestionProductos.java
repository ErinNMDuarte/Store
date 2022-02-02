package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.swing.JOptionPane;

import modelo.ProductoDAO;

/**
 * Servlet implementation class ServletGestionProductos
 */
@WebServlet("/ServletGestionProductos")
@MultipartConfig
public class ServletGestionProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletGestionProductos() {
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
		
		Part archivo=request.getPart("archivo");
		String Url="C:\\\\Users\\\\510\\\\git\\\\repository\\\\StoreWare\\\\src\\\\main\\\\webapp\\\\documentos\\\\";
		if(request.getParameter("cargar")!= null){
			try {
				InputStream file= archivo.getInputStream();
				File copia=new File(Url+"archivo13.csv");
				FileOutputStream escribir=new FileOutputStream(copia);
				int num=file.read();
				while(num != -1) {
					escribir.write(num);
					num=file.read();
				}
				file.close();
				escribir.close();
				JOptionPane.showMessageDialog(null, "el archivo se cargo correctamente");
								
				boolean x;
				ProductoDAO prodao=new ProductoDAO();
				x=prodao.cargarcredito(Url+"archivo13.csv");
				if(x) {
					JOptionPane.showMessageDialog(null, "Datos cargados en la bd");
				}else {
					JOptionPane.showMessageDialog(null, "no se cargaron los datos");
				}
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Error al cargar el archivo"+e);
			}
			
			
			
			
		}
		
	}

}

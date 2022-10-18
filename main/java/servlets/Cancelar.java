package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import interfaces.Acceso;

/**
 * Servlet implementation class Cancelar
 */
@WebServlet("/Cancelar")
public class Cancelar extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Cancelar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acceso ac = Acceso.getInstancia();
		ac.setActividad(null);
		ac.setclase(null);
		ac.setInstitucion(null);
		getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acceso ac = Acceso.getInstancia();
		ac.setActividad(null);
		ac.setclase(null);
		ac.setInstitucion(null);
		getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
	}

}

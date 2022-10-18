package reset;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import interfaces.Acceso;

/**
 * Servlet implementation class ResetRegistrarC
 */
public class ResetRegistrarC extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetRegistrarC() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acceso ac = Acceso.getInstancia();
		ac.setActividad(null);
		ac.setInstitucion(null);
		ac.setclase(null);
		getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acceso ac = Acceso.getInstancia();
		ac.setActividad(null);
		ac.setInstitucion(null);
		ac.setclase(null);
		getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
	}

}

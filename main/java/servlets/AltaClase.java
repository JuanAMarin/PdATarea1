package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.ICaltadictadoclase;

/**
 * Servlet implementation class AltaClase
 */
@WebServlet("/AltaClase")
public class AltaClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaClase() {
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
		Acceso ac = Acceso.getInstancia();
		Fabrica f = Fabrica.getInstancia();
		ICaltadictadoclase ICac = f.getICaltadictadoclase();
		String institucion=request.getParameter("instituciones");
		String actividad=request.getParameter("actividades");
		String ultimaInsti=request.getParameter("ultimaInstitucion");
		if(ultimaInsti==null || !institucion.equals(ultimaInsti)) {
			ac.setInstitucion(ICac.buscarInsti(institucion));
			ac.setActividad(null);
			getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
		}else if(!actividad.equals("Selecciona una actividad")){
			String ultimaActi=request.getParameter("ultimaActividad");
			if(ultimaActi==null || !actividad.equals(ultimaActi)) {
				ICac.buscarActividad(actividad);
				ac.setActividad(ICac.getDtad());
				getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
			}
		}
		getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
	}
}

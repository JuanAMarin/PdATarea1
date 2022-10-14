package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import datatypes.DtActividadDep;
import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.ICconsultaactividad;

/**
 * Servlet implementation class ConsultaActividad
 */
@WebServlet("/ConsultaActividad")
public class ConsultaActividad extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaActividad() {
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
		String acti=request.getParameter("actividades");
		Acceso ac = Acceso.getInstancia();
		Fabrica f= Fabrica.getInstancia();
		ICconsultaactividad ICca = f.getICconsultaactividad();
		ICca.buscarActividad(acti);
		DtActividadDep a = ICca.getDtad();
		ac.setActividad(a);
		getServletContext().getRequestDispatcher("/consultaactividad.jsp").forward(request, response);
	}

}

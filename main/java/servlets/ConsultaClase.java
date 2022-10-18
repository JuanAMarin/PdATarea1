package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.ICconsultaactividad;
import interfaces.ICconsultaclase;

/**
 * Servlet implementation class ConsultaClase
 */
@WebServlet("/ConsultaClase")
public class ConsultaClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaClase() {
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
		String clase=request.getParameter("clases");
		String ultimaActi=request.getParameter("ultimaActividad");
		Acceso ac = Acceso.getInstancia();
		Fabrica f= Fabrica.getInstancia();
		ICconsultaactividad ICca = f.getICconsultaactividad();
		if(ultimaActi==null || !acti.equals(ultimaActi)) {
			ICca.buscarActividad(acti);
			ac.setActividad(ICca.getDtad());
			ac.setclase(null);
			getServletContext().getRequestDispatcher("/consultaclase.jsp").forward(request, response);
		}else {
			ICconsultaclase ICcc = f.getICconsultaclase();
			ICcc.buscarClase(clase);
			ICca.buscarActividad(acti);
			ac.setActividad(ICca.getDtad());
			ac.setclase(ICcc.getDtc());
			getServletContext().getRequestDispatcher("/consultaclase.jsp").forward(request, response);
		}
	}
}

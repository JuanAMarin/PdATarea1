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
 * Servlet implementation class ConsultaUsuario
 */
@WebServlet("/ConsultaUsuario")
public class ConsultaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConsultaUsuario() {
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
		Fabrica f= Fabrica.getInstancia();
		if(ac.getP()!=null) {
			String acti=request.getParameter("actividades");
			String clase=request.getParameter("clases");
			String ultimaActi=request.getParameter("ultimaActividad");	
			ICconsultaactividad ICca = f.getICconsultaactividad();
			if(ac.getP()!=null) {
				if(ultimaActi==null || !acti.equals(ultimaActi)) {
					ICca.buscarActividad(acti);
					ac.setActividad(ICca.getDtad());
					ac.setclase(null);
					getServletContext().getRequestDispatcher("/consultausuario.jsp").forward(request, response);
				}else {
					ICconsultaclase ICcc = f.getICconsultaclase();
					ICcc.buscarClase(clase);
					ICca.buscarActividad(acti);
					ac.setActividad(ICca.getDtad());
					ac.setclase(ICcc.getDtc());
					getServletContext().getRequestDispatcher("/consultausuario.jsp").forward(request, response);
				}
			}
		}else {
			String clasS=request.getParameter("clasS");
			String ultimaClas=request.getParameter("ultimaClas");
			ICconsultaclase ICcc = f.getICconsultaclase();
			if(ultimaClas==null || !clasS.equals(ultimaClas)) {
				ICcc.buscarClase(clasS);
				ac.setclase(ICcc.getDtc());
			}
			getServletContext().getRequestDispatcher("/consultausuario.jsp").forward(request, response);
		}
	}

}

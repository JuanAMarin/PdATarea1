package servlets;

import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.ICaltadictadoclase;
import interfaces.ICregistrodeclases;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import exceptions.SocioYaEliminadoException;
import exceptions.SocioYaRegistradoException;

/**
 * Servlet implementation class RegistroDeClase
 */
@WebServlet("/RegElimDeClase")
public class RegElimDeClase extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegElimDeClase() {
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
		Fabrica fabrica = Fabrica.getInstancia();
		Acceso ac = Acceso.getInstancia();
		ICregistrodeclases icon = fabrica.getICregistrodeclases();
		ICaltadictadoclase ICac = fabrica.getICaltadictadoclase();
		String clase=request.getParameter("clase");
		String insti=request.getParameter("institucion");
		String acti=request.getParameter("actividad");
		String socio=request.getParameter("nickname");
		String ultimaInsti=request.getParameter("ultimaInstitucion");
		if(ac.getclase()==null) {
		if(ultimaInsti==null || !insti.equals(ultimaInsti)) {
			ac.setInstitucion(ICac.buscarInsti(insti));
			ac.setActividad(null);
			getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
		}else if(!acti.equals("Selecciona una actividad")){
			String ultimaActi=request.getParameter("ultimaActividad");
			if(ultimaActi==null || !acti.equals(ultimaActi)) {
				ICac.buscarActividad(acti);
				ac.setActividad(ICac.getDtad());
				getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
			}else if(!clase.equals("Selecciona una clase")){
					ac.setclase(icon.buscarClase(clase));
					getServletContext().getRequestDispatcher("/registrodeclase2.jsp").forward(request, response);
			}
		}}
		if (request.getParameter("boton").equals("registro")) {
			try {
				icon.Registro(clase, socio);
				ac.setModalAux(true);
				ac.setActividad(null);
				ac.setclase(null);
				ac.setInstitucion(null);
				getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
			} catch (SocioYaRegistradoException e) {
				ac.setModal(false);
				ac.setModalErr(true);
				ac.setActividad(null);
				ac.setclase(null);
				ac.setInstitucion(null);
				getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
			}
		}else if (request.getParameter("boton").equals("eliminar")){
			try {
				icon.eliminarRegistro(clase, socio);
				ac.setModal(true);
				ac.setModalErr(false);
				ac.setActividad(null);
				ac.setclase(null);
				ac.setInstitucion(null);
				getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
			} catch (SocioYaEliminadoException e) {
				ac.setModal(true);
				ac.setModalErr(true);
				ac.setActividad(null);
				ac.setclase(null);
				ac.setInstitucion(null);
				getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
			}	
		}
	}
}

package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;
import publicadores.ControladorPublishRSC;
import publicadores.ControladorPublishRSCService;
import publicadores.ControladorPublishRSCServiceLocator;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

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
		ControladorPublishRSCService cpsRSC = new ControladorPublishRSCServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishRSC portRSC=null;
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portRSC = cpsRSC.getControladorPublishRSCPort();
			String clase=request.getParameter("clase");
			String insti=request.getParameter("institucion");
			String acti=request.getParameter("actividad");
			String ultimaInsti=request.getParameter("ultimaInstitucion");
			if(portA.cIsNull()) {
			if(ultimaInsti==null || !insti.equals(ultimaInsti)) {
				if(!insti.equals("Selecciona una institución")) {
					portA.setInstitucion(portRSC.buscarInsti(insti));
					portA.setActividad(null);
					getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
				}
			}else if(!acti.equals("Selecciona una actividad")){
				String ultimaActi=request.getParameter("ultimaActividad");
				if(ultimaActi==null || !acti.equals(ultimaActi)) {
					if(!acti.equals("Selecciona una actividad")) {
						portRSC.buscarActividad(acti);
						portA.setActividad(portRSC.getDtad());
						getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
					}
				}else if(!clase.equals("Selecciona una clase")){
					if(!clase.equals("Selecciona una clase")) {
						portA.setclase(portRSC.buscarClase(clase));
						getServletContext().getRequestDispatcher("/registrodeclase2.jsp").forward(request, response);
					}
				}
			}}
			if(!portA.cIsNull()) {
				if (request.getParameter("boton").equals("registro")) {
					if(!portRSC.socioYaRegistrado(portA.getclase().getNombre(), portA.getS().getNickname())) {
						portRSC.registro(portA.getclase().getNombre(), portA.getS().getNickname());
						portA.setModalAux(true);
						portA.setActividad(null);
						portA.setclase(null);
						portA.setInstitucion(null);
						getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
					}else {
						portA.setModal(false);
						portA.setModalErr(true);
						portA.setActividad(null);
						portA.setclase(null);
						portA.setInstitucion(null);
						getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
					}
				}else if (request.getParameter("boton").equals("eliminar")){
					if(portRSC.socioYaRegistrado(portA.getclase().getNombre(), portA.getS().getNickname())) {
						portRSC.eliminarRegistro(portA.getclase().getNombre(), portA.getS().getNickname());
						portA.setModal(true);
						portA.setModalErr(false);
						portA.setActividad(null);
						portA.setclase(null);
						portA.setInstitucion(null);
						getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
					}else {
						portA.setModal(true);
						portA.setModalErr(true);
						portA.setActividad(null);
						portA.setclase(null);
						portA.setInstitucion(null);
						getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
					}
				}
			}
			getServletContext().getRequestDispatcher("/registrodeclase.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

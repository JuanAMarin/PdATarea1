package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAC;
import publicadores.ControladorPublishACService;
import publicadores.ControladorPublishACServiceLocator;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;

import java.io.IOException;

import javax.xml.rpc.ServiceException;
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
		ControladorPublishACService cpsAC = new ControladorPublishACServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAC portAC=null;
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portAC = cpsAC.getControladorPublishACPort();
			String institucion=request.getParameter("instituciones");
			String actividad=request.getParameter("actividades");
			String ultimaInsti=request.getParameter("ultimaInstitucion");
			if(ultimaInsti==null || !institucion.equals(ultimaInsti)) {
				if(!institucion.equals("Selecciona una institución")) {
					portA.setInstitucion(portAC.buscarInsti(institucion));
					portA.setActividad(null);
				}
			}else if(!actividad.equals("Selecciona una actividad")){
				String ultimaActi=request.getParameter("ultimaActividad");
				if(ultimaActi==null || !actividad.equals(ultimaActi)) {
					if(!actividad.equals("Selecciona una actividad")) {
						portAC.buscarActividad(actividad);
						portA.setActividad(portAC.getDtad());
					}
				}
			}
			getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}
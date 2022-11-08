package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;
import publicadores.ControladorPublishCUCA;
import publicadores.ControladorPublishCUCAService;
import publicadores.ControladorPublishCUCAServiceLocator;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

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
		ControladorPublishCUCAService cpsCUCA = new ControladorPublishCUCAServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAcceso portA = null;
		ControladorPublishCUCA portCUCA = null;
		try {
			portCUCA = cpsCUCA.getControladorPublishCUCAPort();
			portA = cpsA.getControladorPublishAccesoPort();
			String acti=request.getParameter("actividades");
			String clase=request.getParameter("clases");
			String ultimaActi=request.getParameter("ultimaActividad");
			if(ultimaActi==null || !acti.equals(ultimaActi)) {
				if(!acti.equals("Selecciona una actividad")) {
					portCUCA.buscarActividad(acti);
					portA.setActividad(portCUCA.getDtad());
					portA.setclase(null);
				}
			}else {
				if(!clase.equals("Selecciona una clase")) {
					portCUCA.buscarClase(clase);
					portCUCA.buscarActividad(acti);
					portA.setclase(portCUCA.getDtc());
				}
			}
			getServletContext().getRequestDispatcher("/consultaactividad.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}

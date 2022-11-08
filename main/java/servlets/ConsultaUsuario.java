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
		ControladorPublishCUCAService cpsCUCA = new ControladorPublishCUCAServiceLocator();
		ControladorPublishCUCA portCUCA=null;
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAcceso portA=null;
		try {
			portCUCA = cpsCUCA.getControladorPublishCUCAPort();
			portA = cpsA.getControladorPublishAccesoPort();
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(!portA.pIsNull()) {
			String acti=request.getParameter("actividades");
			String clase=request.getParameter("clases");
			String ultimaActi=request.getParameter("ultimaActividad");	
			if(!portA.pIsNull()) {
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
						portA.setActividad(portCUCA.getDtad());
						portA.setclase(portCUCA.getDtc());
					}
				}
			}
		}else {
			String clasS=request.getParameter("clasS");
			String ultimaClas=request.getParameter("ultimaClas");
			if(ultimaClas==null || !clasS.equals(ultimaClas)) {
				if(!clasS.equals("Selecciona una clase")) {
					portCUCA.buscarClase(clasS);
					portA.setclase(portCUCA.getDtc());
				}
			}
		}
		getServletContext().getRequestDispatcher("/consultausuario.jsp").forward(request, response);
	}

}

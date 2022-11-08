package reset;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class ResetConsuActi
 */
public class ResetConsuActi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetConsuActi() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portA.setActividad(null);
			portA.setInstitucion(null);
			portA.setclase(null);
			getServletContext().getRequestDispatcher("/consultaactividad.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portA.setActividad(null);
			portA.setInstitucion(null);
			portA.setclase(null);
			getServletContext().getRequestDispatcher("/consultaactividad.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}

}

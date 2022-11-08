package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;
import publicadores.ControladorPublishMU;
import publicadores.ControladorPublishMUService;
import publicadores.ControladorPublishMUServiceLocator;

import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;

import javax.xml.rpc.ServiceException;

/**
 * Servlet implementation class ModificarUsuario
 */
@WebServlet("/ModificarUsuario")
public class ModificarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarUsuario() {
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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPublishMUService cpsMU = new ControladorPublishMUServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAcceso portA=null;
		ControladorPublishMU portMU=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portMU = cpsMU.getControladorPublishMUPort();
			String nickname=request.getParameter("Nickname");
			String nombre=request.getParameter("Nombre");
			String apellido=request.getParameter("Apellido");
			String[] parts = request.getParameter("fecha").split("-");
			Date f = new Date();
			f.setDate(Integer.valueOf(parts[2]));
			f.setMonth(Integer.valueOf(parts[1])-1);
			f.setYear(Integer.valueOf(parts[0])-1900);
			Calendar cal = Calendar.getInstance();
			cal.setTime(f);
			String image=request.getParameter("img");
			byte[] foto;
			if(image.equals(""))
				if(portA.pIsNull())
					foto=portA.getS().getImage();
				else
					foto=portA.getP().getImage();
			else {
				foto=Base64.getDecoder().decode(image.substring(image.lastIndexOf(",") + 1));
			}
			
			if(!portA.pIsNull()) {
				String biografia=request.getParameter("Biografia");
				String desc=request.getParameter("Descripcion");
				String sw=request.getParameter("SitioWeb");
				portMU.modProfesor(nickname, nombre, apellido, cal, desc, biografia, sw, foto);
				portA.setP(portMU.obtenerProfesor(nickname));
			}else {
				portMU.modSocio(nickname, nombre, apellido, cal, foto); 
				portA.setS(portMU.obtenerSocio(nickname));
			}
			portA.setModal(true);
			request.getRequestDispatcher("modificarusuario.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		
	}
}

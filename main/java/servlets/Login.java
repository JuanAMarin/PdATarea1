package servlets;

import java.io.IOException;

import javax.xml.rpc.ServiceException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import publicadores.ControladorPublishAcceso;
import publicadores.ControladorPublishAccesoService;
import publicadores.ControladorPublishAccesoServiceLocator;
import publicadores.ControladorPublishLogin;
import publicadores.ControladorPublishLoginService;
import publicadores.ControladorPublishLoginServiceLocator;
import publicadores.DtProfesor;
import publicadores.DtSocio;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
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
		ControladorPublishLoginService cpsL = new ControladorPublishLoginServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishLogin portL=null;
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portL = cpsL.getControladorPublishLoginPort();
			portA.killInstancia();
			String nickname=request.getParameter("nickname");
			String pass=request.getParameter("password");
			DtSocio s = null;
			DtProfesor p = null;
			if(portL.existeSBoolean(nickname, pass)) {
				s = portL.existeS(nickname, pass);
			}else if(portL.existePBoolean(nickname, pass)) {
				p = portL.existeP(nickname, pass);
			}
			if(p != null){
				portA.setP(p);
			}else if(s != null){
				portA.setS(s);
			}else{
				portA.setModal(true);
				request.getRequestDispatcher("/login.jsp").forward(request, response);
			}
			getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
	}
}

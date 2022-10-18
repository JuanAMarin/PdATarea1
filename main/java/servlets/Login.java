package servlets;

import java.io.IOException;
import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.IClogin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import datatypes.DtProfesor;
import datatypes.DtSocio;

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
		Acceso access = Acceso.getInstancia();
		access.killInstancia();
		String nickname=request.getParameter("nickname");
		String pass=request.getParameter("password");
		Fabrica fabrica = Fabrica.getInstancia();
		IClogin ICl = fabrica.getIClogin();
		DtProfesor p = ICl.existeP(nickname, pass);
		DtSocio s = ICl.existeS(nickname, pass);
		if(p != null)
		{
			access = Acceso.getInstancia();
			access.setP(p);
		}else if(s != null)
		{
			access = Acceso.getInstancia();
			access.setS(s);
		}else
		{
			access = Acceso.getInstancia();
			access.setModal(true);
			request.getRequestDispatcher("/login.jsp").forward(request, response);
		}
		getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
	}

}

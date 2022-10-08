package servlets;

import java.io.IOException;
import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.IClogin;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logica.Profesor;
import logica.Socio;

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
		Profesor p = ICl.existeP(nickname, pass);
		Socio s = ICl.existeS(nickname, pass);
		if(p != null)
		{
			access = Acceso.getInstancia();
			access.setP(p);
			getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
		}else if(s != null)
		{
			access = Acceso.getInstancia();
			access.setS(s);
			getServletContext().getRequestDispatcher("/principal.jsp").forward(request, response);
		}else
		{
			request.setCharacterEncoding("UTF-8");
			request.setAttribute("error","Usuario o contraseña invalido");
			RequestDispatcher rd=request.getRequestDispatcher("/login.jsp/");            
			rd.include(request, response);
	        
		}
	}

}

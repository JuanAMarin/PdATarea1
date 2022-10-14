package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Base64;
import java.util.Date;

import interfaces.Acceso;
import interfaces.Fabrica;
import interfaces.ICmodusuario;

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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Acceso ac = Acceso.getInstancia();
		Fabrica fabrica = Fabrica.getInstancia();
		ICmodusuario ICmu = fabrica.getICmodusuario(); 
		
		String nickname=request.getParameter("Nickname");
		String nombre=request.getParameter("Nombre");
		String apellido=request.getParameter("Apellido");
		String[] parts = request.getParameter("fecha").split("-");
		Date f = new Date();
		f.setDate(Integer.valueOf(parts[2]));
		f.setMonth(Integer.valueOf(parts[1])-1);
		f.setYear(Integer.valueOf(parts[0])-1900);
		String image=request.getParameter("img");
		byte[] foto;
		if(image.equals(""))
			if(ac.getP()==null)
				foto=ac.getS().getImage();
			else
				foto=ac.getP().getImage();
		else {
			foto=Base64.getDecoder().decode(image.substring(image.lastIndexOf(",") + 1));
		}
		
		if(ac.getP()!=null) {
			String biografia=request.getParameter("Biografia");
			String desc=request.getParameter("Descripcion");
			String sw=request.getParameter("SitioWeb");
			ICmu.modProfesor(nickname, nombre, apellido, f, desc, biografia, sw, foto);
			ac.setP(ICmu.obtenerProfesor(nickname));
		}else {
			ICmu.modSocio(nickname, nombre, apellido, f, foto); 
			ac.setS(ICmu.obtenerSocio(nickname));
		}
		ac.setModal(true);
		request.getRequestDispatcher("modificarusuario.jsp").forward(request, response);
	}
}

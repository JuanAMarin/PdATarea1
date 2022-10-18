package servlets;

import interfaces.Fabrica;
import interfaces.ICaltadictadoclase;
import interfaces.Acceso;
import exceptions.ClaseRepetidaException;
import exceptions.ErrorFechaException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import javax.swing.JOptionPane;

@WebServlet("/AltaClase2")
public class AltaClase2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AltaClase2() {
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
		Fabrica f = Fabrica.getInstancia();
		ICaltadictadoclase ICac = f.getICaltadictadoclase();
		String clase=request.getParameter("clase");
		String fInicio=request.getParameter("fechainicio");
		String hInicio=request.getParameter("horainicio");
		String profesor=request.getParameter("nickname");
		String url=request.getParameter("url");
		String imag=request.getParameter("img");
		byte[] imagen = null;
		String filename = null;
		File fail = new File("C:\\Users\\PC\\eclipse\\pdaprojectweb\\src\\main\\webapp\\imagenes\\default.jpg");
		if(!imag.equals(""))
			imagen=Base64.getDecoder().decode(imag.substring(imag.lastIndexOf(",") + 1));
		else {
			filename = fail.getAbsolutePath();
			try {
				File image = new File(filename);
				FileInputStream fis = new FileInputStream(image);
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				byte[] buf = new byte[1024];
				for (int readNum;(readNum = fis.read(buf))!=-1;){
					bos.write(buf,0,readNum);
				}
				imagen = bos.toByteArray();
				fis.close();
			} catch (Exception e2) {
				JOptionPane.showMessageDialog(null,e2);
			}
			
		}
		
		String[] parts = fInicio.split("-");
		String[] parts2 = hInicio.split(":");
		Date fI = new Date();
		fI.setDate(Integer.valueOf(parts[2]));
		fI.setMonth(Integer.valueOf(parts[1])-1);
		fI.setYear(Integer.valueOf(parts[0])-1900);
		Date fechaReg = new Date();
		Date hI = new Date();
		hI.setHours(Integer.valueOf(parts2[0]));
		hI.setMinutes(Integer.valueOf(parts2[1]));
		try {
			ICac.altaClase(clase,url,fI,fechaReg,hI,profesor,ac.getActividad().getNombre(),imagen);
			ac.setModal(true);
			ac.setActividad(null);
			ac.setclase(null);
			ac.setInstitucion(null);
			getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
		} catch (ClaseRepetidaException e) {
			ac.setModalErr(true);
			getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);		
		} catch (ErrorFechaException e) {
			// TODO Auto-generated catch block
		}
	}

}
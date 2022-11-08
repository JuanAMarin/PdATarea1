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

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.xml.rpc.ServiceException;

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
	@SuppressWarnings("deprecation")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorPublishACService cpsAC = new ControladorPublishACServiceLocator();
		ControladorPublishAccesoService cpsA = new ControladorPublishAccesoServiceLocator();
		ControladorPublishAC portAC=null;
		ControladorPublishAcceso portA=null;
		try {
			portA = cpsA.getControladorPublishAccesoPort();
			portAC = cpsAC.getControladorPublishACPort();
			String clase=request.getParameter("clase");
			if(!portAC.existeClase(clase)) {
				String fInicio=request.getParameter("fechainicio");
				String hInicio=request.getParameter("horainicio");
				String profesor=request.getParameter("nickname");
				String url=request.getParameter("url");
				String imag=request.getParameter("img");
				byte[] imagen = null;
				String filename = null;
				File fail = new File("C:\\Users\\PC\\eclipse\\pdaprojectwebS\\src\\main\\webapp\\imagenes\\default.jpg");
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
				Calendar cal1=Calendar.getInstance(), cal2=Calendar.getInstance(), cal3=Calendar.getInstance();
				cal1.setTime(fI);
				cal2.setTime(fechaReg);
				cal3.setTime(hI);
				portAC.altaClase(clase,url,cal1,cal2,cal3,profesor,portA.getActividad().getNombre(),imagen);
				portA.setModal(true);
				portA.setActividad(null);
				portA.setclase(null);
				portA.setInstitucion(null);
			}else {
				portA.setModalErr(true);
				
			}
			getServletContext().getRequestDispatcher("/altaclase.jsp").forward(request, response);
		} catch (ServiceException e) {
			e.printStackTrace();
	}}
}
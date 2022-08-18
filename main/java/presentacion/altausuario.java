package presentacion;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import interfaces.*;
import logica.InstitucionDep;
import logica.ManejadorInstituciones;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.*;
import java.awt.event.ActionEvent;

public class altausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltausuario ICau;
	
	private JTextField escribirNickname;
	private JTextField escribirNombre;
	private JTextField escribirApellido;
	private JTextField escribirEmail;
	private JTextField escribirDescripcion;
	private JTextField escribirBiografia;
	private JTextField escribirSitioWeb;
	private JComboBox seleccionarInsti;
	private JRadioButton botonProfesor;
	private JRadioButton botonSocio;
	private JButton btnCancelar;
	private JButton btnAceptar;

	/**
	 * Create the frame.
	 */
	public altausuario(ICaltausuario ICaltau) {
		setClosable(true);
		
		setTitle("Alta de Usuario");
		ICau = ICaltau;
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JLabel textoAltaUsuario = new JLabel("Complete los campos a continuación:");
		textoAltaUsuario.setToolTipText("");
		textoAltaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 10));
		textoAltaUsuario.setBounds(33, 10, 170, 29);
		getContentPane().add(textoAltaUsuario);
		
		JLabel nickname = new JLabel("NICKNAME");
		nickname.setBounds(43, 49, 139, 14);
		getContentPane().add(nickname);
		
		JLabel nombre = new JLabel("NOMBRE");
		nombre.setBounds(43, 73, 139, 14);
		getContentPane().add(nombre);
		
		JLabel apellido = new JLabel("APELLIDO");
		apellido.setBounds(43, 97, 125, 14);
		getContentPane().add(apellido);
		
		JLabel email = new JLabel("EMAIL");
		email.setBounds(43, 121, 99, 14);
		getContentPane().add(email);
		
		JLabel fechaNaci = new JLabel("FECHA DE NACIMIENTO");
		fechaNaci.setBounds(43, 145, 183, 14);
		getContentPane().add(fechaNaci);
		
		escribirNickname = new JTextField();
		escribirNickname.setBounds(236, 47, 170, 20);
		getContentPane().add(escribirNickname);
		escribirNickname.setColumns(10);
		
		escribirNombre = new JTextField();
		escribirNombre.setBounds(236, 71, 170, 20);
		getContentPane().add(escribirNombre);
		escribirNombre.setColumns(10);
		
		escribirApellido = new JTextField();
		escribirApellido.setBounds(236, 95, 170, 20);
		getContentPane().add(escribirApellido);
		escribirApellido.setColumns(10);
		
		escribirEmail = new JTextField();
		escribirEmail.setBounds(236, 119, 170, 20);
		getContentPane().add(escribirEmail);
		escribirEmail.setColumns(10);
		
		JSpinner dia = new JSpinner();
		dia.setBounds(236, 143, 46, 20);
		getContentPane().add(dia);
		
		JSpinner mes = new JSpinner();
		mes.setBounds(297, 143, 46, 20);
		getContentPane().add(mes);
		
		JSpinner año = new JSpinner();
		año.setBounds(360, 143, 46, 20);
		getContentPane().add(año);
		
		botonProfesor = new JRadioButton("Profesor");
		botonProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonProfesor.setSelected(true);
				botonSocio.setSelected(false);
				seleccionarInsti.setEnabled(true);
				escribirDescripcion.setEnabled(true);
				escribirBiografia.setEnabled(true);
				escribirSitioWeb.setEnabled(true);
			}
		});
		botonProfesor.setBounds(33, 186, 109, 23);
		getContentPane().add(botonProfesor);
		
		botonSocio = new JRadioButton("Socio");
		botonSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				botonSocio.setSelected(true);
				botonProfesor.setSelected(false);
				seleccionarInsti.setEnabled(false);
				escribirDescripcion.setText("");
				escribirDescripcion.setEnabled(false);
				escribirBiografia.setText("");
				escribirBiografia.setEnabled(false);
				escribirSitioWeb.setText("");
				escribirSitioWeb.setEnabled(false);
			}
		});
		botonSocio.setBounds(144, 186, 109, 23);
		getContentPane().add(botonSocio);
		
		JLabel descripcion = new JLabel("DESCRIPCIÓN");
		descripcion.setBounds(43, 222, 125, 14);
		getContentPane().add(descripcion);
		
		JLabel biografia = new JLabel("BIOGRAFÍA");
		biografia.setBounds(43, 247, 139, 14);
		getContentPane().add(biografia);
		
		JLabel sitioWeb = new JLabel("SITIO WEB");
		sitioWeb.setBounds(43, 271, 139, 14);
		getContentPane().add(sitioWeb);
		
		escribirDescripcion = new JTextField();
		escribirDescripcion.setBounds(236, 220, 170, 20);
		getContentPane().add(escribirDescripcion);
		escribirDescripcion.setColumns(10);
		
		escribirBiografia = new JTextField();
		escribirBiografia.setBounds(236, 245, 170, 20);
		getContentPane().add(escribirBiografia);
		escribirBiografia.setColumns(10);
		
		escribirSitioWeb = new JTextField();
		escribirSitioWeb.setBounds(236, 269, 170, 20);
		getContentPane().add(escribirSitioWeb);
		escribirSitioWeb.setColumns(10);
		
		seleccionarInsti = new JComboBox();
		seleccionarInsti.setBounds(236, 291, 170, 22);
		getContentPane().add(seleccionarInsti);
		
		JLabel institucion = new JLabel("INSTITUCIÓN");
		institucion.setBounds(43, 295, 139, 14);
		getContentPane().add(institucion);
		
		seleccionarInsti.setEnabled(false);
		escribirDescripcion.setEnabled(false);
		escribirBiografia.setEnabled(false);
		escribirSitioWeb.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				escribirNickname.setText("");
				escribirNombre.setText("");
				escribirApellido.setText("");
				escribirEmail.setText("");
				escribirDescripcion.setText("");
				escribirBiografia.setText("");
				escribirSitioWeb.setText("");
				setVisible(false);
			}
		});
		btnCancelar.setBounds(405, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				ManejadorInstituciones mInst = new ManejadorInstituciones();
				InstitucionDep institucion;
				String insti;
				boolean profe;
				String nickname=escribirNickname.getText();
				String nombre=escribirNombre.getText();
				String apellido=escribirApellido.getText();
				String email=escribirEmail.getText();
				LocalDate fecha = LocalDate.of((int)dia.getValue(),(int)mes.getValue(),(int)año.getValue());
				if(botonProfesor.isSelected()){
					String descripcion=escribirDescripcion.getText();
					String biografia=escribirBiografia.getText();
					String sitioweb=escribirSitioWeb.getText();
					insti=(String)seleccionarInsti.getSelectedItem();
					institucion=mInst.buscarInstitucion(insti);
					profe=true;
					ICau.datosProfesor(descripcion, biografia, sitioweb, institucion, profe);
				}
				ICau.datosUsuario(nickname, nombre, apellido, email, fecha);
				ICau.altausuario();
			}
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
	}
}

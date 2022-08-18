package presentacion;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.UsuarioRepetidoException;
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
import java.awt.Color;
import javax.swing.JTextPane;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

public class altausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltausuario ICau;
	
	private JTextField textNickname;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textDescripcion;
	private JTextField textBiografia;
	private JTextField textSitioWeb;
	private JComboBox comboBoxInsti;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
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
		
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(33, 10, 170, 29);
		getContentPane().add(lblMensaje);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(43, 49, 139, 14);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(43, 73, 139, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(43, 97, 125, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(43, 121, 99, 14);
		getContentPane().add(lblEmail);
		
		JLabel lblFechaNaci = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNaci.setBounds(43, 145, 183, 14);
		getContentPane().add(lblFechaNaci);
		
		textNickname = new JTextField();
		textNickname.setBounds(236, 47, 170, 20);
		getContentPane().add(textNickname);
		textNickname.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.setBounds(236, 71, 170, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.setBounds(236, 95, 170, 20);
		getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setBounds(236, 119, 170, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		JSpinner spinnerMes = new JSpinner();
		spinnerMes.setBounds(297, 143, 46, 20);
		getContentPane().add(spinnerMes);
		
		JSpinner spinnerAño = new JSpinner();
		spinnerAño.setBounds(360, 143, 46, 20);
		getContentPane().add(spinnerAño);
		
		JSpinner spinnerDia = new JSpinner();
		spinnerDia.setBounds(236, 143, 46, 20);
		getContentPane().add(spinnerDia);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(true);
				rdbtnSocio.setSelected(false);
				comboBoxInsti.setEnabled(true);
				textDescripcion.setEnabled(true);
				textBiografia.setEnabled(true);
				textSitioWeb.setEnabled(true);
			}
		});
		rdbtnProfesor.setBounds(33, 186, 109, 23);
		getContentPane().add(rdbtnProfesor);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				comboBoxInsti.setEnabled(false);
				textDescripcion.setText("");
				textDescripcion.setEnabled(false);
				textBiografia.setText("");
				textBiografia.setEnabled(false);
				textSitioWeb.setText("");
				textSitioWeb.setEnabled(false);
			}
		});
		rdbtnSocio.setBounds(144, 186, 109, 23);
		getContentPane().add(rdbtnSocio);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(43, 222, 125, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("BIOGRAFÍA");
		lblBiografia.setBounds(43, 247, 139, 14);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("SITIO WEB");
		lblSitioWeb.setBounds(43, 271, 139, 14);
		getContentPane().add(lblSitioWeb);
		
		textDescripcion = new JTextField();
		textDescripcion.setBounds(236, 220, 170, 20);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textBiografia = new JTextField();
		textBiografia.setBounds(236, 245, 170, 20);
		getContentPane().add(textBiografia);
		textBiografia.setColumns(10);
		
		textSitioWeb = new JTextField();
		textSitioWeb.setBounds(236, 269, 170, 20);
		getContentPane().add(textSitioWeb);
		textSitioWeb.setColumns(10);
		
		comboBoxInsti = new JComboBox();
		comboBoxInsti.setBounds(236, 291, 170, 22);
		getContentPane().add(comboBoxInsti);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(43, 295, 139, 14);
		getContentPane().add(lblInstitucion);
		
		comboBoxInsti.setEnabled(false);
		textDescripcion.setEnabled(false);
		textBiografia.setEnabled(false);
		textSitioWeb.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				textNickname.setText("");
				textNombre.setText("");
				textApellido.setText("");
				textEmail.setText("");
				textDescripcion.setText("");
				textBiografia.setText("");
				textSitioWeb.setText("");
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
				String nickname=textNickname.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				String email=textEmail.getText();
				LocalDate fecha = LocalDate.of((int)spinnerDia.getValue(),(int)spinnerMes.getValue(),(int)spinnerAño.getValue());
				try {
					ICau.datosUsuario(nickname, nombre, apellido, email, fecha);
					if(rdbtnProfesor.isSelected()){
						String descripcion=textDescripcion.getText();
						String biografia=textBiografia.getText();
						String sitioweb=textSitioWeb.getText();
						insti=(String)comboBoxInsti.getSelectedItem();
						institucion=mInst.buscarInstitucion(insti);
						profe=true;
						ICau.datosProfesor(descripcion, biografia, sitioweb, institucion, profe);
					}
					ICau.altausuario();
				} catch (UsuarioRepetidoException | EmailRepetidoException | ErrorFechaException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblErrorFecha = new JLabel("*Fecha Incorrecta");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(236, 167, 170, 13);
		getContentPane().add(lblErrorFecha);
		lblErrorFecha.setVisible(false);
		
	}
}

package presentacion;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Label;

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
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JTextPane;
import javax.swing.border.LineBorder;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	private JDateChooser dateFechaNac;

	/**
	 * Create the frame.
	 */
	private void formClose(){
		textNickname.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textEmail.setText("");
		textDescripcion.setText("");
		textBiografia.setText("");
		textSitioWeb.setText("");
		rdbtnProfesor.setSelected(false);
		rdbtnSocio.setSelected(false);
		dateFechaNac.setCalendar(null);
	}
	
	private void changeTextFormat(JLabel l, Color c){
		/*
		 l - Label a cambiar el color
		 c - Color de fuente
		*/
		
		l.setForeground(c);
	}
	
	public altausuario(ICaltausuario ICaltau) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Alta de Usuario");
		ICau = ICaltau;
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JLabel lblErrorFecha = new JLabel("*Fecha Incorrecta");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(236, 167, 170, 13);
		getContentPane().add(lblErrorFecha);
		
		dateFechaNac = new JDateChooser();
		dateFechaNac.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblErrorFecha.setVisible(false);
			}
		});
		dateFechaNac.setBounds(236, 145, 170, 19);
		getContentPane().add(dateFechaNac);
		lblErrorFecha.setVisible(false);
				
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
		textNickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblNickname, Color.BLACK);
			}
		});
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
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblEmail, Color.BLACK);
			}
		});
		textEmail.setBounds(236, 119, 170, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
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
				formClose();
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
				Date fecha = dateFechaNac.getDate();
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
					formClose();
				} catch (UsuarioRepetidoException e1) {
					changeTextFormat(lblNickname, Color.RED);
				} catch (ErrorFechaException e2) {
					lblErrorFecha.setVisible(true);
				} catch (EmailRepetidoException e3) {
					changeTextFormat(lblEmail, Color.RED);
				}
			}
			
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		
	}
}

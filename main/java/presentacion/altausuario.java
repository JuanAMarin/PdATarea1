package presentacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.toedter.calendar.JDateChooser;

import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import exceptions.UsuarioRepetidoException;
import interfaces.ICaltausuario;
import logica.InstitucionDep;
import logica.ManejadorInstituciones;

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
	private JComboBox cboInsti;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JDateChooser dateFechaNac;
	private JLabel lblUsuarioAñadido;
	private JLabel lblErrorFecha;
	private JLabel lblErrorEmail;
	private JLabel lblErrorNickname;
	private JLabel lblEmailEnUso;

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
		lblUsuarioAñadido.setVisible(true);
	}
	
	private void changeTextFormat(JLabel l, Color c){
		//l - Label a cambiar el color
		//c - Color de fuente
		l.setForeground(c);
	}
	
	public void habilitarPofSoc() {
		if (!textNickname.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()
			&& !textEmail.getText().isEmpty() && !((JTextField)dateFechaNac.getDateEditor().getUiComponent()).getText().isEmpty()) {
			rdbtnProfesor.setEnabled(true);
			rdbtnSocio.setEnabled(true);
		}else {
			rdbtnProfesor.setEnabled(false);
			rdbtnSocio.setEnabled(false);
			rdbtnProfesor.setSelected(false);
			rdbtnSocio.setSelected(false);
		}
	}
	
	public boolean verificarEmail(String email) {
		Pattern patron = Pattern.compile("^[A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-])*@"+"[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
		Matcher mat = patron.matcher(email);
		return mat.find();
	}
	
	public void habilitarAceptar() {
		if (!textNickname.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()
			&& !textEmail.getText().isEmpty() && !((JTextField)dateFechaNac.getDateEditor().getUiComponent()).getText().isEmpty() 
			&& (rdbtnSocio.isSelected() || (rdbtnProfesor.isSelected() && !textDescripcion.getText().isEmpty() 
			&& !textBiografia.getText().isEmpty() && !textSitioWeb.getText().isEmpty() && cboInsti.getSelectedItem()!=null)))
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
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
		
		lblErrorFecha = new JLabel("*Fecha Incorrecta");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(405, 121, 170, 13);
		getContentPane().add(lblErrorFecha);
		
		lblErrorNickname = new JLabel("*Nickname en uso");
		lblErrorNickname.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorNickname.setForeground(Color.RED);
		lblErrorNickname.setBounds(405, 50, 170, 13);
		getContentPane().add(lblErrorNickname);
		
		lblErrorEmail = new JLabel("*Email incorrecto");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setBounds(405, 146, 170, 13);
		getContentPane().add(lblErrorEmail);
		
		dateFechaNac = new JDateChooser();
		
		dateFechaNac.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			        	habilitarAceptar();
						habilitarPofSoc();
			        }
			    });
		dateFechaNac.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblErrorFecha.setVisible(false);
			}
		});
		dateFechaNac.setBounds(225, 121, 170, 19);
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
		lblErrorNickname.setVisible(false);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(43, 73, 139, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(43, 97, 125, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(43, 145, 99, 14);
		getContentPane().add(lblEmail);
		lblErrorEmail.setVisible(false);
		
		JLabel lblFechaNaci = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNaci.setBounds(43, 121, 183, 14);
		getContentPane().add(lblFechaNaci);
		
		textNickname = new JTextField();
		textNickname.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblNickname, Color.BLACK);
				lblErrorNickname.setVisible(false);
				habilitarAceptar();
				habilitarPofSoc();
			}
		});
		textNickname.setBounds(225, 47, 170, 20);
		getContentPane().add(textNickname);
		textNickname.setColumns(10);
		
		textNombre = new JTextField();
		textNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
				habilitarPofSoc();
			}
		});
		textNombre.setBounds(225, 71, 170, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		textApellido = new JTextField();
		textApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
				habilitarPofSoc();
			}
		});
		textApellido.setBounds(225, 95, 170, 20);
		getContentPane().add(textApellido);
		textApellido.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblEmailEnUso.setVisible(false);
			}
		});
		textEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(verificarEmail(textEmail.getText())) {
					changeTextFormat(lblEmail, Color.BLACK);
					habilitarAceptar();
					habilitarPofSoc();
					lblErrorEmail.setVisible(false);
					lblEmailEnUso.setVisible(false);
					changeTextFormat(lblEmail, Color.BLACK);
				}else {
					changeTextFormat(lblEmail, Color.RED);
					lblErrorEmail.setVisible(true);
					lblEmailEnUso.setVisible(false);
				}
				if(textEmail.getText().isEmpty()) {
					lblErrorEmail.setVisible(false);
					lblEmailEnUso.setVisible(false);
					changeTextFormat(lblEmail, Color.BLACK);
					habilitarAceptar();
					habilitarPofSoc();
				}
			}
		});
		textEmail.setBounds(225, 143, 170, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setEnabled(false);
		rdbtnProfesor.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		rdbtnProfesor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnProfesor.setSelected(true);
				rdbtnSocio.setSelected(false);
				btnAceptar.setEnabled(false);
				cboInsti.setEnabled(true);
				textDescripcion.setEnabled(true);
				textBiografia.setEnabled(true);
				textSitioWeb.setEnabled(true);
			}
		});
		rdbtnProfesor.setBounds(33, 186, 109, 23);
		getContentPane().add(rdbtnProfesor);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setEnabled(false);
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				btnAceptar.setEnabled(false);
				cboInsti.setEnabled(false);
				textDescripcion.setText("");
				textDescripcion.setEnabled(false);
				textBiografia.setText("");
				textBiografia.setEnabled(false);
				textSitioWeb.setText("");
				textSitioWeb.setEnabled(false);
				if (!textNickname.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()
						&& !textEmail.getText().isEmpty() && !dateFechaNac.getDateFormatString().isEmpty())
					btnAceptar.setEnabled(true);
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
		textDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textDescripcion.setBounds(225, 220, 170, 20);
		getContentPane().add(textDescripcion);
		textDescripcion.setColumns(10);
		
		textBiografia = new JTextField();
		textBiografia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textBiografia.setBounds(225, 245, 170, 20);
		getContentPane().add(textBiografia);
		textBiografia.setColumns(10);
		
		textSitioWeb = new JTextField();
		textSitioWeb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textSitioWeb.setBounds(225, 269, 170, 20);
		getContentPane().add(textSitioWeb);
		textSitioWeb.setColumns(10);
		
		cboInsti = new JComboBox();
		cboInsti.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		cboInsti.setBounds(225, 291, 170, 22);
		getContentPane().add(cboInsti);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(43, 295, 139, 14);
		getContentPane().add(lblInstitucion);
		
		cboInsti.setEnabled(false);
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
		
		lblEmailEnUso = new JLabel("*Email en uso");
		lblEmailEnUso.setForeground(Color.RED);
		lblEmailEnUso.setBounds(405, 146, 170, 13);
		getContentPane().add(lblEmailEnUso);
		lblEmailEnUso.setVisible(false);
		
		lblUsuarioAñadido = new JLabel("Usuario añadido exitosamente!!!");
		lblUsuarioAñadido.setForeground(new Color(50, 205, 50));
		lblUsuarioAñadido.setBounds(95, 381, 215, 13);
		getContentPane().add(lblUsuarioAñadido);
		lblUsuarioAñadido.setVisible(false);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
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
					ICau.datosUsuario(nickname.toLowerCase(), nombre.toLowerCase(), apellido.toLowerCase(), email.toLowerCase(), fecha);
					if(rdbtnProfesor.isSelected()){
						String descripcion=textDescripcion.getText();
						String biografia=textBiografia.getText();
						String sitioweb=textSitioWeb.getText();
						insti=(String)cboInsti.getSelectedItem();
						institucion=mInst.buscarInstitucion(insti.toLowerCase());
						profe=true;
						ICau.datosProfesor(descripcion.toLowerCase(), biografia.toLowerCase(), sitioweb.toLowerCase(), institucion, profe);
					}
					ICau.altausuario();
					lblUsuarioAñadido.setVisible(true);
					int delay = 2000; //milliseconds
					ActionListener taskPerformer = new ActionListener() {
						public void actionPerformed(ActionEvent evt) {
					    	lblUsuarioAñadido.setVisible(false);
					    }
					};
					new javax.swing.Timer(delay, taskPerformer).start();
					formClose();
				} catch (UsuarioRepetidoException e1) {
					changeTextFormat(lblNickname, Color.RED);
					changeTextFormat(lblEmail, Color.RED);
					lblEmailEnUso.setVisible(true);
					lblErrorNickname.setVisible(true);
				} catch (ErrorFechaException e2) {
					changeTextFormat(lblFechaNaci, Color.RED);
					lblErrorFecha.setVisible(true);
				} catch (EmailRepetidoException e3) {
					changeTextFormat(lblEmail, Color.RED);
					lblEmailEnUso.setVisible(true);
				}catch (NicknameRepetidoException e4) {
					changeTextFormat(lblNickname, Color.RED);
					lblErrorNickname.setVisible(true);
				}
			}
			
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);
	}
}

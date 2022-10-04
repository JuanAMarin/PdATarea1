package presentacion;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import exceptions.ContraErrorException;
import exceptions.EmailRepetidoException;
import exceptions.ErrorFechaException;
import exceptions.NicknameRepetidoException;
import exceptions.UsuarioRepetidoException;
import interfaces.ICaltausuario;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class Altausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltausuario ICau;
	
	private JTextField textNickname;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textBiografia;
	private JTextField textSitioWeb;
	private JComboBox<String> cboInsti;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
	private JButton btnCancelar;
	private JButton btnAceptar;
	private JDateChooser dateFechaNac;
	private JLabel lblErrorFecha;
	private JLabel lblErrorEmail;
	private JLabel lblErrorNickname;
	private JLabel lblEmailEnUso;
	private JLabel lblFechaNaci;
	private JLabel lblNickname;
	private JLabel lblEmail;
	private JLabel lblConfContra;
	private JTextArea textAreaDescripcion;
	private JTextField textContra;
	private JTextField textConfContra;
	private JLabel lblContraseñaDiferente;
	private String filename = null;
	private byte[] personImage = null;
	private JLabel lblImage;
	
	/**
	 * Create the frame.
	 */
	public void formClose(){
		textNickname.setText("");
		textNombre.setText("");
		textApellido.setText("");
		textEmail.setText("");
		textAreaDescripcion.setText("");
		textBiografia.setText("");
		textSitioWeb.setText("");
		rdbtnProfesor.setSelected(false);
		rdbtnSocio.setSelected(false);
		dateFechaNac.setCalendar(null);
		cboInsti.setAction(null);
		textAreaDescripcion.setText("");
		textBiografia.setText("");
		textSitioWeb.setText("");
		cboInsti.setEnabled(false);
		textAreaDescripcion.setEnabled(false);
		textBiografia.setEnabled(false);
		textSitioWeb.setEnabled(false);
		lblEmailEnUso.setVisible(false);
		lblErrorEmail.setVisible(false);
		lblErrorFecha.setVisible(false);
		lblErrorNickname.setVisible(false);
		lblContraseñaDiferente.setVisible(false);
		textConfContra.setText("");
		textContra.setText("");
		File f= new File(".\\src\\main\\icono\\predeterminado.jpg");
		cargarImg(f);
		changeTextFormat(lblEmail, Color.BLACK);
		changeTextFormat(lblNickname, Color.BLACK);
		changeTextFormat(lblConfContra, Color.BLACK);
		changeTextFormat(lblFechaNaci, Color.BLACK);
	}
	
	private void changeTextFormat(JLabel l, Color c){
		l.setForeground(c);
	}
	
	public void habilitarPofSoc() {
		if (!textNickname.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()
			&& !textEmail.getText().isEmpty() && !((JTextField)dateFechaNac.getDateEditor().getUiComponent()).getText().isEmpty() && !textContra.getText().isEmpty() && !textConfContra.getText().isEmpty()) {
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
			&& (rdbtnSocio.isSelected() || (rdbtnProfesor.isSelected() && !textAreaDescripcion.getText().isEmpty() 
			&& !textBiografia.getText().isEmpty() && !textSitioWeb.getText().isEmpty() && cboInsti.getSelectedItem()!=null)) && !textContra.getText().isEmpty() && !textConfContra.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public void cargarImg(File f) {
		filename = f.getAbsolutePath();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(imageIcon);				
		try {
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readNum;(readNum = fis.read(buf))!=-1;){
				bos.write(buf,0,readNum);
			}
			personImage = bos.toByteArray();
			fis.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,e2);
		}
	}
	
	public Altausuario(ICaltausuario ICaltau) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Alta de Usuario");
		ICau = ICaltau;
		
		setBounds(100, 100, 524, 513);
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
		
		lblErrorEmail = new JLabel("*Email Incorrecto");
		lblErrorEmail.setForeground(Color.RED);
		lblErrorEmail.setBounds(405, 146, 170, 13);
		getContentPane().add(lblErrorEmail);
		
		dateFechaNac = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFechaNac.getDateEditor();
		editor.setEditable(false);
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
				changeTextFormat(lblFechaNaci, Color.BLACK);
			}
		});
		dateFechaNac.setBounds(225, 121, 170, 19);
		getContentPane().add(dateFechaNac);
		lblErrorFecha.setVisible(false);
				
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(33, 10, 220, 29);
		getContentPane().add(lblMensaje);
		
		lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(43, 49, 139, 14);
		getContentPane().add(lblNickname);
		lblErrorNickname.setVisible(false);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(43, 73, 139, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(43, 97, 125, 14);
		getContentPane().add(lblApellido);
		
		lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(43, 145, 99, 14);
		getContentPane().add(lblEmail);
		lblErrorEmail.setVisible(false);
		
		lblFechaNaci = new JLabel("FECHA DE NACIMIENTO");
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
				textAreaDescripcion.setEnabled(true);
				textBiografia.setEnabled(true);
				textSitioWeb.setEnabled(true);
				if(ICau.listarInstituciones().length < 1) {
					rdbtnSocio.setSelected(true);
					rdbtnProfesor.setSelected(false);
					textAreaDescripcion.setEnabled(false);
					textBiografia.setEnabled(false);
					textSitioWeb.setEnabled(false);
					cboInsti.setEnabled(false);
					llamadoMensajito2();
					habilitarAceptar();
				}
			}
		});
		rdbtnProfesor.setBounds(33, 227, 109, 23);
		getContentPane().add(rdbtnProfesor);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setEnabled(false);
		rdbtnSocio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				btnAceptar.setEnabled(false);
				cboInsti.setEnabled(false);
				textAreaDescripcion.setText("");
				textAreaDescripcion.setEnabled(false);
				textBiografia.setText("");
				textBiografia.setEnabled(false);
				textSitioWeb.setText("");
				textSitioWeb.setEnabled(false);
				if (!textNickname.getText().isEmpty() && !textNombre.getText().isEmpty() && !textApellido.getText().isEmpty()
						&& !textEmail.getText().isEmpty() && !dateFechaNac.getDateFormatString().isEmpty())
					btnAceptar.setEnabled(true);
			}
		});
		rdbtnSocio.setBounds(144, 227, 109, 23);
		getContentPane().add(rdbtnSocio);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(225, 252, 125, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("BIOGRAFÍA");
		lblBiografia.setBounds(43, 381, 139, 14);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("SITIO WEB");
		lblSitioWeb.setBounds(43, 405, 139, 14);
		getContentPane().add(lblSitioWeb);
		
		textBiografia = new JTextField();
		textBiografia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textBiografia.setBounds(225, 375, 170, 20);
		getContentPane().add(textBiografia);
		textBiografia.setColumns(10);
		
		textSitioWeb = new JTextField();
		textSitioWeb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textSitioWeb.setBounds(225, 403, 170, 20);
		getContentPane().add(textSitioWeb);
		textSitioWeb.setColumns(10);
		
		cboInsti = new JComboBox<String>();
		cboInsti.setBounds(225, 425, 170, 22);
		getContentPane().add(cboInsti);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(43, 429, 139, 14);
		getContentPane().add(lblInstitucion);
		
		cboInsti.setEnabled(false);
		textBiografia.setEnabled(false);
		textSitioWeb.setEnabled(false);		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				formClose();
				setVisible(false);
			}
		});
		
		btnCancelar.setBounds(405, 451, 98, 23);
		getContentPane().add(btnCancelar);
		
		lblEmailEnUso = new JLabel("*Email en uso");
		lblEmailEnUso.setForeground(Color.RED);
		lblEmailEnUso.setBounds(405, 146, 170, 13);
		getContentPane().add(lblEmailEnUso);
		lblEmailEnUso.setVisible(false);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String insti;
				boolean profe;
				String nickname=textNickname.getText();
				String nombre=textNombre.getText();
				String apellido=textApellido.getText();
				String email=textEmail.getText();
				String contra=textContra.getText();
				String confContra=textConfContra.getText();
				Date fecha = dateFechaNac.getDate();
				try {
					if(contra.compareTo(confContra)!=0)
						throw new ContraErrorException("La contraseña no coninside");
					ICau.datosUsuario(nickname.toLowerCase(), nombre, apellido, email.toLowerCase(), fecha, contra, personImage);
					if(rdbtnProfesor.isSelected()){
						String descripcion=textAreaDescripcion.getText();
						String biografia=textBiografia.getText();
						String sitioweb=textSitioWeb.getText();
						insti=(String)cboInsti.getSelectedItem();
						profe=true;
						ICau.datosProfesor(descripcion.toLowerCase(), biografia.toLowerCase(), sitioweb.toLowerCase(), insti, profe);
					}
					ICau.altausuario();
					llamadoMensajito(e,nickname);
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
				}catch (ContraErrorException e4) {
					changeTextFormat(lblConfContra, Color.RED);
					lblContraseñaDiferente.setVisible(true);
				}
			}
		});
		
		btnAceptar.setBounds(297, 451, 98, 23);
		getContentPane().add(btnAceptar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 279, -190, -104);
		getContentPane().add(scrollPane);
		
		textAreaDescripcion = new JTextArea();
		textAreaDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textAreaDescripcion.setLineWrap(true);
		textAreaDescripcion.setBounds(225, 220, 262, 89);
		getContentPane().add(textAreaDescripcion);
		JScrollPane scr = new JScrollPane(textAreaDescripcion);
		scr.setBounds(225, 276, 262, 89);
		getContentPane().add(scr);
		
		JLabel lblContra = new JLabel("CONTRASEÑA");
		lblContra.setBounds(43, 169, 99, 14);
		getContentPane().add(lblContra);
		
		lblConfContra = new JLabel("CONFIRMAR CONTRASEÑA");
		lblConfContra.setBounds(43, 193, 183, 14);
		getContentPane().add(lblConfContra);
		
		textContra = new JTextField();
		textContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textContra.setColumns(10);
		textContra.setBounds(225, 167, 170, 20);
		getContentPane().add(textContra);
		
		textConfContra = new JTextField();
		textConfContra.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				changeTextFormat(lblConfContra, Color.BLACK);
				lblContraseñaDiferente.setVisible(false);
			}
		});
		textConfContra.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
				habilitarPofSoc();
			}
		});
		textConfContra.setColumns(10);
		textConfContra.setBounds(225, 191, 170, 20);
		getContentPane().add(textConfContra);
		
		lblContraseñaDiferente = new JLabel("*Contra Diferente");
		lblContraseñaDiferente.setForeground(new Color(255, 0, 0));
		lblContraseñaDiferente.setBounds(405, 193, 183, 14);
		getContentPane().add(lblContraseñaDiferente);
		
		JButton btnLoadImage = new JButton("Seleccionar");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				cargarImg(f);
			}
		});
		btnLoadImage.setBounds(119, 311, 96, 21);
		getContentPane().add(btnLoadImage);
		
		lblImage = new JLabel("");
		lblImage.setBounds(20, 256, 89, 111);
		getContentPane().add(lblImage);
	}
	
	protected void llamadoMensajito(ActionEvent arg0, String nickname) {
		JOptionPane.showMessageDialog(this, "El usuario "+nickname+" se ha creado con éxito", "Alta de Usuario",
                JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void llamadoMensajito2() {
		JOptionPane.showMessageDialog(this, "No hay instituciones registradas en el sistema", "Alta de Usuario",
                JOptionPane.ERROR_MESSAGE);
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelInsti = new DefaultComboBoxModel<String>(ICau.listarInstituciones());
		cboInsti.setModel(modelInsti);
	}
}


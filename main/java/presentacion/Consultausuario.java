package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultausuario;
import logica.InstitucionDep;
import logica.Profesor;
import logica.Socio;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;

@SuppressWarnings("unused")
public class Consultausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICconsultausuario ICcu;
	
	private JComboBox<String> comboBoxNickname;
	private JTextArea textAreaUsu;
	private JTextField txtEmail;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtFechaNac;
	private JTextField txtDescripcion;
	private JTextField txtBiografia;
	private JTextField txtSitioWeb;
	private JRadioButton rdbtnProfe;
	private JLabel lblMensajito;

	/**
	 * Create the frame.
	 */
	public Consultausuario(ICconsultausuario ICcus) {	
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Consulta de usuario");
		this.ICcu = ICcus;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNickname.setBounds(23, 24, 200, 24);
		getContentPane().add(lblNickname);
		
		comboBoxNickname = new JComboBox<String>();
		comboBoxNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname=(String) comboBoxNickname.getSelectedItem();
				Profesor p = ICcu.buscarProfesor(nickname);
				if (p==null) {
					Socio s = ICcu.buscarSocio(nickname);
					lblMensajito.setText("ES SOCIO");
					txtEmail.setText(s.getEmail());
					txtNombre.setText(s.getNombre());
					txtApellido.setText(s.getApellido());
					txtFechaNac.setText(s.getFechaNac().toString());
				}else{
					lblMensajito.setText("ES PROFESOR");
					txtEmail.setText(p.getEmail());
					txtNombre.setText(p.getNombre());
					txtApellido.setText(p.getApellido());
					txtFechaNac.setText(p.getFechaNac().toString());
					txtDescripcion.setText(p.getDescripcion());
					txtBiografia.setText(p.getBiografia());
					txtSitioWeb.setText(p.getSitioweb());
				}
				lblMensajito.setVisible(true);
			}
		});
		comboBoxNickname.setBounds(188, 27, 231, 22);
		getContentPane().add(comboBoxNickname);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setBounds(188, 59, 231, 24);
		getContentPane().add(txtEmail);
		txtEmail.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(188, 95, 231, 24);
		getContentPane().add(txtNombre);
		
		txtApellido = new JTextField();
		txtApellido.setEditable(false);
		txtApellido.setColumns(10);
		txtApellido.setBounds(188, 129, 231, 24);
		getContentPane().add(txtApellido);
		
		txtFechaNac = new JTextField();
		txtFechaNac.setEditable(false);
		txtFechaNac.setColumns(10);
		txtFechaNac.setBounds(188, 164, 231, 24);
		getContentPane().add(txtFechaNac);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEditable(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(188, 199, 231, 24);
		getContentPane().add(txtDescripcion);
		
		txtBiografia = new JTextField();
		txtBiografia.setEditable(false);
		txtBiografia.setColumns(10);
		txtBiografia.setBounds(188, 234, 231, 24);
		getContentPane().add(txtBiografia);
		
		txtSitioWeb = new JTextField();
		txtSitioWeb.setEditable(false);
		txtSitioWeb.setColumns(10);
		txtSitioWeb.setBounds(188, 269, 231, 24);
		getContentPane().add(txtSitioWeb);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmail.setBounds(23, 59, 116, 24);
		getContentPane().add(lblEmail);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNombre.setBounds(23, 94, 179, 24);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblApellido.setBounds(23, 130, 179, 24);
		getContentPane().add(lblApellido);
		
		JLabel lblFechaNac = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNac.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFechaNac.setBounds(23, 164, 290, 24);
		getContentPane().add(lblFechaNac);
		
		JLabel lblDescripcion = new JLabel("DECRIPCIÓN");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDescripcion.setBounds(23, 199, 116, 24);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("BIOGRAFÍA");
		lblBiografia.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblBiografia.setBounds(23, 234, 116, 24);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("SITIO WEB");
		lblSitioWeb.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSitioWeb.setBounds(23, 269, 116, 24);
		getContentPane().add(lblSitioWeb);
		
		lblMensajito = new JLabel("New label");
		lblMensajito.setVisible(false);
		lblMensajito.setHorizontalAlignment(SwingConstants.CENTER);
		lblMensajito.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMensajito.setBounds(188, 304, 231, 38);
		getContentPane().add(lblMensajito);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(400, 376, 98, 23);
		getContentPane().add(btnSalir);

	}
	
	public void cargarCombo() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(ICcu.listarUsuarios());
		comboBoxNickname.setModel(modelUsuarios);
	}
	
	public void formClose(){
		txtEmail.setText("");
		txtNombre.setText("");
		txtApellido.setText("");
		txtFechaNac.setText("");
		txtDescripcion.setText("");
		txtBiografia.setText("");
		txtSitioWeb.setText("");
		lblMensajito.setVisible(false);
	}
}
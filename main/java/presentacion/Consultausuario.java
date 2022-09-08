package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultausuario;
import logica.InstitucionDep;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtProfesor;
import datatypes.DtSocio;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

@SuppressWarnings("unused")
public class Consultausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICconsultausuario ICcu;
	
	private JComboBox<String> comboBoxNickname;
	private JTextArea textAreaUsu;
	private JRadioButton rdbtnProfe;

	/**
	 * Create the frame.
	 */
	public Consultausuario(ICconsultausuario ICcus) {
		getContentPane().setBackground(Color.WHITE);	
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
		
		comboBoxNickname = new JComboBox<String>();
		comboBoxNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname=(String) comboBoxNickname.getSelectedItem();
				DtProfesor p = ICcu.buscarProfesor(nickname);
				if (p==null) {
					DtSocio s = ICcu.buscarSocio(nickname);
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
		comboBoxNickname.setBounds(74, 7, 231, 22);
		getContentPane().add(comboBoxNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(400, 376, 98, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(10, 11, 139, 14);
		getContentPane().add(lblNickname);

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
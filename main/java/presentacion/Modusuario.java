package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import interfaces.ICmodusuario;
import logica.Profesor;
import logica.Socio;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Modusuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICmodusuario ICmu;
	
	private JTextField txtDescripcion;
	private JTextField txtSitioWeb;
	private JTextField txtApellido;
	private JTextField txtNombre;
	private JComboBox<String> cboNicknames;
	private JTextField txtBiografia;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
	private JDateChooser dateFechaNac;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnVerInfo;
	private JTextField txtEmail;

	/**
	 * Create the frame.
	 */
	public void formClose() {
		txtNombre.setText("");
		txtApellido.setText("");
		dateFechaNac.setCalendar(null);
		txtEmail.setText("");
		txtDescripcion.setText("");
		txtSitioWeb.setText("");
		txtBiografia.setText("");
		rdbtnSocio.setSelected(false);
		rdbtnProfesor.setSelected(false);
		txtBiografia.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelNicks = new DefaultComboBoxModel<String>(ICmu.listarUsuarios());
		cboNicknames.setModel(modelNicks);
	}
	
	protected void verInfo(ActionEvent arg0) {
		if(this.cboNicknames.getSelectedItem()!=null) {
			String nickname = this.cboNicknames.getSelectedItem().toString();
			Profesor profe = ICmu.obtenerProfesor(nickname);
			if(profe==null) {
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				txtBiografia.setEnabled(false);
				txtSitioWeb.setEnabled(false);
				txtDescripcion.setEnabled(false);
				Socio socio = ICmu.obtenerSocio(nickname);
				txtApellido.setText(socio.getApellido());
				txtNombre.setText(socio.getNombre());
				dateFechaNac.setDate(socio.getFechaNac());
				txtEmail.setText(socio.getEmail());
			}else {
				rdbtnSocio.setSelected(false);
				rdbtnProfesor.setSelected(true);
				txtBiografia.setEnabled(true);
				txtSitioWeb.setEnabled(true);
				txtDescripcion.setEnabled(true);
				txtApellido.setText(profe.getApellido());
				txtNombre.setText(profe.getNombre());
				dateFechaNac.setDate(profe.getFechaNac());
				txtDescripcion.setText(profe.getDescripcion());
				txtBiografia.setText(profe.getBiografia());
				txtSitioWeb.setText(profe.getSitioweb());
				txtEmail.setText(profe.getEmail());
			}
			txtNombre.setEnabled(true);
			txtApellido.setEnabled(true);
		}
	}
	
	protected void Aceptar(ActionEvent arg0){
		String nickname=this.cboNicknames.getSelectedItem().toString();
		String nombre=this.txtNombre.getText();
		String apellido=this.txtApellido.getText();
		Date fecha=this.dateFechaNac.getDate();
		
		if (checkFormulario()) {
			if(rdbtnProfesor.isSelected()) {
				String descripcion=this.txtDescripcion.getText();
				String biografia=this.txtBiografia.getText();
				String sitioweb=this.txtSitioWeb.getText();
				ICmu.modProfesor(nickname, nombre, apellido, fecha, descripcion, biografia, sitioweb);
			} else if(rdbtnSocio.isSelected()) {
				ICmu.modSocio(nickname, nombre, apellido, fecha);
			}
            JOptionPane.showMessageDialog(this, "El Usuario "+nickname+" se ha modificado con Éxito", "Modificar Usuario",
                    JOptionPane.INFORMATION_MESSAGE);
            formClose();    
        }
	}
	
	private boolean checkFormulario() {
		if(rdbtnProfesor.isSelected()) {
	        if (txtDescripcion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtBiografia.getText().isEmpty() || txtSitioWeb.getText().isEmpty() || dateFechaNac.getDate()==null) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Institucion",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        return true;
		}else {
			if (txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || dateFechaNac.getDate()==null) {
	            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Institucion",
	                    JOptionPane.ERROR_MESSAGE);
	            return false;
	        }
	        return true;
		}
			
    }
	
	public Modusuario(ICmodusuario ICmodusu) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		ICmu = ICmodusu;
		
		setTitle("Modificar Usuario");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(31, 24, 139, 14);
		getContentPane().add(lblNickname);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(31, 48, 139, 14);
		getContentPane().add(lblNombre);
		
		JLabel lblApellido = new JLabel("APELLIDO");
		lblApellido.setBounds(31, 72, 125, 14);
		getContentPane().add(lblApellido);
		
		JLabel lblFechaNaci = new JLabel("FECHA DE NACIMIENTO");
		lblFechaNaci.setBounds(31, 96, 183, 14);
		getContentPane().add(lblFechaNaci);
		
		JLabel lblEmail = new JLabel("EMAIL");
		lblEmail.setBounds(31, 120, 99, 14);
		getContentPane().add(lblEmail);
		
		rdbtnProfesor = new JRadioButton("Profesor");
		rdbtnProfesor.setEnabled(false);
		rdbtnProfesor.setBounds(21, 161, 109, 23);
		getContentPane().add(rdbtnProfesor);
		
		rdbtnSocio = new JRadioButton("Socio");
		rdbtnSocio.setEnabled(false);
		rdbtnSocio.setBounds(132, 161, 109, 23);
		getContentPane().add(rdbtnSocio);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(31, 197, 125, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("BIOGRAFIA");
		lblBiografia.setBounds(31, 222, 139, 14);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("SITIO WEB");
		lblSitioWeb.setBounds(31, 246, 139, 14);
		getContentPane().add(lblSitioWeb);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setEnabled(false);
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(213, 195, 170, 20);
		getContentPane().add(txtDescripcion);
		
		txtSitioWeb = new JTextField();
		txtSitioWeb.setEnabled(false);
		txtSitioWeb.setColumns(10);
		txtSitioWeb.setBounds(213, 244, 170, 20);
		getContentPane().add(txtSitioWeb);
		
		dateFechaNac = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFechaNac.getDateEditor();
		editor.setEditable(false);
		dateFechaNac.setBounds(213, 96, 170, 19);
		getContentPane().add(dateFechaNac);
		
		txtApellido = new JTextField();
		txtApellido.setColumns(10);
		txtApellido.setBounds(213, 70, 170, 20);
		getContentPane().add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(213, 46, 170, 20);
		getContentPane().add(txtNombre);
		
		cboNicknames = new JComboBox<String>();
		cboNicknames.setBounds(213, 20, 170, 22);
		getContentPane().add(cboNicknames);
		
		btnVerInfo = new JButton("Ver Info");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				verInfo(e);
				btnAceptar.setEnabled(true);
			}
		});
		btnVerInfo.setBounds(385, 19, 117, 25);
		getContentPane().add(btnVerInfo);
		
		txtBiografia = new JTextField();
		txtBiografia.setEnabled(false);
		txtBiografia.setColumns(10);
		txtBiografia.setBounds(213, 219, 170, 20);
		getContentPane().add(txtBiografia);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aceptar(e);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(295, 378, 98, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(403, 378, 98, 23);
		getContentPane().add(btnCancelar);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(213, 120, 170, 20);
		getContentPane().add(txtEmail);
	}
}

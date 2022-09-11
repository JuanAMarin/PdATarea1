package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import datatypes.DtProfesor;
import datatypes.DtSocio;
import interfaces.ICmodusuario;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import javax.swing.JTextPane;

public class Modusuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICmodusuario ICmu;
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
	private JTextPane textPaneDescripcion;

	/**
	 * Create the frame.
	 */
	public void formClose() {
		txtNombre.setText("");
		txtApellido.setText("");
		dateFechaNac.setCalendar(null);
		txtEmail.setText("");
		textPaneDescripcion.setText("");
		txtSitioWeb.setText("");
		txtBiografia.setText("");
		rdbtnSocio.setSelected(false);
		rdbtnProfesor.setSelected(false);
		txtBiografia.setEnabled(false);
		txtNombre.setEnabled(false);
		txtApellido.setEnabled(false);
		textPaneDescripcion.setEnabled(false);
		txtSitioWeb.setEnabled(false);
		dateFechaNac.setEnabled(false);
	}
	
	public void habilitarAceptar() {
		if (!textPaneDescripcion.getText().isEmpty() && !txtSitioWeb.getText().isEmpty() 
			&& !txtApellido.getText().isEmpty() && !txtNombre.getText().isEmpty() 
			&& !txtBiografia.getText().isEmpty() && !((JTextField)dateFechaNac.getDateEditor().getUiComponent()).getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelNicks = new DefaultComboBoxModel<String>(ICmu.listarUsuarios());
		cboNicknames.setModel(modelNicks);
	}
	
	protected void verInfo(ActionEvent arg0) {
		if(this.cboNicknames.getSelectedItem()!=null) {
			String nickname = this.cboNicknames.getSelectedItem().toString();
			DtProfesor profe = ICmu.obtenerProfesor(nickname);
			if(profe==null) {
				dateFechaNac.setEnabled(true);
				rdbtnSocio.setSelected(true);
				rdbtnProfesor.setSelected(false);
				txtBiografia.setEnabled(false);
				txtSitioWeb.setEnabled(false);
				textPaneDescripcion.setEnabled(false);
				DtSocio socio = ICmu.obtenerSocio(nickname);
				txtApellido.setText(socio.getApellido());
				txtNombre.setText(socio.getNombre());
				dateFechaNac.setDate(socio.getFechaNac());
				txtEmail.setText(socio.getEmail());
				txtBiografia.setText("");
				textPaneDescripcion.setText("");
				txtSitioWeb.setText("");
			}else {
				dateFechaNac.setEnabled(true);
				rdbtnSocio.setSelected(false);
				rdbtnProfesor.setSelected(true);
				txtBiografia.setEnabled(true);
				txtSitioWeb.setEnabled(true);
				textPaneDescripcion.setEnabled(true);
				txtApellido.setText(profe.getApellido());
				txtNombre.setText(profe.getNombre());
				dateFechaNac.setDate(profe.getFechaNac());
				textPaneDescripcion.setText(profe.getDescripcion());
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
				String descripcion=this.textPaneDescripcion.getText();
				String biografia=this.txtBiografia.getText();
				String sitioweb=this.txtSitioWeb.getText();
				ICmu.modProfesor(nickname.toLowerCase(), nombre, apellido, fecha, descripcion, biografia, sitioweb);
			} else if(rdbtnSocio.isSelected()) {
				ICmu.modSocio(nickname.toLowerCase(), nombre, apellido, fecha);
			}
            JOptionPane.showMessageDialog(this, "El Usuario "+nickname+" se ha modificado con Éxito", "Modificar Usuario",
                    JOptionPane.INFORMATION_MESSAGE);
            formClose();    
        }
	}
	
	private boolean checkFormulario() {
		if(rdbtnProfesor.isSelected()) {
	        if (textPaneDescripcion.getText().isEmpty() || txtNombre.getText().isEmpty() || txtApellido.getText().isEmpty() || txtBiografia.getText().isEmpty() || txtSitioWeb.getText().isEmpty() || dateFechaNac.getDate()==null) {
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
		setBounds(100, 100, 524, 513);
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
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(31, 197, 125, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblBiografia = new JLabel("BIOGRAFÍA");
		lblBiografia.setBounds(31, 324, 139, 14);
		getContentPane().add(lblBiografia);
		
		JLabel lblSitioWeb = new JLabel("SITIO WEB");
		lblSitioWeb.setBounds(31, 348, 139, 14);
		getContentPane().add(lblSitioWeb);
		
		txtSitioWeb = new JTextField();
		txtSitioWeb.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		txtSitioWeb.setEnabled(false);
		txtSitioWeb.setColumns(10);
		txtSitioWeb.setBounds(213, 346, 170, 20);
		getContentPane().add(txtSitioWeb);
		
		dateFechaNac = new JDateChooser();
		dateFechaNac.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				habilitarAceptar();
			}
		});
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFechaNac.getDateEditor();
		editor.setEditable(false);
		dateFechaNac.setBounds(213, 96, 170, 19);
		getContentPane().add(dateFechaNac);
		
		txtApellido = new JTextField();
		txtApellido.setEnabled(false);
		txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		txtApellido.setColumns(10);
		txtApellido.setBounds(213, 70, 170, 20);
		getContentPane().add(txtApellido);
		
		txtNombre = new JTextField();
		txtNombre.setEnabled(false);
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		txtNombre.setColumns(10);
		txtNombre.setBounds(213, 46, 170, 20);
		getContentPane().add(txtNombre);
		
		cboNicknames = new JComboBox<String>();
		cboNicknames.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptar.setEnabled(false);
				textPaneDescripcion.setEnabled(false);
				txtSitioWeb.setEnabled(false);
				txtApellido.setEnabled(false);
				txtNombre.setEnabled(false);
				txtBiografia.setEnabled(false);
				dateFechaNac.setEnabled(false);
				txtEmail.setEnabled(false);
				textPaneDescripcion.setText("");
				txtSitioWeb.setText("");
				txtApellido.setText("");
				txtNombre.setText("");
				txtBiografia.setText("");
				dateFechaNac.setCalendar(null);
				txtEmail.setText("");
			}
		});
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
		txtBiografia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		txtBiografia.setEnabled(false);
		txtBiografia.setColumns(10);
		txtBiografia.setBounds(213, 321, 170, 20);
		getContentPane().add(txtBiografia);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aceptar(e);
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(296, 451, 98, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(404, 451, 98, 23);
		getContentPane().add(btnCancelar);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(213, 120, 170, 20);
		getContentPane().add(txtEmail);
		
		textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setBounds(213, 195, 289, 116);
		getContentPane().add(textPaneDescripcion);
		JScrollPane scr = new JScrollPane(textPaneDescripcion);
		scr.setBounds(213, 195, 289, 116);
		getContentPane().add(scr);
	}
}

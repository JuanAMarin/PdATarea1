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

import interfaces.ICmodusuario;
import logica.InstitucionDep;
import logica.ManejadorInstituciones;
import logica.Profesor;
import logica.Socio;
import logica.Usuario;
import persistencia.UsuarioID;

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
	private JComboBox<String> cboInsti;
	private JComboBox<String> cboEmail;
	private JTextField txtBiografia;
	private JRadioButton rdbtnProfesor;
	private JRadioButton rdbtnSocio;
	private JDateChooser dateFechaNac;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnVerInfo;

	/**
	 * Create the frame.
	 */
	private void limpiarFormulario() {
		txtDescripcion.setText("");
		txtApellido.setText("");
		txtNombre.setText("");
		txtSitioWeb.setText("");
		txtBiografia.setText("");
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelNicks = new DefaultComboBoxModel<String>(ICmu.listarUsuariosN());
		cboNicknames.setModel(modelNicks);
		
		DefaultComboBoxModel<String> modelEmail = new DefaultComboBoxModel<String>(ICmu.listarUsuariosE());
		cboNicknames.setModel(modelEmail);
	
		DefaultComboBoxModel<String> modelInsti = new DefaultComboBoxModel<String>(ICmu.listarInstituciones());
		cboInsti.setModel(modelInsti);
	}
	
	protected void verInfo(ActionEvent arg0) {
		if(this.cboNicknames.getSelectedItem()!=null) {
			String nickname = this.cboNicknames.getSelectedItem().toString();
			String email = this.cboEmail.getSelectedItem().toString();
			UsuarioID key = new UsuarioID(nickname, email);
			Profesor profe = ICmu.obtenerProfesor(key);
			if(profe==null) {
				Socio socio = ICmu.obtenerSocio(key);
				txtApellido.setText(socio.getApellido());
				txtNombre.setText(socio.getNombre());
				dateFechaNac.setDate(socio.getFechaNac());
			}else {
				txtApellido.setText(profe.getApellido());
				txtNombre.setText(profe.getNombre());
				dateFechaNac.setDate(profe.getFechaNac());
				txtDescripcion.setText(profe.getDescripcion());
				txtBiografia.setText(profe.getBiografia());
				txtSitioWeb.setText(profe.getSitioweb());
			}
		}
	}
	
	protected void Aceptar(ActionEvent arg0){
		String nickname=this.cboNicknames.getSelectedItem().toString();
		String nombre=this.cboNicknames.getSelectedItem().toString();
		String apellido=this.txtApellido.getSelectedText().toString();
		String email=this.cboEmail.getSelectedItem().toString();
		Date fecha=this.dateFechaNac.getDate();
		String descripcion=this.txtDescripcion.getSelectedText().toString();
		String biografia=this.txtBiografia.getSelectedText().toString();
		String sitioweb=this.txtSitioWeb.getSelectedText().toString();
		String insti=this.cboInsti.getSelectedItem().toString();
		ManejadorInstituciones mI = ManejadorInstituciones.getInstancia();
		InstitucionDep institucion = mI.buscarInstitucion(insti);
		if (checkFormulario()) {
			if(rdbtnProfesor.isSelected()) {
				ICmu.modProfesor(nickname, nombre, apellido, email, fecha, descripcion, biografia, sitioweb, institucion);
			} else if(rdbtnSocio.isSelected()) {
				ICmu.modSocio(nickname, nombre, apellido, email, fecha);
			}
            JOptionPane.showMessageDialog(this, "La Institucion "+nombre+" se ha modificado con Ã©xito", "Modificar Institucion",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();    
        }
	}
	
	private boolean checkFormulario() {
		String nombre=this.cboNicknames.getSelectedItem().toString();
		String apellido=this.txtApellido.getSelectedText().toString();
		String descripcion=this.txtDescripcion.getSelectedText().toString();
		String biografia=this.txtBiografia.getSelectedText().toString();
		String sitioweb=this.txtSitioWeb.getSelectedText().toString();
        if (descripcion.isEmpty() || nombre.isEmpty() || apellido.isEmpty() || biografia.isEmpty() || sitioweb.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacÃ­os", "Modificar Institucion",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	public Modusuario(ICmodusuario ICmodusu) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
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
		
		JLabel lblInstitucion = new JLabel("INSTITUCION");
		lblInstitucion.setBounds(31, 270, 139, 14);
		getContentPane().add(lblInstitucion);
		
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
		
		cboInsti = new JComboBox<String>();
		cboInsti.setEnabled(false);
		cboInsti.setBounds(213, 266, 170, 22);
		getContentPane().add(cboInsti);
		
		dateFechaNac = new JDateChooser();
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
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(403, 378, 98, 23);
		getContentPane().add(btnCancelar);
		
		cboEmail = new JComboBox<String>();
		cboEmail.setBounds(213, 121, 170, 22);
		getContentPane().add(cboEmail);

	}
}


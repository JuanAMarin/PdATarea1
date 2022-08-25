package presentacion;

import interfaces.ICaltadictadoclase;
import logica.Profesor;
import logica.Usuario;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import datatypes.DtClase;
//import exceptions.InstitucionRepetidaException;

//import datatypes.DtClase;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
//import java.awt.event.ActionListener;
//import java.awt.event.ActionEvent;

public class Altadictadoclase extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private ICaltadictadoclase ICac;
	private JTextField textFieldName;
	private JTextField textFieldDate;
	private JTextField textField_2;
	private JTextField textFieldProf;
	private JTextField textFieldURL;
	private JComboBox<String> comboBoxiD1;
	private JComboBox<String> comboBoxAD;
	private JLabel lblNewLabelID;
	private JLabel lblNewLabelAD;
	
	public Altadictadoclase(ICaltadictadoclase icon) {
		this.ICac = icon;
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Alta de Dictado de Clase");
		//setBounds(100, 100, 450, 300);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		lblNewLabelID = new JLabel("INSTITUCIÃ“N DEPORTIVA");
		lblNewLabelID.setBounds(43, 49, 139, 14);
		getContentPane().add(lblNewLabelID);
		
		lblNewLabelAD = new JLabel("ACTIVIDADES DEPORTIVAS");
		lblNewLabelAD.setBounds(43, 89, 139, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxiD1 = new JComboBox<String>();
		comboBoxiD1.setBounds(236, 46, 170, 20);
		getContentPane().add(comboBoxiD1);
		
		/*JComboBox<String> comboBoxID_1 = new JComboBox<String>();
		comboBoxID_1.setBounds(236, 143, 170, 20);
		getContentPane().add(comboBoxID_1);*/
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(236, 86, 170, 20);
		getContentPane().add(comboBoxAD);
		
		JLabel lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(43, 182, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		
		JLabel lblNewLabelFecha = new JLabel("FECHA DE INICIO");
		lblNewLabelFecha.setBounds(43, 217, 139, 14);
		getContentPane().add(lblNewLabelFecha);
		
		JLabel lblNewLabelHora = new JLabel("HORA DE INICIO");
		lblNewLabelHora.setBounds(43, 257, 139, 14);
		getContentPane().add(lblNewLabelHora);
		
		JLabel lblMensaje = new JLabel("Complete los datos de la clase:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(43, 139, 170, 29);
		getContentPane().add(lblMensaje);
		
		JLabel lblNewLabelProfesor = new JLabel("PROFESOR");
		lblNewLabelProfesor.setBounds(43, 297, 139, 14);
		getContentPane().add(lblNewLabelProfesor);
		
		JLabel lblNewLabelURL = new JLabel("URL");
		lblNewLabelURL.setBounds(43, 333, 139, 14);
		getContentPane().add(lblNewLabelURL);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(236, 179, 170, 20);
		getContentPane().add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldDate = new JTextField();
		textFieldDate.setColumns(10);
		textFieldDate.setBounds(236, 214, 170, 20);
		getContentPane().add(textFieldDate);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(236, 254, 170, 20);
		getContentPane().add(textField_2);
		
		textFieldProf = new JTextField();
		textFieldProf.setColumns(10);
		textFieldProf.setBounds(236, 294, 170, 20);
		getContentPane().add(textFieldProf);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(236, 330, 170, 20);
		getContentPane().add(textFieldURL);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				agregarClaseAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(292, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(400, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
	
		

	}
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICac.listarInstituciones());
		comboBoxiD1.setModel(modelinstituciones);
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICac.listarActividades());
		comboBoxAD.setModel(modelactividades);
	}
	
	protected void agregarClaseAceptarActionPerformed(ActionEvent arg0) {
		String nombre = this.textFieldName.getText();
		//seleccionar fecha
		//seleccionar hora
		String profesor = this.textFieldProf.getText();
		String url = this.textFieldURL.getText();
		ICac.datosClase(nombre, url, profesor);
	}
}


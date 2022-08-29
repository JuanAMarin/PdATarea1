package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICaltadictadoclase;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.*;
import java.util.Calendar;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;

import datatypes.DtHora;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import exceptions.ClaseRepetidaException;


import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class AltaDictadoClase extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	private ICaltadictadoclase ICac;
	private JLabel lblNewLabelID;
	private JLabel lblNewLabelAD;
	private JComboBox<String> comboBoxID;
	private JComboBox<String> comboBoxAD;
	private JButton btnAceptar;
	private JLabel lblMensaje;
	private JLabel lblNewLabelNombre;
	private JLabel lblNewLabelFecha;
	private JTextField textFieldNombre;
	private JDateChooser dateFecha;
	private JLabel lblNewLabelHora;
	private JSpinner spinnerHora;
	private JSpinner spinnerMin;
	private JLabel lblNewLabelProfesor;
	private JTextField textFieldProfesor;
	private JLabel lblNewLabelURL;
	private JTextField textFieldURL;
	private JTextField textField;
	private JButton btnCancelar;
	private JLabel lblNewLabelFechaR;

	
	public AltaDictadoClase(ICaltadictadoclase icac) {
		this.ICac = icac;
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Alta de Dictado de Clase");
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		lblNewLabelID = new JLabel("INSTITUCIÓN DEPORTIVA");
		lblNewLabelID.setBounds(60, 36, 139, 14);
		getContentPane().add(lblNewLabelID);
		
		lblNewLabelAD = new JLabel("ACTIVIDADES DEPORTIVAS");
		lblNewLabelAD.setBounds(60, 76, 139, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxID = new JComboBox<String>();
		comboBoxID.setBounds(245, 33, 170, 20);
		getContentPane().add(comboBoxID);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(245, 73, 170, 20);
		getContentPane().add(comboBoxAD);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agregarClaseActionPerformed(e);
				} catch (ClaseRepetidaException e1) {
					e1.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(296, 375, 98, 23);
		getContentPane().add(btnAceptar);
		
		lblMensaje = new JLabel("Complete los datos de la clase:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(60, 129, 170, 29);
		getContentPane().add(lblMensaje);
		
		lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(60, 169, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(245, 166, 170, 20);
		getContentPane().add(textFieldNombre);
		
		lblNewLabelFecha = new JLabel("FECHA DE INICIO");
		lblNewLabelFecha.setBounds(60, 202, 139, 14);
		getContentPane().add(lblNewLabelFecha);
		
		dateFecha = new JDateChooser();
		dateFecha.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		dateFecha.setBounds(245, 197, 170, 19);
		getContentPane().add(dateFecha);
		
		lblNewLabelHora = new JLabel("HORA DE INICIO");
		lblNewLabelHora.setBounds(60, 237, 139, 14);
		getContentPane().add(lblNewLabelHora);
		
		spinnerHora = new JSpinner();
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora.setBounds(245, 234, 41, 20);
		getContentPane().add(spinnerHora);
		
		spinnerMin = new JSpinner();
		spinnerMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMin.setBounds(296, 234, 41, 20);
		getContentPane().add(spinnerMin);
		
		lblNewLabelProfesor = new JLabel("PROFESOR");
		lblNewLabelProfesor.setBounds(60, 268, 139, 14);
		getContentPane().add(lblNewLabelProfesor);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setColumns(10);
		textFieldProfesor.setBounds(245, 265, 170, 20);
		getContentPane().add(textFieldProfesor);
		
		lblNewLabelURL = new JLabel("URL");
		lblNewLabelURL.setBounds(60, 299, 139, 14);
		getContentPane().add(lblNewLabelURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(245, 296, 170, 20);
		getContentPane().add(textFieldURL);
		
		lblNewLabelFechaR = new JLabel("FECHA REGISTRO");
		lblNewLabelFechaR.setBounds(60, 327, 139, 14);
		getContentPane().add(lblNewLabelFechaR);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(245, 324, 170, 20);
		getContentPane().add(textField);
		textField.setEnabled(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(400, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICac.listarInstituciones());
		comboBoxID.setModel(modelinstituciones);
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICac.listarActividades());
		comboBoxAD.setModel(modelactividades);
	}
	
	protected void agregarClaseActionPerformed(ActionEvent arg0) throws ClaseRepetidaException {
		LocalDateTime fechaReg = LocalDateTime.now();
		textField.setText(fechaReg.toString());
		String strID = this.comboBoxID.getSelectedItem().toString();
		String strAD = this.comboBoxAD.getSelectedItem().toString();
		String nombre=textFieldNombre.getText();
		Date fecha = dateFecha.getDate();
		String prof = textFieldProfesor.getText();
		String url = textFieldURL.getText();
		Integer hora = (Integer) spinnerHora.getValue();
		Integer min = (Integer) spinnerMin.getValue();
		DtHora h = new DtHora(hora, min);
		if(checkFormulario()) {
			ICac.altaClase(nombre, url, fecha, fechaReg, h, prof);
			JOptionPane.showMessageDialog(this, "La Clase "+nombre+" se ha creado con éxito", "Alta de Dictado de Clase",
	                JOptionPane.INFORMATION_MESSAGE);
			limpiarFormulario();
			setVisible(false); 
		}
			
	}
	
	protected void cancelarActionPerformed(ActionEvent arg0) {
		limpiarFormulario();
		setVisible(false);  
	}
	
	
	private boolean checkFormulario() {
		String strID = this.comboBoxID.getSelectedItem().toString();
		String strAD = this.comboBoxAD.getSelectedItem().toString();
		String nombre=textFieldNombre.getText();
		String fecha = dateFecha.getDateFormatString();
		String prof = textFieldProfesor.getText();
		String url = textFieldURL.getText();
		if(strID.isEmpty() || strAD.isEmpty() || nombre.isEmpty() || fecha.isEmpty() || prof.isEmpty() || url.isEmpty() || url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Dictado Clase",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	private void limpiarFormulario() {
        textFieldNombre.setText(null);
		textFieldProfesor.setText(null);
        textFieldURL.setText(null);
	 }
	
}



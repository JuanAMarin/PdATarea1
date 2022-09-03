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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import exceptions.ClaseRepetidaException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

public class Altadictadoclase extends JInternalFrame{

	private static final long serialVersionUID = 1L;
	
	private ICaltadictadoclase ICac;
	
	private JLabel lblNewLabelID;
	private JLabel lblNewLabelAD;
	private JComboBox<String> comboBoxID;
	private JComboBox<String> comboBoxAD;
	private JComboBox<String> comboBoxProfe;
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
	private JLabel lblNewLabelURL;
	private JTextField textFieldURL;
	private JTextField textField;
	private JButton btnCancelar;
	private JLabel lblNewLabelFechaR;
	
	public void habilitarAceptar() {
		if (!textFieldNombre.getText().isEmpty() && !textFieldURL.getText().isEmpty()
			&& !((JTextField)dateFecha.getDateEditor().getUiComponent()).getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public Altadictadoclase(ICaltadictadoclase icac) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		this.ICac = icac;
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Alta de Dictado de Clase");
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		lblNewLabelID = new JLabel("INSTITUCIÓN DEPORTIVA");
		lblNewLabelID.setBounds(60, 36, 194, 14);
		getContentPane().add(lblNewLabelID);
		
		lblNewLabelAD = new JLabel("ACTIVIDADES DEPORTIVAS");
		lblNewLabelAD.setBounds(60, 76, 226, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxID = new JComboBox<String>();
		comboBoxID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarComboBoxAD();
			}
		});
		comboBoxID.setBounds(245, 33, 170, 20);
		getContentPane().add(comboBoxID);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(245, 73, 170, 20);
		getContentPane().add(comboBoxAD);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
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
		textFieldNombre.setBounds(245, 167, 170, 20);
		getContentPane().add(textFieldNombre);
		
		lblNewLabelFecha = new JLabel("FECHA DE INICIO");
		lblNewLabelFecha.setBounds(60, 202, 139, 14);
		getContentPane().add(lblNewLabelFecha);
		
		dateFecha = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFecha.getDateEditor();
		editor.setEditable(false);
		dateFecha.getDateEditor().addPropertyChangeListener(
			    new PropertyChangeListener() {
			        @Override
			        public void propertyChange(PropertyChangeEvent e) {
			        	habilitarAceptar();
			        }
			    });
		dateFecha.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				//lblErrorFecha.setVisible(false);
				//changeTextFormat(lblFecha, Color.BLACK);
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
		
		comboBoxProfe = new JComboBox<String>();
		comboBoxProfe.setBounds(245, 264, 170, 20);
		getContentPane().add(comboBoxProfe);
		
	}
	
	public void inicializarComboBoxID() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICac.listarInstituciones());
		comboBoxID.setModel(modelinstituciones);
	}
	
	public void inicializarComboBoxAD() {
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICac.listarActividades((String)comboBoxID.getSelectedItem()));
		comboBoxAD.setModel(modelactividades);
	}
	
	public void inicializarComboBoxP() {
		DefaultComboBoxModel<String> modelProfesores = new DefaultComboBoxModel<String>(ICac.listarProfesores((String)comboBoxID.getSelectedItem()));
		comboBoxProfe.setModel(modelProfesores);
	}
	
	protected void agregarClaseActionPerformed(ActionEvent arg0) throws ClaseRepetidaException {
		Date fechaReg = new Date();
		textField.setText(fechaReg.toString());
		String strID = comboBoxID.getSelectedItem().toString();
		String strAD = comboBoxAD.getSelectedItem().toString();
		String nombre=textFieldNombre.getText();
		Date fecha = dateFecha.getDate();
		String prof = comboBoxProfe.getSelectedItem().toString();
		String url = textFieldURL.getText();
		Integer hora = (Integer) spinnerHora.getValue();
		Integer min = (Integer) spinnerMin.getValue();
		String sDate1 = "1900/01/01 " + hora + ":" + min + ":00";
		Date h = null;
		try {
			h = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss").parse(sDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(checkFormulario()) {
			
			try {
				ICac.altaClase(nombre, url, fecha, fechaReg, h, prof);
			} catch (ClaseRepetidaException e) {
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(this, "La Clase "+nombre+" se ha creado con Éxito", "Alta de Dictado de Clase",
	                JOptionPane.INFORMATION_MESSAGE);
			formClose();
			setVisible(false); 
		}
			
	}
	
	protected void cancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);  
	}
	
	
	private boolean checkFormulario() {
		String strID = comboBoxID.getSelectedItem().toString();
		String strAD = comboBoxAD.getSelectedItem().toString();
		String nombre=textFieldNombre.getText();
		String fecha = dateFecha.getDateFormatString();
		String prof = comboBoxProfe.getSelectedItem().toString();
		String url = textFieldURL.getText();
		if(strID.isEmpty() || strAD.isEmpty() || nombre.isEmpty() || fecha.isEmpty() || prof.isEmpty() || url.isEmpty() || url.isEmpty()) {
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta Dictado Clase",
                    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
	
	public void formClose() {
        textFieldNombre.setText(null);
        textFieldURL.setText(null);
        dateFecha.setCalendar(null);
        spinnerHora.setValue(0);
        spinnerMin.setValue(0);
	 }
}





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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import exceptions.ClaseRepetidaException;
import exceptions.ErrorFechaException;

import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
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
	private JButton btnCancelar;
	private JButton btnConfirmar;
	private JLabel lblErrorNombre;
	private JLabel lblErrorFecha;
	
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
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		lblErrorFecha = new JLabel("*Fecha Incorrecta");
		lblErrorFecha.setForeground(Color.RED);
		lblErrorFecha.setBounds(410, 203, 170, 13);
		getContentPane().add(lblErrorFecha);
		
		lblErrorNombre = new JLabel("*Nombre en uso");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(410, 170, 170, 13);
		getContentPane().add(lblErrorNombre);
		
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
		comboBoxID.setBounds(233, 33, 170, 20);
		getContentPane().add(comboBoxID);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(233, 73, 170, 20);
		getContentPane().add(comboBoxAD);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					agregarClaseActionPerformed(e);
				} catch (ClaseRepetidaException e1) {
					e1.printStackTrace();
				}catch (ErrorFechaException e2) {
					e2.printStackTrace();
				}
			}
		});
		btnAceptar.setBounds(296, 451, 98, 23);
		getContentPane().add(btnAceptar);
		
		lblMensaje = new JLabel("Complete los datos de la clase:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(60, 129, 170, 29);
		getContentPane().add(lblMensaje);
		
		lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(60, 169, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		lblErrorNombre.setVisible(false);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblNewLabelNombre, Color.BLACK);
				lblErrorNombre.setVisible(false);
				habilitarAceptar();
			}
		});
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(233, 167, 170, 20);
		getContentPane().add(textFieldNombre);
		
		lblNewLabelFecha = new JLabel("FECHA DE INICIO");
		lblNewLabelFecha.setBounds(60, 202, 139, 14);
		getContentPane().add(lblNewLabelFecha);
		
		dateFecha = new JDateChooser();
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateFecha.getDateEditor();
		editor.setEditable(false);
		dateFecha.setEnabled(false);
		dateFecha.getDateEditor().addPropertyChangeListener(new PropertyChangeListener() {
	        @Override
	        public void propertyChange(PropertyChangeEvent e) {
	        	habilitarAceptar();
	        }
	    });
				
		dateFecha.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				lblErrorFecha.setVisible(false);
				changeTextFormat(lblNewLabelFecha, Color.BLACK);
			}
		});
		dateFecha.setBounds(233, 197, 170, 19);
		getContentPane().add(dateFecha);
		
		lblNewLabelHora = new JLabel("HORA DE INICIO");
		lblNewLabelHora.setBounds(60, 237, 139, 14);
		getContentPane().add(lblNewLabelHora);
		
		spinnerHora = new JSpinner();
		spinnerHora.setEnabled(false);
		spinnerHora.setModel(new SpinnerNumberModel(0, 0, 23, 1));
		spinnerHora.setBounds(233, 235, 41, 20);
		getContentPane().add(spinnerHora);
		
		spinnerMin = new JSpinner();
		spinnerMin.setEnabled(false);
		spinnerMin.setModel(new SpinnerNumberModel(0, 0, 59, 1));
		spinnerMin.setBounds(284, 235, 41, 20);
		getContentPane().add(spinnerMin);
		
		lblNewLabelProfesor = new JLabel("PROFESOR");
		lblNewLabelProfesor.setBounds(60, 268, 139, 14);
		getContentPane().add(lblNewLabelProfesor);
		
		lblNewLabelURL = new JLabel("URL");
		lblNewLabelURL.setBounds(60, 299, 139, 14);
		getContentPane().add(lblNewLabelURL);
		
		textFieldURL = new JTextField();
		textFieldURL.setEnabled(false);
		textFieldURL.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblNewLabelNombre, Color.BLACK);
				lblErrorNombre.setVisible(false);
				habilitarAceptar();
			}
		});
		textFieldURL.setColumns(10);
		textFieldURL.setBounds(233, 297, 170, 20);
		getContentPane().add(textFieldURL);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					cancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(404, 451, 98, 23);
		getContentPane().add(btnCancelar);
		
		comboBoxProfe = new JComboBox<String>();
		comboBoxProfe.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		comboBoxProfe.setBounds(233, 265, 170, 20);
		getContentPane().add(comboBoxProfe);
		
		btnConfirmar = new JButton("Confirmar");
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(ICac.listarProfesores(comboBoxID.getSelectedItem().toString()) .length < 1) {
					elmensajito();
					textFieldNombre.setEnabled(false);
					dateFecha.setEnabled(false);
					spinnerHora.setEnabled(false);
					spinnerMin.setEnabled(false);
					textFieldURL.setEnabled(false);
				}else {
					confirmarActionPerformed(e);
					textFieldNombre.setEnabled(true);
					dateFecha.setEnabled(true);
					spinnerHora.setEnabled(true);
					spinnerMin.setEnabled(true);
					textFieldURL.setEnabled(true);
				}
			}
		});
		btnConfirmar.setBounds(317, 104, 98, 23);
		getContentPane().add(btnConfirmar);
		
	}
	
	public void inicializarComboBoxID() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICac.listarInstituciones());
		comboBoxID.setModel(modelinstituciones);
	}
	
	public void inicializarComboBoxAD() {
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICac.listarActividades((String)comboBoxID.getSelectedItem()));
		comboBoxAD.setModel(modelactividades);
		if ((comboBoxID.getItemCount() != 0) && (comboBoxAD.getItemCount() !=0))
			btnConfirmar.setEnabled(true);
		else
			btnConfirmar.setEnabled(false);
	}
	
	public void inicializarComboBoxP() {
		DefaultComboBoxModel<String> modelProfesores = new DefaultComboBoxModel<String>(ICac.listarProfesores((String)comboBoxID.getSelectedItem()));
		comboBoxProfe.setModel(modelProfesores);
	}
	
	protected void agregarClaseActionPerformed(ActionEvent arg0) throws ClaseRepetidaException, ErrorFechaException {
		Date fechaReg = new Date();
		String nombre=textFieldNombre.getText();
		Date fecha = dateFecha.getDate();
		String prof = comboBoxProfe.getSelectedItem().toString();
		String url = textFieldURL.getText();
		Integer hora = (Integer) spinnerHora.getValue();
		Integer min = (Integer) spinnerMin.getValue();
		String sDate1 = "1900/01/01 " + hora + ":" + min + ":00";
		Date h = null;
		String actividad = comboBoxAD.getSelectedItem().toString();
		try {
			h = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").parse(sDate1);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		if(checkFormulario()) {
			try {
				ICac.altaClase(nombre.toLowerCase(), url, fecha, fechaReg, h, prof.toLowerCase(), actividad.toLowerCase());
				JOptionPane.showMessageDialog(this, "La Clase "+nombre+" se ha creado con Ã‰xito", "Alta de Dictado de Clase",
		                JOptionPane.INFORMATION_MESSAGE);
				formClose();
			} catch (ClaseRepetidaException e) {
				changeTextFormat(lblNewLabelNombre, Color.RED);
				lblErrorNombre.setVisible(true);
			}
			catch (ErrorFechaException e) {
				changeTextFormat(lblNewLabelFecha, Color.RED);
				lblErrorFecha.setVisible(true);
			}
		}
			
	}
	
	protected void cancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);  
	}
	
	protected void confirmarActionPerformed (ActionEvent arg0) {
		inicializarComboBoxP();
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
        comboBoxProfe.removeAllItems();
        lblErrorFecha.setVisible(false);
        lblErrorNombre.setVisible(false);
        changeTextFormat(lblNewLabelFecha,Color.BLACK);
        changeTextFormat(lblNewLabelNombre,Color.BLACK);
	}
	
	private void changeTextFormat(JLabel l, Color c){
		l.setForeground(c);
	}
	private void elmensajito() {
		JOptionPane.showMessageDialog(this, comboBoxID.getSelectedItem().toString()+" no cuenta con profesores", "Alta Dictado Clase",
                JOptionPane.ERROR_MESSAGE);
	}
}





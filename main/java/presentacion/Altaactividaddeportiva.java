package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICaltaactividaddeportiva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Altaactividaddeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltaactividaddeportiva ICaad;
	
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JComboBox<String> cboInsti;
	
	public Altaactividaddeportiva(ICaltaactividaddeportiva ICaltaad) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				//formClose();
			}
		});
		setClosable(true);
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		ICaad = ICaltaad;
		setTitle("Alta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(30, 55, 139, 14);
		getContentPane().add(lblInstitucion);
		
		cboInsti = new JComboBox<String>();
		cboInsti.setEditable(true);
		cboInsti.setBounds(179, 51, 170, 22);
		getContentPane().add(cboInsti);
		
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(20, 11, 170, 29);
		getContentPane().add(lblMensaje);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 89, 139, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(179, 86, 170, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(30, 117, 139, 14);
		getContentPane().add(lblDescripcion);
		
		JTextArea txtDesc = new JTextArea();
		txtDesc.setForeground(Color.BLACK);
		txtDesc.setWrapStyleWord(true);
		txtDesc.setLineWrap(true);
		txtDesc.setRows(2);
		txtDesc.setBounds(179, 116, 170, 52);
		getContentPane().add(txtDesc);
		
		JSpinner spnDuracion = new JSpinner();
		spnDuracion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnDuracion.setBounds(179, 179, 170, 20);
		getContentPane().add(spnDuracion);
		
		JLabel lblDuracion = new JLabel("DURACIÓN");
		lblDuracion.setBounds(30, 182, 139, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("COSTO");
		lblCosto.setBounds(30, 213, 139, 14);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.setColumns(10);
		txtCosto.setBounds(179, 210, 170, 20);
		getContentPane().add(txtCosto);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String insti = cboInsti.getSelectedItem().toString();
				String nombre = txtNombre.getText(), descripcion = txtDesc.getText();
				Integer duracion = (Integer) spnDuracion.getValue();
				float costo = Float.parseFloat(txtCosto.getText());
				ICaltaad.datosActividad(nombre, descripcion, duracion, costo, insti);
				ICaltaad.altaActividad();
			}
		});
		btnAceptar.setBounds(298, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(404, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICaad.listarInstituciones());
		cboInsti.setModel(modelinstituciones);
	}

}


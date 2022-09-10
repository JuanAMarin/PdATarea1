package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import exceptions.ActividadRepetidaException;
import interfaces.ICaltaactividaddeportiva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Altaactividaddeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltaactividaddeportiva ICaad;
	
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JComboBox<String> cboInsti;
	private JTextArea txtDesc;
	private JSpinner spnDuracion;
	private JButton btnAceptar;
	private JLabel lblErrorNombre;
	private JLabel lblNombre;
	
	private void changeTextFormat(JLabel l, Color c){
		l.setForeground(c);
	}
	
	public void habilitarAceptar() {
		if (!txtNombre.getText().isEmpty() && !txtCosto.getText().isEmpty()
			&& !txtDesc.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	@SuppressWarnings("removal")
	public Altaactividaddeportiva(ICaltaactividaddeportiva ICaltaad) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		setBounds(100, 100, 524, 513);
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
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 89, 139, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblErrorNombre.setVisible(false);
				changeTextFormat(lblNombre,Color.BLACK);
				habilitarAceptar();
			}
		});
		txtNombre.setBounds(179, 86, 170, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblErrorNombre = new JLabel("*Esa actividad ya existe");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(359, 90, 170, 13);
		getContentPane().add(lblErrorNombre);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(30, 117, 139, 14);
		getContentPane().add(lblDescripcion);
		
		txtDesc = new JTextArea();
		txtDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		txtDesc.setForeground(Color.BLACK);
		txtDesc.setWrapStyleWord(true);
		txtDesc.setLineWrap(true);
		txtDesc.setRows(2);
		txtDesc.setBounds(179, 116, 170, 52);
		getContentPane().add(txtDesc);
		
		spnDuracion = new JSpinner();
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
		txtCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		txtCosto.setColumns(10);
		txtCosto.setBounds(179, 210, 170, 20);
		getContentPane().add(txtCosto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(296, 451, 98, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(404, 451, 98, 23);
		getContentPane().add(btnCancelar);
		
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICaad.listarInstituciones());
		cboInsti.setModel(modelinstituciones);
	}
	
	protected void AceptarActionPerformed(ActionEvent arg0) {
		String insti = cboInsti.getSelectedItem().toString();
		String nombre = txtNombre.getText(), descripcion = txtDesc.getText();
		Integer duracion = (Integer) spnDuracion.getValue();
		float costo = Float.parseFloat(txtCosto.getText());
		if(checkFormulario()) {
			try {
			ICaad.datosActividad(nombre.toLowerCase(), descripcion, duracion, costo, insti.toLowerCase());
			ICaad.altaActividad();
			JOptionPane.showMessageDialog(this, "La Actividad Deportiva "+nombre+" se ha creado con exito", "Alta Actividad Deportiva",
                    JOptionPane.INFORMATION_MESSAGE);
			formClose();
			}catch (ActividadRepetidaException e1){
				lblErrorNombre.setVisible(true);
				changeTextFormat(lblNombre,Color.RED);
			}
		}
	}
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);
	}
	
	private boolean checkFormulario() {
        String nombre = this.txtNombre.getText().toString();
        String descripcion = this.txtDesc.getText().toString();
        String costo = String.valueOf(this.txtCosto.getText());
        if (nombre.isEmpty() || descripcion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	public void formClose() {
		txtNombre.setText("");
		txtDesc.setText("");
		spnDuracion.setValue(1);
		txtCosto.setText("");
		lblErrorNombre.setVisible(false);
		changeTextFormat(lblNombre,Color.BLACK);
	}

}


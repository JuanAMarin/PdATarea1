package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import exceptions.InstitucionRepetidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import interfaces.ICaltainstitucion;

public class Altainstitucion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltainstitucion ICai;
	
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JTextField textFieldUrl;
	private JLabel lblErrorNombre;
	private JLabel lblIns;

	/**
	 * Create the frame.
	 */
	
	public void formClose() {
		textFieldNombre.setText("");
		textFieldDesc.setText("");
		textFieldUrl.setText("");
		lblErrorNombre.setVisible(false);
		changeTextFormat(lblIns, Color.BLACK);
	}
	
	private void changeTextFormat(JLabel l, Color c){
		l.setForeground(c);
	}
	
	public void habilitarAceptar() {
		if (!textFieldNombre.getText().isEmpty() && !textFieldDesc.getText().isEmpty() && !textFieldUrl.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public Altainstitucion(ICaltainstitucion ICaltai) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		setClosable(true);
		
		setTitle("Alta de Institucion");
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		ICai = ICaltai;
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitucionAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(305, 449, 98, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(409, 449, 89, 23);
		getContentPane().add(btnCancelar);
		
		lblErrorNombre = new JLabel("*Esa institucion ya existe");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(369, 55, 170, 13);
		getContentPane().add(lblErrorNombre);
		
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(10, 11, 170, 29);
		getContentPane().add(lblMensaje);
		
		lblIns = new JLabel("NOMBRE INSTITUCIÓN");
		lblIns.setBounds(21, 54, 236, 14);
		getContentPane().add(lblIns);
		lblErrorNombre.setVisible(false);
		
		JLabel lblDesc = new JLabel("DESCRIPCIÓN");
		lblDesc.setBounds(21, 94, 111, 14);
		getContentPane().add(lblDesc);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(21, 132, 124, 14);
		getContentPane().add(lblUrl);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				changeTextFormat(lblIns,Color.BLACK);
				lblErrorNombre.setVisible(false);
				habilitarAceptar();
			}
		});
		textFieldNombre.setBounds(196, 51, 170, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDesc = new JTextField();
		textFieldDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldDesc.setBounds(196, 91, 170, 20);
		getContentPane().add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldUrl = new JTextField();
		textFieldUrl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldUrl.setBounds(196, 129, 170, 20);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
	}
		
	protected void agregarInstitucionAceptarActionPerformed(ActionEvent arg0) {
			String nombre=this.textFieldNombre.getText();
			String descripcion=this.textFieldDesc.getText();
			String url=this.textFieldUrl.getText();
			if (checkFormulario()) {
	            try {
	                ICai.altaInstitucion(nombre.toLowerCase(), descripcion, url);
	                JOptionPane.showMessageDialog(this, "La Institución "+nombre+" se ha creado con éxito", "Alta de Institucion",
	                        JOptionPane.INFORMATION_MESSAGE);
	                limpiarFormulario();
	                btnAceptar.setEnabled(false);
	            } catch (InstitucionRepetidaException e) {
	            	changeTextFormat(lblIns,Color.RED);
	            	lblErrorNombre.setVisible(true);
	            	btnAceptar.setEnabled(false);
	            }       
	        }
	}
	
	private boolean checkFormulario() {
        String nombre = this.textFieldNombre.getText();
        String descripcion = this.textFieldDesc.getText();
        String url=this.textFieldUrl.getText();
        if (nombre.isEmpty() || descripcion.isEmpty() || url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Alta de Institucion",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	 private void limpiarFormulario() {
        textFieldNombre.setText("");
        textFieldDesc.setText("");
        textFieldUrl.setText("");
	 }
	 
}

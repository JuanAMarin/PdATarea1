package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.event.ActionEvent;
import exceptions.InstitucionRepetidaException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import interfaces.ICaltainstitucion;




public class Altainstitucion extends JInternalFrame {
	private ICaltainstitucion ICai;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JTextField textFieldUrl;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		ICai = ICaltai;
		
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				agregarInstitucionAceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(409, 376, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(19, 4, 170, 29);
		getContentPane().add(lblMensaje);
		
		JLabel lblIns = new JLabel("NOMBRE INSTITUCION");
		lblIns.setBounds(19, 142, 236, 14);
		getContentPane().add(lblIns);
		
		JLabel lblDesc = new JLabel("DESCRIPCION");
		lblDesc.setBounds(19, 177, 111, 14);
		getContentPane().add(lblDesc);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(19, 213, 124, 14);
		getContentPane().add(lblUrl);
		
		textFieldNombre = new JTextField();
		textFieldNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldNombre.setBounds(196, 140, 170, 20);
		getContentPane().add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		textFieldDesc = new JTextField();
		textFieldDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldDesc.setBounds(196, 175, 170, 20);
		getContentPane().add(textFieldDesc);
		textFieldDesc.setColumns(10);
		
		textFieldUrl = new JTextField();
		textFieldUrl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldUrl.setBounds(196, 211, 170, 20);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
	}
		
	protected void agregarInstitucionAceptarActionPerformed(ActionEvent arg0) {
			String nombre=this.textFieldNombre.getText();
			String descripcion=this.textFieldDesc.getText();
			String url=this.textFieldUrl.getText();
			if (checkFormulario()) {
	            try {
	                ICai.altaInstitucion(nombre, descripcion, url);
	                JOptionPane.showMessageDialog(this, "La Institucion "+nombre+" se ha creado con éxito", "Alta de Institucion",
	                        JOptionPane.INFORMATION_MESSAGE);
	                limpiarFormulario();
	                btnAceptar.setEnabled(false);
	            } catch (InstitucionRepetidaException e) {
	                JOptionPane.showMessageDialog(this, e.getMessage(), "Alta de Institucion", JOptionPane.ERROR_MESSAGE);  
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

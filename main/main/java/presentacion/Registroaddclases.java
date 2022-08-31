package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICrankingdeclases;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Registroaddclases extends JInternalFrame {
	private ICrankingdeclases ICrc;
	private static final long serialVersionUID = 1L;
	
	private JLabel lblUsuarioAñadido;
	private JButton btnAceptar;
	private JButton btnCancelar;
	
	/**
	 * Create the frame.
	 */
	private void formClose(){
		///sdfsdfsdf
	}
	
	public Registroaddclases(ICrankingdeclases ICmodi) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
				setVisible(false);
			}
		});
		setClosable(true);
		
		setTitle("Registro a Dictado de Clases");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		lblUsuarioAñadido = new JLabel("Usuario añadido exitosamente!!!");
		lblUsuarioAñadido.setForeground(new Color(50, 205, 50));
		lblUsuarioAñadido.setBounds(95, 381, 215, 13);
		getContentPane().add(lblUsuarioAñadido);
		lblUsuarioAñadido.setVisible(false);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(404, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(295, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		ICrc = ICmodi;
	}
}


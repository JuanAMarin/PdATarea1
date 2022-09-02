package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

import interfaces.*;
import logica.InstitucionDep;

import javax.swing.JFormattedTextField;
import javax.swing.JSpinner;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JScrollBar;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.*;
import java.awt.event.ActionEvent;

public class altausuario extends JInternalFrame {
	
	private ICaltausuario ICau;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;

	/**
	 * Create the frame.
	 */
	public altausuario(ICaltausuario ICaltau) {
		ICau = ICaltau;
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Alta de Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblNewLabel.setBounds(118, 11, 275, 83);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nickname");
		lblNewLabel_1.setBounds(48, 113, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(48, 150, 46, 14);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Apellido");
		lblNewLabel_3.setBounds(48, 186, 46, 14);
		getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setBounds(48, 222, 46, 14);
		getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Fecha de nacimiento");
		lblNewLabel_5.setBounds(48, 257, 98, 14);
		getContentPane().add(lblNewLabel_5);
		
		textField = new JTextField();
		textField.setBounds(173, 110, 86, 20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(173, 147, 86, 20);
		getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(173, 183, 86, 20);
		getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(173, 219, 86, 20);
		getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JSpinner spinner = new JSpinner();
		spinner.setBounds(173, 254, 30, 20);
		getContentPane().add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(205, 254, 30, 20);
		getContentPane().add(spinner_1);
		
		JSpinner spinner_2 = new JSpinner();
		spinner_2.setBounds(234, 254, 30, 20);
		getContentPane().add(spinner_2);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Profesor");
		rdbtnNewRadioButton.setBounds(284, 109, 109, 23);
		getContentPane().add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Socio");
		rdbtnNewRadioButton_1.setBounds(405, 109, 109, 23);
		getContentPane().add(rdbtnNewRadioButton_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Descripcion");
		lblNewLabel_1_1.setBounds(284, 150, 54, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Biografia");
		lblNewLabel_1_2.setBounds(284, 186, 46, 14);
		getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Sitio Web");
		lblNewLabel_1_3.setBounds(284, 222, 46, 14);
		getContentPane().add(lblNewLabel_1_3);
		
		textField_4 = new JTextField();
		textField_4.setBounds(354, 147, 86, 20);
		getContentPane().add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(354, 183, 86, 20);
		getContentPane().add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(354, 219, 86, 20);
		getContentPane().add(textField_6);
		textField_6.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(354, 253, 128, 22);
		getContentPane().add(comboBox);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Institucion");
		lblNewLabel_1_3_1.setBounds(284, 257, 54, 14);
		getContentPane().add(lblNewLabel_1_3_1);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(405, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname=textField.getText();
				String nombre=textField_1.getText();
				String apellido=textField_2.getText();
				String email=textField_3.getText();
				String descripcion=textField_4.getText();
				String biografia=textField_5.getText();
				String sitioweb=textField_6.getText();
				LocalDate fecha = LocalDate.of((int)spinner.getValue(),(int)spinner_1.getValue(),(int)spinner_2.getValue());
				
				
			}
		});
		btnAceptar.setBounds(297, 376, 98, 23);
		getContentPane().add(btnAceptar);

	}
}

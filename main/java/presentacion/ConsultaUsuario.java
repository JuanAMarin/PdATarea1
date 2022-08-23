package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultausuario;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Consultausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private ICconsultausuario ICcu;

	/**
	 * Create the frame.
	 */
	public Consultausuario(ICconsultausuario ICcu) {	
		setClosable(true);
		
		setTitle("Consulta de usuario");
		this.ICcu = ICcu;
		
		setBounds(100, 100, 592, 478);
		getContentPane().setLayout(null);
		
		JLabel lblNickname = new JLabel("Nickname");
		lblNickname.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNickname.setBounds(23, 24, 70, 24);
		getContentPane().add(lblNickname);
		
		JComboBox<String> comboBoxNickname = new JComboBox<String>();
		comboBoxNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname = (String) comboBoxNickname.getSelectedItem();
				ICcu.consultaUsuario(nickname);
				if(ICcu.isProfe()==true) {
					JTextArea textArea = new JTextArea(
	
						"Nickname " + ICcu.getNickname() + 
						"Email " + ICcu.getEmail() + 
						"Nombre " + ICcu.getNombre() +
						"Apellido " + ICcu.getApellido() + 
						"Fecha de nacimiento " + ICcu.getFechaNac() +
						"Descripcion " + ICcu.getDescripcion() +
						"Biografia " + ICcu.getBiografia() +
						"Sitio Web " + ICcu.getSitioweb() +
						"Institucion " + ICcu.getInstitucion()
						
								);
						textArea.setBounds(226, 26, 340, 411);
						getContentPane().add(textArea);
				}else {
					JTextArea textArea = new JTextArea(
							
							"Nickname " + ICcu.getNickname() + 
							"Email " + ICcu.getEmail() + 
							"Nombre " + ICcu.getNombre() +
							"Apellido " + ICcu.getApellido() + 
							"Fecha de nacimiento " + ICcu.getFechaNac() 
							
									);
							textArea.setBounds(226, 26, 340, 411);
							getContentPane().add(textArea);
				}
			}
		});
		comboBoxNickname.setBounds(94, 27, 122, 22);
		getContentPane().add(comboBoxNickname);

	}
}

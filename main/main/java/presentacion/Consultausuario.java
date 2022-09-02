package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultausuario;
import logica.InstitucionDep;
import logica.Profesor;
import logica.Socio;

import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

@SuppressWarnings("unused")
public class Consultausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private ICconsultausuario ICcu;
	private JComboBox<String> comboBoxNickname;
	private JTextArea textAreaUsu;

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
		
		comboBoxNickname = new JComboBox<String>();
		comboBoxNickname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nickname=(String) comboBoxNickname.getSelectedItem();
				Socio s = null;
				Profesor p = null;
				boolean profe = ICcu.esProfe(s, p , nickname);
				if(s==null) {
				textAreaUsu = new JTextArea(
						p.getNickname() +
						p.getNombre() +
						p.getApellido() +
						p.getEmail() +
						p.getFechaNac() +
						p.getDescripcion() +
						p.getBiografia() +
						p.getSitioweb() +
						p.getInstitucion());
				textAreaUsu.setBounds(226, 26, 340, 411);
				getContentPane().add(textAreaUsu);
				}else {
					textAreaUsu = new JTextArea(
							s.getNickname() +
							s.getNombre() +
							s.getApellido() +
							s.getEmail() +
							s.getFechaNac() 
							);
					textAreaUsu.setBounds(226, 26, 340, 411);
					getContentPane().add(textAreaUsu);
				}
			}
		});
		comboBoxNickname.setBounds(94, 27, 122, 22);
		getContentPane().add(comboBoxNickname);

	}
	
	public void cargarCombo() {
		ArrayList<String> usuarios = new ArrayList<String>(ICcu.listarUsuarios());
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>((String[]) usuarios.toArray());
		comboBoxNickname.setModel(modelUsuarios);
	}
}

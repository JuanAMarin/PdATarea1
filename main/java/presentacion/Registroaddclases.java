package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICregistrodeclases;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

import datatypes.DtClase;
import exceptions.SocioYaRegistradoException;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Color;
import javax.swing.border.TitledBorder;

public class Registroaddclases extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICregistrodeclases ICrc;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblActividad;
	private JComboBox<String> cboActividad;
	private JComboBox<String> cboInstitucion;
	private JLabel lblClases;
	private JList<String> list;
	private JComboBox<String> cboClases;
	DefaultListModel<String> modelo = new DefaultListModel<String>();
	private JLabel lblSocios;
	private JComboBox<String> cboSocios;
	
	/**
	 * Create the frame.
	 */

	protected void llamadoMensajito(ActionEvent arg0, String socio, String clase) {
		JOptionPane.showMessageDialog(this, "Ya hay un registro de "+ socio + " a la clase: "+ clase +".", "Registro a Dictado de Clase",
                JOptionPane.INFORMATION_MESSAGE);
	}
	
	protected void llamadoMensajito2(ActionEvent arg0, String socio, String clase) {
		JOptionPane.showMessageDialog(this, "Se ha registrado a "+ socio + " a la clase: "+ clase +".", "Registro a Dictado de Clase",
                JOptionPane.INFORMATION_MESSAGE);
	}
	
	public void formClose() {
		DefaultComboBoxModel<String> modelol = new DefaultComboBoxModel<String>();
		cboActividad.setModel(modelol);
		cboClases.setModel(modelol);
		cboSocios.setModel(modelol);
		modelo.clear();
		btnAceptar.setEnabled(false);
	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICrc.listarInstituciones());
		cboInstitucion.setModel(modelinstituciones);		
	}
	
	private void getActividades(String institucion) {
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICrc.listarActividades(cboInstitucion.getSelectedItem().toString()));
		cboActividad.setModel(modelactividades);
	}
	
	private void getClases(String actividad) {
		DefaultComboBoxModel<String> modelClases = new DefaultComboBoxModel<String>(ICrc.listarClases(cboActividad.getSelectedItem().toString()));
		cboClases.setModel(modelClases);
	}
	
	public Registroaddclases(ICregistrodeclases ICrcs) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				setVisible(false);
			}
		});
		setClosable(true);
		
		setTitle("Registro a Dictado de Clases");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
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
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				ICrc.Registro(cboClases.getSelectedItem().toString(), cboSocios.getSelectedItem().toString());
				llamadoMensajito2(e, cboSocios.getSelectedItem().toString(), cboClases.getSelectedItem().toString());
				}catch (SocioYaRegistradoException e1) {
					llamadoMensajito(e, cboSocios.getSelectedItem().toString(), cboClases.getSelectedItem().toString());
				}
			}
		});
		btnAceptar.setEnabled(false);
		btnAceptar.setBounds(295, 376, 98, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblInstitucion = new JLabel("INSTITUCION");
		lblInstitucion.setBounds(22, 49, 141, 14);
		getContentPane().add(lblInstitucion);
		
		cboInstitucion = new JComboBox<String>();
		cboInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getActividades(cboInstitucion.getSelectedItem().toString());
				DefaultComboBoxModel<String> modelol = new DefaultComboBoxModel<String>();
				cboClases.setModel(modelol);
				cboSocios.setModel(modelol);
				modelo.clear();
				btnAceptar.setEnabled(false);
			}
		});
		cboInstitucion.setBounds(141, 45, 190, 22);
		getContentPane().add(cboInstitucion);
		
		lblActividad = new JLabel("ACTIVIDAD");
		lblActividad.setBounds(22, 77, 141, 14);
		getContentPane().add(lblActividad);
		
		cboActividad = new JComboBox<String>();
		cboActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getClases(cboActividad.getSelectedItem().toString());
				DefaultComboBoxModel<String> modelol = new DefaultComboBoxModel<String>();
				cboSocios.setModel(modelol);
				modelo.clear();
				btnAceptar.setEnabled(false);
			}
		});
		cboActividad.setBounds(141, 73, 190, 22);
		getContentPane().add(cboActividad);
		
		lblClases = new JLabel("CLASE");
		lblClases.setBounds(22, 106, 141, 14);
		getContentPane().add(lblClases);
		
		cboClases = new JComboBox<String>();
		cboClases.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {	
					modelo.clear();
					DtClase clase = ICrcs.buscarClase(cboClases.getSelectedItem().toString());
					modelo.addElement("Nombre: " + clase.getNombre());
					modelo.addElement("URL: " + clase.getUrl());
					modelo.addElement("Fecha de Registro: " + clase.getFechaReg().toString());
					modelo.addElement("Fecha de inicio: " + Integer.toString(clase.getFecha().getDate()) +
													"/" + Integer.toString(clase.getFecha().getMonth()+1) +
													"/" + Integer.toString(clase.getFecha().getYear()+1900) );
					modelo.addElement("Hora de la clase: " + Integer.toString(clase.getHoraInicio().getHours()) +
													 ":" + Integer.toString(clase.getHoraInicio().getMinutes()));
					
					DefaultComboBoxModel<String> modelusuarios = new DefaultComboBoxModel<String>(ICrc.listarSocios());
					cboSocios.setModel(modelusuarios);
			}
		});
		cboClases.setBounds(141, 102, 190, 22);
		getContentPane().add(cboClases);
		list = new JList<String>();
		list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBackground(Color.WHITE);
		list.setBounds(22, 134, 464, 181);
		list.setModel(modelo);
		
		getContentPane().add(list);
		
		lblSocios = new JLabel("SOCIO");
		lblSocios.setBounds(22, 341, 141, 14);
		getContentPane().add(lblSocios);
		
		cboSocios = new JComboBox<String>();
		cboSocios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAceptar.setEnabled(true);
			}
		});
		cboSocios.setBounds(141, 337, 190, 22);
		getContentPane().add(cboSocios);
		
		ICrc = ICrcs;
	}
	
}

package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICregistrodeclases;
import logica.Clase;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JList;
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
	
	/**
	 * Create the frame.
	 */
	
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
				setVisible(false);
			}
		});
		btnCancelar.setBounds(404, 376, 98, 23);
		getContentPane().add(btnCancelar);
		
		btnAceptar = new JButton("Aceptar");
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
			}
		});
		cboActividad.setBounds(141, 73, 190, 22);
		getContentPane().add(cboActividad);
		
		lblClases = new JLabel("CLASES");
		lblClases.setBounds(22, 106, 141, 14);
		getContentPane().add(lblClases);
		
		cboClases = new JComboBox<String>();
		cboClases.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
					modelo.clear();
					Clase clase = ICrcs.buscarClase(cboClases.getSelectedItem().toString());
					modelo.addElement("Nombre: " + clase.getNombre());
					modelo.addElement("URL: " + clase.getUrl());
					modelo.addElement("Fecha de Registro: " + clase.getFechaReg().toString());
					modelo.addElement("Fecha de inicio: " + Integer.toString(clase.getFecha().getDay()) +
													"/" + Integer.toString(clase.getFecha().getMonth()) +
													"/" + Integer.toString(clase.getFecha().getYear()) );
					modelo.addElement("Hora de la clase: " + Integer.toString(clase.getHoraInicio().getHours()) +
													 ":" + Integer.toString(clase.getHoraInicio().getMinutes()));
			}
		});
		cboClases.setBounds(141, 102, 190, 22);
		getContentPane().add(cboClases);
		list = new JList<String>();
		list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBackground(Color.WHITE);
		list.setBounds(22, 131, 464, 211);
		list.setModel(modelo);
		
		getContentPane().add(list);
		
		ICrc = ICrcs;
	}
}

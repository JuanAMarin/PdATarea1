package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultaactividad;
import interfaces.ICconsultaclase;
import interfaces.ICconsultausuario;
import logica.InstitucionDep;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import datatypes.DtClase;
import datatypes.DtProfesor;
import datatypes.DtSocio;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("unused")
public class Consultaclase extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICconsultaclase ICcc;
	
	private JComboBox<String> cboInstitucion;
	private JTextArea textAreaUsu;
	private JRadioButton rdbtnProfe;
	private JTable tbRegistros;
	private JComboBox<String> cboActividad;
	private JButton btnBuscarClase;
	private JComboBox<String> cboClase;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private String col[] = {"Nickname","FechaR"};
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	private JTextField textFieldProfesor;
	private JLabel lblImage;
	
	// The 0 argument is number rows.	

	/**
	 * Create the frame.
	 */
	public Consultaclase(ICconsultaclase ICccs) {	
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Consulta de Dictado de Clase");
		this.ICcc = ICccs;
		
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(400, 451, 98, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(23, 28, 97, 14);
		getContentPane().add(lblInstitucion);
		
		JLabel lblActividad = new JLabel("ACTIVIDAD");
		lblActividad.setBounds(23, 56, 74, 14);
		getContentPane().add(lblActividad);
		
		cboClase = new JComboBox<String>();
		cboClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				tableModel.setRowCount(0);
				btnBuscarClase.setEnabled(true);
				textFieldProfesor.setText("");
				lblImage.setIcon(null);
			}
		});
		cboClase.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (cboClase.getSelectedItem() == null || cboClase.getSelectedItem().toString() == "")
					btnBuscarClase.setEnabled(false);
				else
					btnBuscarClase.setEnabled(true);
			}
		});
		cboClase.setBounds(107, 80, 312, 22);
		getContentPane().add(cboClase);
		
		lblImage = new JLabel("");
		lblImage.setBounds(409, 135, 89, 111);
		getContentPane().add(lblImage);
		
		btnBuscarClase = new JButton("🔍︎");
		btnBuscarClase.setEnabled(false);
		btnBuscarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ICcc.buscarClase(cboClase.getSelectedItem().toString());
				modelo.clear();
				
				modelo.addElement("Nombre: " + ICcc.getDtad().getNombre());
				modelo.addElement("URL: " + ICcc.getDtad().getUrl());
				modelo.addElement("Fecha: " + ICcc.getDtad().getFecha());
				modelo.addElement("Hora de inicio: " + ICcc.getDtad().getHoraInicio());
				modelo.addElement("Fecha de registro: " + ICcc.getDtad().getFechaReg());
				textFieldProfesor.setText(ICcc.buscarProfesorCC(cboClase.getSelectedItem().toString()));
				tableModel.setRowCount(0);
				for(Object[] o: ICcc.listarRegistros(cboClase.getSelectedItem().toString())) {
					tableModel.addRow(o);
				}
				
				ImageIcon image = new ImageIcon(new ImageIcon(ICcc.getDtad().getImage()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
				lblImage.setIcon(image);
			}
		});
		btnBuscarClase.setBounds(429, 47, 69, 32);
		getContentPane().add(btnBuscarClase);
		
		cboActividad = new JComboBox<String>();
		cboActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> modelClases = new DefaultComboBoxModel<String>(ICcc.listarClases(cboActividad.getSelectedItem().toString()));
				cboClase.setModel(modelClases);
				modelo.clear();
				tableModel.setRowCount(0);
				btnBuscarClase.setEnabled(false);
				textFieldProfesor.setText("");
				lblImage.setIcon(null);
			}
		});
		cboActividad.setBounds(107, 52, 312, 22);
		getContentPane().add(cboActividad);
		
		cboInstitucion = new JComboBox<String>();
		cboInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<String>(ICcc.listarActividades(cboInstitucion.getSelectedItem().toString()));
				cboActividad.setModel(modelActividades);
				modelo.clear();
				tableModel.setRowCount(0);
				btnBuscarClase.setEnabled(false);
				cboClase.removeAllItems();
				textFieldProfesor.setText("");
				lblImage.setIcon(null);
			}
		});
		cboInstitucion.setBounds(107, 24, 312, 22);
		getContentPane().add(cboInstitucion);
		
		JLabel lblInformacion = new JLabel("INFORMACION");
		lblInformacion.setBounds(23, 130, 103, 14);
		getContentPane().add(lblInformacion);
		
		JList<String> lstInformacion = new JList<String>();
		lstInformacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstInformacion.setBackground(Color.WHITE);
		lstInformacion.setBounds(23, 155, 379, 91);
		lstInformacion.setModel(modelo);
		getContentPane().add(lstInformacion);
		
		JLabel lblRegistros = new JLabel("REGISTROS");
		lblRegistros.setBounds(23, 257, 74, 14);
		getContentPane().add(lblRegistros);
		
		tbRegistros = new JTable(tableModel){
		private static final long serialVersionUID = 1L;
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
			return false;
		}};
		tbRegistros.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbRegistros.getSelectedRow()==-1)
					btnBuscarClase.setEnabled(false);
				else
					btnBuscarClase.setEnabled(true);
			}
		});
		
		
		tbRegistros.setBounds(23, 249, 463, 102);
		
		JScrollPane scp = new JScrollPane(tbRegistros);
		scp.setBounds(23, 282, 463, 84);
		getContentPane().add(scp);
		
		JLabel lblClase = new JLabel("CLASE");
		lblClase.setBounds(23, 84, 74, 14);
		getContentPane().add(lblClase);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setEditable(false);
		textFieldProfesor.setBounds(107, 401, 200, 19);
		getContentPane().add(textFieldProfesor);
		textFieldProfesor.setColumns(10);
		
		JLabel lblProfesor = new JLabel("PROFESOR");
		lblProfesor.setBounds(23, 404, 74, 14);
		getContentPane().add(lblProfesor);
	}
	
	public void cargarCombo() {
		DefaultComboBoxModel<String> modelInstituciones = new DefaultComboBoxModel<String>(ICcc.listarInstituciones());
		cboInstitucion.setModel(modelInstituciones);
	}
	
	public void cargarClase(String inst, String act, String clas){
		cargarCombo();
		cboInstitucion.setSelectedItem(inst);
	}
	
	public void formClose(){
		tableModel.setRowCount(0);
		modelo.clear();
		cboClase.setModel(new DefaultComboBoxModel<>());
		cboActividad.setModel(new DefaultComboBoxModel<>());
		btnBuscarClase.setEnabled(false);
		lblImage.setIcon(null);
	}
}
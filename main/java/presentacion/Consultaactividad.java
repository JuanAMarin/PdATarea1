package presentacion;

import javax.swing.JInternalFrame;

import interfaces.Fabrica;
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
import javax.swing.JFrame;
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
import javax.swing.SwingUtilities;
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
import javax.swing.JScrollBar;
import java.awt.Component;
import javax.swing.JPanel;

@SuppressWarnings("unused")
public class Consultaactividad extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	private ICconsultaactividad ICca;
	private JComboBox<String> cboInstitucion;
	private JTextArea textAreaUsu;
	private JRadioButton rdbtnProfe;
	private JTable tbClases;
	private JComboBox<String> cboActividad;
	private JButton btnBuscarClase;
	private JButton btnBuscarActividad;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private String col[] = {"Nom","URL","Fecha", "FechaR", "HoraIni"};
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	private String colReg[] = {"Nickname","FechaR"};
	private DefaultTableModel tableModelR = new DefaultTableModel(colReg, 0);
	private JTable tableRegistros;
	private JTextField textFieldProfesor;
	private JLabel lblImage;
	
	// The 0 argument is number rows.	

	/**
	 * Create the frame.
	 */
	public Consultaactividad(ICconsultaactividad ICcas) {	
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Consulta de Actividad Deportiva");
		this.ICca = ICcas;
		
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(404, 451, 98, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(23, 28, 97, 14);
		getContentPane().add(lblInstitucion);
		
		JLabel lblActividad = new JLabel("ACTIVIDAD");
		lblActividad.setBounds(23, 61, 74, 14);
		getContentPane().add(lblActividad);
		
		lblImage = new JLabel("");
		lblImage.setBounds(413, 86, 89, 111);
		getContentPane().add(lblImage);
		
		btnBuscarActividad = new JButton("🔍︎");
		btnBuscarActividad.setEnabled(false);
		btnBuscarActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ICca.buscarActividad(cboActividad.getSelectedItem().toString());
				modelo.clear();
				
				modelo.addElement("Nombre: " + ICca.getDtad().getNombre());
				modelo.addElement("Descripcion: " + ICca.getDtad().getDescripcion());
				modelo.addElement("Duracion: " + ICca.getDtad().getDuracion());
				modelo.addElement("Costo: " + ICca.getDtad().getCosto());
				modelo.addElement("Fecha de registro: " + ICca.getDtad().getFechaReg());
				tableModel.setRowCount(0);
				for(Object[] o: ICca.listarClases(cboActividad.getSelectedItem().toString())) {
					tableModel.addRow(o);
				}
				
				ImageIcon image = new ImageIcon(new ImageIcon(ICca.getDtad().getImage()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
				lblImage.setIcon(image);
			}
		});
		btnBuscarActividad.setBounds(429, 32, 69, 32);
		getContentPane().add(btnBuscarActividad);
		
		cboActividad = new JComboBox<String>();
		cboActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modelo.clear();
				tableModel.setRowCount(0);
				tableModelR.setRowCount(0);
				btnBuscarActividad.setEnabled(true);
				textFieldProfesor.setText("");
				btnBuscarClase.setEnabled(false);
				lblImage.setIcon(null);
			}
		});
		cboActividad.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (cboActividad.getSelectedItem() == null || cboActividad.getSelectedItem().toString() == "")
					btnBuscarActividad.setEnabled(false);
				else
					btnBuscarActividad.setEnabled(true);
			}
		});
		cboActividad.setBounds(107, 57, 312, 22);
		getContentPane().add(cboActividad);
		
		cboInstitucion = new JComboBox<String>();
		cboInstitucion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultComboBoxModel<String> modelActividades = new DefaultComboBoxModel<String>(ICca.listarActividades(cboInstitucion.getSelectedItem().toString()));
				cboActividad.setModel(modelActividades);
				modelo.clear();
				tableModel.setRowCount(0);
				tableModelR.setRowCount(0);
				btnBuscarActividad.setEnabled(false);
				textFieldProfesor.setText("");
				btnBuscarClase.setEnabled(false);
				lblImage.setIcon(null);
			}
		});
		cboInstitucion.setBounds(107, 24, 312, 22);
		getContentPane().add(cboInstitucion);
		
		JLabel lblInformacion = new JLabel("INFORMACION");
		lblInformacion.setBounds(23, 89, 103, 14);
		getContentPane().add(lblInformacion);
		
		JList<String> lstInformacion = new JList<String>();
		lstInformacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstInformacion.setBackground(Color.WHITE);
		lstInformacion.setBounds(23, 106, 380, 91);
		lstInformacion.setModel(modelo);
		getContentPane().add(lstInformacion);
		
		JLabel lblClases = new JLabel("CLASES");
		lblClases.setBounds(23, 224, 74, 14);
		getContentPane().add(lblClases);
		
		tbClases = new JTable(tableModel){
		private static final long serialVersionUID = 1L;
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
			return false;
		}};
		tbClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (tbClases.getSelectedRow()==-1)
					btnBuscarClase.setEnabled(false);
				else
					btnBuscarClase.setEnabled(true);
			}
		});
		
		tbClases.setBounds(23, 249, 463, 102);
		tbClases.getColumnModel().getColumn(4).setPreferredWidth(30);
		tbClases.getColumnModel().getColumn(3).setPreferredWidth(110);
		
		btnBuscarClase = new JButton("🔍︎");
		btnBuscarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int r = tbClases.getSelectedRow();
				String value = tbClases.getModel().getValueAt(r, 0).toString();
				tableModelR.setRowCount(0);
				textFieldProfesor.setText(ICca.buscarProfesorCC(value));
				for(Object[] o: ICca.listarRegistros(value)) {
					tableModelR.addRow(o);
				}
			}
		});
		btnBuscarClase.setBounds(417, 207, 69, 32);
		getContentPane().add(btnBuscarClase);
		
		JScrollPane scp = new JScrollPane(tbClases);
		scp.setBounds(23, 242, 463, 91);
		getContentPane().add(scp);
		
		JLabel lblRegistros = new JLabel("REGISTROS");
		lblRegistros.setBounds(23, 339, 74, 14);
		getContentPane().add(lblRegistros);
		
		tableRegistros = new JTable(tableModelR);
		
		JScrollPane scpRegistros = new JScrollPane(tableRegistros);
		scpRegistros.setBounds(23, 357, 463, 69);
		getContentPane().add(scpRegistros);
		
		JLabel lblProfesor = new JLabel("PROFESOR");
		lblProfesor.setBounds(23, 436, 74, 14);
		getContentPane().add(lblProfesor);
		
		textFieldProfesor = new JTextField();
		textFieldProfesor.setEditable(false);
		textFieldProfesor.setBounds(107, 436, 194, 19);
		getContentPane().add(textFieldProfesor);
		textFieldProfesor.setColumns(10);
	}
	
	public void cargarCombo() {
		DefaultComboBoxModel<String> modelInstituciones = new DefaultComboBoxModel<String>(ICca.listarInstituciones());
		cboInstitucion.setModel(modelInstituciones);
	}
	
	public void formClose(){
		cboActividad.removeAllItems();
		tableModel.setRowCount(0);
		tableModelR.setRowCount(0);
		modelo.clear();
		btnBuscarActividad.setEnabled(false);
		btnBuscarClase.setEnabled(false);
		textFieldProfesor.setText("");
		lblImage.setIcon(null);
	}
}
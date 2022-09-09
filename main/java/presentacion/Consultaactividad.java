package presentacion;

import javax.swing.JInternalFrame;

import interfaces.Fabrica;
import interfaces.ICconsultaactividad;
import interfaces.ICconsultaclase;
import interfaces.ICconsultausuario;
import logica.InstitucionDep;
import net.bytebuddy.asm.Advice.This;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import org.hibernate.annotations.Parent;

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
		
		setTitle("Consulta de actividad");
		this.ICca = ICcas;
		
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(400, 376, 98, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblInstitucion = new JLabel("INSTITUCION");
		lblInstitucion.setBounds(23, 28, 97, 14);
		getContentPane().add(lblInstitucion);
		
		JLabel lblActividad = new JLabel("ACTIVIDAD");
		lblActividad.setBounds(23, 61, 74, 14);
		getContentPane().add(lblActividad);
		
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
			}
		});
		btnBuscarActividad.setBounds(429, 32, 69, 32);
		getContentPane().add(btnBuscarActividad);
		
		cboActividad = new JComboBox<String>();
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
			}
		});
		cboInstitucion.setBounds(107, 24, 312, 22);
		getContentPane().add(cboInstitucion);
		
		JLabel lblInformacion = new JLabel("INFORMACION");
		lblInformacion.setBounds(23, 97, 103, 14);
		getContentPane().add(lblInformacion);
		
		JList<String> lstInformacion = new JList<String>();
		lstInformacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstInformacion.setBackground(Color.WHITE);
		lstInformacion.setBounds(23, 122, 463, 91);
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
		
		btnBuscarClase = new JButton("🔍︎");
		btnBuscarClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnBuscarClase.setBounds(23, 362, 69, 32);
		getContentPane().add(btnBuscarClase);
		
		JScrollPane scp = new JScrollPane(tbClases);
		scp.setBounds(23, 249, 463, 91);
		getContentPane().add(scp);

	}
	
	public void cargarCombo() {
		DefaultComboBoxModel<String> modelInstituciones = new DefaultComboBoxModel<String>(ICca.listarInstituciones());
		cboInstitucion.setModel(modelInstituciones);
	}
	
	public void formClose(){
		cboActividad.removeAllItems();
		tableModel.setRowCount(0);
		modelo.clear();
		btnBuscarActividad.setEnabled(false);
		btnBuscarClase.setEnabled(false);

	}
}
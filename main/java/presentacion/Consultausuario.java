package presentacion;

import javax.swing.JInternalFrame;

import interfaces.ICconsultaclase;
import interfaces.ICconsultausuario;
import logica.Cconsultausuario;
import logica.InstitucionDep;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import datatypes.DtProfesor;
import datatypes.DtSocio;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.Component;
import java.awt.Dialog;

import javax.swing.ListSelectionModel;
import java.awt.Panel;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.event.MouseMotionAdapter;

@SuppressWarnings("unused")
public class Consultausuario extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICconsultausuario ICcu;
	private JComboBox<String> cboNickname;
	private JTextArea textAreaUsu;
	private JRadioButton rdbtnProfe;
	private JButton btnBuscarUsuario;
	private DefaultListModel<String> modelo = new DefaultListModel<String>();
	private String col[] = {"Nombre","URL","Fecha", "FechaReg", "HoraIni"};
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
	private String colAc[] = {"Nombre","Descripción","Duración", "Costo", "FechaReg"};
	private DefaultTableModel tableModelAC = new DefaultTableModel(colAc, 0);
	private JTable tbClases;
	private JTable tbActivities;
	private JButton btnMasActividad;
	private JButton btnMasClase;
	private String colMC[] = {"Socio","FechaReg"};
	private DefaultTableModel tableModelMC = new DefaultTableModel(colMC, 0);
	private JScrollPane scpClases;
	private JScrollPane scpRegistros;
	private JTable tbRegistros;
	private JTable tbClasesAct;
	private DefaultTableModel tableModelCA = new DefaultTableModel(col, 0);
	private JLabel lblRegistros;
	private JScrollPane scpClasesAct;

	/**
	 * Create the frame. 
	 */
	public Consultausuario(ICconsultausuario ICcus) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		
		setTitle("Consulta de Usuario");
		this.ICcu = ICcus;
		
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		cboNickname = new JComboBox<String>();
		cboNickname.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				if (cboNickname.getSelectedItem() == null || cboNickname.getSelectedItem().toString() == "")
					btnBuscarUsuario.setEnabled(false);
				else
					btnBuscarUsuario.setEnabled(true);
			}
		});

		cboNickname.setBounds(102, 7, 231, 22);
		getContentPane().add(cboNickname);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
				setVisible(false);
			}
		});
		btnSalir.setBounds(404, 451, 98, 23);
		getContentPane().add(btnSalir);
		
		JLabel lblNickname = new JLabel("NICKNAME");
		lblNickname.setBounds(10, 11, 139, 14);
		getContentPane().add(lblNickname);
		
		btnBuscarUsuario = new JButton("🔍︎");
		btnBuscarUsuario.setEnabled(false);
		btnBuscarUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ICcu.buscarUsuario(cboNickname.getSelectedItem().toString());
				modelo.clear();
				modelo.addElement("Nombre: " + ICcu.getUsuario().getNombre());
				modelo.addElement("Apellido: " + ICcu.getUsuario().getApellido());
				modelo.addElement("Email: " + ICcu.getUsuario().getEmail());
				modelo.addElement("Fecha: " + ICcu.getUsuario().getFechaNac());
				
				if(ICcu.buscarProfesor(cboNickname.getSelectedItem().toString()) != null) {
					tableModel.setRowCount(0);
					for(Object[] o: ICcu.listarClasesP(cboNickname.getSelectedItem().toString())) {
						tableModel.addRow(o);
					}
					tableModelAC.setRowCount(0);
					for(Object[] o: ICcu.listarClasesP(cboNickname.getSelectedItem().toString())) {
						tableModelAC.addRow(o);
					}
				}else {
					tableModel.setRowCount(0);
					for(Object[] o: ICcu.listarClasesS(cboNickname.getSelectedItem().toString())) {
						tableModel.addRow(o);
					}
				}
				tableModelAC.setRowCount(0);
				for(Object[] o: ICcu.listarActividades(cboNickname.getSelectedItem().toString())) {
					tableModelAC.addRow(o);
				}
			}
		});
		btnBuscarUsuario.setEnabled(false);
		btnBuscarUsuario.setBounds(429, 7, 69, 32);
		getContentPane().add(btnBuscarUsuario);
		
		JLabel lblInformacion = new JLabel("INFORMACIÓN");
		lblInformacion.setBounds(10, 39, 103, 14);
		getContentPane().add(lblInformacion);
		
		JList<String> lstInformacion = new JList<String>();
		lstInformacion.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		lstInformacion.setBackground(Color.WHITE);
		lstInformacion.setBounds(20, 56, 462, 77);
		lstInformacion.setModel(modelo);
		getContentPane().add(lstInformacion);
		
		JLabel lblClases = new JLabel("CLASES");
		lblClases.setBounds(10, 143, 74, 14);
		getContentPane().add(lblClases);
		
		tbClases = new JTable(tableModel) {
		private static final long serialVersionUID = 1L;
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
			return false;
		}};
		tbClases.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tbClases.getSelectedRow()>=0) {
					btnMasClase.setEnabled(true);
				}
			}
		});
		tbClases.setRowSelectionAllowed(true);
		
		tbClases.setBounds(23, 249, 463, 102);
		tbClases.getColumnModel().getColumn(4).setPreferredWidth(30);
		tbClases.getColumnModel().getColumn(3).setPreferredWidth(110);
		
		JScrollPane scp = new JScrollPane(tbClases);
		scp.setBounds(20, 167, 463, 66);
		getContentPane().add(scp);
		
		tbActivities = new JTable(tableModelAC) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
			}};
		tbActivities.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(tbActivities.getSelectedRow()>=0) {
					btnMasActividad.setEnabled(true);
				}
			}
		});
		tbActivities.setRowSelectionAllowed(true);
			
		tbActivities.setBounds(23, 249, 463, 102);
		tbActivities.getColumnModel().getColumn(2).setPreferredWidth(30);
		tbActivities.getColumnModel().getColumn(3).setPreferredWidth(30);
		tbActivities.getColumnModel().getColumn(4).setPreferredWidth(110);
		
		JScrollPane scp_A = new JScrollPane(tbActivities);
		scp_A.setBounds(19, 267, 463, 72);
		getContentPane().add(scp_A);
		
		JLabel lblActividades = new JLabel("ACTIVIDADES");
		lblActividades.setBounds(10, 243, 139, 14);
		getContentPane().add(lblActividades);
		
		btnMasActividad = new JButton("Mas Info");
		btnMasActividad.setEnabled(false);
		btnMasActividad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scpClasesAct.setVisible(true);
				scpRegistros.setVisible(false);
				lblRegistros.setVisible(true);
				int r = tbActivities.getSelectedRow();
				String value = tbActivities.getModel().getValueAt(r, 0).toString();
				tableModelCA.setRowCount(0);
				for(Object[] o: ICcu.listarClasesA(value)) {
					tableModelCA.addRow(o);
				}
				lblRegistros.setText("CLASES DE "+value.toUpperCase());
			}
		});
		btnMasActividad.setBounds(384, 243, 98, 23);
		getContentPane().add(btnMasActividad);
		
		btnMasClase = new JButton("Mas Info");
		btnMasClase.setEnabled(false);
		btnMasClase.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scpClasesAct.setVisible(false);
				scpRegistros.setVisible(true);
				lblRegistros.setVisible(true);
				int r = tbClases.getSelectedRow();
				String value = tbClases.getModel().getValueAt(r, 0).toString();
				tableModelMC.setRowCount(0);
				for(Object[] o: ICcu.listarRegistros(value)) {
					tableModelMC.addRow(o);
				}
				lblRegistros.setText("REGISTROS DE "+value.toUpperCase());
			}
		});
		btnMasClase.setBounds(384, 143, 98, 23);
		getContentPane().add(btnMasClase);
		
		tbRegistros = new JTable(tableModelMC) {
		private static final long serialVersionUID = 1L;
		public boolean editCellAt(int row, int column, java.util.EventObject e) {
			return false;
		}};
		tbClases.setRowSelectionAllowed(true);
		
		tbClases.setBounds(23, 249, 463, 102);
		scpRegistros = new JScrollPane(tbRegistros);
		scpRegistros.setVisible(false);
		scpRegistros.setBounds(20, 375, 463, 72);
		getContentPane().add(scpRegistros);
		
		lblRegistros = new JLabel("REGISTROS");
		lblRegistros.setVisible(false);
		lblRegistros.setBounds(10, 351, 272, 14);
		getContentPane().add(lblRegistros);
		
		tbClasesAct = new JTable(tableModelCA) {
			private static final long serialVersionUID = 1L;
			public boolean editCellAt(int row, int column, java.util.EventObject e) {
				return false;
		}};
		
		scpClasesAct = new JScrollPane(tbClasesAct);
		scpClasesAct.setVisible(false);
		scpClasesAct.setBounds(20, 375, 463, 72);
		getContentPane().add(scpClasesAct);
		
	}
	
	public void cargarCombo() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(ICcu.listarUsuarios());
		cboNickname.setModel(modelUsuarios);
	}
	
	public void formClose(){
		cboNickname.removeAllItems();
		tableModel.setRowCount(0);
		tableModelAC.setRowCount(0);
		tableModelCA.setRowCount(0);
		tableModelMC.setRowCount(0);
		modelo.clear();
		btnBuscarUsuario.setEnabled(false);
		btnMasClase.setEnabled(false);
		btnMasActividad.setEnabled(false);
		scpClasesAct.setVisible(false);
		scpRegistros.setVisible(false);
		lblRegistros.setVisible(false);
	}
}
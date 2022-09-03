package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICregistrodeclases;
import logica.Clase;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Registroaddclases extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICregistrodeclases ICrc;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JLabel lblActividad;
	private JComboBox<String> cboActividad;
	private JComboBox<String> cboInstitucion;
	private JLabel lblClases;
	private JTable tabClases;
	
	/**
	 * Create the frame.
	 */
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICrc.listarInstituciones());
		cboInstitucion.setModel(modelinstituciones);
		getActividades((String)cboInstitucion.getSelectedItem());
	}
	
	private void getActividades(String institucion) {
		cboActividad.removeAllItems();
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICrc.listarActividades(cboInstitucion.getSelectedItem().toString()));
		cboActividad.setModel(modelactividades);
		getClases((String)cboActividad.getSelectedItem());

	}
	
	private void getClases(String actividad) {
		tabClases.removeAll();
		String col[] = {"Nombre","Fecha","Hora", "URL"};
		DefaultTableModel tableModel = new DefaultTableModel(col, 0);
        // The 0 argument is number rows.
		tabClases = new JTable(tableModel);
		for (Clase c:ICrc.listarClases(actividad)) {
			Object[] ob = {c.getNombre(),c.getFecha().toString(),c.getHoraInicio().toString(),c.getUrl()};
			tableModel.addRow(ob);
		}
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
		cboInstitucion.setBounds(141, 45, 190, 22);
		getContentPane().add(cboInstitucion);
		
		lblActividad = new JLabel("ACTIVIDAD");
		lblActividad.setBounds(22, 77, 141, 14);
		getContentPane().add(lblActividad);
		
		cboActividad = new JComboBox<String>();
		cboActividad.setBounds(141, 73, 190, 22);
		getContentPane().add(cboActividad);
		
		lblClases = new JLabel("CLASES");
		lblClases.setBounds(22, 101, 141, 14);
		getContentPane().add(lblClases);
		
		tabClases = new JTable();
		tabClases.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nombre", "Fecha", "Hora", "URL"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tabClases.setBounds(22, 131, 480, 111);
		getContentPane().add(tabClases);
		
		ICrc = ICrcs;
	}
}

package presentacion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICmodinstitucion;
import logica.InstitucionDep;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class modinstitucion extends JInternalFrame {
	private ICmodinstitucion ICmi;
	private static final long serialVersionUID = 1L;
	private JTextField textFieldDescripcion;
	private JTextField textFieldUrl;
	private JComboBox<String> comboBoxIns;
	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	
	public modinstitucion(ICmodinstitucion ICmodi) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				limpiarFormulario();
			}
		});
		setClosable(true);
		
		setTitle("Modificar Institucion");
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		ICmi = ICmodi;
		JLabel lblInstitucion = new JLabel("INSTITUCION");
		lblInstitucion.setBounds(10, 39, 99, 14);
		getContentPane().add(lblInstitucion);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modInstitucionAceptarActionPerformed(e);
			}
		});
		
		
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modInstitucionVerInfoActionPerformed(e);
			}
		});
		btnVerInfo.setBounds(307, 34, 117, 25);
		getContentPane().add(btnVerInfo);
		
		
		comboBoxIns = new JComboBox<String>();
		comboBoxIns.setBounds(99, 35, 190, 22);
		getContentPane().add(comboBoxIns);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(99, 89, 190, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(10, 92, 79, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(10, 137, 79, 14);
		getContentPane().add(lblUrl);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setBounds(99, 134, 190, 20);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
		
		
		btnAceptar.setBounds(307, 376, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(409, 376, 89, 23);
		getContentPane().add(btnCancelar);
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICmi.listarInstituciones());
		comboBoxIns.setModel(modelinstituciones);
	}
	
	protected void modInstitucionVerInfoActionPerformed(ActionEvent arg0) {
		if(this.comboBoxIns.getSelectedItem()!=null) {
			String strId = this.comboBoxIns.getSelectedItem().toString();
			InstitucionDep ins;
			
				ins = ICmi.obtenerInfo(strId);
				textFieldDescripcion.setText(ins.getDescripcion());
				textFieldUrl.setText(ins.getUrl());
		}
	}
	
	protected void modInstitucionAceptarActionPerformed(ActionEvent arg0){
		String nombre=this.comboBoxIns.getSelectedItem().toString();
		String descripcion=this.textFieldDescripcion.getText();
		String url=this.textFieldUrl.getText();
		if (checkFormulario()) {
            ICmi.modInstitucion(nombre, descripcion, url);
            JOptionPane.showMessageDialog(this, "La Institucion "+nombre+" se ha modificado con éxito", "Modificar Institucion",
                    JOptionPane.INFORMATION_MESSAGE);
            limpiarFormulario();
            setVisible(false);     
        }
	}
	
	private boolean checkFormulario() {
        String descripcion = this.textFieldDescripcion.getText();
        String url=this.textFieldUrl.getText();
        if (descripcion.isEmpty() || url.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Institucion",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	private void limpiarFormulario() {
        textFieldDescripcion.setText("");
        textFieldUrl.setText("");
	 }
	
}

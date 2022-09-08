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

import datatypes.DtInstitucionDep;
import interfaces.ICmodinstitucion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modinstitucion extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICmodinstitucion ICmi;
	
	private JTextField textFieldDescripcion;
	private JTextField textFieldUrl;
	private JComboBox<String> comboBoxIns;
	private JButton btnAceptar;

	/**
	 * Create the frame.
	 */
	
	public void habilitarAceptar() {
		if (!textFieldDescripcion.getText().isEmpty() && !textFieldUrl.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public void formClose() {
		btnAceptar.setEnabled(false);
		textFieldDescripcion.setText("");
		textFieldUrl.setText("");
	}
	
	public Modinstitucion(ICmodinstitucion ICmodi) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
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
		lblInstitucion.setBounds(10, 39, 141, 14);
		getContentPane().add(lblInstitucion);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modInstitucionAceptarActionPerformed(e);
			}
		});
		
		JButton btnVerInfo = new JButton("Ver Info");
		btnVerInfo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modInstitucionVerInfoActionPerformed(e);
				btnAceptar.setEnabled(true);
				textFieldDescripcion.setEnabled(true);
				textFieldUrl.setEnabled(true);
			}
		});
		btnVerInfo.setBounds(329, 34, 117, 25);
		getContentPane().add(btnVerInfo);
		
		
		comboBoxIns = new JComboBox<String>();
		comboBoxIns.setBounds(129, 35, 190, 22);
		getContentPane().add(comboBoxIns);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setEnabled(false);
		textFieldDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldDescripcion.setBounds(129, 90, 190, 20);
		getContentPane().add(textFieldDescripcion);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(10, 92, 141, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblUrl = new JLabel("URL");
		lblUrl.setBounds(10, 137, 79, 14);
		getContentPane().add(lblUrl);
		
		textFieldUrl = new JTextField();
		textFieldUrl.setEnabled(false);
		textFieldUrl.setBounds(129, 135, 190, 20);
		getContentPane().add(textFieldUrl);
		textFieldUrl.setColumns(10);
		
		
		btnAceptar.setBounds(307, 376, 89, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				formClose();
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
			DtInstitucionDep ins;
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
            ICmi.modInstitucion(nombre.toLowerCase(), descripcion, url);
            JOptionPane.showMessageDialog(this, "La Institución "+nombre+" se ha modificado con Éxito", "Modificar Institucion",
                    JOptionPane.INFORMATION_MESSAGE);
            formClose();
            //setVisible(false);     
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
	
}
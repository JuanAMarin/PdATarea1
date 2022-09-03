package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICmodactividaddep;
import logica.ActividadDep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ModActividadDeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private ICmodactividaddep ICMad;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JTextField textFieldFechaReg;
	private JLabel lblDescripcion;
	private JLabel lblNewLabelAD;
	private JComboBox<String> comboBoxAD;
	private JLabel lblNewLabelNombre;
	private JLabel lblDuracion;
	private JLabel lblNewLabelCosto;
	private JLabel lblNewLabelFecha;
	private JButton btnModificar;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnVer;
	
	public ModActividadDeportiva(ICmodactividaddep ICmad) {
		ICMad = ICmad; 
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Modificar Actividad Deportiva");
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		lblNewLabelAD = new JLabel("ACTIVIDADES DEPORTIVAS");
		lblNewLabelAD.setBounds(56, 32, 139, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(230, 28, 170, 20);
		getContentPane().add(comboBoxAD);
		
		lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(56, 113, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(56, 152, 139, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(230, 110, 170, 20);
		getContentPane().add(textFieldNombre);
		
		textFieldDesc = new JTextField();
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(230, 149, 170, 20);
		getContentPane().add(textFieldDesc);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(230, 191, 170, 20);
		getContentPane().add(textFieldDuracion);
		
		lblDuracion = new JLabel("DURACION");
		lblDuracion.setBounds(56, 194, 139, 14);
		getContentPane().add(lblDuracion);
		
		lblNewLabelCosto = new JLabel("COSTO");
		lblNewLabelCosto.setBounds(56, 239, 139, 14);
		getContentPane().add(lblNewLabelCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(230, 236, 170, 20);
		getContentPane().add(textFieldCosto);
		
		lblNewLabelFecha = new JLabel("FECHA DE REGISTRO");
		lblNewLabelFecha.setBounds(56, 283, 139, 14);
		getContentPane().add(lblNewLabelFecha);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setColumns(10);
		textFieldFechaReg.setBounds(230, 280, 170, 20);
		getContentPane().add(textFieldFechaReg);
		
		btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarActividadActionPerformed(e);
			}
		});
		btnModificar.setBounds(310, 311, 90, 23);
		getContentPane().add(btnModificar);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed(e);
			}
			
		});
		btnAceptar.setBounds(310, 376, 90, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(408, 376, 90, 23);
		getContentPane().add(btnCancelar);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInfoActividadActionPerformed(e);
			}
		});
		btnVer.setBounds(310, 59, 90, 23);
		getContentPane().add(btnVer);
		
	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICMad.listarActividades());
		comboBoxAD.setModel(modelactividades);
	}
	
	protected void VerInfoActividadActionPerformed(ActionEvent arg0){
		String act = this.comboBoxAD.getSelectedItem().toString();
		ActividadDep act1;
		act1 = ICMad.obtenerInfo(act);
		textFieldNombre.setText(act1.getNombre());
		textFieldNombre.setEnabled(false);
		textFieldDesc.setText(act1.getDescripcion());
		textFieldDesc.setEnabled(false);
		textFieldDuracion.setText(act1.getDuracion().toString());
		textFieldDuracion.setEnabled(false);
		float c = act1.getCosto();
		String str = String.valueOf(c);
		textFieldCosto.setText(str);
		textFieldCosto.setEnabled(false);
		
	}
	protected void ModificarActividadActionPerformed(ActionEvent arg0) {
		//textFieldNombre.setEnabled(true);
		textFieldDesc.setEnabled(true);
		textFieldDuracion.setEnabled(true);
		textFieldCosto.setEnabled(true);
	}
	
	protected void AceptarActionPerformed(ActionEvent arg0) {
		String nombre = this.textFieldNombre.getText();
		String descripcion = this.textFieldDesc.getText();
		Integer duracion = Integer.valueOf(this.textFieldDuracion.getText());
		Float costo = Float.parseFloat(this.textFieldCosto.getText());
		//agregar fecha de registro 
		if(checkFormulario()) {
			ICMad.ModActividadDeportiva(nombre, descripcion, duracion, costo);
			JOptionPane.showMessageDialog(this, "La Actividad Deportiva "+nombre+" se ha modificado con Ã©xito", "Modificar Actividad Deportiva",
                    JOptionPane.INFORMATION_MESSAGE);
			formClose();
            setVisible(false);  
		}
	}
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);
	}
	
	private boolean checkFormulario() {
        String descripcion = this.textFieldDesc.getText().toString();
        String duracion = String.valueOf(this.textFieldDuracion.getText());
        String costo = String.valueOf(this.textFieldCosto.getText());
        if (descripcion.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacÃ­os", "Modificar Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	public void formClose() {
        textFieldNombre.setText(null);
		textFieldDesc.setText(null);
        textFieldDuracion.setText(null);
        textFieldCosto.setText(null);
        //agregarRegistro
	 }
}

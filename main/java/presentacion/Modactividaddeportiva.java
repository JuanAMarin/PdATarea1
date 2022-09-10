package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICmodactividaddep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtActividadDep;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Modactividaddeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private ICmodactividaddep ICMad;
	
	private JTextField textFieldNombre;
	private JTextField textFieldDesc;
	private JTextField textFieldDuracion;
	private JTextField textFieldCosto;
	private JLabel lblDescripcion;
	private JLabel lblNewLabelAD;
	private JComboBox<String> comboBoxAD;
	private JLabel lblNewLabelNombre;
	private JLabel lblDuracion;
	private JLabel lblNewLabelCosto;
	private JButton btnAceptar;
	private JButton btnCancelar;
	private JButton btnVer;
	private JTextField textFieldFechaReg;
	private JLabel lblFechaDeRegistro;
	
	public void habilitarAceptar() {
		if (!textFieldDesc.getText().isEmpty() && !textFieldDuracion.getText().isEmpty() && !textFieldCosto.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
	}
	
	public Modactividaddeportiva(ICmodactividaddep ICmad) {
		ICMad = ICmad; 
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		setTitle("Modificar Actividad Deportiva");
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		lblNewLabelAD = new JLabel("ACTIVIDADES DEPORTIVAS");
		lblNewLabelAD.setBounds(56, 32, 139, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.setBounds(230, 28, 170, 20);
		getContentPane().add(comboBoxAD);
		
		lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(56, 138, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		
		lblDescripcion = new JLabel("DESCRIPCION");
		lblDescripcion.setBounds(56, 182, 139, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(230, 135, 170, 20);
		getContentPane().add(textFieldNombre);
		
		textFieldDesc = new JTextField();
		textFieldDesc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textFieldDesc.setEnabled(false);
		textFieldDesc.setColumns(10);
		textFieldDesc.setBounds(230, 179, 170, 20);
		getContentPane().add(textFieldDesc);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		textFieldDuracion.setEnabled(false);
		textFieldDuracion.setColumns(10);
		textFieldDuracion.setBounds(230, 223, 170, 20);
		getContentPane().add(textFieldDuracion);
		
		lblDuracion = new JLabel("DURACION");
		lblDuracion.setBounds(56, 226, 139, 14);
		getContentPane().add(lblDuracion);
		
		lblNewLabelCosto = new JLabel("COSTO");
		lblNewLabelCosto.setBounds(56, 269, 139, 14);
		getContentPane().add(lblNewLabelCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
			@Override
			public void keyTyped(KeyEvent evt) {
				char c=evt.getKeyChar();
				if(Character.isLetter(c)) {
					getToolkit().beep();
					evt.consume();
				}
			}
		});
		textFieldCosto.setEnabled(false);
		textFieldCosto.setColumns(10);
		textFieldCosto.setBounds(230, 266, 170, 20);
		getContentPane().add(textFieldCosto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed(e);
			}
			
		});
		btnAceptar.setBounds(310, 451, 90, 23);
		getContentPane().add(btnAceptar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(412, 451, 90, 23);
		getContentPane().add(btnCancelar);
		
		btnVer = new JButton("Ver");
		btnVer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VerInfoActividadActionPerformed(e);
				btnAceptar.setEnabled(true);
				textFieldDesc.setEnabled(true);
				textFieldDuracion.setEnabled(true);
				textFieldCosto.setEnabled(true);
			}
		});
		btnVer.setBounds(310, 59, 90, 23);
		getContentPane().add(btnVer);
		
		lblFechaDeRegistro = new JLabel("FECHA DE REGISTRO");
		lblFechaDeRegistro.setBounds(56, 316, 139, 14);
		getContentPane().add(lblFechaDeRegistro);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setEnabled(false);
		textFieldFechaReg.setColumns(10);
		textFieldFechaReg.setBounds(230, 310, 170, 20);
		getContentPane().add(textFieldFechaReg);
		
	}
	
	public void inicializarComboBoxes() {
		DefaultComboBoxModel<String> modelactividades = new DefaultComboBoxModel<String>(ICMad.listarActividades());
		comboBoxAD.setModel(modelactividades);
	}
	
	protected void VerInfoActividadActionPerformed(ActionEvent arg0){
		String act = this.comboBoxAD.getSelectedItem().toString();
		DtActividadDep act1;
		act1 = ICMad.obtenerInfo(act);
		textFieldNombre.setText(act1.getNombre());
		textFieldNombre.setEnabled(false);
		String fechaR = act1.getFechaReg().toString();
		textFieldFechaReg.setText(fechaR);
		textFieldFechaReg.setEnabled(false);
		textFieldDesc.setText(act1.getDescripcion());
		textFieldDuracion.setText(act1.getDuracion().toString());
		float c = act1.getCosto();
		String str = String.valueOf(c);
		textFieldCosto.setText(str);
		textFieldDesc.setEnabled(true);
		textFieldDuracion.setEnabled(true);
		textFieldCosto.setEnabled(true);
	}

	protected void AceptarActionPerformed(ActionEvent arg0) {
		String nombre = this.textFieldNombre.getText();
		String descripcion = this.textFieldDesc.getText();
		Integer duracion = Integer.valueOf(this.textFieldDuracion.getText());
		Float costo = Float.parseFloat(this.textFieldCosto.getText());
		if(checkFormulario()) {
			ICMad.ModActividadDeportiva(nombre.toLowerCase(), descripcion, duracion, costo);
			JOptionPane.showMessageDialog(this, "La Actividad Deportiva "+nombre+" se ha modificado con exito", "Modificar Actividad Deportiva",
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
            return false;
        }
        return true;
    }
	
	public void formClose() {
        textFieldNombre.setText(null);
		textFieldDesc.setText(null);
        textFieldDuracion.setText(null);
        textFieldCosto.setText(null);
        textFieldFechaReg.setText(null);
	 }
}

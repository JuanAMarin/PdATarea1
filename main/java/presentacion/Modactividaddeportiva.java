package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.ICmodactividaddep;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import datatypes.DtActividadDep;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JTextPane;

public class Modactividaddeportiva extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	
	private ICmodactividaddep ICMad;
	
	private JTextField textFieldNombre;
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
	private JTextPane textPaneDescripcion;
	private JButton btnLoadImage;
	private JLabel lblImage;
	private String filename = null;
	private byte[] actiImage = null;
	
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
		lblNewLabelAD.setBounds(56, 32, 277, 14);
		getContentPane().add(lblNewLabelAD);
		
		comboBoxAD = new JComboBox<String>();
		comboBoxAD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textPaneDescripcion.setEnabled(false);
				textFieldDuracion.setEnabled(false);
				textFieldCosto.setEnabled(false);
				btnAceptar.setEnabled(false);
				textPaneDescripcion.setText("");
				textFieldDuracion.setText("");
				textFieldCosto.setText("");
				textFieldFechaReg.setText("");
				textFieldNombre.setText("");
				btnLoadImage.setEnabled(false);
		        lblImage.setIcon(null);
			}
		});
		comboBoxAD.setBounds(230, 28, 170, 20);
		getContentPane().add(comboBoxAD);
		
		lblNewLabelNombre = new JLabel("NOMBRE");
		lblNewLabelNombre.setBounds(56, 138, 139, 14);
		getContentPane().add(lblNewLabelNombre);
		
		lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(230, 169, 139, 14);
		getContentPane().add(lblDescripcion);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEnabled(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(230, 135, 170, 20);
		getContentPane().add(textFieldNombre);
		
		textFieldDuracion = new JTextField();
		textFieldDuracion.addKeyListener(new KeyAdapter() {
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
		textFieldDuracion.setBounds(230, 314, 170, 20);
		getContentPane().add(textFieldDuracion);
		
		lblDuracion = new JLabel("DURACIÓN");
		lblDuracion.setBounds(56, 317, 139, 14);
		getContentPane().add(lblDuracion);
		
		lblNewLabelCosto = new JLabel("COSTO");
		lblNewLabelCosto.setBounds(56, 346, 139, 14);
		getContentPane().add(lblNewLabelCosto);
		
		textFieldCosto = new JTextField();
		textFieldCosto.addKeyListener(new KeyAdapter() {
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
		textFieldCosto.setBounds(230, 344, 170, 20);
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
				btnAceptar.setEnabled(true);
				textPaneDescripcion.setEnabled(true);
				textFieldDuracion.setEnabled(true);
				textFieldCosto.setEnabled(true);
				btnLoadImage.setEnabled(true);
				VerInfoActividadActionPerformed(e);
			}
		});
		btnVer.setBounds(310, 59, 90, 23);
		getContentPane().add(btnVer);
		
		lblFechaDeRegistro = new JLabel("FECHA DE REGISTRO");
		lblFechaDeRegistro.setBounds(56, 376, 139, 14);
		getContentPane().add(lblFechaDeRegistro);
		
		textFieldFechaReg = new JTextField();
		textFieldFechaReg.setEnabled(false);
		textFieldFechaReg.setColumns(10);
		textFieldFechaReg.setBounds(230, 374, 170, 20);
		getContentPane().add(textFieldFechaReg);
		
		textPaneDescripcion = new JTextPane();
		textPaneDescripcion.setBounds(230, 179, 272, 111);
		getContentPane().add(textPaneDescripcion);
		JScrollPane scr = new JScrollPane(textPaneDescripcion);
		scr.setBounds(230, 193, 272, 111);
		getContentPane().add(scr);
		
		btnLoadImage = new JButton("Seleccionar");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				cargarImg(f);
			}
		});
		btnLoadImage.setEnabled(false);
		btnLoadImage.setBounds(56, 162, 109, 21);
		getContentPane().add(btnLoadImage);
		
		lblImage = new JLabel("");
		lblImage.setBounds(56, 193, 89, 111);
		getContentPane().add(lblImage);
		
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
		textPaneDescripcion.setText(act1.getDescripcion());
		textFieldDuracion.setText(act1.getDuracion().toString());
		float c = act1.getCosto();
		String str = String.valueOf(c);
		textFieldCosto.setText(str);
		textPaneDescripcion.setEnabled(true);
		textFieldDuracion.setEnabled(true);
		textFieldCosto.setEnabled(true);
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(act1.getImage()).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(imageIcon);
		actiImage = act1.getImage();
	}

	protected void AceptarActionPerformed(ActionEvent arg0) {
		if(checkFormulario()) {
			String nombre = this.textFieldNombre.getText();
			String descripcion = this.textPaneDescripcion.getText();
			Integer duracion = Integer.valueOf(this.textFieldDuracion.getText());
			Float costo = Float.parseFloat(this.textFieldCosto.getText());
			ICMad.ModActividadDeportiva(nombre.toLowerCase(), descripcion, duracion, costo, actiImage);
			JOptionPane.showMessageDialog(this, "La Actividad Deportiva "+nombre+" se ha modificado con exito", "Modificar Actividad Deportiva",
                    JOptionPane.INFORMATION_MESSAGE);
			formClose();
		}else
			JOptionPane.showMessageDialog(this, "No puede haber campos vacíos", "Modificar Institucion",
                    JOptionPane.ERROR_MESSAGE);
	}
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);
	}
	
	private boolean checkFormulario() {
        String descripcion = this.textPaneDescripcion.getText().toString();
        String duracion = String.valueOf(this.textFieldDuracion.getText());
        String costo = String.valueOf(this.textFieldCosto.getText());
        if (descripcion.isEmpty() || duracion.isEmpty() || costo.isEmpty()) {
            return false;
        }
        return true;
    }
	
	public void formClose() {
        textFieldNombre.setText(null);
		textPaneDescripcion.setText(null);
        textFieldDuracion.setText(null);
        textFieldCosto.setText(null);
        textFieldFechaReg.setText(null);
        textPaneDescripcion.setEnabled(false);
        textFieldDuracion.setEnabled(false);
        textFieldCosto.setEnabled(false);
        btnAceptar.setEnabled(false);
        btnLoadImage.setEnabled(false);
        lblImage.setIcon(null);
	 }
	
	public void cargarImg(File f) {
		filename = f.getAbsolutePath();
		ImageIcon imageIcon = new ImageIcon(new ImageIcon(filename).getImage().getScaledInstance(lblImage.getWidth(), lblImage.getHeight(), Image.SCALE_SMOOTH));
		lblImage.setIcon(imageIcon);				
		try {
			File image = new File(filename);
			FileInputStream fis = new FileInputStream(image);
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			byte[] buf = new byte[1024];
			for (int readNum;(readNum = fis.read(buf))!=-1;){
				bos.write(buf,0,readNum);
			}
			actiImage = bos.toByteArray();
			fis.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,e2);
		}
	}
}

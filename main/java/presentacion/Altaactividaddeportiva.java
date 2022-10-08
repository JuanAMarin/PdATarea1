package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import exceptions.ActividadRepetidaException;
import interfaces.ICaltaactividaddeportiva;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.swing.JTextPane;

public class Altaactividaddeportiva extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICaltaactividaddeportiva ICaad;
	
	private JTextField txtNombre;
	private JTextField txtCosto;
	private JComboBox<String> cboInsti;
	private JSpinner spnDuracion;
	private JButton btnAceptar;
	private JLabel lblErrorNombre;
	private JLabel lblNombre;
	private JTextPane textPaneDescripcion;
	private String filename = null;
	private byte[] personImage = null;
	private JLabel lblImage;
	
	private void changeTextFormat(JLabel l, Color c){
		l.setForeground(c);
	}
	
	public void habilitarAceptar() {
		if (!txtNombre.getText().isEmpty() && !txtCosto.getText().isEmpty()
			&& !textPaneDescripcion.getText().isEmpty())
				btnAceptar.setEnabled(true);
		else
				btnAceptar.setEnabled(false);
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
			personImage = bos.toByteArray();
			fis.close();
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null,e2);
		}
	}
	
	@SuppressWarnings({ "removal" })
	public Altaactividaddeportiva(ICaltaactividaddeportiva ICaltaad) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
			}
		});
		setClosable(true);
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		ICaad = ICaltaad;
		setTitle("Alta de Actividad Deportiva");
		setClosable(true);
		getContentPane().setLayout(null);
		
		JLabel lblInstitucion = new JLabel("INSTITUCIÓN");
		lblInstitucion.setBounds(30, 55, 139, 14);
		getContentPane().add(lblInstitucion);
		
		cboInsti = new JComboBox<String>();
		cboInsti.setBounds(179, 51, 170, 22);
		getContentPane().add(cboInsti);
		
		JLabel lblMensaje = new JLabel("Complete los campos a continuación:");
		lblMensaje.setToolTipText("");
		lblMensaje.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMensaje.setBounds(20, 11, 170, 29);
		getContentPane().add(lblMensaje);
		
		lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(30, 89, 139, 14);
		getContentPane().add(lblNombre);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				lblErrorNombre.setVisible(false);
				changeTextFormat(lblNombre,Color.BLACK);
				habilitarAceptar();
			}
		});
		txtNombre.setBounds(179, 86, 170, 20);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		lblErrorNombre = new JLabel("*Esa actividad ya existe");
		lblErrorNombre.setHorizontalAlignment(SwingConstants.LEFT);
		lblErrorNombre.setForeground(Color.RED);
		lblErrorNombre.setBounds(359, 90, 170, 13);
		getContentPane().add(lblErrorNombre);
		
		JLabel lblDescripcion = new JLabel("DESCRIPCIÓN");
		lblDescripcion.setBounds(30, 117, 139, 14);
		getContentPane().add(lblDescripcion);
		
		spnDuracion = new JSpinner();
		
		spnDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c=e.getKeyChar();
				if(Character.isLetter(c)) {
					getToolkit().beep();
					e.consume();
				}
			}
		});
		spnDuracion.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		spnDuracion.setBounds(179, 224, 170, 20);
		getContentPane().add(spnDuracion);
		
		JLabel lblDuracion = new JLabel("DURACIÓN");
		lblDuracion.setBounds(30, 226, 139, 14);
		getContentPane().add(lblDuracion);
		
		JLabel lblCosto = new JLabel("COSTO");
		lblCosto.setBounds(30, 257, 139, 14);
		getContentPane().add(lblCosto);
		
		txtCosto = new JTextField();
		txtCosto.addKeyListener(new KeyAdapter() {
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
		txtCosto.setColumns(10);
		txtCosto.setBounds(179, 255, 170, 20);
		getContentPane().add(txtCosto);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setEnabled(false);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AceptarActionPerformed(e);
			}
		});
		btnAceptar.setBounds(296, 451, 98, 23);
		getContentPane().add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CancelarActionPerformed(e);
			}
		});
		btnCancelar.setBounds(404, 451, 98, 23);
		getContentPane().add(btnCancelar);
		
		textPaneDescripcion = new JTextPane();
		textPaneDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				habilitarAceptar();
			}
		});
		textPaneDescripcion.setBounds(179, 116, 215, 98);
		getContentPane().add(textPaneDescripcion);
		JScrollPane scr = new JScrollPane(textPaneDescripcion);
		scr.setBounds(179, 116, 215, 98);
		getContentPane().add(scr);
		
		lblImage = new JLabel("");
		lblImage.setBounds(179, 285, 89, 111);
		getContentPane().add(lblImage);
		
		JButton btnLoadImage = new JButton("Seleccionar");
		btnLoadImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser = new JFileChooser();
				chooser.showOpenDialog(null);
				File f = chooser.getSelectedFile();
				cargarImg(f);
			}
		});
		btnLoadImage.setBounds(30, 285, 108, 21);
		getContentPane().add(btnLoadImage);
	}
	
	public void inicializarComboBox() {
		DefaultComboBoxModel<String> modelinstituciones = new DefaultComboBoxModel<String>(ICaad.listarInstituciones());
		cboInsti.setModel(modelinstituciones);
	}
	
	protected void AceptarActionPerformed(ActionEvent arg0) {
		String insti = cboInsti.getSelectedItem().toString();
		String nombre = txtNombre.getText(), descripcion = textPaneDescripcion.getText();
		Integer duracion = (Integer) spnDuracion.getValue();
		float costo = Float.parseFloat(txtCosto.getText());
		if(checkFormulario()) {
			try {
			ICaad.datosActividad(nombre.toLowerCase(), descripcion, duracion, costo, insti.toLowerCase(), personImage);
			ICaad.altaActividad();
			JOptionPane.showMessageDialog(this, "La Actividad Deportiva "+nombre+" se ha creado con exito", "Alta Actividad Deportiva",
                    JOptionPane.INFORMATION_MESSAGE);
			formClose();
			}catch (ActividadRepetidaException e1){
				lblErrorNombre.setVisible(true);
				changeTextFormat(lblNombre,Color.RED);
			}
		}
	}
	
	protected void CancelarActionPerformed(ActionEvent arg0) {
		formClose();
		setVisible(false);
	}
	
	private boolean checkFormulario() {
        String nombre = this.txtNombre.getText().toString();
        String descripcion = this.textPaneDescripcion.getText().toString();
        String costo = String.valueOf(this.txtCosto.getText());
        if (nombre.isEmpty() || descripcion.isEmpty() || costo.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No puede haber campos vacios", "Alta Actividad Deportiva",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;
    }
	
	public void formClose() {
		txtNombre.setText("");
		textPaneDescripcion.setText("");
		spnDuracion.setValue(1);
		txtCosto.setText("");
		lblErrorNombre.setVisible(false);
		File f= new File(".\\src\\main\\icono\\default.jpg");
		cargarImg(f);
		changeTextFormat(lblNombre,Color.BLACK);
	}
}


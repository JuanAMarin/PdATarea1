package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICrankingdeclases;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.awt.Color;


public class Rankingdeclases extends JInternalFrame {
	private ICrankingdeclases ICrc;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Create the frame.
	 */
	
	//DefaultListModel<String> modelolista = new DefaultListModel;
	
	private void formClose(){
		///sdfsdfsdf
	}
	
	public Rankingdeclases(ICrankingdeclases ICmodi) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				formClose();
				setVisible(false);
			}
		});
		setClosable(true);
		
		setTitle("Ranking de Dictado de Clases");
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
		btnSalir.setBounds(404, 378, 98, 23);
		getContentPane().add(btnSalir);
		
		JList list = new JList();
		list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBackground(Color.WHITE);
		list.setBounds(81, 23, 346, 333);
		getContentPane().add(list);
		
		ICrc = ICmodi;
	}
}

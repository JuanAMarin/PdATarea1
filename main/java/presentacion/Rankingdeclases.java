package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;

import interfaces.ICrankingdeclases;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.border.TitledBorder;

import java.awt.Color;


public class Rankingdeclases extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICrankingdeclases ICrc;
	
	/**
	 * Create the frame.
	 */
	
	public Rankingdeclases(ICrankingdeclases ICranki) {
		addInternalFrameListener(new InternalFrameAdapter() {
			@Override
			public void internalFrameClosing(InternalFrameEvent e) {
				setVisible(false);
			}
		});
		setClosable(true);
		
		setTitle("Ranking de Dictado de Clases");
		ICrc=ICranki;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		setBounds(100, 100, 524, 440);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(404, 378, 98, 23);
		getContentPane().add(btnSalir);
		DefaultListModel<String> modelo = new DefaultListModel<String>();
		JList<String> list = new JList<String>();
		list.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		list.setBackground(Color.WHITE);
		list.setBounds(81, 23, 346, 333);
		list.setModel(modelo);
		for(String s: ICrc.obtRankClasesC()) {
			modelo.addElement(s);
		}
		getContentPane().add(list);
	}
	
}

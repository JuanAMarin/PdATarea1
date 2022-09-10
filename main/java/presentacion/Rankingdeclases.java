package presentacion;

import javax.swing.JInternalFrame;
import javax.swing.event.InternalFrameAdapter;
import javax.swing.event.InternalFrameEvent;
import javax.swing.table.DefaultTableModel;

import interfaces.ICrankingdeclases;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTable;
import javax.swing.JScrollPane;


public class Rankingdeclases extends JInternalFrame {
	
	private static final long serialVersionUID = 1L;
	
	private ICrankingdeclases ICrc;
	private JTable tb;
	
	private String col[] = {"Puesto","Nombre","URL","Fecha"};
	private DefaultTableModel tableModel = new DefaultTableModel(col, 0);
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
		setBounds(100, 100, 524, 513);
		getContentPane().setLayout(null);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSalir.setBounds(404, 451, 98, 23);
		getContentPane().add(btnSalir);
		
		tb = new JTable(tableModel);
		tb.setBounds(85, 80, 322, 206);
		tb.getColumnModel().getColumn(0).setPreferredWidth(5);
		
		JScrollPane scrollPane = new JScrollPane(tb);
		scrollPane.setBounds(10, 11, 488, 430);
		getContentPane().add(scrollPane);
	}
	
	public void ranking() {	
		tableModel.setRowCount(0);
		for(Object[] o: ICrc.obtRankClases()) {
			tableModel.addRow(o);
		}
	}
}

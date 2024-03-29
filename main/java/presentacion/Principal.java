package presentacion;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import interfaces.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;


public class Principal {

	private JFrame frmServidorCentral;
	
	private ICaltausuario ICau;
	private Altausuario AltaUsuario;
	private ICconsultausuario ICcu;
	private Consultausuario consultaUsuario;
	private ICaltainstitucion ICai;
	private Altainstitucion AltaInstitucion;
	private ICmodinstitucion ICmi;
	private Modinstitucion ModInstitucion;
	private ICrankingdeclases ICrc;
	private Rankingdeclases RankingClases;
	private ICmodusuario ICmu;
	private Modusuario ModUsuario;
	private ICaltaactividaddeportiva ICaad;
	private Altaactividaddeportiva AltaActividadDeportiva;
	private AltaDictadoClase AltaDictadoClaseInternalFrame;
	private ICaltadictadoclase ICac;
	private ICmodactividaddeportiva ICmad;
	private ModActividadDeportiva ModactividadDep;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frmServidorCentral.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	
	public void limpiarVentanas() {
		AltaUsuario.setVisible(false);
		consultaUsuario.setVisible(false);
		AltaInstitucion.setVisible(false);
		ModInstitucion.setVisible(false);
		RankingClases.setVisible(false);
		ModUsuario.setVisible(false);
		AltaActividadDeportiva.setVisible(false);
	}
	public Principal() {
		initialize();
		
		Fabrica fabrica = Fabrica.getInstancia();
		ICau=fabrica.getICaltausuario();
		ICcu=fabrica.getICconsultaUsuario();
		ICai=fabrica.getICaltainstitucion();
		ICmi=fabrica.getICmodinstitucion();
		ICrc=fabrica.getICrankingdeclases();
		ICmu=fabrica.getICmodusuario();
		ICaad=fabrica.getICaltaactividaddeportiva();
		ICac=fabrica.getICaltadictadoclase();
		ICmad=fabrica.getICmodactividaddeportiva();
		
		frmServidorCentral.setResizable(false);
		
		AltaUsuario=new Altausuario(ICau);
		AltaUsuario.setLocation(0,20);
		AltaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaUsuario);
		
		AltaInstitucion=new Altainstitucion(ICai);
		AltaInstitucion.setLocation(0,20);
		AltaInstitucion.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaInstitucion);
		
		ModInstitucion=new Modinstitucion(ICmi);
		ModInstitucion.setLocation(0,20);
		ModInstitucion.setVisible(false);
		frmServidorCentral.getContentPane().add(ModInstitucion);
		
		RankingClases=new Rankingdeclases(ICrc);
		RankingClases.setLocation(0,20);
		RankingClases.setVisible(false);
		frmServidorCentral.getContentPane().add(RankingClases);
		
		ModUsuario=new Modusuario(ICmu);
		ModUsuario.setLocation(0,20);
		ModUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(ModUsuario);
		
		AltaActividadDeportiva=new Altaactividaddeportiva(ICaad);
		AltaActividadDeportiva.setLocation(0,20);
		AltaActividadDeportiva.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaActividadDeportiva);
		
		AltaDictadoClaseInternalFrame=new AltaDictadoClase(ICac);
		AltaDictadoClaseInternalFrame.setLocation(0,20);
		AltaDictadoClaseInternalFrame.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaDictadoClaseInternalFrame);
		
		ModactividadDep = new ModActividadDeportiva(ICmad);
		ModactividadDep.setLocation(0,20);
		ModactividadDep.setVisible(false);
		frmServidorCentral.getContentPane().add(ModactividadDep);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorCentral = new JFrame();
		frmServidorCentral.setTitle("Servidor Central");
		frmServidorCentral.setBounds(100, 100, 538, 496);
		frmServidorCentral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServidorCentral.getContentPane().setLayout(null);
		consultaUsuario=new Consultausuario(ICcu);
		consultaUsuario.setBorder(UIManager.getBorder("OptionPane.border"));
		consultaUsuario.setBackground(Color.GRAY);
		consultaUsuario.setSize(524, 440);
		consultaUsuario.setLocation(0, 20);
		
		consultaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(consultaUsuario);
		
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setForeground(Color.BLACK);
		menuPrincipal.setBounds(0, 0, 524, 22);
		frmServidorCentral.getContentPane().add(menuPrincipal);
		
		JMenu menuAlta = new JMenu("Alta");
		menuPrincipal.add(menuAlta);
		
		JMenuItem menuUsuarioA = new JMenuItem("Usuario");
		menuUsuarioA.setSelected(true);
		menuUsuarioA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				AltaUsuario.setVisible(true);
			}
		});
		menuAlta.add(menuUsuarioA);
		
		JMenuItem menuActividadA = new JMenuItem("Actividad");
		menuActividadA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				AltaActividadDeportiva.inicializarComboBox();
				AltaActividadDeportiva.setVisible(true);
			}
		});
		menuAlta.add(menuActividadA);
		
		JMenuItem menuClaseA = new JMenuItem("Clase");
		menuClaseA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaDictadoClaseInternalFrame.inicializarComboBoxes();
				AltaDictadoClaseInternalFrame.setVisible(true);
			}
		});
		menuAlta.add(menuClaseA);
		
		JMenuItem menuInstitucionA = new JMenuItem("Institucion");
		menuInstitucionA.setSelected(true);
		menuInstitucionA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				AltaInstitucion.setVisible(true);
			}
		});
		menuAlta.add(menuInstitucionA);
		
		JMenu menuRegistrar = new JMenu("Registrar");
		menuPrincipal.add(menuRegistrar);
		
		JMenuItem menuInscripcion = new JMenuItem("Inscripcion a clase");
		menuRegistrar.add(menuInscripcion);
		
		JMenu menuModificar = new JMenu("Modificar");
		menuPrincipal.add(menuModificar);
		
		JMenuItem menuUsuarioM = new JMenuItem("Usuario");
		menuUsuarioM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				ModUsuario.setVisible(true);
			}
		});
		menuModificar.add(menuUsuarioM);
		
		JMenuItem menuActividadM = new JMenuItem("Actividad");
		menuModificar.add(menuActividadM);
		menuActividadM.setSelected(true);
		menuActividadM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				ModactividadDep.inicializarComboBoxes();
				limpiarVentanas();
				ModactividadDep.setVisible(true);
			}
		});
		
		JMenuItem menuInstitucionM = new JMenuItem("Institucion");
		menuInstitucionM.setSelected(true);
		menuInstitucionM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModInstitucion.inicializarComboBox();
				limpiarVentanas();
				ModInstitucion.setVisible(true);
			}
		});
		menuModificar.add(menuInstitucionM);
		
		JMenu menuRanking = new JMenu("Ranking");
		menuPrincipal.add(menuRanking);
		
		JMenuItem menuClasesR = new JMenuItem("Clases");
		menuClasesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				RankingClases.setVisible(true);
			}
		});
		menuRanking.add(menuClasesR);
		
		JMenuItem menuActividadesR = new JMenuItem("Actividades");
		menuRanking.add(menuActividadesR);
		
		JMenu menuConsultar = new JMenu("Consultar");
		menuPrincipal.add(menuConsultar);
		
		JMenuItem menuUsuarioC = new JMenuItem("Usuario");
		menuUsuarioC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				consultaUsuario.cargarCombo();
				consultaUsuario.setVisible(true);
			}
		});
		menuConsultar.add(menuUsuarioC);
		
		JMenuItem menuActividadC = new JMenuItem("Actividad");
		menuConsultar.add(menuActividadC);
		
		JMenuItem menuClaseC = new JMenuItem("Clase");
		menuConsultar.add(menuClaseC);
		
	}
}

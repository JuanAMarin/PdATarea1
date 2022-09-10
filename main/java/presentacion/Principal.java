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
import java.awt.Toolkit;

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
	private ICaltadictadoclase ICac;
	private Altadictadoclase AltaDictadoClaseInternalFrame;
	private ICmodactividaddep ICmad;
	private Modactividaddeportiva ModactividadDep;
	private ICregistrodeclases ICrcs;
	private Registroaddclases Registro;
	private ICconsultaactividad ICcas;
	private Consultaactividad consultaActividad;
	private ICconsultaclase ICccs;
	private Consultaclase consultaClase;
	private ICrankingdeactividades ICra;
	private Rankingdeactividades RankingActividades;
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
		AltaUsuario.formClose();
		AltaUsuario.setVisible(false);
		consultaUsuario.formClose();
		consultaUsuario.setVisible(false);
		AltaInstitucion.formClose();
		AltaInstitucion.setVisible(false);
		ModInstitucion.formClose();
		ModInstitucion.setVisible(false);
		RankingClases.setVisible(false);
		ModUsuario.formClose(); 
		ModUsuario.setVisible(false);
		AltaActividadDeportiva.formClose();
		AltaActividadDeportiva.setVisible(false);
		AltaDictadoClaseInternalFrame.formClose();
		AltaDictadoClaseInternalFrame.setVisible(false);
		Registro.formClose();
		Registro.setVisible(false);
		ModactividadDep.formClose();
		ModactividadDep.setVisible(false);
		consultaActividad.formClose();
		consultaActividad.setVisible(false);
		consultaClase.formClose();
		consultaClase.setVisible(false);
		RankingActividades.setVisible(false);
	}
	public Principal() {
		initialize();
		
		Fabrica fabrica = Fabrica.getInstancia();
		ICau=fabrica.getICaltausuario();
		ICcu=fabrica.getICconsultausuario();
		ICai=fabrica.getICaltainstitucion();
		ICmi=fabrica.getICmodinstitucion();
		ICrc=fabrica.getICrankingdeclases();
		ICmu=fabrica.getICmodusuario();
		ICaad=fabrica.getICaltaactividaddeportiva();
		ICac=fabrica.getICaltadictadoclase();
		ICmad=fabrica.getICmodactividaddep();
		ICrcs=fabrica.getICregistrodeclases();
		ICcas=fabrica.getICconsultaactividad();
		ICccs=fabrica.getICconsultaclase();
		ICra=fabrica.getICrankingdeactividades();
		
		frmServidorCentral.setResizable(false);
		
		AltaUsuario=new Altausuario(ICau);
		AltaUsuario.setSize(524, 513);
		AltaUsuario.setLocation(0,20);
		AltaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaUsuario);
		
		ModInstitucion=new Modinstitucion(ICmi);
		ModInstitucion.setSize(524, 513);
		ModInstitucion.setLocation(0,20);
		ModInstitucion.setVisible(false);
		frmServidorCentral.getContentPane().add(ModInstitucion);
		
		RankingClases=new Rankingdeclases(ICrc);
		RankingClases.setSize(524, 513);
		RankingClases.setLocation(0,20);
		RankingClases.setVisible(false);
		frmServidorCentral.getContentPane().add(RankingClases);
		
		ModUsuario=new Modusuario(ICmu);
		ModUsuario.setSize(524, 513);
		ModUsuario.setLocation(0,20);
		ModUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(ModUsuario);
		
		AltaActividadDeportiva=new Altaactividaddeportiva(ICaad);
		AltaActividadDeportiva.setSize(524, 513);
		AltaActividadDeportiva.setLocation(0,20);
		AltaActividadDeportiva.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaActividadDeportiva);
		
		AltaDictadoClaseInternalFrame=new Altadictadoclase(ICac);
		AltaDictadoClaseInternalFrame.setSize(524, 513);
		AltaDictadoClaseInternalFrame.setLocation(0,20);
		AltaDictadoClaseInternalFrame.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaDictadoClaseInternalFrame);
		
		ModactividadDep = new Modactividaddeportiva(ICmad);
		ModactividadDep.setSize(524, 513);
		ModactividadDep.setLocation(0,20);
		ModactividadDep.setVisible(false);
		frmServidorCentral.getContentPane().add(ModactividadDep);
		
		Registro=new Registroaddclases(ICrcs);
		Registro.setSize(524, 513);
		Registro.setLocation(0,20);
		Registro.setVisible(false);
		frmServidorCentral.getContentPane().add(Registro);
		
		consultaActividad=new Consultaactividad(ICcas);
		consultaActividad.setSize(524, 513);
		consultaActividad.setLocation(0,20);
		consultaActividad.setVisible(false);
		frmServidorCentral.getContentPane().add(consultaActividad);
		
		consultaUsuario=new Consultausuario(ICcu);
		consultaUsuario.setSize(524, 513);
		consultaUsuario.setLocation(0,20);
		consultaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(consultaUsuario);
		
		consultaClase=new Consultaclase(ICccs);
		consultaClase.setSize(524, 513);
		consultaClase.setLocation(0,20);
		consultaClase.setVisible(false);
		frmServidorCentral.getContentPane().add(consultaClase);
		
		RankingActividades=new Rankingdeactividades(ICra);
		RankingActividades.setBounds(0, 20, 524, 513);
		frmServidorCentral.getContentPane().add(RankingActividades);
		RankingActividades.setVisible(false);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmServidorCentral = new JFrame();
		frmServidorCentral.setIconImage(Toolkit.getDefaultToolkit().getImage(".\\src\\main\\icono\\png-transparent-computer-icons-computer-servers-cloud-computing-virtual-private-server-blue-technology-blue-text-logo-thumbnail.png"));
		frmServidorCentral.setTitle("Servidor Central");
		frmServidorCentral.setBounds(100, 100, 538, 570);
		frmServidorCentral.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmServidorCentral.getContentPane().setLayout(null);
		
		consultaUsuario=new Consultausuario(ICcu);
		consultaUsuario.setSize(524, 513);
		consultaUsuario.setLocation(0,20);
		consultaUsuario.setVisible(false);
		
		AltaInstitucion=new Altainstitucion(ICai);
		AltaInstitucion.setSize(524, 513);
		AltaInstitucion.setLocation(0,20);
		AltaInstitucion.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaInstitucion);
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
				AltaUsuario.inicializarComboBox();
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
				limpiarVentanas();
				AltaDictadoClaseInternalFrame.inicializarComboBoxID();
				AltaDictadoClaseInternalFrame.inicializarComboBoxAD();
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
		menuInscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				Registro.inicializarComboBoxes();
				Registro.setVisible(true);
			}
		});
		menuRegistrar.add(menuInscripcion);
		
		JMenu menuModificar = new JMenu("Modificar");
		menuPrincipal.add(menuModificar);
		
		JMenuItem menuUsuarioM = new JMenuItem("Usuario");
		menuUsuarioM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				ModUsuario.inicializarComboBox();
				ModUsuario.setVisible(true);
			}
		});
		menuModificar.add(menuUsuarioM);
		
		JMenuItem menuActividadM = new JMenuItem("Actividad");
		menuModificar.add(menuActividadM);
		menuActividadM.setSelected(true);
		menuActividadM.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				ModactividadDep.inicializarComboBoxes();
				ModactividadDep.setVisible(true);
			}
		});
		
		JMenuItem menuInstitucionM = new JMenuItem("Institucion");
		menuInstitucionM.setSelected(true);
		menuInstitucionM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				ModInstitucion.inicializarComboBox();
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
				RankingClases.ranking();
				RankingClases.setVisible(true);
			}
		});
		menuRanking.add(menuClasesR);
		
		JMenuItem menuActividadesR = new JMenuItem("Actividades");
		menuActividadesR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				RankingActividades.ranking();
				RankingActividades.setVisible(true);
			}
		});
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
		menuActividadC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				consultaActividad.cargarCombo();
				consultaActividad.setVisible(true);
			}
		});
		menuConsultar.add(menuActividadC);
		
		JMenuItem menuClaseC = new JMenuItem("Clase");
		menuClaseC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarVentanas();
				consultaClase.cargarCombo();
				consultaClase.setVisible(true);
			}
		});
		menuConsultar.add(menuClaseC);
		
	}
	
}

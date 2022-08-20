package presentacion;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import interfaces.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Principal {

	private JFrame frmServidorCentral;
	private ICaltausuario ICau;
	private ICconsultaUsuario ICcu;
	private altausuario AltaUsuario;
	private ConsultaUsuario consultaUsuario;

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
	public Principal() {
		initialize();
		
		Fabrica fabrica = Fabrica.getInstancia();
		ICau=fabrica.getICaltausuario();
		ICcu=fabrica.getICconsultaUsuario();
		
		frmServidorCentral.setResizable(false);
		
		AltaUsuario=new altausuario(ICau);
		
		AltaUsuario.setLocation(0,20);
		
		AltaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(AltaUsuario);

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
		consultaUsuario=new ConsultaUsuario(ICcu);
		consultaUsuario.setSize(524, 440);
		consultaUsuario.setLocation(0, 20);
		
		consultaUsuario.setVisible(false);
		frmServidorCentral.getContentPane().add(consultaUsuario);
		
		JMenuBar menuPrincipal = new JMenuBar();
		menuPrincipal.setBounds(0, 0, 524, 22);
		frmServidorCentral.getContentPane().add(menuPrincipal);
		
		JMenu menuAlta = new JMenu("Alta");
		menuPrincipal.add(menuAlta);
		
		JMenuItem menuUsuarioA = new JMenuItem("Usuario");
		menuUsuarioA.setSelected(true);
		menuUsuarioA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AltaUsuario.setVisible(true);
			}
		});
		menuAlta.add(menuUsuarioA);
		
		JMenuItem menuActividadA = new JMenuItem("Actividad");
		menuAlta.add(menuActividadA);
		
		JMenuItem menuClaseA = new JMenuItem("Clase");
		menuAlta.add(menuClaseA);
		
		JMenuItem menuInstitucionA = new JMenuItem("Institucion");
		menuAlta.add(menuInstitucionA);
		
		JMenu menuRegistrar = new JMenu("Registrar");
		menuPrincipal.add(menuRegistrar);
		
		JMenuItem menuInscripcion = new JMenuItem("Inscripcion a clase");
		menuRegistrar.add(menuInscripcion);
		
		JMenu menuModificar = new JMenu("Modificar");
		menuPrincipal.add(menuModificar);
		
		JMenuItem menuUsuarioM = new JMenuItem("Usuario");
		menuModificar.add(menuUsuarioM);
		
		JMenuItem menuActividadM = new JMenuItem("Actividad");
		menuModificar.add(menuActividadM);
		
		JMenuItem menuInstitucionM = new JMenuItem("Institucion");
		menuModificar.add(menuInstitucionM);
		
		JMenu menuRanking = new JMenu("Ranking");
		menuPrincipal.add(menuRanking);
		
		JMenuItem menuClasesR = new JMenuItem("Clases");
		menuRanking.add(menuClasesR);
		
		JMenuItem menuActividadesR = new JMenuItem("Actividades");
		menuRanking.add(menuActividadesR);
		
		JMenu menuConsultar = new JMenu("Consultar");
		menuPrincipal.add(menuConsultar);
		
		JMenuItem menuUsuarioC = new JMenuItem("Usuario");
		menuUsuarioC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
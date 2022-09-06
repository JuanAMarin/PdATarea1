package datatypes;

public class DtInstitucionDep {
	private String nombre, descripcion, url;
	
	public DtInstitucionDep(String nombre, String descripcion, String url) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.url = url;
	}

	public String getNombre() {
		return nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public String getUrl() {
		return url;
	}
	
}

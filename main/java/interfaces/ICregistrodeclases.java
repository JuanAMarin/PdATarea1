package interfaces;

import logica.InstitucionDep;

public interface ICregistrodeclases {
	
	public String[] listarInstituciones();
	public String[] listarActividades(InstitucionDep insti);
	public void setInsti(String insti);
	public void setActi(String acti);
	
}

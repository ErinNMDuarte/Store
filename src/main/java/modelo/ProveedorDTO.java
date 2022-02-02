package modelo;

public class ProveedorDTO {
	
	private int nitpro;
	private String nompro;
	private String dirpro;
	private int telpro;
	private String citypro;
	
	public ProveedorDTO(int nitpro, String nompro, String dirpro, int telpro, String citypro) {
		this.nitpro = nitpro;
		this.nompro = nompro;
		this.dirpro = dirpro;
		this.telpro = telpro;
		this.citypro = citypro;
	}
	
	
	public ProveedorDTO(int nitpro) {
		this.nitpro = nitpro;
	}


	public int getNitpro() {
		return nitpro;
	}
	public void setNitpro(int nitpro) {
		this.nitpro = nitpro;
	}
	public String getNompro() {
		return nompro;
	}
	public void setNompro(String nompro) {
		this.nompro = nompro;
	}
	public String getDirpro() {
		return dirpro;
	}
	public void setDirpro(String dirpro) {
		this.dirpro = dirpro;
	}
	public int getTelpro() {
		return telpro;
	}
	public void setTelpro(int telpro) {
		this.telpro = telpro;
	}
	public String getCitypro() {
		return citypro;
	}
	public void setCitypro(String citypro) {
		this.citypro = citypro;
	}
	
	

}

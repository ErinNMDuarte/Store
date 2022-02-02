package modelo;

public class UsuarioDTO{
	
	private int docus;
	private String nomus;
	private String emailus;
	private String us;
	private String passus;
	public UsuarioDTO(int docus, String emailus, String nomus, String us, String passus) {
		this.docus = docus;
		this.nomus = nomus;
		this.emailus = emailus;
		this.us = us;
		this.passus = passus;
	}
	public UsuarioDTO(int docus) {
		this.docus = docus;
	}
	
	
	public UsuarioDTO(String us, String passus) {
		this.us = us;
		this.passus = passus;
	}
	public int getDocus() {
		return docus;
	}
	public void setDocus(int docus) {
		this.docus = docus;
	}
	public String getNomus() {
		return nomus;
	}
	public void setNomus(String nomus) {
		this.nomus = nomus;
	}
	public String getEmailus() {
		return emailus;
	}
	public void setEmailus(String emailus) {
		this.emailus = emailus;
	}
	public String getUs() {
		return us;
	}
	public void setUs(String us) {
		this.us = us;
	}
	public String getPassus() {
		return passus;
	}
	public void setPassus(String passus) {
		this.passus = passus;
	}
	
	
	
	

}

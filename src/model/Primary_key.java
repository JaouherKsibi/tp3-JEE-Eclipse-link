package model;

public class Primary_key {
	private int id;
	private String cin;
	private String login;
	public Primary_key(int id, String cin, String login) {
		super();
		this.id = id;
		this.cin = cin;
		this.login = login;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	

}

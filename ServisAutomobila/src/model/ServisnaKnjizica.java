package model;

import java.util.ArrayList;

public class ServisnaKnjizica {
	
	protected String id;
	protected Automobil automobil;
	protected ArrayList<Servis> servisi;
	
	public ServisnaKnjizica(String id, Automobil automobil, ArrayList<Servis> servisi) {
		super();
		this.id = id;
		this.automobil = automobil;
		this.servisi = servisi;
	}
	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	public ArrayList<Servis> getServisi() {
		return servisi;
	}

	public void setServisi(ArrayList<Servis> servisi) {
		this.servisi = servisi;
	}
	@Override
	public String toString() {
		return "ServisnaKnjizica [id=" + id + ", automobil=" + automobil + ", servisi=" + servisi + "]";
	}


	

}

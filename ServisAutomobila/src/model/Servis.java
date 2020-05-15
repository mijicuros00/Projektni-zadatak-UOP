package model;

import java.util.GregorianCalendar;
import java.util.ArrayList;

public class Servis {
	
	protected String id;
	protected Serviser serviser;
	protected Automobil automobil;
	protected ArrayList<Deo> delovi;
	protected String opis;
	protected GregorianCalendar termin;
	
	public Servis(String id, Serviser serviser, Automobil automobil, ArrayList<Deo> delovi, String opis, GregorianCalendar termin) {
		super();
		this.id = id;
		this.serviser = serviser;
		this.automobil = automobil;
		this.delovi = delovi;
		this.opis = opis;
		this.termin = termin;
	}
	public String getId(){
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}

	public Serviser getServiser() {
		return serviser;
	}

	public void setServiser(Serviser serviser) {
		this.serviser = serviser;
	}

	public Automobil getAutomobil() {
		return automobil;
	}

	public void setAutomobil(Automobil automobil) {
		this.automobil = automobil;
	}

	public ArrayList<Deo> getDelovi() {
		return delovi;
	}

	public void setDelovi(ArrayList<Deo> delovi) {
		this.delovi = delovi;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}
	
	public GregorianCalendar getTermin() {
		return termin;
	}

	public void setTermin(GregorianCalendar termin) {
		this.termin = termin;
	}
	@Override
	public String toString() {
		return "Servis [id=" + id + ", serviser=" + serviser + ", automobil=" + automobil + ", delovi=" + delovi
				+ ", opis=" + opis + ", termin=" + termin + "]";
	}


	
	

}

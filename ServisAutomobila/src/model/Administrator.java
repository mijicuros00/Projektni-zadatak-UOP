package model;

public class Administrator extends Korisnik {
	
	protected double plata;

	public Administrator(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona,
			String korisnickoIme, String lozinka, boolean obrisan, double plata) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.plata = plata;
		this.obrisan = obrisan;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	@Override
	public String toString() {
		return "Administrator [plata=" + plata + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime + ", jmbg="
				+ jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona + ", korisnickoIme="
				+ korisnickoIme + ", lozinka=" + lozinka + "]";
	}


	
	

}

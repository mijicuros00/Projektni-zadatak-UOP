package model;

public class Serviser extends Korisnik {
	
	protected double plata;
	protected Specijalizacija specijalizacija;

	public Serviser(String id, String ime, String prezime, String jmbg, Pol pol, String adresa, String brojTelefona, String korisnickoIme,
			String lozinka, boolean obrisan, double plata, Specijalizacija specijalizacija) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.plata = plata ;
		this.specijalizacija = specijalizacija;
		this.obrisan = obrisan;
	}

	public double getPlata() {
		return plata;
	}

	public void setPlata(double plata) {
		this.plata = plata;
	}

	public Specijalizacija getSpecijalizacija() {
		return specijalizacija;
	}

	public void setSpecijalizacija(Specijalizacija specijalizacija) {
		this.specijalizacija = specijalizacija;
	}

	@Override
	public String toString() {
		return "Serviser [plata=" + plata + ", specijalizacija=" + specijalizacija + ", id=" + id + ", ime=" + ime
				+ ", prezime=" + prezime + ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona="
				+ brojTelefona + ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}


	

}

package model;

public class Musterija extends Korisnik {
	protected int nagradniBodovi;

	public Musterija(String id, String ime, String prezime, String jmbg, Pol pol,  String adresa, String brojTelefona, String korisnickoIme,
			String lozinka, boolean obrisan, int nagradniBodovi) {
		super(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan);
		this.nagradniBodovi = nagradniBodovi;
	}

	public int getNagradniBodovi() {
		return nagradniBodovi;
	}

	public void setNagradniBodovi(int nagradniBodovi) {
		this.nagradniBodovi = nagradniBodovi;
	}

	@Override
	public String toString() {
		return "Musterija [nagradniBodovi=" + nagradniBodovi + ", id=" + id + ", ime=" + ime + ", prezime=" + prezime
				+ ", jmbg=" + jmbg + ", pol=" + pol + ", adresa=" + adresa + ", brojTelefona=" + brojTelefona
				+ ", korisnickoIme=" + korisnickoIme + ", lozinka=" + lozinka + "]";
	}


	
	

}

package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Administrator;
import model.Musterija;
import model.Pol;

public class RadSaAdministratorima {
	

	public static ArrayList<Administrator> citanjeAdministratora(){
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		
		try {
		File file = new File("src/txt/administratori.txt");
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		
		while((line = reader.readLine()) != null) {
			String[] splittedLine = line.split("\\|");
			String id = splittedLine[0];
			String ime = splittedLine[1];
			String prezime = splittedLine[2];
			String jmbg = splittedLine[3];
			Pol pol = Pol.values()[Integer.parseInt(splittedLine[4])];
			String adresa = splittedLine[5];
			String brojTelefona = splittedLine[6];
			String korisnickoIme = splittedLine[7];
			String lozinka = splittedLine[8];
			boolean obrisan = Boolean.parseBoolean(splittedLine[9]);
			double plata = Double.parseDouble(splittedLine[10]);
			
			Administrator a = new Administrator(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan, plata);
			administratori.add(a);
		}
		reader.close();

	}catch(IOException e) {
		System.out.println("Greska pri citanju iz fajla!");
	}
	return administratori;
}
	
	public static void ispisAdministratora() {
		ArrayList<Administrator> administratori = neobrisaniAdministratori();
		
		for (Administrator administrator : administratori) {
			System.out.println(administrator);
		}
		
	}
	public static void snimanjeAdministratora() {
		ArrayList<Administrator> administratori = Vrednosti.administratori;
		try {
		File file = new File("src/txt/administratori.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Administrator administrator : administratori) {
			writer.write(administrator.getId() + "|" + administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJmbg() + "|" + administrator.getPol().ordinal() + "|" + administrator.getAdresa() + "|" + administrator.getBrojTelefona() + "|" + administrator.getKorisnickoIme() + "|" + administrator.getLozinka() + "|" + administrator.isObrisan() + "|" + administrator.getPlata() + "|" + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajAdministratora(Administrator a) {
		Vrednosti.administratori.add(a);
	}
	
	public static ArrayList<Administrator> neobrisaniAdministratori(){
		ArrayList<Administrator> neobrisaniAdministratori = new ArrayList<Administrator>();
		for(Administrator a: Vrednosti.administratori) {
			if(a.isObrisan() == false) {
				neobrisaniAdministratori.add(a);
			}
		}
		return neobrisaniAdministratori;
	}
	
	public static Administrator pronadjiAdministratoraPoId(String splittedLine) {
		Administrator admin = null;
		ArrayList<Administrator> admini = Vrednosti.administratori;
		for (Administrator a : admini) {
			if(a.getId().equals(splittedLine)) {
				admin = a;
				return admin;
			}
			
		}
		return null;
	}
	
	public static void obrisiAdministratora(Administrator a) {
		a.setObrisan(true);
		
	}
	
	public static void izmeniAdresuAdministratora(Administrator a, String novaAdresa) {
		a.setAdresa(novaAdresa);
	}
	
	public static void izmeniBrojTelefonaAdministratora(Administrator a, String noviBrojTelefona) {
		a.setBrojTelefona(noviBrojTelefona);
	}
	
	public static void izmeniKorisnickoImeAdministratora(Administrator a, String novoKorisnickoIme) {
		a.setKorisnickoIme(novoKorisnickoIme);
	}
	
	public static void izmeniLozinkuAdministratora(Administrator a, String novaLozinka) {
		a.setLozinka(novaLozinka);
	}
	
	public static void izmeniPrezimeAdministratora(Administrator a, String novoPrezime) {
		a.setPrezime(novoPrezime);
	}
	
	public static void izmeniImeAdministratora(Administrator a, String novoIme) {
		a.setIme(novoIme);
	}
	
	public static void izmeniPlatuAdministratora(Administrator a, double novaPlata) {
		a.setPlata(novaPlata);
	}

}

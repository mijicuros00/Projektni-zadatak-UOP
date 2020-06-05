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
import model.Serviser;
import model.Specijalizacija;

public class RadSaServiserima {
	
	public static ArrayList<Serviser> citanjeServisera(){
		ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
		try {
			File file = new File("src/txt/serviseri.txt");
			
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
				Specijalizacija specijalizacija = Specijalizacija.values()[Integer.parseInt(splittedLine[11])];
				
				
				Serviser s = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan, plata, specijalizacija);
				
				serviseri.add(s);
				
			}
			reader.close();
			
		}catch(IOException e){
			System.out.println("Greska pri citanju iz fajla");
			
		}catch(NumberFormatException n){
			System.out.println("Greska pri parsiranju");
		}
		return serviseri;
		
	}
	public static void ispisServisera() {
		ArrayList<Serviser> serviseri = neobrisaniServiseri();
		
		for (Serviser serviser : serviseri) {
			System.out.println(serviser);
		}
	}
	
	public static void snimanjeServisera() {
		ArrayList<Serviser> serviseri = Vrednosti.serviseri;
		try {
		File file = new File("src/txt/serviseri.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Serviser serviser : serviseri) {
			writer.write(serviser.getId() + "|" + serviser.getIme() + "|" + serviser.getPrezime() + "|" + serviser.getJmbg() + "|" + serviser.getPol().ordinal() + "|" + serviser.getAdresa() + "|" + serviser.getBrojTelefona() + "|" + serviser.getKorisnickoIme() + "|" + serviser.getLozinka() + "|" + serviser.isObrisan() + "|" + serviser.getPlata() + "|" + serviser.getSpecijalizacija().ordinal() + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajServisere(Serviser s) {
		Vrednosti.serviseri.add(s);
	}
	
	public static Serviser pronadjiServiseraPoId(String splittedLine) {
		Serviser serviser = null;
		ArrayList<Serviser> serviseri = Vrednosti.serviseri;
		for (Serviser serviser2 : serviseri) {
			if(serviser2.getId().equals(splittedLine)) {
				serviser = serviser2;
				return serviser;
			}
			
		}
		return null;
	}
	
	public static ArrayList<Serviser> neobrisaniServiseri(){
		ArrayList<Serviser> neobrisaniServiseri = new ArrayList<Serviser>();
		for(Serviser s: Vrednosti.serviseri) {
			if(s.isObrisan() == false) {
				neobrisaniServiseri.add(s);
			}
		}
		return neobrisaniServiseri;
	}
	
	public static void obrisiServisera(Serviser s) {
		s.setObrisan(true);
	}
	
	public static void izmeniAdresuServisera(Serviser s, String novaAdresa) {
		s.setAdresa(novaAdresa);
	}
	
	public static void izmeniBrojTelefonaServisera(Serviser s, String noviBrojTelefona) {
		s.setBrojTelefona(noviBrojTelefona);
	}
	
	public static void izmeniKorisnickoImeServisera(Serviser s, String novoKorisnickoIme) {
		s.setKorisnickoIme(novoKorisnickoIme);
	}
	
	public static void izmeniLozinkuServisera(Serviser s, String novaLozinka) {
		s.setLozinka(novaLozinka);
	}
	
	public static void izmeniPrezimeServisera(Serviser s, String novoPrezime) {
		s.setPrezime(novoPrezime);
	}
	
	public static void izmeniImeServisera(Serviser s, String novoIme) {
		s.setIme(novoIme);
	}
	
	public static void izmeniPlatuServisera(Serviser s, double novaPlata) {
		s.setPlata(novaPlata);
	}

	
	

}

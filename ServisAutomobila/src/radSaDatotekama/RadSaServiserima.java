package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
				double plata = Double.parseDouble(splittedLine[9]);
				Specijalizacija specijalizacija = Specijalizacija.values()[Integer.parseInt(splittedLine[10])];
				
				Serviser s = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija);
				
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
		ArrayList<Serviser> serviseri = RadSaServiserima.citanjeServisera();
		
		for (Serviser serviser : serviseri) {
			System.out.println(serviser);
		}
	}
	
	public static void dodavanjeServisera(Serviser s) {
		ArrayList<Serviser> serviseri = RadSaServiserima.citanjeServisera();
		try {
		File file = new File("src/txt/serviseri.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		serviseri.add(s);
		for (Serviser serviser : serviseri) {
			writer.write(serviser.getId() + "|" + serviser.getIme() + "|" + serviser.getPrezime() + "|" + serviser.getJmbg() + "|" + serviser.getPol().ordinal() + "|" + serviser.getAdresa() + "|" + serviser.getBrojTelefona() + "|" + serviser.getKorisnickoIme() + "|" + serviser.getLozinka() + "|" + serviser.getPlata() + "|" + serviser.getSpecijalizacija().ordinal() + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}

}

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

public class RadSaMusterijama {
	

		
		public static ArrayList<Musterija> citanjeMusterija(){
			ArrayList<Musterija> musterije = new ArrayList<Musterija>();
			
			try {
			File file = new File("src/txt/musterije.txt");
			
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
				Integer nagradniBodovi = Integer.parseInt(splittedLine[9]);
				
				Musterija m = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, nagradniBodovi);
				
				musterije.add(m);
				
			}
			reader.close();
			}catch (IOException e){
				System.out.println("Greska pri citanju iz fajla");
			}catch(NumberFormatException n){
				System.out.println("Greska pri parsiranju");
			}
			return musterije;
		}
		
		public static void ispisMusterija() {
			ArrayList<Musterija> musterije = RadSaMusterijama.citanjeMusterija();

			for (Musterija musterija : musterije) {
				System.out.println(musterija);
			}
		}
		
		public static void dodavanjeMusterije(Musterija m) {
			ArrayList<Musterija> musterije = RadSaMusterijama.citanjeMusterija();
			try {
			File file = new File("src/txt/musterije.txt");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			musterije.add(m);
			for (Musterija musterija : musterije) {
				writer.write(musterija.getId() + "|" + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getPol().ordinal() + "|" + musterija.getAdresa() + "|" + musterija.getBrojTelefona() + "|" + musterija.getKorisnickoIme() + "|" + musterija.getLozinka() + "|" + musterija.getNagradniBodovi() + "\n"); 
			}
			writer.close();
		
			}catch(IOException e){
				System.out.println("Greska pri upisivanju u fajl");
			}
		}

	}




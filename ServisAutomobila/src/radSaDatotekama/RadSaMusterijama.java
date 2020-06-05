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
				boolean obrisan = Boolean.parseBoolean(splittedLine[9]);
				Integer nagradniBodovi = Integer.parseInt(splittedLine[10]);
				
				Musterija m = new Musterija(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, obrisan, nagradniBodovi);
				
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
			ArrayList<Musterija> musterije = neobrisaneMusterije();

			for (Musterija musterija : musterije) {
				System.out.println(musterija);
			}
		}
		
		public static void snimanjeMusterija() {
			ArrayList<Musterija> musterije = Vrednosti.musterije;
			try {
			File file = new File("src/txt/musterije.txt");
			
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (Musterija musterija : musterije) {
				writer.write(musterija.getId() + "|" + musterija.getIme() + "|" + musterija.getPrezime() + "|" + musterija.getJmbg() + "|" + musterija.getPol().ordinal() + "|" + musterija.getAdresa() + "|" + musterija.getBrojTelefona() + "|" + musterija.getKorisnickoIme() + "|" + musterija.getLozinka() + "|" + musterija.isObrisan() + "|" + musterija.getNagradniBodovi() + "\n"); 
			}
			writer.close();
		
			}catch(IOException e){
				System.out.println("Greska pri upisivanju u fajl");
			}
		}
		
		public static void dodajMusteriju(Musterija m) {
			Vrednosti.musterije.add(m);
		}
		
		public static Musterija pronadjiMusterijuPoId(String splittedLine) {
			Musterija vlasnik = null;
			ArrayList<Musterija> musterije = Vrednosti.musterije;
			for (Musterija musterija : musterije) {
				if(musterija.getId().equals(splittedLine)) {
					vlasnik = musterija;
					return vlasnik;
				}
				
			}
			return null;
			
		}
		
		public static ArrayList<Musterija> neobrisaneMusterije(){
			ArrayList<Musterija> neobrisaneMusterije = new ArrayList<Musterija>();
			for(Musterija musterija: Vrednosti.musterije) {
				if(musterija.isObrisan() == false) {
					neobrisaneMusterije.add(musterija);
				}
			}
			return neobrisaneMusterije;
		}
		
		public static void obrisiMusteriju(Musterija m) {
			m.setObrisan(true);
		}
		
		public static void izmeniAdresuMusterije(Musterija m, String novaAdresa) {
			m.setAdresa(novaAdresa);
		}
		
		public static void izmeniBrojTelefonaMusterije(Musterija m, String noviBrojTelefona) {
			m.setBrojTelefona(noviBrojTelefona);
			
		}
		
		public static void izmeniKorisnickoImeMusterije(Musterija m, String novoKorisnickoIme) {
			m.setKorisnickoIme(novoKorisnickoIme);
		}
		
		public static void izmeniLozinkuMusterije(Musterija m, String novaLozinka) {
			m.setLozinka(novaLozinka);
		}
		
		public static void izmeniPrezimeMusterije(Musterija m, String novoPrezime) {
			m.setPrezime(novoPrezime);
		}
		
		public static void izmeniImeMusterije(Musterija m, String novoIme) {
			m.setIme(novoIme);
		}
		
		
		
		
		

	}




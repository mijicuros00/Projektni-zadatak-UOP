package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Automobil;
import model.Musterija;
import model.Servis;
import model.ServisnaKnjizica;

public class RadSaServisnimKnjizicama {
	
	public static ArrayList<ServisnaKnjizica> ucitajServisneKnjizice(){
		ArrayList<ServisnaKnjizica> knjizice = new ArrayList<ServisnaKnjizica>();
		try {
			File file = new File("src/txt/servisneKnjizice.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				Automobil automobil = RadSaAutomobilima.pronadjiAutomobilPoId(splittedLine[1]);
				ArrayList<Servis> servisi = RadSaServisima.pronadjiListuServisaPoId(splittedLine[2]);
				boolean obrisan = Boolean.parseBoolean(splittedLine[3]);
				ServisnaKnjizica k = new ServisnaKnjizica(id, automobil, servisi, obrisan);
				knjizice.add(k);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return knjizice;
	}
	
	public static void ispisServisnihKnjizica() {
		ArrayList<ServisnaKnjizica> knjizice = neobrisaneKnjizice();
		
		for (ServisnaKnjizica servisnaKnjizica : knjizice) {
			System.out.println(servisnaKnjizica);
		}
	}
	
	public static void snimanjeServisneKnjizice() {
		ArrayList<ServisnaKnjizica> knjizice = Vrednosti.knjizice;
		try {
		File file = new File("src/txt/servisneKnjizice.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (ServisnaKnjizica knjizica : knjizice) {
			writer.write(knjizica.getId() + "|" + knjizica.getAutomobil().getId() + "|" );
			for (Servis servis : knjizica.getServisi()) {
				writer.write(servis.getId() + ";");
			}
			writer.write("|" + knjizica.isObrisan() + "|\n");
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajKnjizica(ServisnaKnjizica sk) {
		Vrednosti.knjizice.add(sk);
	}
	
	public static ArrayList<ServisnaKnjizica> neobrisaneKnjizice(){
		ArrayList<ServisnaKnjizica> neobrisaneKnjizice = new ArrayList<ServisnaKnjizica>();
		for(ServisnaKnjizica sk: Vrednosti.knjizice) {
			if(sk.isObrisan() == false) {
				neobrisaneKnjizice.add(sk);
			}
		}
		return neobrisaneKnjizice;
	}
	
	public static ServisnaKnjizica pronadjiKnjizicuPoId(String splittedLine) {
		ArrayList<ServisnaKnjizica> knjizice = Vrednosti.knjizice;
		for (ServisnaKnjizica sk : knjizice) {
			if(sk.getId().equals(splittedLine)) {
				return sk;
			}
			
		}
		return null;
	}
	
	public static void obrisiServisnuKnjizicu(ServisnaKnjizica sk) {
		sk.setObrisan(true);
	}
	
	public static void izmeniAutomobil(ServisnaKnjizica sk, Automobil a) {
		sk.setAutomobil(a);
	}
	
	public static void izmeniListuServisaUKnjizici(ServisnaKnjizica sk, ArrayList<Servis> servisi) {
		sk.setServisi(servisi);
	}

}

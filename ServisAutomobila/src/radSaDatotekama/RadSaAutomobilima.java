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
import model.VrstaGoriva;

public class RadSaAutomobilima {
	
	public static ArrayList<Automobil> citanjeAutomobila(){
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				Musterija vlasnik = RadSaMusterijama.pronadjiMusterijuPoId(splittedLine[1]);
				String marka = splittedLine[2];
				String model = splittedLine[3];
				int godinaProizvodnje = Integer.parseInt(splittedLine[4]);
				int zapreminaMotora = Integer.parseInt(splittedLine[5]);
				int snagaMotora = Integer.parseInt(splittedLine[6]);
				VrstaGoriva vrstaGoriva = VrstaGoriva.values()[Integer.parseInt(splittedLine[7])];
				boolean obrisan = Boolean.parseBoolean(splittedLine[8]);
				
				Automobil a = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva, obrisan);
				
				automobili.add(a);
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return automobili;
	}
	
	public static void ispisAutomobila() {
		ArrayList<Automobil> automobili = neobrisaniAutomobili();
		
		for (Automobil automobil : automobili) {
			System.out.println(automobil);
		}
	}
	
	public static void snimanjeAutomobila() {
		ArrayList<Automobil> automobili = Vrednosti.automobili;
		try {
		File file = new File("src/txt/automobili.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		for (Automobil automobil : automobili) {
			writer.write(automobil.getId() + "|" + automobil.getVlasnik().getId() + "|" + automobil.getMarka() + "|" + automobil.getModel() + "|" + automobil.getGodinaProizvodnje() + "|" + automobil.getZapreminaMotora() + "|" + automobil.getSnagaMotora() + "|" + automobil.getVrstaGoriva().ordinal()  +  "|" + automobil.isObrisan() + "|" + "\n" ); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
	
	public static void dodajAutomobil(Automobil a) {
		Vrednosti.automobili.add(a);
	}
	
	public static Automobil pronadjiAutomobilPoId(String splittedLine) {
		ArrayList<Automobil> automobili = Vrednosti.automobili;
		for (Automobil automobil : automobili) {
			if(automobil.getId().equals(splittedLine)) {
				return automobil;
			}
		}
		return null;
	}
	
	public static ArrayList<Automobil> neobrisaniAutomobili(){
		ArrayList<Automobil> neobrisaniAutomobili = new ArrayList<Automobil>();
		for(Automobil a: Vrednosti.automobili) {
			if(a.isObrisan() == false) {
				neobrisaniAutomobili.add(a);
			}
		}
		return neobrisaniAutomobili;
	}
	
	public static void obrisiAutomobil(Automobil a) {
		a.setObrisan(true);
	}
	
	public static void izmeniVlasnikaAutomobila(Automobil a, Musterija m) {
		a.setVlasnik(m);
	}
	
	public static void izmeniMarkuAutomobila(Automobil a, String novaMarka) {
		a.setMarka(novaMarka);
	}
	
	public static void izmeniModelAutomobila(Automobil a, String noviModel) {
		a.setModel(noviModel);
	}
	
	public static void izmeniGodinuProizvodnjeAutomobila(Automobil a, int godina) {
		a.setGodinaProizvodnje(godina);
	}
	
	public static void izmeniZapreminuMotoraAutomobila(Automobil a, int zapremina) {
		a.setZapreminaMotora(zapremina);
	}
	
	public static void izmeniSnaguMotoraAutomobila(Automobil a, int snaga) {
		a.setSnagaMotora(snaga);

	}
	
	public static void izmeniVrstuGorivaAutomobila(Automobil a, VrstaGoriva gorivo) {
		a.setVrstaGoriva(gorivo);
	}





}

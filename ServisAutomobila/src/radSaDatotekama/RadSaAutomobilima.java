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

public class RadSaAutomobilima {
	
	public static ArrayList<Automobil> citanjeAutomobila(){
		ArrayList<Automobil> automobili = new ArrayList<Automobil>();
		try {
			File file = new File("src/txt/automobili.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			Musterija vlasnik = null;
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				ArrayList<Musterija> musterije = RadSaMusterijama.citanjeMusterija();
				for (Musterija musterija : musterije) {
					if(musterija.getId().equals(splittedLine[1])) {
						vlasnik = new Musterija(musterija.getId(), musterija.getIme(), musterija.getPrezime(), musterija.getJmbg(), musterija.getPol(), musterija.getAdresa(), musterija.getBrojTelefona(), musterija.getKorisnickoIme(), musterija.getLozinka(), musterija.getNagradniBodovi());
					}
					
				}
				
				String marka = splittedLine[2];
				String model = splittedLine[3];
				int godinaProizvodnje = Integer.parseInt(splittedLine[4]);
				int zapreminaMotora = Integer.parseInt(splittedLine[5]);
				int snagaMotora = Integer.parseInt(splittedLine[6]);
				String vrstaGoriva = splittedLine[7];
				
				Automobil a = new Automobil(id, vlasnik, marka, model, godinaProizvodnje, zapreminaMotora, snagaMotora, vrstaGoriva);
				
				automobili.add(a);
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return automobili;
	}
	
	public static void ispisAutomobila() {
		ArrayList<Automobil> automobili = RadSaAutomobilima.citanjeAutomobila();
		
		for (Automobil automobil : automobili) {
			System.out.println(automobil);
		}
	}
	
	public static void dodavanjeAutomobila(Automobil a) {
		ArrayList<Automobil> automobili = RadSaAutomobilima.citanjeAutomobila();
		try {
		File file = new File("src/txt/automobili.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		automobili.add(a);
		for (Automobil automobil : automobili) {
			writer.write(automobil.getId() + "|" + automobil.getVlasnik().getId() + "|" + automobil.getMarka() + "|" + automobil.getModel() + "|" + automobil.getGodinaProizvodnje() + "|" + automobil.getZapreminaMotora() + "|" + automobil.getSnagaMotora() + "|" + automobil.getVrstaGoriva()  + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}

}

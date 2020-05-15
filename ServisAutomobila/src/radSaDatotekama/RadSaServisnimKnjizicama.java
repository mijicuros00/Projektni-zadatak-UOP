package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import model.Automobil;
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
				Automobil automobil2 = null;
				ArrayList<Automobil> automobili = RadSaAutomobilima.citanjeAutomobila();
				for (Automobil automobil : automobili) {
					if(automobil.getId().equals(splittedLine[1])) {
						automobil2 = new Automobil(automobil.getId(), automobil.getVlasnik(), automobil.getMarka(), automobil.getModel(), automobil.getGodinaProizvodnje(), automobil.getZapreminaMotora(), automobil.getSnagaMotora(), automobil.getVrstaGoriva());
					}
				}
				ArrayList<Servis> servisi = new ArrayList<Servis>();
				ArrayList<Servis> sviServisi = RadSaServisima.citanjeServisa();
				String[] servisiIzFajla = splittedLine[2].split(";");
				for (Servis servis : sviServisi) {
					for (String string : servisiIzFajla) {
						if(servis.getId().equals(string)) {
							servisi.add(servis);
						}
					}
				}
				ServisnaKnjizica k = new ServisnaKnjizica(id, automobil2, servisi);
				knjizice.add(k);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return knjizice;
	}
	
	public static void ispisServisnihKnjizica() {
		ArrayList<ServisnaKnjizica> knjizice = RadSaServisnimKnjizicama.ucitajServisneKnjizice();
		
		for (ServisnaKnjizica servisnaKnjizica : knjizice) {
			System.out.println(servisnaKnjizica);
		}
	}
	public static void dodavanjeServisneKnjizice(ServisnaKnjizica sk) {
		ArrayList<ServisnaKnjizica> knjizice = RadSaServisnimKnjizicama.ucitajServisneKnjizice();
		try {
		File file = new File("src/txt/servisneKnjizice.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		knjizice.add(sk);
		for (ServisnaKnjizica knjizica : knjizice) {
			writer.write(knjizica.getId() + "|" + knjizica.getAutomobil().getId() + "|" );
			for (Servis servis : knjizica.getServisi()) {
				writer.write(servis.getId() + ";");
			}
			writer.write("\n");
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}

}

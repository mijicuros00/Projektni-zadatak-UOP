package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Deo;
import model.Musterija;

public class RadSaDelovima {
	public static ArrayList<Deo> citajDelove(){
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		try {
			File file = new File("src/txt/delovi.txt");
			
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				String marka = splittedLine[1];
				String model = splittedLine[2];
				String naziv = splittedLine[3];
				double cena = Double.parseDouble(splittedLine[4]);
				
				Deo d = new Deo(id, marka, model, naziv, cena);
				delovi.add(d);
			}
			reader.close();
		}catch(IOException e) {
			System.out.println("Greska pri citanju iz fajla!");
		}
		return delovi;
	}
	public static void ispisDelova() {
		ArrayList<Deo> delovi = RadSaDelovima.citajDelove();
		
		for (Deo deo : delovi) {
			System.out.println(deo);
		}
	}
	
	public static void dodavanjeDelova(Deo d) {
		ArrayList<Deo> delovi = RadSaDelovima.citajDelove();
		try {
		File file = new File("src/txt/delovi.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		delovi.add(d);
		for (Deo deo : delovi) {
			writer.write(deo.getId() + "|" + deo.getMarka() + "|" + deo.getModel() + "|" + deo.getNaziv() + "|" + deo.getCena() + "|" + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}

}

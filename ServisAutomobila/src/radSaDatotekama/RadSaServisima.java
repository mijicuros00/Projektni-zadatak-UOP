package radSaDatotekama;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;


import model.Automobil;
import model.Deo;
import model.Servis;
import model.Serviser;

public class RadSaServisima {
	
	
	public static ArrayList<Servis> citanjeServisa(){
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		try {
			File file = new File("src/txt/servisi.txt");
			BufferedReader reader = new BufferedReader(new FileReader(file));
			String line;
			while((line = reader.readLine()) != null) {
				String[] splittedLine = line.split("\\|");
				String id = splittedLine[0];
				Serviser serviser = null;
				ArrayList<Serviser> serviseri = RadSaServiserima.citanjeServisera();
				for (Serviser serviser2 : serviseri) {
					if(serviser2.getId().equals(splittedLine[1])) {
						serviser = new Serviser(serviser2.getId(), serviser2.getIme(), serviser2.getPrezime(), serviser2.getJmbg(), serviser2.getPol(), serviser2.getAdresa(), serviser2.getBrojTelefona(), serviser2.getKorisnickoIme(), serviser2.getLozinka(), serviser2.getPlata(), serviser2.getSpecijalizacija());
					}
				}
				Automobil automobil2 = null;
				ArrayList<Automobil> automobili = RadSaAutomobilima.citanjeAutomobila();
				for (Automobil automobil : automobili) {
					if(automobil.getId().equals(splittedLine[2])) {
						automobil2 = new Automobil(automobil.getId(), automobil.getVlasnik(), automobil.getMarka(), automobil.getModel(), automobil.getGodinaProizvodnje(), automobil.getZapreminaMotora(), automobil.getSnagaMotora(), automobil.getVrstaGoriva());
					}
				}
				ArrayList<Deo> deloviZaServis = new ArrayList<Deo>();
				String[] deloviIzFajla = splittedLine[3].split(";");
				ArrayList<Deo> delovi = RadSaDelovima.citajDelove();
				for (Deo deo : delovi) {
					for (int i = 0; i < deloviIzFajla.length; i++) {
						String deoIzFajla = deloviIzFajla[i];
						if(deo.getId().equals(deoIzFajla)) {
							deloviZaServis.add(deo);
						}
					}
				}
				String opis = splittedLine[4];
				String datumIzFajla = splittedLine[5];
				GregorianCalendar datum = new GregorianCalendar();
				try {
					datum.setTime(formatter.parse(datumIzFajla));
				}catch(ParseException p) {
					System.out.println("Datum nije u dobrom formatu!");
				}
				Servis s = new Servis(id, serviser, automobil2, deloviZaServis, opis, datum);
				servisi.add(s);
			}
			reader.close();
			
		}catch(IOException e) {
			System.out.println("Greska pri ucitavanju iz fajla");
		}
		return servisi;
	}
	
	public static void ispisServisa() {
		ArrayList<Servis> servisi = RadSaServisima.citanjeServisa();
		for (Servis servis : servisi) {
			System.out.println(servis);
		}
		
	}
	
	public static void dodavanjeServisa(Servis s) {
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		ArrayList<Servis> servisi = RadSaServisima.citanjeServisa();
		try {
		File file = new File("src/txt/servisi.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		servisi.add(s);
		for (Servis servis : servisi) {
			
			writer.write(servis.getId() + "|" + servis.getServiser().getId() + "|" + servis.getAutomobil().getId() + "|");
			for(Deo deo : servis.getDelovi()) {
				writer.write(deo.getId() + ";" );
			}
			writer.write("|" + servis.getOpis() + "|" + formatter.format(servis.getTermin().getTime()) + "\n");
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}

}

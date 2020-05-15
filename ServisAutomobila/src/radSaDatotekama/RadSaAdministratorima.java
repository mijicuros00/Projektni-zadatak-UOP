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

public class RadSaAdministratorima {
	

	public static ArrayList<Administrator> citanjeAdministratora(){
		ArrayList<Administrator> administratori = new ArrayList<Administrator>();
		
		try {
		File file = new File("src/txt/administratori.txt");
		
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
			
			Administrator a = new Administrator(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata);
			administratori.add(a);
		}
		reader.close();

	}catch(IOException e) {
		System.out.println("Greska pri citanju iz fajla!");
	}
	return administratori;
}
	
	public static void ispisAdministratora() {
		ArrayList<Administrator> administratori = RadSaAdministratorima.citanjeAdministratora();
		
		for (Administrator administrator : administratori) {
			System.out.println(administrator);
		}
		
	}
	public static void dodavanjeAdministratora(Administrator a) {
		ArrayList<Administrator> administratori = RadSaAdministratorima.citanjeAdministratora();
		try {
		File file = new File("src/txt/administratori.txt");
		
		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		administratori.add(a);
		for (Administrator administrator : administratori) {
			writer.write(administrator.getId() + "|" + administrator.getIme() + "|" + administrator.getPrezime() + "|" + administrator.getJmbg() + "|" + administrator.getPol().ordinal() + "|" + administrator.getAdresa() + "|" + administrator.getBrojTelefona() + "|" + administrator.getKorisnickoIme() + "|" + administrator.getLozinka() + "|" + administrator.getPlata() + "|" + "\n"); 
		}
		writer.close();
	
		}catch(IOException e){
			System.out.println("Greska pri upisivanju u fajl");
		}
	}
}

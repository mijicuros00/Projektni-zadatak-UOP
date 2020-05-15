package test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import model.Administrator;
import model.Automobil;
import model.Deo;
import model.Musterija;
import model.Pol;
import model.Servis;
import model.Serviser;
import model.ServisnaKnjizica;
import model.Specijalizacija;
import radSaDatotekama.RadSaAdministratorima;
import radSaDatotekama.RadSaAutomobilima;
import radSaDatotekama.RadSaDelovima;
import radSaDatotekama.RadSaMusterijama;
import radSaDatotekama.RadSaServiserima;
import radSaDatotekama.RadSaServisima;
import radSaDatotekama.RadSaServisnimKnjizicama;

public class TestKlasa {

	public static void main(String[] args) {
		
		RadSaMusterijama.ispisMusterija();
		System.out.println("-------------------------------------------------------------------------------------");
		Musterija m = new Musterija("m3", "Novak", "Djokovic", "0505988714562", Pol.MUSKI, "Beograd", "066545321", "Nole1", "111111",  0);
		RadSaMusterijama.dodavanjeMusterije(m);
		RadSaMusterijama.ispisMusterija();
		
		System.out.println("///////////////////////////////////////////////////////////////////////");
		
		RadSaServiserima.ispisServisera();
		System.out.println("------------------------------------------------------");
		Serviser s = new Serviser("s2", "Dragan", "Dragic", "1122334455667", Pol.MUSKI, "Novi Sad Strazilovska", "069987985", "DraganD", "dragan123", 55000, Specijalizacija.VULKANIZER);
		RadSaServiserima.dodavanjeServisera(s);
		RadSaServiserima.ispisServisera();
		
		System.out.println("//////////////////////////////////////////////////////////////");
		
		RadSaAdministratorima.ispisAdministratora();
		System.out.println("----------------------------------------------------");
		Administrator a = new Administrator("a2", "Djordje", "Djordjevic", "014725836922", Pol.MUSKI, "Novi Sad Kisacka", "064445565", "Djole12", "DjoleDjole", 72000);
		RadSaAdministratorima.dodavanjeAdministratora(a);
		RadSaAdministratorima.ispisAdministratora();
		
		System.out.println("///////////////////////////////////////////////////////////////");
		
		RadSaAutomobilima.ispisAutomobila();
		System.out.println("------------------------------------------------------------------------");
		Automobil auto = new Automobil("03", m, "BMW", "320d", 2011, 1998, 170, "dizel");
		RadSaAutomobilima.dodavanjeAutomobila(auto);
		RadSaAutomobilima.ispisAutomobila();
		
		System.out.println("///////////////////////////////////////////////////////////////");
		
		RadSaDelovima.ispisDelova();
		System.out.println("---------------------------------------------------------------------");
		Deo d = new Deo("03", "BMW", "320d" , "DPF filter", 7000);
		RadSaDelovima.dodavanjeDelova(d);
		RadSaDelovima.ispisDelova();
		
		
		
		RadSaServisima.ispisServisa();
		System.out.println("--------------------------------------------------------------------");
		GregorianCalendar termin = new GregorianCalendar(25, 05, 2020, 10, 00);
		SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy. HH:mm");
		try {
		termin.setTime(formatter.parse(termin.toString()));
		}catch(Exception e) {
			System.out.println();
		}
		ArrayList<Deo> delovi = new ArrayList<Deo>();
		delovi.add(d);
		Servis serv = new Servis("02", s, auto, delovi, "Zamena filtera", termin);
		RadSaServisima.dodavanjeServisa(serv);
		RadSaServisima.ispisServisa();
		
		System.out.println("////////////////////////////////////////////////////////////////////");
		
		ArrayList<Servis> servisi = new ArrayList<Servis>();
		servisi.add(serv);
		RadSaServisnimKnjizicama.ispisServisnihKnjizica();
		ServisnaKnjizica sk = new ServisnaKnjizica("k2", auto, servisi);
		RadSaServisnimKnjizicama.dodavanjeServisneKnjizice(sk);
		
	}

}

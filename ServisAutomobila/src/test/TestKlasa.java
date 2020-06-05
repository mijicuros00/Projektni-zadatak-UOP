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
import radSaDatotekama.Vrednosti;

public class TestKlasa {

	public static void main(String[] args) {
		
		Vrednosti.musterije = RadSaMusterijama.citanjeMusterija();
		Vrednosti.serviseri = RadSaServiserima.citanjeServisera();
		Vrednosti.administratori = RadSaAdministratorima.citanjeAdministratora();
		Vrednosti.delovi = RadSaDelovima.citajDelove();
		Vrednosti.automobili = RadSaAutomobilima.citanjeAutomobila();
		Vrednosti.servisi = RadSaServisima.citanjeServisa();
		Vrednosti.knjizice = RadSaServisnimKnjizicama.ucitajServisneKnjizice();
		
		/*
		Musterija m = RadSaMusterijama.pronadjiMusterijuPoId("m1");
		RadSaMusterijama.izmeniBrojTelefonaMusterije(m, "06666666666");
		RadSaMusterijama.izmeniAdresuMusterije(m, "Bulevar oslobodjenja 68");
		RadSaMusterijama.snimanjeMusterija();
		*/

		
		
		
		Serviser s = RadSaServiserima.pronadjiServiseraPoId("s1");
		/*
		RadSaServiserima.ispisServisera();
		RadSaServiserima.obrisiServisera(s);
		RadSaServiserima.snimanjeServisera();
		System.out.println("--------------------------------------------");
		RadSaServiserima.ispisServisera();
		*/
		
		
		/*
		RadSaAdministratorima.ispisAdministratora();
		Administrator a = new Administrator("a3", "Njegos", "Lazarevic", "2131231231231", Pol.MUSKI, "Novi Sad Bulevar cara Lazara","065987987", "njega00", "456456", false, 70000.0 );
		System.out.println("------------------------------------------------------------------");
		RadSaAdministratorima.dodajAdministratora(a);
		RadSaAdministratorima.ispisAdministratora();
		RadSaAdministratorima.snimanjeAdministratora();
		 */
		
		/*
		Deo d  = RadSaDelovima.pronadjiDeoPoId("02");
		RadSaDelovima.izmeniCenuDela(d, 8200);
		RadSaDelovima.snimanjeDelova();
		*/
		
		/*
		Automobil a = RadSaAutomobilima.pronadjiAutomobilPoId("03");
		RadSaAutomobilima.izmeniSnaguMotoraAutomobila(a, 172);
		RadSaAutomobilima.snimanjeAutomobila();
		*/
		
		
		Servis servis = RadSaServisima.pronadjiServisPoId("02");
		RadSaServisima.izmeniServisera(servis, s);
		RadSaServisima.snimanjeServisa();
		
		
		
	}

}

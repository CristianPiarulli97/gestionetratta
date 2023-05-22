package it.prova.gestionetratte;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import it.prova.gestionetratte.model.Airbus;
import it.prova.gestionetratte.model.Stato;
import it.prova.gestionetratte.model.Tratta;
import it.prova.gestionetratte.service.AirbusService;
import it.prova.gestionetratte.service.TrattaService;

@SpringBootApplication
public class GestionetratteApplication implements CommandLineRunner{

	
	@Autowired
	private AirbusService airbusService;
	
	@Autowired
	private TrattaService trattaService;
	
	public static void main(String[] args) {
		SpringApplication.run(GestionetratteApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		String codiceAirbus1 = "01";
		String descrizioneAirbus1 = "AirBus1";
		Airbus airbus1 = airbusService.findByCodiceAndDescrizione(codiceAirbus1, descrizioneAirbus1);
		if (airbus1 == null) {
			airbus1 = new Airbus(codiceAirbus1, descrizioneAirbus1, LocalDate.now().minusDays(1), 120);
			airbusService.inserisciNuovo(airbus1);
		}
		
		Tratta trattaRomaMilano = new Tratta("T1", "Roma-Milano", LocalDate.now(), LocalTime.of(8, 30), LocalTime.of(11, 30), Stato.ATTIVA, airbus1);
		if (trattaService.findByCodiceAndDescrizione(trattaRomaMilano.getCodice(), trattaRomaMilano.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(trattaRomaMilano);
		}
		
		String codiceAirbus2 = "02";
		String descrizioneAirbus2 = "AirBus2";
		Airbus airbus2 = airbusService.findByCodiceAndDescrizione(codiceAirbus2, descrizioneAirbus2);
		if (airbus2 == null) {
			airbus2 = new Airbus(codiceAirbus2, descrizioneAirbus2, LocalDate.of(2020, 05, 19), 110);
			airbusService.inserisciNuovo(airbus2);
		}
		
		Tratta trattaNapoliTorino = new Tratta("T2", "Napoli-Torino", LocalDate.of(2023, 12, 1), LocalTime.of(8, 30), LocalTime.of(13, 30), Stato.CONCLUSA, airbus2);
		if (trattaService.findByCodiceAndDescrizione(trattaNapoliTorino.getCodice(), trattaNapoliTorino.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(trattaNapoliTorino);
		}
		
		String codiceAirbus3 = "03";
		String descrizioneAirbus3 = "AirBus3";
		Airbus airbus3 = airbusService.findByCodiceAndDescrizione(codiceAirbus3, descrizioneAirbus3);
		if (airbus3 == null) {
			airbus3 = new Airbus(codiceAirbus2, descrizioneAirbus2, LocalDate.of(2020, 05, 19), 110);
			airbusService.inserisciNuovo(airbus2);
		}
		
		
		Tratta trattaRomaBologna = new Tratta("T3", "Roma-Bologna", LocalDate.of(2023, 06, 3), LocalTime.of(11, 30), LocalTime.of(15, 30), Stato.CONCLUSA, airbus2);
		if (trattaService.findByCodiceAndDescrizione(trattaRomaBologna.getCodice(), trattaRomaBologna.getDescrizione()).isEmpty()) {
			trattaService.inserisciNuovo(trattaRomaBologna);
		}
	}

}

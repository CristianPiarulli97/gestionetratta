package it.prova.gestionetratte.repository;

import java.util.List;

import it.prova.gestionetratte.model.Tratta;

public interface CustomTrattaRepository {

	List<Tratta> findByExample(Tratta example);
}

package org.exercise.model.bonus;

import org.exercise.model.Evento;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProgrammEventi {
    // Attributi
    private final String titolo;
    private final List<Evento> eventi;

    // Costruttore
    public ProgrammEventi(String titolo) {
        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Metodo per restituire una lista di eventi in una certa data
    public List<Evento> eventiInData(LocalDate data) {
        return eventi.stream()
                .filter(evento -> evento.getData().equals(data))
                .collect(Collectors.toList());
    }

    // Metodo per aggiungere un evento alla lista
    public void aggiungiEvento(Evento evento) {
        eventi.add(evento);
    }

    // Metodo per restituire il numero di eventi presenti nel programma
    public int numeroEventi() {
        return eventi.size();
    }

    // Metodo per svuotare la lista di eventi
    public void svuotaEventi() {
        eventi.clear();
    }

    // Override del metodo toString
    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Programma Eventi: ").append(titolo).append("\n");
        List<Evento> toSort = new ArrayList<>(eventi);
        toSort.sort(Comparator.comparing(Evento::getData));
        for (Evento evento : toSort) {
            stringBuilder.append(evento.getData()).append(" - ").append(evento.getTitolo()).append("\n");
        }
        return stringBuilder.toString();
    }
}

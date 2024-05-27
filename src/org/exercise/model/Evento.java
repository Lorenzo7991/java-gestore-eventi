package org.exercise.model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Evento {
    // Attributi
    private String titolo;
    private LocalDate data;
    private final int numeroPostiTotali;
    private int numeroPostiPrenotati;

    // Costruttore con verifica che la data non sia nel passato e che il numero di posti totali sia positivo.
    public Evento(String titolo, String data, int numeroPostiTotali) throws IllegalArgumentException {
        LocalDate dataParsed;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataParsed = LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Usa il formato dd/MM/yyyy.");
        }

        if (dataParsed.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
        if (numeroPostiTotali <= 0) {
            throw new IllegalArgumentException("Il numero di posti totali deve essere positivo.");
        }
        if (!isValidTitolo(titolo)) {
            throw new IllegalArgumentException("Il titolo non può contenere numeri o simboli.");
        }

        this.titolo = titolo;
        this.data = dataParsed;
        this.numeroPostiTotali = numeroPostiTotali;
        this.numeroPostiPrenotati = 0;
    }

    // Metodi getter
    public String getTitolo() {
        return titolo;
    }

    public LocalDate getData() {
        return data;
    }

    public int getNumeroPostiTotali() {
        return numeroPostiTotali;
    }

    public int getNumeroPostiPrenotati() {
        return numeroPostiPrenotati;
    }

    // Metodi setter
    public void setTitolo(String titolo) {
        if (!isValidTitolo(titolo)) {
            throw new IllegalArgumentException("Il titolo non può contenere numeri o simboli.");
        }
        this.titolo = titolo;
    }

    // Setter data con validazione
    public void setData(String data) {
        LocalDate dataParsed;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            dataParsed = LocalDate.parse(data, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato data non valido. Usa il formato dd/MM/yyyy.");
        }

        if (dataParsed.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data non può essere nel passato.");
        }
        this.data = dataParsed;
    }

    // Metodo per validare il titolo
    private boolean isValidTitolo(String titolo) {
        return titolo.matches("[a-zA-Z\\s]+");
    }

    // Metodo per prenotare posti
    public void prenota(int posti) throws IllegalArgumentException {
        if (posti <= 0) {
            throw new IllegalArgumentException("Il numero di posti da prenotare deve essere positivo.");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato, non è possibile prenotare posti.");
        }
        if (numeroPostiPrenotati + posti > numeroPostiTotali) {
            throw new IllegalArgumentException("Non ci sono abbastanza posti disponibili.");
        }
        numeroPostiPrenotati += posti;
    }

    // Metodo per disdire posti
    public void disdici(int posti) throws IllegalArgumentException {
        if (posti <= 0) {
            throw new IllegalArgumentException("Il numero di posti da disdire deve essere positivo.");
        }
        if (data.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("L'evento è già passato, non è possibile disdire posti.");
        }
        if (numeroPostiPrenotati - posti < 0) {
            throw new IllegalArgumentException("Non ci sono abbastanza prenotazioni da disdire.");
        }
        numeroPostiPrenotati -= posti;
    }

    // Override del metodo toString
    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return data.format(formatter) + " - " + titolo;
    }
}
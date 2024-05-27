package org.exercise.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Concerto extends Evento {
    //Attributi
    private LocalTime ora;
    private BigDecimal prezzo;

    //Costruttore
    public Concerto(String titolo, String data, int numeroPostiTotali, String ora, BigDecimal prezzo) throws IllegalArgumentException {
        //Chiamata al costruttore della superclasse Evento
        super(titolo, data, numeroPostiTotali);
        try {
            //Conversione della stringa data in un oggetto LocalTime
            this.ora = LocalTime.parse(ora);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato ora non valido. Usa il formato HH:mm.");
        }
        this.prezzo = prezzo;
    }

    //Metodi getter
    public LocalTime getOra() {
        return ora;
    }

    public BigDecimal getPrezzo() {
        return prezzo;
    }

    public String getDataFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return getData().format(formatter);
    }

    public String getOraFormattata() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        return ora.format(formatter);
    }

    public String getPrezzoFormattato() {
        return String.format("%.2f€", prezzo);
    }

    //Metodi setter
    public void setOra(LocalTime ora) {
        this.ora = ora;
    }

    public void setPrezzo(BigDecimal prezzo) {
        this.prezzo = prezzo;
    }

    // Override del metodo toString
    @Override
    public String toString() {
        return getDataFormattata() + " " + getOraFormattata() + " - " + getTitolo() + " - " + getPrezzoFormattato();
    }

}
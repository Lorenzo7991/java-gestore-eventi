package org.exercise.model;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Concerto extends Evento {
    //Attributi
    private final LocalTime ora;
    private final BigDecimal prezzo;

    //Costruttore
    public Concerto(String titolo, String data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
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




}
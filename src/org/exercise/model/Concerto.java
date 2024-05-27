package org.exercise.model;

import java.math.BigDecimal;
import java.time.LocalTime;

public class Concerto extends Evento {
    private LocalTime ora;
    private BigDecimal prezzo;

    public Concerto(String titolo, String data, int numeroPostiTotali, LocalTime ora, BigDecimal prezzo) {
        super(titolo, data, numeroPostiTotali);
        this.ora = ora;
        this.prezzo = prezzo;
    }
}
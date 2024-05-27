package org.exercise.Main.bonus;

import org.exercise.model.Evento;
import org.exercise.model.bonus.ProgrammEventi;

import java.time.LocalDate;

public class MainProgrammEventi {
    public static void main(String[] args) {
        // Creazione di un programma eventi
        ProgrammEventi p = new ProgrammEventi("Programma Eventi");

        // Aggiunta di eventi
        p.aggiungiEvento(new Evento("Concerto Rock", "01/06/2024", 200));
        p.aggiungiEvento(new Evento("Concerto Sinfonico", "01/06/2024", 300));
        p.aggiungiEvento(new Evento("Jazz Night", "15/06/2024", 150));
        p.aggiungiEvento(new Evento("EDM OLD WAYS", "30/06/2024", 100));

        // Stampa di tutti gli eventi nel programma
        System.out.println(p);
        System.out.println("********************************************************");

        // Stampa eventi in una data specifica
        System.out.println("Eventi il 1 giugno 2024:");
        p.eventiInData(LocalDate.of(2024, 6, 1)).forEach(System.out::println);
        System.out.println("********************************************************");


        // Stampa del numero di eventi totali nel programma
        System.out.println("Numero totale di eventi nel programma: " + p.numeroEventi());
        System.out.println("********************************************************");


        // Stampa della lista degli eventi dopo averla svuotata
        p.svuotaEventi();
        System.out.println("Numero totale di eventi dopo aver svuotato la lista: " + p.numeroEventi());
    }
}

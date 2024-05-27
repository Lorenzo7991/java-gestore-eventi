package org.exercise.Main;

import org.exercise.model.Evento;
import org.exercise.model.Concerto;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Evento> eventiCreati = new ArrayList<>();

        boolean continuaCreazione = true;

        while (continuaCreazione) {
            boolean eventoValido = false;
            Evento evento;

            while (!eventoValido) {
                try {
                    //Chiede all'utente che tipo di evento vuole creare
                    System.out.println("Che tipo di evento vuoi creare? (evento/concerto)");
                    String tipoEvento = scanner.nextLine().toLowerCase();

                    //Creazione dell'evento in base alla scelta dell'utente
                    if (tipoEvento.equals("evento")) {
                        System.out.println("Inserisci il titolo dell'evento:");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserisci la data dell'evento (dd/MM/yyyy):");
                        String dataString = scanner.nextLine();

                        System.out.println("Inserisci il numero totale di posti:");
                        int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

                        evento = new Evento(titolo, dataString, numeroPostiTotali);
                    } else if (tipoEvento.equals("concerto")) {
                        System.out.println("Inserisci il titolo del concerto:");
                        String titolo = scanner.nextLine();

                        System.out.println("Inserisci la data del concerto (dd/MM/yyyy):");
                        String dataString = scanner.nextLine();

                        System.out.println("Inserisci il numero totale di posti:");
                        int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

                        System.out.println("Inserisci l'orario del concerto (HH:mm):");
                        String ora = scanner.nextLine();

                        System.out.println("Inserisci il prezzo del concerto:");
                        BigDecimal prezzo = new BigDecimal(scanner.nextLine());

                        evento = new Concerto(titolo, dataString, numeroPostiTotali, ora, prezzo);
                    } else {
                        throw new IllegalArgumentException("Scelta non valida. Riprova.");
                    }

                    eventiCreati.add(evento);

                    eventoValido = true;
                    System.out.println("Evento creato con successo: " + evento);

                    //Chiedere all'utente se vuole creare un altro evento
                    System.out.println("Vuoi creare un altro evento? (sì/no)");
                    String risposta = scanner.nextLine().toLowerCase();
                    if (risposta.equals("no")) {
                        continuaCreazione = false;
                    }

                } catch (DateTimeParseException e) {
                    System.out.println("Formato data o ora non valido. Riprova.");
                } catch (IllegalArgumentException e) {
                    System.out.println("Formato numero non valido o errore nei dati inseriti. Riprova.");
                }
            }
        }

        //Stampa di tutti gli eventi creati
        System.out.println("Eventi creati:");
        for (Evento evento : eventiCreati) {
            System.out.println(evento);
        }
        System.out.println("Programma terminato...");

        scanner.close();
    }
}

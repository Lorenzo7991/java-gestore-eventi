package org.exercise.Main;

import org.exercise.model.Evento;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Richiesta dei dettagli dell'evento all'utente
            System.out.print("Inserisci il titolo dell'evento: ");
            String titolo = scanner.nextLine();

            System.out.print("Inserisci la data di inizio (formato YYYY-MM-DD): ");
            String dataInput = scanner.nextLine();
            LocalDate data = LocalDate.parse(dataInput);

            System.out.print("Inserisci il numero totale di posti: ");
            int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

            Evento evento = new Evento(titolo, data, numeroPostiTotali);
            System.out.println(evento);

            boolean continua = true;
            while (continua) {
                System.out.print("Vuoi prenotare o disdire posti? (prenota/disdici/esci): ");
                String azione = scanner.nextLine();

                switch (azione.toLowerCase()) {
                    case "prenota":
                        System.out.print("Quanti posti vuoi prenotare?: ");
                        int postiPrenotare = Integer.parseInt(scanner.nextLine());
                        try {
                            evento.prenota(postiPrenotare);
                            System.out.println("Posti prenotati con successo. Posti attualmente prenotati: " + evento.getNumeroPostiPrenotati());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore: " + e.getMessage());
                        }
                        break;

                    case "disdici":
                        System.out.print("Quanti posti vuoi disdire?: ");
                        int postiDisdire = Integer.parseInt(scanner.nextLine());
                        try {
                            evento.disdici(postiDisdire);
                            System.out.println("Posti disdetti con successo. Posti attualmente prenotati: " + evento.getNumeroPostiPrenotati());
                        } catch (IllegalArgumentException e) {
                            System.out.println("Errore: " + e.getMessage());
                        }
                        break;

                    case "esci":
                        continua = false;
                        break;

                    default:
                        System.out.println("Azione non riconosciuta. Riprova.");
                }
            }

        } catch (DateTimeParseException e) {
            System.out.println("Errore: La data inserita non è valida.");
        } catch (IllegalArgumentException e) {
            System.out.println("Errore: " + e.getMessage());
        }

        scanner.close();
        System.out.println("Grazie per aver utilizzato il programma di gestione eventi!");
    }
}

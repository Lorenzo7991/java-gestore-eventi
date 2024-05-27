package org.exercise.Main;

import org.exercise.model.Evento;

import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean eventoValido = false;
        Evento evento = null;

        while (!eventoValido) {
            try {
                // Chiedere all'utente di inserire i dettagli dell'evento
                System.out.println("Inserisci il titolo dell'evento:");
                String titolo = scanner.nextLine();

                System.out.println("Inserisci la data dell'evento (dd/MM/yyyy):");
                String dataString = scanner.nextLine();

                System.out.println("Inserisci il numero totale di posti:");
                int numeroPostiTotali = Integer.parseInt(scanner.nextLine());

                evento = new Evento(titolo, dataString, numeroPostiTotali);
                eventoValido = true;
                System.out.println("Evento creato con successo: " + evento);

            } catch (DateTimeParseException e) {
                System.out.println("Formato data non valido. Riprova.");
            } catch (NumberFormatException e) {
                System.out.println("Formato numero non valido. Riprova.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            }
        }

        boolean gestioneEvento = true;
        while (gestioneEvento) {
            System.out.println("Vuoi prenotare posti, disdire posti o uscire? (prenota/disdici/esci)");
            String operazione = scanner.nextLine();

            switch (operazione.toLowerCase()) {
                case "prenota":
                    System.out.println("Quanti posti vuoi prenotare?");
                    try {
                        int postiPrenotare = Integer.parseInt(scanner.nextLine());
                        evento.prenota(postiPrenotare);
                        System.out.println("Prenotazione avvenuta con successo. Posti prenotati: " + evento.getNumeroPostiPrenotati());
                        System.out.println("Posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));
                    } catch (NumberFormatException e) {
                        System.out.println("Formato numero non valido. Riprova.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella prenotazione: " + e.getMessage());
                    }
                    break;

                case "disdici":
                    System.out.println("Quanti posti vuoi disdire?");
                    try {
                        int postiDisdire = Integer.parseInt(scanner.nextLine());
                        evento.disdici(postiDisdire);
                        System.out.println("Disdetta avvenuta con successo. Posti prenotati: " + evento.getNumeroPostiPrenotati());
                        System.out.println("Posti disponibili: " + (evento.getNumeroPostiTotali() - evento.getNumeroPostiPrenotati()));
                    } catch (NumberFormatException e) {
                        System.out.println("Formato numero non valido. Riprova.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Errore nella disdetta: " + e.getMessage());
                    }
                    break;

                case "esci":
                    gestioneEvento = false;
                    System.out.println("Programma terminato...");
                    break;

                default:
                    System.out.println("Operazione non valida. Riprova.");
            }
        }

        scanner.close();
    }
}

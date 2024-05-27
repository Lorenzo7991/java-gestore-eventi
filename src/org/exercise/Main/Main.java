package org.exercise.Main;

import org.exercise.model.Evento;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creazione di tre eventi predefiniti
        List<Evento> eventi = new ArrayList<>();
        eventi.add(new Evento("Concerto Rock", "15/06/2024", 100));
        eventi.add(new Evento("Conferenza Tech", "10/09/2024", 200));
        eventi.add(new Evento("Spettacolo Teatrale", "20/12/2024", 150));

        boolean running = true;

        while (running) {
            try {
                System.out.println("Seleziona un evento:");
                for (int i = 0; i < eventi.size(); i++) {
                    System.out.println((i + 1) + ". " + eventi.get(i));
                }

                int scelta = Integer.parseInt(scanner.nextLine()) - 1;

                if (scelta < 0 || scelta >= eventi.size()) {
                    System.out.println("Scelta non valida. Riprova.");
                    continue;
                }

                Evento eventoSelezionato = eventi.get(scelta);

                System.out.println("Hai selezionato: " + eventoSelezionato);

                boolean eventoAttivo = true;

                while (eventoAttivo) {
                    System.out.println("Scegli un'operazione: prenota, disdici, esci");
                    String operazione = scanner.nextLine();

                    switch (operazione.toLowerCase()) {
                        case "prenota":
                            System.out.println("Quanti posti vuoi prenotare?");
                            int postiPrenotare = Integer.parseInt(scanner.nextLine());

                            try {
                                eventoSelezionato.prenota(postiPrenotare);
                                System.out.println("Prenotazione avvenuta con successo. Posti prenotati: " + eventoSelezionato.getNumeroPostiPrenotati());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Errore nella prenotazione: " + e.getMessage());
                            }
                            break;

                        case "disdici":
                            System.out.println("Quanti posti vuoi disdire?");
                            int postiDisdire = Integer.parseInt(scanner.nextLine());

                            try {
                                eventoSelezionato.disdici(postiDisdire);
                                System.out.println("Disdetta avvenuta con successo. Posti prenotati: " + eventoSelezionato.getNumeroPostiPrenotati());
                            } catch (IllegalArgumentException e) {
                                System.out.println("Errore nella disdetta: " + e.getMessage());
                            }
                            break;

                        case "esci":
                            eventoAttivo = false;
                            break;

                        default:
                            System.out.println("Operazione non valida. Riprova.");
                    }
                }
            } catch (NumberFormatException e) {
                System.out.println("Formato numero non valido. Riprova.");
            } catch (IllegalArgumentException e) {
                System.out.println("Errore: " + e.getMessage());
            } finally {
                System.out.println("Vuoi selezionare un altro evento? (si/no)");
                if (!scanner.nextLine().equalsIgnoreCase("si")) {
                    running = false;
                }
            }
        }

        scanner.close();
    }
}
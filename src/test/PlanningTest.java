package test;

import classes.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PlanningTest {

    /**
     * Test pour la méthode ajout() de la classe Planning.
     * Vérifie l'ajout de réservations, la gestion des erreurs d'ajout et le remplissage du planning.
     * @throws ExceptionPlanning Si une erreur d'ajout survient dans le planning.
     */
    @Test
    void ajoutTest() throws ExceptionPlanning {
        Planning p1 = new Planning(2);
        Reservation res1 = new Reservation(new Date(10, 3, 2025),
                new PlageHoraire(new Horaire(10, 0), new Horaire(12, 0)), "Foot");
        Reservation res2 = new Reservation(new Date(11, 3, 2025),
                new PlageHoraire(new Horaire(12, 0), new Horaire(14, 0)), "Judo");
        Reservation res3 = new Reservation(new Date(12, 3, 2025),
                new PlageHoraire(new Horaire(9, 0), new Horaire(11, 0)), "Karaté");

        p1.ajout(res1);
        p1.ajout(res2);
        assertEquals(res1, p1.getReservation(new Date(10, 3, 2025)));

        ExceptionPlanning exception = assertThrows(ExceptionPlanning.class, () -> {
            p1.ajout(res1);
        });
        assertEquals(2, exception.getChCodeErreur());

        ExceptionPlanning exception2 = assertThrows(ExceptionPlanning.class, () -> {
            p1.ajout(res3);
        });
        assertEquals(1, exception2.getChCodeErreur());
    }

    /**
     * Test pour la méthode getReservation() de la classe Planning.
     * Vérifie la récupération d'une réservation par date et la gestion d'une date sans réservation.
     * @throws ExceptionPlanning Si une erreur survient lors de la récupération de la réservation.
     */
    @Test
    void getReservationTest() throws ExceptionPlanning {
        Planning planning = new Planning(3);
        Reservation res = new Reservation(new Date(15, 3, 2025),
                new PlageHoraire(new Horaire(10, 0), new Horaire(12, 0)), "Réunion");
        planning.ajout(res);
        assertEquals(res, planning.getReservation(new Date(15, 3, 2025)));
        assertNull(planning.getReservation(new Date(16, 3, 2025)));
    }

    /**
     * Test pour la méthode plusAncienneReservation() de la classe Planning.
     * Vérifie la récupération de l'indice de la réservation la plus ancienne entre deux indices.
     * @throws ExceptionPlanning Si une erreur survient lors de l'ajout des réservations.
     */
    @Test
    void plusAncienneReservationTest() throws ExceptionPlanning {
        Planning planning = new Planning(3);
        Horaire heureDebut1 = new Horaire("09:00");
        Horaire heureFin1 = new Horaire("10:00");
        Horaire heureDebut2 = new Horaire("10:00");
        Horaire heureFin2 = new Horaire("11:00");

        Reservation res1 = new Reservation(new Date(15, 3, 2025), new PlageHoraire(heureDebut1, heureFin1), "Réunion");
        Reservation res2 = new Reservation(new Date(16, 3, 2025), new PlageHoraire(heureDebut2, heureFin2), "Conférence");

        planning.ajout(res1);
        planning.ajout(res2);

        assertEquals(0, planning.plusAncienneReservation(0, 2));
    }

    /**
     * Test pour la méthode toString() de la classe Planning.
     * Vérifie que la méthode toString génère une chaîne contenant les informations correctes sur la réservation.
     * @throws ExceptionPlanning Si une erreur survient lors de l'ajout de la réservation.
     */
    @Test
    void testToString() throws ExceptionPlanning {
        Planning planning = new Planning(3);
        Reservation res = new Reservation(new Date(15, 3, 2025),
                new PlageHoraire(new Horaire(10, 0), new Horaire(12, 0)), "Réunion");
        planning.ajout(res);
        String str = planning.toString();
        assertTrue(str.contains("Réunion"));
        assertTrue(str.contains("15/3/2025"));
    }
}

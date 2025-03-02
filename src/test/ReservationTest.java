package test;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import classes.Reservation;
import classes.Date;
import classes.PlageHoraire;
import classes.Horaire;
import classes.ExceptionPlanning;

class ReservationTest {

    /**
     * Test pour la méthode compareTo() de la classe Reservation.
     * Vérifie la comparaison de réservations par date et plage horaire.
     * @throws ExceptionPlanning Si une erreur survient lors de la création des réservations.
     */
    @Test
    void compareTo() {
        try {
            Reservation r1 = new Reservation(new Date(10, 3, 2024), new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion A");
            Reservation r2 = new Reservation(new Date(11, 3, 2024), new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion B");
            Reservation r3 = new Reservation(new Date(10, 3, 2024), new PlageHoraire(new Horaire(10, 0), new Horaire(11, 30)), "Réunion C");

            assertTrue(r1.compareTo(r2) < 0);
            assertTrue(r2.compareTo(r1) > 0);
            assertEquals(0, r1.compareTo(r3)); // Chevauchement
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode estValide() de la classe Reservation.
     * Vérifie si la réservation est valide.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la réservation.
     */
    @Test
    void estValide() {
        try {
            Reservation r = new Reservation(new Date(10, 3, 2024), new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion A");
            assertTrue(r.estValide());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode getDate() de la classe Reservation.
     * Vérifie la récupération de la date d'une réservation.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la réservation.
     */
    @Test
    void getDate() {
        try {
            Date d = new Date(10, 3, 2024);
            Reservation r = new Reservation(d, new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion A");
            assertEquals(d, r.getDate());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode getIntitule() de la classe Reservation.
     * Vérifie la récupération de l'intitulé d'une réservation.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la réservation.
     */
    @Test
    void getIntitule() {
        try {
            Reservation r = new Reservation(new Date(10, 3, 2024), new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion A");
            assertEquals("Réunion A", r.getIntitule());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode toString() de la classe Reservation.
     * Vérifie que la méthode toString génère une chaîne contenant les informations correctes sur la réservation.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la réservation.
     */
    @Test
    void testToString() {
        try {
            Reservation r = new Reservation(new Date(10, 3, 2024), new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30)), "Réunion A");
            assertEquals("Réunion A, 10/3/2024, 9:00 - 10:30 durée 1:30", r.toString());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }
}

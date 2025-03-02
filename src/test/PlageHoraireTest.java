package test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import classes.PlageHoraire;
import classes.Horaire;
import classes.ExceptionPlanning;

class PlageHoraireTest {

    /**
     * Test pour la méthode estValide() de la classe PlageHoraire.
     * Vérifie la validité de la plage horaire en fonction de la durée minimale.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la plage horaire.
     * @throws IllegalArgumentException Si les horaires sont nuls.
     */
    @Test
    void estValide() {
        try {
            PlageHoraire pH = new PlageHoraire(new Horaire(10, 0), new Horaire(11, 30));
            assertTrue(pH.estValide());

            PlageHoraire pH2 = new PlageHoraire(new Horaire(10, 0), new Horaire(10, 30));
            assertFalse(pH2.estValide());  // Si DUREE_Minimum > 30
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        } catch (IllegalArgumentException e) {
            fail("Les horaires ne peuvent pas être null !");
        }
    }

    /**
     * Test pour la méthode duree() de la classe PlageHoraire.
     * Vérifie que la durée d'une plage horaire est correcte.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la plage horaire.
     */
    @Test
    void duree() {
        try {
            PlageHoraire pH = new PlageHoraire(new Horaire(10, 0), new Horaire(11, 30));
            assertEquals(90, pH.duree());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode compareTo() de la classe PlageHoraire.
     * Vérifie la comparaison entre différentes plages horaires.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la plage horaire.
     */
    @Test
    void compareTo() {
        try {
            PlageHoraire p1 = new PlageHoraire(new Horaire(9, 0), new Horaire(10, 30));
            PlageHoraire p2 = new PlageHoraire(new Horaire(11, 0), new Horaire(12, 30));
            PlageHoraire p3 = new PlageHoraire(new Horaire(9, 30), new Horaire(11, 0));

            assertEquals(-1, p1.compareTo(p2));
            assertEquals(1, p2.compareTo(p1));
            assertEquals(0, p1.compareTo(p3));
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }

    /**
     * Test pour la méthode toString() de la classe PlageHoraire.
     * Vérifie que la méthode toString génère une chaîne contenant les informations correctes sur la plage horaire.
     * @throws ExceptionPlanning Si une erreur survient lors de la création de la plage horaire.
     */
    @Test
    void testToString() {
        try {
            PlageHoraire pH = new PlageHoraire(new Horaire(14, 0), new Horaire(15, 30));
            assertEquals("14:00 - 15:30 durée 1:30", pH.toString());
        } catch (ExceptionPlanning e) {
            fail("Une exception ne devrait pas être levée ici !");
        }
    }
}

package test;

import static org.junit.jupiter.api.Assertions.*;

import classes.Date;
import org.junit.jupiter.api.Test;

class DateTest {

    /**
     * Test de la méthode isbissextile() de la classe Date.
     * Vérifie si une année est bissextile.
     */
    @Test
    void testIsBissextile() {
        assertTrue(Date.isbissextile(2024));
        assertFalse(Date.isbissextile(2023));
        assertFalse(Date.isbissextile(1901));
        assertTrue(Date.isbissextile(2000));
    }

    /**
     * Test de la méthode lastJour() de la classe Date.
     * Vérifie le dernier jour d'un mois pour une année donnée.
     */
    @Test
    void testLastJour() {
        assertEquals(31, Date.lastJour(1, 2023));
        assertEquals(28, Date.lastJour(2, 2023));
        assertEquals(29, Date.lastJour(2, 2024));
        assertEquals(30, Date.lastJour(4, 2023));
    }

    /**
     * Test de la méthode isValable() de la classe Date.
     * Vérifie si une date est valide (en prenant en compte les années bissextiles et les jours).
     */
    @Test
    void testIsValable() {
        assertTrue(new Date(29, 2, 2024).isValable());
        assertFalse(new Date(29, 2, 2023).isValable());
        assertFalse(new Date(31, 4, 2023).isValable());
        assertTrue(new Date(31, 12, 2023).isValable());
        assertFalse(new Date(32, 1, 2023).isValable());
    }

    /**
     * Test de la méthode compareTo() de la classe Date.
     * Vérifie la comparaison de dates entre elles.
     */
    @Test
    void testCompareTo() {
        Date d1 = new Date(1, 1, 2023);
        Date d2 = new Date(2, 1, 2023);
        Date d3 = new Date(1, 2, 2023);
        Date d4 = new Date(1, 1, 2024);

        assertEquals(0, d1.compareTo(new Date(1, 1, 2023)));
        assertTrue(d1.compareTo(d2) < 0);
        assertTrue(d2.compareTo(d1) > 0);
        assertTrue(d1.compareTo(d3) < 0);
        assertTrue(d1.compareTo(d4) < 0);
    }

    /**
     * Test de la méthode dateDuLendemain() de la classe Date.
     * Vérifie que la date du lendemain est correcte.
     */
    @Test
    void testDateDuLendemain() {
        assertEquals("2/1/2023", new Date(1, 1, 2023).dateDuLendemain().toString());
        assertEquals("1/2/2023", new Date(31, 1, 2023).dateDuLendemain().toString());
        assertEquals("1/3/2024", new Date(29, 2, 2024).dateDuLendemain().toString());
        assertEquals("1/1/2024", new Date(31, 12, 2023).dateDuLendemain().toString());
    }

    /**
     * Test de la méthode dateDeLaVielle() de la classe Date.
     * Vérifie que la date du jour précédent est correcte.
     */
    @Test
    void testDateDeLaVielle() {
        assertEquals("31/12/2022", new Date(1, 1, 2023).dateDeLaVielle().toString());
        assertEquals("30/1/2023", new Date(31, 1, 2023).dateDeLaVielle().toString());
        assertEquals("28/2/2023", new Date(1, 3, 2023).dateDeLaVielle().toString());
        assertEquals("29/2/2024", new Date(1, 3, 2024).dateDeLaVielle().toString());
    }

    /**
     * Test de la méthode getWeekOfYear() de la classe Date.
     * Vérifie que le numéro de la semaine de l'année est correct.
     */
    @Test
    void testGetWeekOfYear() {
        assertEquals(1, new Date(8, 1, 2023).getWeekOfYear());
        assertEquals(52, new Date(31, 12, 2023).getWeekOfYear());
        assertEquals(1, new Date(1, 1, 2024).getWeekOfYear());
    }

    /**
     * Test de la méthode toString() de la classe Date.
     * Vérifie la représentation sous forme de chaîne de caractères d'une date.
     */
    @Test
    void testToString() {
        assertEquals("1/1/2023", new Date(1, 1, 2023).toString());
        assertEquals("31/12/2023", new Date(31, 12, 2023).toString());
    }
}

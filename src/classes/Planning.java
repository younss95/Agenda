package classes;

public class Planning {
    private Reservation[] chTabReservations; // Supprimé static
    private int TAILLE_TAB_RES;

    public Planning(int parTaille) {
        chTabReservations = new Reservation[parTaille];
        TAILLE_TAB_RES = parTaille;
    }

    public Planning() {}

    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] != null && chTabReservations[i].compareTo(parReservation) == 0) {
                throw new ExceptionPlanning(2);
            }
        }
        if (chTabReservations[TAILLE_TAB_RES - 1] != null) {
            throw new ExceptionPlanning(1);
        }
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] == null) {
                chTabReservations[i] = parReservation;
                break;
            }
        }
    }

    public Reservation getReservation(Date parDate) {
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] == null) return null;
            if (chTabReservations[i].getDate().compareTo(parDate) == 0) return chTabReservations[i];
        }
        return null;
    }

    public Reservation[] getChTabReservations(Date parDateTab) {
        Reservation[] getTabRes = new Reservation[TAILLE_TAB_RES];
        int Cpt = 0;
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] == null) break;
            if (chTabReservations[i].getDate().compareTo(parDateTab) == 0) {
                getTabRes[Cpt] = chTabReservations[i];
                Cpt++;
            }
        }
        return getTabRes;
    }

    public int plusAncienneReservation(int parDebut, int parFin) throws ExceptionPlanning {
        if (parDebut < 0 || parFin >= TAILLE_TAB_RES || chTabReservations[parDebut] == null) {
            throw new ExceptionPlanning(0); // Vérification des bornes
        }
        int indiceMin = parDebut;
        for (int i = parDebut + 1; i <= parFin; i++) { // <= pour inclure parFin
            if (chTabReservations[i] != null && chTabReservations[i].compareTo(chTabReservations[indiceMin]) < 0) {
                indiceMin = i;
            }
        }
        return indiceMin;
    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] != null) res.append(chTabReservations[i].toString()).append(" // ");
        }
        return res.toString();
    }
}

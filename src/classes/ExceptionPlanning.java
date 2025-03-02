package classes;

public class ExceptionPlanning extends Exception {
    private int chCodeErreur;

    public ExceptionPlanning(int chCodeErreur) {
        super("Erreur avec code : " + chCodeErreur);
        this.chCodeErreur = chCodeErreur;
    }

    public int getChCodeErreur() {
        return chCodeErreur;
    }
}

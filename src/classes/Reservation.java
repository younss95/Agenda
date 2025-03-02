package classes;

public class Reservation implements Comparable<Reservation>{
    private Date date;
    private PlageHoraire plage;
    private String intitule;

    public Reservation(Date date, PlageHoraire plageHoraire, String description) throws ExceptionPlanning {
        if (date == null || plageHoraire == null || description == null) {
            System.out.println("Erreur : paramètre invalide détecté !");
            throw new ExceptionPlanning(0);
        }
        this.date = date;
        this.plage = plageHoraire;
        this.intitule = description;
    }


    public Reservation(java.util.Date date, String client1) {
    }

    /**
     * compareTo retourne :
     * -un entier < 0 quand this est antérieur à parReservation
     * - un entier > 0 quand this est postérieur à parReservation
     * - 0 quand this et parReservation sont égales ou imcompatible (chevauchent ou inclusion)
     */

    public int compareTo(Reservation parReservation){
        int compareDate = this.date.compareTo((parReservation.date));
        if (compareDate < 0)
            return -1;
        if(compareDate >0 )
            return 1;
        return plage.compareTo(parReservation.plage);

    }

    public boolean estValide(){
        return this.date.isValable() && this.plage.estValide();
    }

    public Date getDate(){
        return date;
    }

    public String getIntitule(){
        return intitule;
    }

    public String toString(){
        return intitule + ", " + date.toString() + ", " + plage.toString();
    }




}

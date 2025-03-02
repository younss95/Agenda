package classes;

import java.util.Calendar;

public class DateCalendrier extends Date implements ConstanteCalendrier, Comparable<Date> {
    private int chJourSemaine; //1: Lundi

    public DateCalendrier(){
        super();
        Calendar today = Calendar.getInstance();
        chAnnee = today.get(Calendar.YEAR); // Ici 2024
        // Calendar.MONTH retourne 0 pour janvier , 1 pour février...
        chMois = today.get(Calendar.MONTH) + 1;
        chJour = today.get(Calendar.DAY_OF_MONTH);
        // Calendar.DAY_OF_MONTH retourne 1 pour dimanche, 2 pour lundi ...
        int dayOfWeek = today.get(Calendar.DAY_OF_WEEK);

        if ( dayOfWeek == 1){ // SI c'est dimanche
            chJourSemaine = 7; // On initialise chJourSemaine à 7
        }
        else chJourSemaine = dayOfWeek - 1; // Si c'est pas dimanche, on fait - 1

    }

    public DateCalendrier(int parJour,int parMois, int parAnne){
        super(parJour,parMois,parAnne);
        Calendar date = Calendar.getInstance();
        date.set(parAnne,parMois,parAnne);
        int dayOfWeek = date.get(Calendar.DAY_OF_WEEK);
        if(dayOfWeek==1){
            chJourSemaine= 7;
        }
        else chJourSemaine = dayOfWeek - 1;

    }
    public DateCalendrier dateDuLendemain(){
        Date dateLendemain = super.dateDuLendemain();
        return new DateCalendrier(dateLendemain.chJour,dateLendemain.chMois,dateLendemain.chAnnee);
    }

    public DateCalendrier dateDeLaVeille(){
        Date dateVeille = super.dateDeLaVielle();
        return new DateCalendrier(dateVeille.chJour,dateVeille.chMois, dateVeille.chAnnee);
    }


    public int compareTo(Date d1){
       return super.compareTo(d1);
    }



    public String toString(){
        return  JOURS_SEMAINE[chJourSemaine-1] + " " + super.toString() ;
    }
}

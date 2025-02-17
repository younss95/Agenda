import java.util.Calendar;
import java.util.Scanner;

public class Date {
    protected int chJour;
    protected int chMois;
    protected int chAnnee;

    public Date(){}

    public Date(int parJour, int parMois, int parAnnee){
        chJour = parJour;
        chMois = parMois;
        chAnnee = parAnnee;
    }



    public static boolean isbissextile(int parAnnee){
        if (parAnnee%4==0)
            return true;
        return false;
    }


    public static int lastJour(int parMois, int parAnnee){
        switch(parMois){
            case 2: if (Date.isbissextile(parAnnee))
                return 28;
            return 29;

            case 4: case 6: case 9: case 11: return 30;
            default:return 31;


        }
    }


    public boolean isValable(){
        if(chAnnee >= 1583){
            if(chMois>0 && chMois<13){
                if (chJour > 0 && chJour <= lastJour(chMois, chAnnee)) {
                    return true;
                }
            }

        }
        return false;
    }


    public static Date lireDate(){
        System.out.println ("Entrez la date (jour/mois/année)");
        Scanner scanner = new Scanner (System.in);

        int jour = scanner.nextInt();
        int mois = scanner.nextInt();
        int annee = scanner.nextInt();

        return new Date(jour, mois, annee);
    }


    /**
     CompareTO compare l'objet appelant (this) avec parDate, elle retourne :
     - 0 quand this = parDate
     - Un négatif quand this est antérieur à parDate
     - Un positif quand this est postérieur à parDate
     */

    public int compareTo (Date parDate){
        if (this.chAnnee < parDate.chAnnee)
              return -5;
        if (this.chAnnee > parDate.chAnnee)
            return 8;

        if (this.chMois < parDate.chMois)
            return -5;
        if (this.chMois > parDate.chMois)
            return 8;

        if (this.chJour < parDate.chJour)
            return -5;
        if (this.chJour > parDate.chJour)
            return 8;

        return 0;
    }

    /**
     * dateDuLendemain retourne la date du lendemain de this
     * @return
     */
    public Date dateDuLendemain(){
        if (chJour < Date.lastJour(chMois,chAnnee))
            return new Date(chJour + 1, chMois, chAnnee);

        if (chMois < 12)
            return new Date(1, chMois + 1, chAnnee);

        return new Date(1,1,chAnnee+1);

    }

    /**
     * si c'est chJour est supérieur à 1 alors on retourne la date avec jour -1
     * Si le mois est supérieur à 1 alors on enleve 1 au mois
     * @return
     */
    public Date dateDeLaVielle(){
        if (chJour > 1)
            return new Date(chJour - 1, chMois, chAnnee);

        if (chMois > 1)
            return new Date(lastJour(chMois-1,chAnnee), chMois - 1, chAnnee);

        return new Date(31,12,chAnnee - 1);
    }

    public int getWeekOfYear(){
        Calendar date = Calendar.getInstance();
        date.set(chAnnee, chMois-1,chJour);
        return date.get(Calendar.WEEK_OF_YEAR);
    }
    public String toString(){
        return chJour + "/" + chMois + "/" + chAnnee;
    }

}




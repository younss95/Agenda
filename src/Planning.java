public class Planning {
    private  static Reservation [] chTabReservations;
    private int TAILLE_TAB_RES ;
    public Planning(int parTaille) {
        chTabReservations = new Reservation[parTaille];
        TAILLE_TAB_RES = parTaille;
    }

    public Planning(){}
        /**
         * La méthode ajout ajoute parReservations à this à condition que:
         * -ce soit valide
         * -que le tableau ne soit pas remplis (null)
         * - que ce soit compatible avec les éléments du tableau
         */
    public void ajout(Reservation parReservation) throws ExceptionPlanning {
        //if (!parReservation.estValide())
            //throw new ExceptionPlanning(0);
        if ( chTabReservations[TAILLE_TAB_RES-1] != null)
            throw new ExceptionPlanning(1);
        for (int i = 0; i < TAILLE_TAB_RES; i++) {
            if (chTabReservations[i] == null) {
                chTabReservations[i] = parReservation;
                break;
            }
            if (chTabReservations[i].compareTo(parReservation)==0)
                throw new ExceptionPlanning(2);

        }
    }




    /**
     * La méthode getReservation retourne :
     * - la première réservation du tableau ayant pour date le paramètre par date
     * - null si le tableau est vide
     * @param parDate
     * @return
     */
    public Reservation getReservation(Date parDate){
        for(int i = 0; i < TAILLE_TAB_RES; i++){
            if (chTabReservations[i] ==null)
                return null;
            if( chTabReservations[i].getDate().compareTo(parDate)==0)
                return chTabReservations[i];
            //if (chTabReservations[i] != null && chTabReservations[i].getDate().compareTo(parDate)==0)
               // return chTabReservations[i];
        }
       return null;
    }

    public Reservation [] getChTabReservations(Date parDateTab){
        Reservation [] getTabRes = new Reservation[TAILLE_TAB_RES];
        int Cpt = 0;
        for(int i = 0; i < TAILLE_TAB_RES ; i++){
            if(chTabReservations[i] ==null)
                break;
            if(chTabReservations[i].getDate().compareTo(parDateTab) == 0)
                getTabRes[Cpt ] = chTabReservations[i];
            Cpt ++;
        }
        return getTabRes;
    }

    public int plusAncienneReservation (int parDebut,int parFin){
        int indiceMin = parDebut;
        for (int i = parDebut+1; i < parFin ; i++){
            if (chTabReservations[i].compareTo(chTabReservations[indiceMin])== -1)
                indiceMin = i;
        }
        return indiceMin;
    }

    public String toString(){
        String res = "";
        for(int i = 0; i < TAILLE_TAB_RES; i++){
            if(chTabReservations[i] != null)
                res = res +  chTabReservations[i].toString() + " // ";
        }
        return res;
    }



}

package classes;

public class PlageHoraire implements Comparable<PlageHoraire>, ConstantesErreur {
    private final static int  DUREE_Minimum=75;
    private Horaire chHoraireDebut;
    private Horaire chHoraireFin;

    public PlageHoraire(Horaire horaireDebut, Horaire horaireFin) throws ExceptionPlanning {
        if (horaireDebut == null || horaireFin == null) {
            throw new ExceptionPlanning(0); // Gestion d'une exception si les horaires sont invalides
        }
        if (horaireDebut.compareTo(horaireFin) >= 0) {
            throw new ExceptionPlanning(1); // Si l'horaire de début est plus tard que l'horaire de fin
        }
        this.chHoraireDebut = horaireDebut;
        this.chHoraireFin = horaireFin;
    }



    /**
     * return true si this est une plage d'horaire valide
     * Les horaires sont supposés etre valides
     * @return
     */
    public boolean estValide() {
        if (chHoraireDebut == null || chHoraireFin == null) {
            throw new IllegalArgumentException("Les horaires ne peuvent pas être null");
        }
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes() >= DUREE_Minimum;

    }




    /**
     * retourne la duré de la plage classes.Horaire
     * @return
     */
    public int duree(){
        return chHoraireFin.toMinutes() - chHoraireDebut.toMinutes();
    }


     public static void main(String[] args) {
        try {
            PlageHoraire pH1 = new PlageHoraire(new Horaire(16, 30), new Horaire(18, 30));
            System.out.println(pH1);

            /**
             * Créer 2 Plage classes.Horaire (test1,test2) puis utilise la méthode compareTo entre le this (test1) et le paramètre (test2)
             */
            PlageHoraire test = new PlageHoraire(new Horaire(20, 21), new Horaire(21, 22));
            PlageHoraire test2 = new PlageHoraire(new Horaire(12, 20), new Horaire(12, 20));
            System.out.println(test.compareTo(test2));
        }
        catch(ExceptionPlanning e){
            System.out.println(ERREURS_PLANNING[e.getChCodeErreur()]);
        }



     }

    /**
     * compareTo retourne:
     *       -un négatif quand this précède le paramètre (autrePlageHoraire)
     *       -un positif lorsque lorsque le paramètre précède this
     *       - 0 dans les autres cas (égalité,chevauchement,inclusion)
     * @param autrePlageHoraire :
     * @return int le résultat de la comparaison

     */
     public int compareTo(PlageHoraire autrePlageHoraire){
        if (this.chHoraireFin.toMinutes()  < autrePlageHoraire.chHoraireDebut.toMinutes())
            return -1;
        if (autrePlageHoraire.chHoraireFin.toMinutes()  < this.chHoraireDebut.toMinutes())
            return +1;
        return 0;

     }



    public String toString() {
        int d = this.duree();
        Horaire hDuree = new Horaire(d / 60, d % 60);
        return chHoraireDebut.toString() + " - " + chHoraireFin.toString() + " durée " + hDuree.toString().replace("h", ":");
    }




}

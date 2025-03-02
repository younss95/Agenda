package classes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

public class PlanningCollections {
    private ArrayList<Reservation> chListReservation;
    private TreeSet<Reservation> chSetReservation;

    private TreeMap<Integer, TreeSet<Reservation>> chMapReservation;

    public PlanningCollections(){
        chListReservation = new ArrayList<>();
        chSetReservation = new TreeSet<>();
        chMapReservation = new TreeMap<>();
    }

    /*
    La méthode ajout reçoit en paramètre une reservation (parReservation) deja valide.
    Elle est ajouté au chListReservation de this, si elle est compatible avec les réservations déja présentes dans chSetReservation.
    Elle est donc ajouté également à ce champ.
    @param Prend en paramètre parReservation, la réservation ajouté aux deux champs
     */
    public void ajout(Reservation parReservation){
        chListReservation.add(parReservation);
        chSetReservation.add(parReservation);
        int semaine = parReservation.getDate().getWeekOfYear();
        if(chMapReservation.containsKey(semaine))
            chMapReservation.get(semaine).add(parReservation);
        else{
            TreeSet<Reservation> sousSet = new TreeSet<>();
            sousSet.add(parReservation);
            chMapReservation.put(semaine, sousSet);
        }
    }


    /*
    La méthode getChSetReservation reçoit en paramètre un intitule(parString).
    Elle parcourt le treeSet (chSetReservation) qui contient des réservations.
    Elle renvoie les réservations du TreeSet qui contient l'intitule donné en paramètre.
    @param Prend en paramètre un string (parString).
    */

    public TreeSet<Reservation> getReservations(DateCalendrier parDate){
        TreeSet<Reservation> resParDate = new TreeSet<>();
        for (Reservation r : chSetReservation ){
            if (r.getDate() == parDate)
                resParDate.add(r);
        }
        return resParDate;

    }
    public TreeSet<Reservation> getChSetReservation (String parString){
        TreeSet <Reservation> res = new TreeSet<>();
        Iterator <Reservation> iterateur = chSetReservation.iterator();
        while (iterateur.hasNext()){
            Reservation resa = iterateur.next();
            if (resa.getIntitule().contains(parString))
                res.add(resa);
        }
        return res;
    }





    public String toString(){
        return "la liste : " + chListReservation.size() + " " + chListReservation + "\n"+
        "\nle treeset : " + chSetReservation.size() + " " + chSetReservation+ "\n" +
                "\nle treemap : " + chMapReservation.size() + " " + chMapReservation;

    }



}

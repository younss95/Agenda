import classes.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ClientPlanning implements ConstantesErreur {
    public static void main(String[] args) {
        Planning pl = new Planning(2);
        try {

            Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt")).useDelimiter(",");


            while(scanner.hasNext()){
                String intitule = scanner.next();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();

                int heureDebut = scanner.nextInt();
                int quartHeureDebut = scanner.nextInt();

                int heureFin = scanner.nextInt();
                int quartHeureFin = scanner.nextInt();

                Reservation res = new Reservation(new Date(jour, mois, annee), new PlageHoraire(new Horaire(heureDebut, quartHeureDebut), new Horaire(heureFin, quartHeureFin)), intitule);
                pl.ajout(res);

            }

            //classes.Reservation res1 = new classes.Reservation(new classes.Date(10, 10, 2000), new classes.PlageHoraire(new classes.Horaire(20, 21), new classes.Horaire(22, 24)), "Test1");
            //classes.Reservation res2 = new classes.Reservation(new classes.Date(10, 10, 2000), new classes.PlageHoraire(new classes.Horaire(18, 20), new classes.Horaire(21, 22)), "Test2");
            //classes.Reservation res3 = new classes.Reservation(new classes.Date(11, 10, 2000), new classes.PlageHoraire(new classes.Horaire(20, 21), new classes.Horaire(22, 24)), "Test1");

            //System.out.println(res1.compareTo(res2));

            //classes.Planning planningTest1 = new classes.Planning(4);
            //classes.Planning planningTest2 = new classes.Planning(6);

            /*planningTest2.ajout(res1);
            planningTest1.ajout(res2);
            planningTest1.ajout(res3);
            System.out.println(planningTest1);

             */


        }

        catch (FileNotFoundException scan){
            System.out.println(scan.getMessage());
        }

        catch (InputMismatchException Mis){
            System.out.println("MismatchExecption");
        }

        catch (NoSuchElementException Ele){

        }

        catch (ExceptionPlanning parExc){
            System.out.println(parExc.getChCodeErreur());
            System.out.println(ERREURS_PLANNING[parExc.getChCodeErreur()]);

            /*
            if (parExc.getChCodeErreur()==0)
                System.out.println("classes.Reservation non valide");
            if (parExc.getChCodeErreur()==1)
                System.out.println("classes.Planning plein");
            if (parExc.getChCodeErreur()==2)
                System.out.println("classes.Reservation incompatible");

             */


        }
        System.out.println(pl);
    }
}

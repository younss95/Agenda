import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ClientPlanningCollection {
    public static void main(String[] args) {
        PlanningCollections planningSport = new PlanningCollections(); // car pas de paramètre dans le constructeur
        try {

            Scanner scanner = new Scanner(new File("data" + File.separator + "planning.txt")).useDelimiter(",");


            while (scanner.hasNext()) {
                String intitule = scanner.next();
                int jour = scanner.nextInt();
                int mois = scanner.nextInt();
                int annee = scanner.nextInt();

                int heureDebut = scanner.nextInt();
                int quartHeureDebut = scanner.nextInt();

                int heureFin = scanner.nextInt();
                int quartHeureFin = scanner.nextInt();
                Reservation res = new Reservation(new Date(jour, mois, annee), new PlageHoraire(new Horaire(heureDebut, quartHeureDebut), new Horaire(heureFin, quartHeureFin)), intitule);
                planningSport.ajout(res);
                System.out.println(intitule);

            }

            System.out.println(planningSport);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());

        } catch (ExceptionPlanning e) {
            System.out.println(e.getChCodeErreur());
        }


    }

}

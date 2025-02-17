public class ClientDate {
    public static void main (String[]args){
        Date date = new Date(1,1,2000);

        System.out.println(date.dateDeLaVielle());

        System.out.println(date + " est "+date.isValable());
        System.out.println("le dernier jour est "+Date.lastJour(2, 2005));
        System.out.println("l'annee est " + Date.isbissextile(2005));

        Date date2 = new Date(1,1,2000);
        System.out.println(date2.compareTo(date));
        System.out.println("la date du lendemain est :"+ date.dateDuLendemain());
        System.out.println("la date du la veille est :"+ date2.dateDeLaVielle());

    }

}
import classes.DateCalendrier;

import java.util.Arrays;

public class ClientDateCalendrier {
    public static void main(String[] args) {
        DateCalendrier d1 = new DateCalendrier();
        System.out.println(d1);

        DateCalendrier d2 = new DateCalendrier(31,12,2000);
        System.out.println(d2.dateDuLendemain());

        DateCalendrier [] tab = new DateCalendrier[3];
        tab[0] = new DateCalendrier(10,11,2004);;
        tab[1] = new DateCalendrier();
        tab[2] =  new DateCalendrier(8,11,2004);


        System.out.println("Pas trier");

        for (DateCalendrier d : tab){
            System.out.println(d);
        }

        Arrays.sort(tab);

        System.out.println("trier");

        for (int i = 0; i < tab.length; i++){
            System.out.println(tab[i]);
        }
    }
}

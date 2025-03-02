package classes;

public class Horaire {
    private int chHeure;
    private int chQuartHeure;
    public Horaire (int parHeure, int parQuartHeure){
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
    }

    public Horaire(String horaire) {
        String[] parts = horaire.split(":");
        this.chHeure = Integer.parseInt(parts[0]);
        this.chQuartHeure = Integer.parseInt(parts[1]);
    }

    public int toMinutes(){
        return chHeure*60 + chQuartHeure;
    }

    public int getHeure(){
        return chHeure;
    }

    public int getChQuartHeure(){
        return chQuartHeure;
    }

    public void setHeure(int parHeure){
        chHeure =  parHeure;
    }

    public void setChQuartHeure(int parQuartHeure){
        chQuartHeure = parQuartHeure;
    }

    @Override
    public String toString() {
        return chHeure + ":" + String.format("%02d", chQuartHeure);
    }


    public int compareTo(Horaire other) {
        if (this.chHeure < other.chHeure) {
            return -1; // this est plus tôt
        } else if (this.chHeure > other.chHeure) {
            return 1; // other est plus tôt
        } else {
            // Si les heures sont égales, compare les minutes
            if (this.chQuartHeure < other.chQuartHeure) {
                return -1; // this est plus tôt
            } else if (this.chQuartHeure > other.chQuartHeure) {
                return 1; // other est plus tôt
            } else {
                return 0; // même heure et même minute
            }
        }
    }
}

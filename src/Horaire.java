public class Horaire {
    private int chHeure;
    private int chQuartHeure;
    public Horaire (int parHeure, int parQuartHeure){
        chHeure = parHeure;
        chQuartHeure = parQuartHeure;
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

    public String toString(){
        return chHeure +"h" + chQuartHeure;
    }






}

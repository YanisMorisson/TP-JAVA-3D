public class Main {
    public static void main (String[] args){
        Aeroport CharlesDeGaulle = new Aeroport("CDG","Charles de Gaulle", "France", 49.01,20.01);
        World w = new World("/Users/sinay/ENSEA/3D/TP/JAVA/airport-codes_no_comma.csv");

        System.out.println (CharlesDeGaulle);
    }


}

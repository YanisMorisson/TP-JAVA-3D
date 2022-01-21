public class Main {
    /* public static void main (String[] args){
         Aeroport CharlesDeGaulle = new Aeroport("CDG","Charles de Gaulle", "France", 49.01,20.01);
         World w = new World("/Users/sinay/ENSEA/3D/TP/JAVA/airport-codes_no_comma.csv");

         System.out.println (CharlesDeGaulle);
     }
 }
     */

//*********************

    public static void main(String[] args) {
        World w = new World("/Users/sinay/ENSEA/3D/TP/JAVA/airport-codes_no_comma.csv");
        System.out.println("Found " + w.getAeroportlist().size() + " airports.");
        Aeroport paris = w.findNearestAirport(2.316, 48.866);
        Aeroport cdg = w.findByCode("CDG");
        double distance = w.distance(2.316, 48.866, paris.getLongitude(), paris.getLatitude());
        System.out.println(paris);
        System.out.println(distance);
        double distanceCDG = w.distance(2.316, 48.866, cdg.getLongitude(), cdg.getLatitude());
        System.out.println(cdg);
        System.out.println(distanceCDG);
    }
}
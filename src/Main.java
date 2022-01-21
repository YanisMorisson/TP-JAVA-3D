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
        World w = new World("/Users/sinay/ENSEA/3D/TP/JAVA/airport-codes_no_comma.csv"); // Récupérer la liste
        System.out.println("Found " + w.getAeroportlist().size() + " airports."); // Afficher le nb de grand aeroports
        Aeroport paris = w.findNearestAirport(2.316, 48.866); // Trouver l'aeroport le plus proche de paris
        Aeroport cdg = w.findByCode("CDG"); // Trouver CDG dans la liste
        double distance = w.distance(2.316, 48.866, paris.getLongitude(), paris.getLatitude()); // calculer la distance entre paris et l'aeroport le plus proche
        System.out.println(paris); //  Afficher l'aeroprt le plus proche
        System.out.println(distance); // Afficher la distance
        double distanceCDG = w.distance(2.316, 48.866, cdg.getLongitude(), cdg.getLatitude()); // Calculer la distance entre CDG et paris
        System.out.println(cdg); // Afficher CDG
        System.out.println(distanceCDG); // Afficher la distance paris cdg
    }
}
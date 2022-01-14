import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import static java.lang.Math.*;

public class World {
    ArrayList<Aeroport> Aeroportlist;
    public ArrayList<Aeroport> getAeroportlist() {
        return Aeroportlist;
    }
    public World(String fileName) {

        Aeroportlist = new ArrayList<Aeroport>();

            try {
                BufferedReader buf = new BufferedReader(new FileReader(fileName));
                String s = buf.readLine();
                while (s != null) {
                    s = s.replaceAll("\"", "");

//Enlève les guillemets qui séparent les champs de données GPS.
                    String fields[] = s.split(",");

// Une bonne idee : placer un point d'arret ici pour du débuggage.
                    if (fields[1].equals("large_airport")) {
                        // A continuer
                        Aeroport ap;
                        Aeroportlist.add( ap=new Aeroport(fields[9],fields[2],fields[5],Double.parseDouble(fields[12]),Double.parseDouble(fields[11])));
                    }
                    s = buf.readLine();
                }

            } catch (Exception e) {
                System.out.println("Maybe the file isn't there ?");
                System.out.println(Aeroportlist.get(Aeroportlist.size() - 1));
                e.printStackTrace();

            }

        }

    public Aeroport findByCode(String code){
        for(Aeroport aero : Aeroportlist){
            if(aero.getIATA().equals(code)){
                return aero;
            }
        }
        System.out.println("Le code IATA ne correspond à aucun aeroport !!! ");
        return null;
    }

    public Aeroport findNearestAirport(double lon, double lat){ // on utilise la lon et lat de notre position
        double dist = distance(lon,lat,Aeroportlist.get(0).getLongitude(),Aeroportlist.get(0).getLatitude()); // on fait un calcul de dist entre notre pos et le premier aeroport de la list
        Aeroport nearestAirport = null; // mem tampon
        double index = 0;

        for(Aeroport a : Aeroportlist){  // Parcourir la liste pour comparer les distances pour chaque aeroport un par un et garder le plus proche
            double lon1 = a.getLongitude();
            double lat1 = a.getLatitude();
            double d = distance(lon,lat,lon1, lat1);
            if(d < dist){ // Si la distance aeroport b est plus petite que aeroport a
                nearestAirport = a;      // le nouveau aeroport devient le plus proche
                dist = d;  // la distance est actualisée
            }
        }
        return nearestAirport; // on retourne l'aeroport le plus proche
    }

    public double distance(double lo1, double la1, double lo2, double la2){
        double norme = pow(la2 - la1, 2) + pow((lo2 - lo1) * cos(toRadians((la2 + la1) / 2)), 2); // equation page 2

        return norme;
    }

}


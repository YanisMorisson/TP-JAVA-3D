import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

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
    }


public class World {
    public World(String fileName){
        try{
            BufferedReader buf = new BufferedReader(new FileReader(fileName));
            String s = buf.readLine();
            while(s!=null){
                s=s.replaceAll("\"","");
//Enlève les guillemets qui s´éparent les champs de données GPS.
                String fields[]=s.split(",");
// Une bonne id´ee : placer un point d'arret ici pour du débuggage.
                if (fields[1].equals("large_airport")){
// A continuer
                }
                s = buf.readLine();
            }
        }
        catch (Exception e){
            System.out.println("Maybe the file isn't there ?");
            System.out.println(list.get(list.size()-1));
            e.printStackTrace();

    }

}

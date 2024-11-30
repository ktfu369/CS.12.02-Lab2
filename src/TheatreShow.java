import java.util.ArrayList;

public class TheatreShow extends Activity{
    private ArrayList<Cast> showStars = new ArrayList<>();

    public TheatreShow(String name, String description, int cost, int capacity, String destination){
        setName(name);
        setDescription(description);
        setCost(cost);
        setCapacity(capacity);
        setDestination(destination);
        setCurrentSize(0);
    }

    public void addCast(Cast cast){
        showStars.add(cast);
    }

    public ArrayList<Cast> getShowStars(){
        return showStars;
    }

    // print the cast in the theatre show
    public void printStars(){
        for(Cast star:showStars){
            System.out.println("\t\t" + star.getCharacterName() + " played by " + star.getActorName());
        }
    }


}

public class Attraction extends Activity{

    public Attraction(String name, String description, int cost, int capacity, String destination){
        setName(name);
        setDescription(description);
        setCost(cost);
        setCapacity(capacity);
        setDestination(destination);
        setCurrentSize(0);
    }

}

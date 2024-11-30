public class WalkingTour extends Activity{

    private int distance;

    public WalkingTour(String name, String description, int cost, int capacity, String destination, int distance){
        setName(name);
        setDescription(description);
        setCost(cost);
        setCapacity(capacity);
        setDestination(destination);
        setCurrentSize(0);
        this.distance = distance;
    }

    public int getDistance(){
        return distance;
    }
}

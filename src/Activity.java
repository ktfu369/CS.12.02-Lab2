public class Activity {
    private String name;
    private String description;
    private int cost;
    private int capacity;
    private int currentSize;
    private String destination;

    public void updateSize(){
        currentSize++;
    }

    public String getName(){
        return name;
    }

    public int getCost(){
        return cost;
    }

    public int getCapacity(){
        return capacity;
    }

    public String getDestination() {
        return destination;
    }

    public String getDescription() {
        return description;
    }

    public int getCurrentSize() {
        return currentSize;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentSize(int size){
        currentSize = size;
    }
}

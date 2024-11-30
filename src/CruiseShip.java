import java.util.ArrayList;

public class CruiseShip {
    private String name;
    private int passengerCapacity;
    private ArrayList<Destination> itinerary;
    private ArrayList<Passenger> passengers;

    public CruiseShip(String name, int passengerCapacity){
        this.name = name;
        this.passengerCapacity = passengerCapacity;
        itinerary = new ArrayList<>();
        passengers = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    public int getPassengerCapacity(){
        return passengerCapacity;
    }

    public ArrayList<Destination> getItinerary(){
        return itinerary;
    }

    public ArrayList<Passenger> getPassengers(){
        return passengers;
    }

    // add passenger to the cruise ship
    public void addPassengers(Passenger passenger){
        if(passengers.contains(passenger) || passengerCapacity == passengers.size()){
            return;
        }
        passengers.add(passenger);
    }

    // remove passenger from the cruise ship
    public void removePassengers(Passenger passenger){
        if(passengers.contains(passenger)) passengers.remove(passenger);
    }

    // add a destination to the cruise ship
    public void addDestination(Destination dest){
        itinerary.add(dest);
    }

    // print all the destinations in the cruise ship and corresponding activies
    public void printItinerary(){
        System.out.println("Welcome aboard the " + name);
        System.out.print("\n");
        System.out.println("On this trip, we will be visting:");
        for(Destination spot:itinerary){
            System.out.println(spot.getName());
            spot.printActivities(); // invoke method in Activity class for simplicty and to reuse code
            System.out.println();
        }
    }

    // print the detail of all passengers on board
    public void printPassengers(){
        System.out.println("Welcome aboard the " + name);
        System.out.print("\n");
        System.out.println("Passenger Capacity: " + passengerCapacity);
        System.out.print("\n");
        System.out.println("Passengers onboard: " + passengers.size());
        for(Passenger passenger:passengers){
            System.out.println("\t#" + passenger.getPassengerNumber() + " " + passenger.getName());
        }
    }

    // print passenger detail given the passenger number
    public void printPassengerDetail(int num){
        Passenger passenger = passengers.get(num-1); // access object of desired passenger
        System.out.println("#" + passenger.getPassengerNumber() + " " + passenger.getName());
        System.out.println();

        // print balance if necessary
        if(passenger instanceof SeniorPassenger || passenger instanceof StandardPassenger){
            System.out.println("Balance: " + passenger.getBalance());
        }
        System.out.println();

        // print activity list of the passenger
        System.out.println("Activities: ");
        passenger.printActivities();
    }

    // print available activities on the ruise ship
    public void printAvailableActivities(){
        System.out.println("Available activities:");
        for(Destination dest:itinerary){
            // iterate through all activities in all destinations
            for(Activity activity:dest.getActivities()){
                // if the activity is still available
                if(activity.getCapacity()-activity.getCurrentSize() > 0){
                    System.out.println(activity.getName() + " in " + activity.getDestination());
                    System.out.println("\tAvailable spaces: " + (activity.getCapacity() - activity.getCurrentSize()));
                    System.out.println();
                }
            }
        }
    }
}

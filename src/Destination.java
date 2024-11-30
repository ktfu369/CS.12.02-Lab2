import java.util.ArrayList;

public class Destination {
    private String name; // name of destination
    private ArrayList<Activity> activities; // list of activities in the destination

    public Destination(String name){
        this.name = name;
        activities = new ArrayList<>();
    }

    public String getName(){
        return name;
    }

    // add activities to the destination
    public void addActivity(Activity activity){
        if(activities.contains(activity)) return;
        activities.add(activity);
    }

    public ArrayList<Activity> getActivities(){
        return activities;
    }

    // remove an activity from the destination
    public void removeActivity(Activity activity){
        if(activities.contains(activity)){
            activities.remove(activity);
        }
    }

    // print details of each activity in the destination
    public void printActivities(){
        for(Activity activity:activities){
            System.out.println("\t" + activity.getName());
            System.out.println("\t" + activity.getDescription());
            System.out.println("\tCost: $" + activity.getCost());
            System.out.println("\tCapacity: " + activity.getCapacity() + " people");
            if(activity instanceof WalkingTour){ // print walking distance if necessary
                System.out.println("\tWalking Distance: " + ((WalkingTour) activity).getDistance() + " m");
            }
            if(activity instanceof TheatreShow){ // print show cast if necessary
                System.out.println("\tCast:");
                ((TheatreShow) activity).printStars();
            }
            System.out.println();
        }
    }
}

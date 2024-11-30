public class Main {
    private static CruiseShip ship;
    private static Destination dest1, dest2, dest3, dest4;
    private static Attraction activity1, activity3, activity5, activity7;
    private static WalkingTour activity2, activity6;
    private static TheatreShow activity4;
    private static PremiumPassenger passenger1, passenger4, passenger7;
    private static SeniorPassenger passenger2, passenger5;
    private static StandardPassenger passenger3, passenger6;

    public static void main(String[] args) {
        // create cruise ship object
         ship = new CruiseShip("CIS 2024",30 );

        // create destination objects
        dest1 = new Destination("Hong Kong");
        dest2 = new Destination("Macao");
        dest3 = new Destination("Guangzhou");
        dest4 = new Destination("Shanghai");

        // create activity objects for Hong Kong destination
        activity1 = new Attraction("Ocean Park", "Ocean Park is an animal theme park in Hong Kong.",10,200,"Hong Kong");
        activity2 = new WalkingTour("Hike","Hike around Victoria Park",2,3,"Hong Kong",3000);
        dest1.addActivity(activity1);
        dest1.addActivity(activity2);

        // create activity objects for Macau destination
        activity3 = new Attraction("Casino","Venetian Macau Resort Hotel Casino",20,50,"Macau");
        activity4 = new TheatreShow("Wicked","Wicked is a musical with music and lyrics by Stephen Schwartz",10,5,"Macau");
        Cast cast1 = new Cast("Ariana Grande","Glinda");
        Cast cast2 = new Cast("Cynthia Erivo","Elphaba");
        Cast cast3 = new Cast("Jonathan Bailey","Bob");
        Cast cast4 = new Cast("Ethan Slater","Boq Woodsman");
        activity4.addCast(cast1);
        activity4.addCast(cast2);
        activity4.addCast(cast3);
        activity4.addCast(cast4);
        dest2.addActivity(activity3);
        dest2.addActivity(activity4);

        // create activity objects for Guangzhou destination
        activity5 = new Attraction("Chimelong Paradise","Chimelong Paradise is a major amusement park in Panyu District, Guangzhou, Guangdong, China.",15,4,"Guangzhou");
        dest3.addActivity(activity5);

        // create activity objects for Shanghai destination
        activity6 = new WalkingTour("The Bund","Walk around the Bund, a waterfront area and a protected historical district in central Shanghai.",10,10,"Shanghai",5000);
        activity7 = new Attraction("Shanghai Natural History Museum.","The Shanghai Natural History Museum is a museum dedicated to natural history in the city of Shanghai.",3,2,"Shanghai");
        dest4.addActivity(activity6);
        dest4.addActivity(activity7);

        // create passengers
        passenger1 = new PremiumPassenger("Mr. Ewing");
        passenger2 = new SeniorPassenger("Mr. Li",100);
        passenger3 = new StandardPassenger("Katie",40);
        passenger4 = new PremiumPassenger("Emily");
        passenger5 = new SeniorPassenger("Howard",100);
        passenger6 = new StandardPassenger("Alex",100);
        passenger7 = new PremiumPassenger("Sander");

        // add passengers and itinerary to ship
        ship.addDestination(dest1);
        ship.addDestination(dest2);
        ship.addDestination(dest3);
        ship.addDestination(dest4);
        ship.addPassengers(passenger1);
        ship.addPassengers(passenger2);
        ship.addPassengers(passenger3);
        ship.addPassengers(passenger4);
        ship.addPassengers(passenger5);
        ship.addPassengers(passenger6);
        ship.addPassengers(passenger7);


        scenerio1();

        scenerio2();

        scenerio3();

        scenerio4();

        scenerio5();

        scenerio6();

        scenerio7();
    }

    public static void scenerio1(){
        // SCENERIO 1:
        // user tries to sign up after capacity has been reached
        passenger1.signUpActivity(activity2);
        passenger2.signUpActivity(activity2);
        passenger4.signUpActivity(activity2);
        passenger6.signUpActivity(activity2);
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 1: User cannot sign up after capacity has been reached");
        System.out.println("Capacity of activity2: " + activity2.getCapacity());
        System.out.println("Current size of activity2: " + activity2.getCurrentSize());
        // RESULT: capacity should be equal to current size
        System.out.println("\nPassenger #6 num of activities signed up: " + passenger6.getActivityList().size());
        // RESULT: number of activities should be 0, since capacity for activity 2 has been reached
    }

    public static void scenerio2(){
        // SCENERIO 2:
        // deduct balance from senior and check discount rate is applied
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 2: Senior passenger should have a 10% discount");
        System.out.println("Balance before: " + passenger5.getBalance());
        // RESULT: balance should be 100 dollars (from instance variables)
        passenger5.signUpActivity(activity1);
        System.out.println("Cost of activity: " + activity1.getCost());
        System.out.println("Balance after: " + passenger5.getBalance());
        // RESULT: balance should be $91 (cost = 10 * 0.9 = 9, balance = 100 - cost = 100 - 9 = 91)

    }

    public static void scenerio3(){
        // SCENERIO 3:
        // Passengers cannot sign up for an activity if they do not have a high enough balance to cover the discounted cost
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 3: Passengers cannot sign up for activities if their balance is too low");

        // Signing passenger up for different activities
        System.out.println("Balance: " + passenger3.getBalance()); // show balance before
        System.out.println("Passenger3 signed up for Ocean Park attraction");
        System.out.println("\tActivity cost: " + activity1.getCost());
        passenger3.signUpActivity(activity1);
        System.out.println("\tBalance: " + passenger3.getBalance());
        System.out.println("Passenger3 signed up for casino");
        System.out.println("\tActivity cost: " + activity3.getCost());
        passenger3.signUpActivity(activity3);
        System.out.println("\tBalance: " + passenger3.getBalance());
        System.out.println("Passenger3 attempted to sign up for Chimelong Paradise");
        System.out.println("\tActivity cost: " + activity5.getCost());
        passenger3.signUpActivity(activity5); // user should have a too low balance
        System.out.println("\tBalance: " + passenger3.getBalance()); // balance should remain the same

        System.out.println("\nPASSENGER DETAILS:");
        ship.printPassengerDetail(3);
        // RESULT:
        // Cost of each activity should be deducted from balance when signing up
        // Passenger should not be signed up to Activity5
        // Passenger's balance should not change after failing to sign up
    }

    public static void scenerio4(){
        // SCENERIO 4:
        // Passenger cannot sign up for an activity if they already signed up in a destination
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 4: Passenger cannot sign up for multiple activites in the same destination");

        // Sign user up to 2 activities in the same destination
        passenger1.signUpActivity(activity6);
        System.out.println("Passenger1 signed up to activity6");
        passenger1.signUpActivity(activity7);
        System.out.println("Passenger1 attempted to sign up to activity7");

        System.out.println("\nPASSENGER DETAILS:");
        ship.printPassengerDetail(1);
        // RESULT: User should have signed up for activity 6 (The Bund) and not activity 7 (Shanghai Natural History Museum)
    }

    public static void scenerio5(){
        // SCENERIO 5:
        // Print the itinerary of a cruise ship
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 5: Print the itinterary of a cruise ship");
        ship.printItinerary();
    }

    public static void scenerio6(){
        // SCENERIO 6:
        // Print the passenger list of a cruise
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 6: Print the passenger list of a cruise ship");
        ship.printPassengers();
    }

    public static void scenerio7(){
        // SCENERIO 7:
        // Print the details of all available activities
        System.out.println("\n");
        System.out.println("----------------------------------------------------------------------------------------");
        System.out.println("SCENERIO 7: Print the details of all available activities");


        // sign passengers up for activities to make some unavailable
        passenger1.signUpActivity(activity4);
        passenger2.signUpActivity(activity3);
        passenger3.signUpActivity(activity4);
        passenger4.signUpActivity(activity4);
        passenger5.signUpActivity(activity4);
        passenger6.signUpActivity(activity4);
        passenger7.signUpActivity(activity4);

        passenger1.signUpActivity(activity5);
        passenger2.signUpActivity(activity5);
        passenger3.signUpActivity(activity5);
        passenger4.signUpActivity(activity5);
        passenger5.signUpActivity(activity5);

        passenger1.signUpActivity(activity6);
        passenger3.signUpActivity(activity6);
        passenger2.signUpActivity(activity7);
        passenger4.signUpActivity(activity7);
        passenger5.signUpActivity(activity6);
        passenger6.signUpActivity(activity6);
        passenger7.signUpActivity(activity6);

        ship.printAvailableActivities();
        // RESULT:
        // Activity 1 is available
        // Activity 2 is FULL
        // Activity 3 is available
        // Activity 4 is FULL
        // Activity 5 is FULL
        // Activity 6 is available
        // Activity 7 is FULL
    }
}

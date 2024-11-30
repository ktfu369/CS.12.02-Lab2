public class StandardPassenger extends Passenger{

    public StandardPassenger(String name, double balance){
        setName(name);
        setBalance(balance);
        setPassengerNumber();
        setDiscount(1);
    }

}

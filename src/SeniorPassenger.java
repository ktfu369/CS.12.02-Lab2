public class SeniorPassenger extends Passenger{
    public SeniorPassenger(String name, double balance){
        setName(name);
        setBalance(balance);
        setPassengerNumber();
        setDiscount(0.9);
    }
}

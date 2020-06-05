package interfaces;
public interface IDepartureTerminalEntrancePassenger {
   
    boolean prepareNextLeg(int npassengers , int passengerID);
    void syncPassenger();
    int nPassengersDepartureTEntrance();
    void awakePassengers();
}
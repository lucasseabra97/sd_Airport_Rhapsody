package interfaces;
public interface IArraivalTerminalExitPassenger {
    boolean goHome(int npassengers, int passengerID);
    void syncPassenger();
    int nPassengersDepartureAT();
    void awakePassengers();
}
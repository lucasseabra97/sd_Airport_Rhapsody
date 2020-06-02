package clientSide;

import commonInfra.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import clientSide.stubs.*;
import main.*;
import interfaces.*;

/**
*  Passenger entity 
*  @author João Monteiro 
*  @author Lucas Seabra
*/
public class Passenger extends Thread {
	/**
	* State for Passenger
	*/
	private PassengerEnum state;
	/**
    * Random delay to use in thread
    */
    private Random rDelay;
	/**
	* verifying if passenger has another flight
	*/
	private boolean jorneyEnds;

	private ArraivalLoungeStub aloungeStub;

	private BagageCollectionPointStub bcPointStub;
	
	private ArraivalTerminalExitStub atExitStub;
	
	private ArrailvalTTransferQuayStub attQuayStub;

	private DepartureTerminalTransferQuayStub dttQuayStub;

	private BaggageReclaimOfficeStub brOfficeStub;

	private DepartureTerminalEntranceStub dtEntranceStub;
	/**
    * Interface Passenger Arraival Lounge
    */
	// private final IArraivalLoungePassenger monitorAl;
	// /**
    // * Interface Passenger Baggage Collection Point 
    // */
	// private final IBaggageCollectionPointPassenger monitorBc;
	// /**
    // * Interface Passenger Terminal Exit  
    // */
	// private final IArraivalTerminalExitPassenger monitorAe;
	// /**
    // * Interface Passenger Arraival Terminal Transfer Quay  
    // */
	// private final IArraivalTerminalTransferQPassenger monitorTTQ;
	// /**
    // * Interface Passenger Departure Terminal Transfer  
    // */
	// private final IDepartureTerminalTransferQPassenger monitorDTTQ;
	// /**
    // * Interface Passenger Departure Terminal Entrance  
    // */
	// private final IDepartureTerminalEntrancePassenger monitorDEP;
	// /**
    // * Interface Passenger Baggage Reclaim Office 
    // */
	// private final IBaggageReclaimOfficePassenger monitorBRO;
	/**
     * Number of passenger's {@link Bag}s per flight
     */
    private Baggage[] bags;
	/**
    * List of bags collected by Passenger 
    */
	private ArrayList<Baggage> bagsCollected;
	/**
    * Passenger ID  
    */
	private int passengerID;
	/**
    * Terminate Passenger cicle if yes
    */
	private boolean end;
	/**
     * Destination of passenger for each flight
     */
    private Boolean[] flightsDestination;
	 /**
     * Current flight
     */
	private int cFlight;
	/**
	 * total number of flights
	 */
	private int numberFlights;
    /**
     * Bags of passenger for each flight
     */
    private List<List<Baggage>> flightsBags;

	
	public Passenger(int passengerID, Boolean[] flightsDestination, List<List<Baggage>> flightsBags,ArraivalLoungeStub aloungeStub,BagageCollectionPointStub bcPointStub, ArraivalTerminalExitStub atExitStub, ArrailvalTTransferQuayStub attQuayStub,DepartureTerminalTransferQuayStub dttQuayStub, DepartureTerminalEntranceStub dtEntranceStub,BaggageReclaimOfficeStub brOfficeStub) {
		this.passengerID = passengerID;
		//this.numBags = numBags;
		//this.jorneyEnds = jorneyEnds;
		this.flightsDestination = flightsDestination;
		/*this.monitorBc = monitorBc;
		this.monitorAl = monitorAl;*/
		this.state = PassengerEnum.AT_THE_DISEMBARKING_ZONE;	
		this.bagsCollected = new ArrayList<Baggage>();
		this.aloungeStub    = aloungeStub;
		this.bcPointStub    = bcPointStub;
		this.atExitStub     = atExitStub;
		this.attQuayStub    = attQuayStub;
		this.dtEntranceStub = dtEntranceStub;
		this.dttQuayStub    = dttQuayStub;
		/*this.monitorAe = monitorAe;
		this.monitorTTQ = monitorTTQ;
		this.monitorDTTQ = monitorDTTQ;
		this.monitorDEP = monitorDEP;
		this.monitorBRO = monitorBRO;*/
		this.end = true;
		this.flightsBags = flightsBags;
		this.numberFlights = global.NR_FLIGHTS;
	}

	public boolean isJorneyEnds() {
		return this.jorneyEnds;
	}

	// public boolean getJorneyEnds() {
	// 	return this.jorneyEnds;
	// }

	public void setJorneyEnds(boolean jorneyEnds) {
		this.jorneyEnds = jorneyEnds;
	}

	 /**
     * Getter for the current flight bags.
     * @return The current flight bags.
     */
    public int getFlightBags() {
        return flightsBags.get(cFlight).size();
    }

	public int getPassengerID() {
		return this.passengerID;
	}

	public void setPassengerID(int passengerID) {
		this.passengerID = passengerID;
	}
		
	@Override
    public void run() {   
		
		for(cFlight = 0;cFlight < numberFlights ;cFlight++){
			end = true;
			state = PassengerEnum.AT_THE_DISEMBARKING_ZONE;
			
			while (end){

				switch(state){
					case AT_THE_DISEMBARKING_ZONE:
						
						//action = this.monitorAl.whatShouldIDO(this.passengerID,this.bags, this.jorneyEnds);
						Boolean goHome = flightsDestination[cFlight] == true;
						bags = new Baggage[flightsBags.get(cFlight).size()];
						for(int i = 0; i < bags.length; i++) {
							bags[i] = flightsBags.get(cFlight).get(i);
						}
						//falta mexer no ArrailvalLounge
						aloungeStub.whatShouldIDO(goHome); 
						
							
						System.out.printf("Passageiro:%d -> AT_THE_DISEMBARKING_ZONE | chegou com:%d mala(s) e jorneyEnds:%b \n", this.passengerID,bags.length,goHome);
						
						if(goHome){
							if(bags.length >0){
								state = PassengerEnum.AT_THE_LUGGAGE_COLLECTION_POINT;
							}
							else{
								state = PassengerEnum.EXITING_THE_ARRIVAL_TERMINAL;
							}

						}
						else{
							state = PassengerEnum.AT_THE_ARRIVAL_TRANSFER_TERMINAL;
						}
										
						break;
					case AT_THE_LUGGAGE_COLLECTION_POINT:
						//Enquanto o passageiro tem malas entao vai busca las, no caso de as mesmas nao estarem no collectPoint
						// entao vai para o ReclaimOffice  
						System.out.printf("Passenger:%d -> AT_THE_LUGGAGE_COLLECTION_POINT" + " has bags to collect:%d \n",this.passengerID , this.bags.length);
						//int idx =0;
						// passa de array para arraylist. implementaçao mais facil...
						//bagsCollected = Arrays.asList(bags);
						bagsCollected = new ArrayList<>();
						for (Baggage baggage : bags) {
							bagsCollected.add(baggage);
						}
						//System.out.println("Passenger has to collected: "+bagsCollected);
						
						//lostBags = new ArrayList<Baggage>((Arrays.asList(bags)));
						while(bagsCollected.size() >0){
							// ir buscar mala random ? 
							Baggage baggtoCollect = bcPointStub.goCollectABag(bagsCollected);
							
							if(baggtoCollect == null)
							{
								if(bagsCollected.size() >0){
									state =PassengerEnum.AT_THE_BAGGAGE_RECLAIM_OFFICE;
									System.out.println("Passenger lost bags");
								}
									
								else{
									state = PassengerEnum.AT_THE_ARRIVAL_TRANSFER_TERMINAL;
									System.out.println("Passenger has collected all bags");
								}
									
								break;
							}
							if(bagsCollected.contains(baggtoCollect))
							{
								bagsCollected.remove(baggtoCollect);
								state = PassengerEnum.EXITING_THE_ARRIVAL_TERMINAL;

							}
						}
						
						break;


					case AT_THE_BAGGAGE_RECLAIM_OFFICE:
						System.out.printf("Passenger:%d -> COMPLAINING: %d lost bags \n",this.passengerID,bagsCollected.size());
						brOfficeStub.complain(bagsCollected);
						state = PassengerEnum.EXITING_THE_ARRIVAL_TERMINAL;
						break;
						
					case AT_THE_ARRIVAL_TRANSFER_TERMINAL:
						System.out.printf("Passenger:%d -> AT THE ARRIVAL TRANSFER TERMINAL WATING FOR BUS \n",this.passengerID);
						attQuayStub.takeABus(this.passengerID);
						System.out.printf("Passenger:%d -> IN THE BUS \n",this.passengerID);
						attQuayStub.enterTheBus(this.passengerID);
						state = PassengerEnum.TERMINAL_TRANSFER;
						break;
					case TERMINAL_TRANSFER:
						System.out.printf("Passenger:%d -> AT THE TERMINAL TRANSFER \n",this.passengerID);
						dttQuayStub.waitRide();
						state = PassengerEnum.AT_THE_DEPARTURE_TRANSFER_TERMINAL;
						break;

					case AT_THE_DEPARTURE_TRANSFER_TERMINAL:
						System.out.printf("Passenger:%d -> LEAVING THE BUS \n",this.passengerID);
						dttQuayStub.leaveTheBus();
						state = PassengerEnum.ENTERING_THE_DEPARTURE_TERMINAL;
						break;

				
/*
					case EXITING_THE_ARRIVAL_TERMINAL:
						System.out.printf("Passenger:%d -> EXITING_THE_ARRIVAL_TERMINAL \n",this.passengerID);
						atExitStub.syncPassenger();
						int goingHome = dtEntranceStub.nPassengersDepartureTEntrance();
						if(atExitStub.goHome(goingHome)){
							//monitorAe.awakePassengers();
							dtEntranceStub.awakePassengers();
							if(cFlight == numberFlights - 1) {
								aloungeStub.endOfDay();
								attQuayStub.endOfDay();
							}
							
						}
						end = false;
						System.out.printf("Passenger:%d leaving airport \n",this.passengerID);
						state = PassengerEnum.WAITING_END;
						break;
				
					
					case ENTERING_THE_DEPARTURE_TERMINAL:
						System.out.printf("Passenger:%d -> PREPARING NEXT FLIGHT \n",this.passengerID);
						dtEntranceStub.syncPassenger();
						int npassDEP = atExitStub.nPassengersDepartureAT();
				
						if(dtEntranceStub.prepareNextLeg(npassDEP)){
							atExitStub.awakePassengers();
							//monitorDEP.awakePassengers();
							if(cFlight == numberFlights - 1) {
								aloungeStub.endOfDay();
								attQuayStub.endOfDay();
							}
							
						}						
						end = false;
						break ;
				*/
						
				}
				try {
					Thread.sleep(rDelay.nextInt(10));
				} catch (Exception e) {}
				
        	}
			System.out.printf("Passenger:%d reseting state...\n",this.passengerID);
		}
		System.out.println("Passenger Ended . ");
	}

	@Override
	public String toString() {
		return "{" +
			" state='" + state + "'" +
			", jorneyEnds='" + isJorneyEnds() + "'" +
			", passengerID='" + getPassengerID() + "'" +
			"}";
	}
	
}

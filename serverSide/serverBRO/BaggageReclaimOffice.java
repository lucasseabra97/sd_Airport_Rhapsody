package serverSide.serverBRO;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import commonInfra.*;
import clientSide.*;
import clientSide.stubs.GeneralRepositoryStub;
import interfaces.IBaggageReclaimOfficePassenger;
//import shared_regions.GeneralRepository;

/**
 * Baggage Reclaim Office shared memory region.
 * 
 * @author Lucas Seabra
 * @author Joao Monteiro
 */
public class BaggageReclaimOffice implements IBaggageReclaimOfficePassenger{
    /**
     * Baggage Reclaim Office variable for locking
     */
    private final ReentrantLock rl;
    /**
     * List of bags that where missed
     */
    private List<Baggage> bagsList;
    /**
     * General Repository
     */
    private GeneralRepositoryStub grStub;
    /**
     * Baggage Reclaim Office constructor
     * @param rep
     */
    public BaggageReclaimOffice(GeneralRepositoryStub grStub){
        this.grStub = grStub;
        rl = new ReentrantLock(true);
        bagsList = new ArrayList<>();
        this.grStub = grStub;
        
    }
    
    /**
     * Makes a complaint.
     * @param bags Set of bags lost.
     */
    public void complain(ArrayList<Baggage> bags, int passengerID) {
      
        rl.lock();
        try {
            //Passenger passenger = (Passenger) Thread.currentThread();
            grStub.passComplain(passengerID);
            
            System.out.println("Bags losted"+bags.toString());
            for(Baggage b : bags) {
                this.bagsList.add(b);
            }
        } catch(Exception ex) {
        } finally {
            rl.unlock();
        }

    }

    
}

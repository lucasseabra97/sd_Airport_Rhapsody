package clientSide;

import java.util.Random;

import clientSide.stubs.ArraivalLoungeStub;
import clientSide.stubs.BagageCollectionPointStub;
import clientSide.stubs.TemporaryStorageAreaStub;
import commonInfra.*;
import interfaces.*;

/**
*  Porter entity 
*  @author João Monteiro 
*  @author Lucas Seabra
*/
public class Porter extends Thread{
    /**
	* State for Porter
    */
    private PorterEnum state;
    /**
    * Random delay to use in thread
    */
    private Random rDelay;
	/**
	* Next action of Porter
	*/
    private boolean end;
    /**
	* Next bag for Porter collect
	*/
    private Baggage bag;
    /**
    * Interface Porter Arraival Lounge  
    */
    // private final IArraivalLoungePorter monitorAl;
    // /**
    // * Interface Porter Baggage Collection Point 
    // */
    // private final IBaggageCollectionPointPorter monitorBCP;
    //  /**
    // * Interface Porter Temporary Storage Area 
    // */
    // private final ITemporaryStorageAreaPorter monitorTSA;
    private ArraivalLoungeStub aloungeStub;

    private BagageCollectionPointStub bcPointStub;
    
    private TemporaryStorageAreaStub  tsAreaStub;

    public Porter(ArraivalLoungeStub aloungeStub,BagageCollectionPointStub bcPointStub,TemporaryStorageAreaStub  tsAreaStub){
        /*this.monitorAl = monitorAl;
        this.monitorBCP = monitorBCP;
        this.monitorTSA = monitorTSA;*/
        this.state = PorterEnum.WAITING_FOR_A_PLANE_TO_LAND; //initial state
        this.end = true;
        this.aloungeStub = aloungeStub;
        this.bcPointStub = bcPointStub;
        this.tsAreaStub  = tsAreaStub;
    }

    @Override
    public void run() { 
        while(end){
            switch(state){
                case WAITING_FOR_A_PLANE_TO_LAND:
                    System.out.println("Porter -> waiting for a plain to land...");
                    bcPointStub.resetState();
                    if (aloungeStub.takeARest()){
                        //System.out.println("Porter taking a rest");
                        state = PorterEnum.AT_THE_PLANES_HOLD;
                    }

                        
                    else {
                        System.out.println("End of day for porter");
                        end = false;
                    }
                    break;
                case AT_THE_PLANES_HOLD:    
                    System.out.println("Porter -> AT_THE_PLANES_HOLD... ");
                    bag = aloungeStub.tryToCollectABag();
                    System.out.println("Porter carring " + bag);
                    if(bag == null ){
                        System.out.println("No more Bags to Collect .");
                        bcPointStub.noMoreBagsToCollect();
                        state =PorterEnum.WAITING_FOR_A_PLANE_TO_LAND;
                       
                    }
                    else{
                        if(bag.getJourneyEnds())
                            state =  PorterEnum.AT_THE_LUGGAGE_BELT_CONVEYOR;
                        else 
                            state = PorterEnum.AT_THE_STOREROOM;

                    }   
                    break;
                case AT_THE_LUGGAGE_BELT_CONVEYOR:
                    System.out.println("Porter -> AT_THE_LUGGAGE_BELT_CONVEYOR | carring bag to table: " + bag);
                    bcPointStub.carryItToAppropriateStore(bag);
                    state = PorterEnum.AT_THE_PLANES_HOLD;
                    break;
                case AT_THE_STOREROOM:
                    System.out.println("PORTEIRO -> AT_THE_STOREROOM | carring bag to temporary space: " + bag);
                    tsAreaStub.carryItToAppropriateStore(bag);
                    state = PorterEnum.AT_THE_PLANES_HOLD;
                    break;

            }
            try {
                //Thread.sleep(50);
                Thread.sleep(rDelay.nextInt(10));
            } catch (Exception e) {}
        }
        System.out.println("Porter Ended . ");
    }
    
    @Override
    public String toString() {
        return "{" +
            "Porter's state='" + state + "'" +
            "}";
    }

}
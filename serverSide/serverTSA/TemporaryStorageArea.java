package serverSide.serverTSA;

import commonInfra.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import clientSide.stubs.GeneralRepositoryStub;
import interfaces.ITemporaryStorageAreaPorter;
//import shared_regions.GeneralRepository;


public class TemporaryStorageArea implements ITemporaryStorageAreaPorter{
    private GeneralRepositoryStub grStub;
    private final ReentrantLock rl;
    private List<Baggage> bags;
    public TemporaryStorageArea(GeneralRepositoryStub grStub){
        rl = new ReentrantLock();
        bags = new ArrayList<>();
        this.grStub = grStub;
    }

	@Override
	public void carryItToAppropriateStore(Baggage bag) {
        rl.lock();
        try {
            System.out.println("bag: "+ bag);
            bags.add(bag);
            grStub.porterMoveBagToStoreroom();
            
        } catch (Exception e) {
            
        }finally{
            rl.unlock();
        }
		
	}

  
}

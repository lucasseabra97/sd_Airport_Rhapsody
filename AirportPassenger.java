import java.util.*;

import clientSide.BusDriver;
import clientSide.Passenger;
import clientSide.Porter;
import clientSide.stubs.*;
import commonInfra.Baggage;
import main.global;
import serverSide.*;

import java.util.Scanner;
public class AirportPassenger {
    




    public static void main (String [] args)
    {   System.out.println("----------AirportRhapsody---------\n");

        final Random random = new Random();
       
        Scanner sc = new Scanner(System.in); 
        List<List<Baggage>> bagsPerFlight = new ArrayList<>(global.NR_FLIGHTS);
        Boolean[][] passengersDestination = new Boolean [global.NR_PASSENGERS][global.NR_FLIGHTS];
        List<List<List<Baggage>>> passengersBags = new ArrayList<>(global.NR_PASSENGERS);


        for(int p = 0;p<global.NR_PASSENGERS;p++){
            passengersBags.add(new ArrayList<>());
            for(int v = 0; v < global.NR_FLIGHTS; v++) {
                passengersBags.get(p).add(new ArrayList<>());
                if(bagsPerFlight.size() <= v)
                    bagsPerFlight.add(new ArrayList<>()); 

                Boolean goHome = random.nextBoolean();
                passengersDestination[p][v] =  goHome ? true : false;

                int nrRandomBags = random.nextInt(global.MAX_BAGS + 1);
                int bagsLost = random.nextInt(100);
                bagsLost = bagsLost < 5 ? 2 : (bagsLost < 25 ? 1 : 0);

                for(int b = 0; b < nrRandomBags; b++) {
                    Baggage bag = new Baggage(p, passengersDestination[p][v]);
                    passengersBags.get(p).get(v).add(bag);
                }
                int bagsToAdd = bagsLost > nrRandomBags ? nrRandomBags : nrRandomBags - bagsLost;
                for(int b = 0; b < bagsToAdd; b++) {
                    bagsPerFlight.get(v).add(passengersBags.get(p).get(v).get(b));
                }
            }
        }
  

        ArraivalLoungeStub                aLoungStub;                     //stub Arraival Lounge
        ArraivalTerminalExitStub          atExitStub;                    // stub Arraival Terminal Exit
        ArrailvalTTransferQuayStub        attQuayStub;                   // stub Arraival Terminal Transfer Quay
        BagageCollectionPointStub         bcPointStub;                  // stub Baggage Collection Point 
        BaggageReclaimOfficeStub          brOfficeStub;                 // stub Baggage Reclaim Office 
        DepartureTerminalEntranceStub     dtEntranceStub;           // stub Departure Terminal Entrance 
        DepartureTerminalTransferQuayStub dttQuayStub;          // stub Departure Terminal Transfer Quay
        GeneralRepositoryStub             gRepositoyStub;      //stub General Repository
        String fName;                                        // nome do ficheiro de logging 
        String serverHostName;                               // nome do sistema computacional onde está o servidor
        int serverPortNumb;                                  // número do port de escuta do servidor

        /* Obtenção dos parâmetros do problema */

        
        //System.out.println("Nome do ficheiro de logging? ");
        //fName = sc.nextLine(); 
        /*System.out.println("Nome do sistema computacional onde está o servidor Arraival Lounge?");
        serverHostName = sc.nextLine();
        System.out.println("Número do port de escuta do servidor Arraival Lounge?");
        serverPortNumb = sc.nextInt();
        aLoungStub = new ArraivalLoungeStub (serverHostName, serverPortNumb);**/
        //prob vamos ter de limpar os buffers ...
        
        aLoungStub = new ArraivalLoungeStub("localhost",3000);
        bcPointStub = new BagageCollectionPointStub("localhost",3001);
        gRepositoyStub = new GeneralRepositoryStub("localhost",3002);
        atExitStub  = new ArraivalTerminalExitStub("localhost",3003);
        brOfficeStub = new BaggageReclaimOfficeStub("localhost",3004);
        attQuayStub  = new ArrailvalTTransferQuayStub("localhost",3006);
        dttQuayStub  = new DepartureTerminalTransferQuayStub("localhost",3007);
        dtEntranceStub = new DepartureTerminalEntranceStub("localhost",3008);

        Passenger passengers[] = new Passenger[global.NR_PASSENGERS];
        
        for(int i = 0; i < global.NR_PASSENGERS; i++) {
            passengers[i] = new Passenger(i,passengersDestination[i], passengersBags.get(i), aLoungStub, bcPointStub,atExitStub, attQuayStub, dttQuayStub,dtEntranceStub,brOfficeStub);
        } 
        
        aLoungStub.setParameters(global.NR_PASSENGERS, bagsPerFlight);
        atExitStub.setParameters(6);
        attQuayStub.setParameters(3);
        dtEntranceStub.setParemeters(6);

        for(int i = 0; i < global.NR_PASSENGERS; i++) {
            passengers[i].start();
        }

        try {
            for(int i = 0; i < global.NR_PASSENGERS; i++) {
                passengers[i].join();
            }
        } catch (Exception e) {

        }finally{
        }
        aLoungStub.shutdown();
        bcPointStub.shutdown();
        atExitStub.shutdown();
        attQuayStub.shutdown();
        dttQuayStub.shutdown();
        dtEntranceStub.shutdown();
        brOfficeStub.shutdown();
        gRepositoyStub.shutdown();
    }
}

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
        Scanner sc  = new Scanner(System.in);
        int nrFlights;
        int nrPassengers;
        int nrBags;
        int busSize;


        System.out.println("Numero de iterações? ");
        nrFlights = sc.nextInt();
        System.out.println("Numero de Passageiros? ");
        nrPassengers = sc.nextInt();
        System.out.println("Numero de malas? ");
        nrBags = sc.nextInt();
        System.out.println("Tamanho do autocarro? ");
        busSize = sc.nextInt();
        


        List<List<Baggage>> bagsPerFlight = new ArrayList<>(nrFlights);
        Boolean[][] passengersDestination = new Boolean [nrPassengers][nrFlights];
        List<List<List<Baggage>>> passengersBags = new ArrayList<>(nrPassengers);

        

        for(int p = 0;p<nrPassengers;p++){
            passengersBags.add(new ArrayList<>());
            for(int v = 0; v < nrFlights; v++) {
                passengersBags.get(p).add(new ArrayList<>());
                if(bagsPerFlight.size() <= v)
                    bagsPerFlight.add(new ArrayList<>()); 

                Boolean goHome = random.nextBoolean();
                passengersDestination[p][v] =  goHome ? true : false;

                int nrRandomBags = random.nextInt(nrBags + 1);
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
        System.out.println("Nr do port de escuta do servidor Arraival Lounge?");
        serverPortNumb = sc.nextInt();
        aLoungStub = new ArraivalLoungeStub (serverHostName, serverPortNumb);
        System.out.println("Nome do sistema computacional onde está o servidor Baggage Collection Point?");
        serverHostName = sc.nextLine();
        System.out.println("Nr do port de escuta do servidor Baggage Collection Point?");
        serverPortNumb = sc.nextInt();
        bcPointStub = new BagageCollectionPointStub(serverHostName,serverPortNumb);*/
        

        //prob vamos ter de limpar os buffers ...
        
        aLoungStub = new ArraivalLoungeStub(global.SERVER_HOST_NAME_AL,global.SERVER_PORT_NUMB_AL);
        bcPointStub = new BagageCollectionPointStub(global.SERVER_HOST_NAME_BCP,global.SERVER_PORT_NUMB_BCP);
        gRepositoyStub = new GeneralRepositoryStub(global.SERVER_HOST_NAME_GR,global.SERVER_PORT_NUMB_GR);
        atExitStub  = new ArraivalTerminalExitStub(global.SERVER_HOST_NAME_ATE,global.SERVER_PORT_NUMB_ATE);
        brOfficeStub = new BaggageReclaimOfficeStub(global.SERVER_HOST_NAME_BRO,global.SERVER_PORT_NUMB_BRO);
        attQuayStub  = new ArrailvalTTransferQuayStub(global.SERVER_HOST_NAME_ATTQ,global.SERVER_PORT_NUMB_ATTQ);
        dttQuayStub  = new DepartureTerminalTransferQuayStub(global.SERVER_HOST_NAME_DTTQ,global.SERVER_PORT_NUMB_DTTQ);
        dtEntranceStub = new DepartureTerminalEntranceStub(global.SERVER_HOST_NAME_DTE,global.SERVER_PORT_NUMB_DTE);
        gRepositoyStub.setParameters(nrPassengers, busSize);
        Passenger passengers[] = new Passenger[nrPassengers];
        
        for(int i = 0; i < nrPassengers; i++) {
            passengers[i] = new Passenger(i,passengersDestination[i], passengersBags.get(i), aLoungStub, bcPointStub,atExitStub, attQuayStub, dttQuayStub,dtEntranceStub,brOfficeStub , nrFlights);
        } 
        
        aLoungStub.setParameters(nrPassengers, bagsPerFlight);
        atExitStub.setParameters(nrPassengers);
        attQuayStub.setParameters(busSize);
        dtEntranceStub.setParemeters(nrPassengers);
        

        for(int i = 0; i < nrPassengers; i++) {
            passengers[i].start();
        }

        try {
            for(int i = 0; i < nrPassengers; i++) {
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

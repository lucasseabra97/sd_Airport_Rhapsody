package clientSide.passenger;

import java.util.*;

import clientSide.ArrailvalTTransferQuayStub;
import clientSide.ArraivalLoungeStub;
import clientSide.ArraivalTerminalExitStub;
import clientSide.BagageCollectionPointStub;
import clientSide.BaggageReclaimOfficeStub;
import clientSide.DepartureTerminalEntranceStub;
import clientSide.DepartureTerminalTransferQuayStub;
import clientSide.TemporaryStorageAreaStub;
import commonInfra.Baggage;
import main.global;
import serverSide.serverATTQ.ArraivalTerminalTransferQuay;
import serverSide.serverBRO.BaggageReclaimOffice;
import serverSide.serverDTE.DepartureTerminalEntrance;
import serverSide.serverDTTQ.DepartureTerminalTransferQuay;
import serverSide.serverTSA.TemporaryStorageArea;
import java.util.Scanner;

public class PassengerMain {
    public static void main (String [] args)
    {
        final Random random = new Random();
       
        Scanner sc = new Scanner(System.in); 
        // List<List<Baggage>> bagsPerFlight = new ArrayList<>(global.NR_FLIGHTS);
        // Boolean[][] passengersDestination = new Boolean [global.NR_PASSENGERS][global.NR_FLIGHTS];
        // List<List<List<Baggage>>> passengersBags = new ArrayList<>(global.NR_PASSENGERS);

        Passenger passengers[] = new Passenger[global.NR_PASSENGERS];

        ArraivalLoungeStub                aLoungStub;                     //stub Arraival Lounge
        ArraivalTerminalExitStub          atExitStub;                    // stub Arraival Terminal Exit
        ArrailvalTTransferQuayStub        attQuayStub;                   // stub Arraival Terminal Transfer Quay
        BagageCollectionPointStub         bcPointStub;                  // stub Baggage Collection Point 
        BaggageReclaimOfficeStub          brOfficeStub;                 // stub Baggage Reclaim Office 
        DepartureTerminalEntranceStub     dtEntranceStub;           // stub Departure Terminal Entrance 
        DepartureTerminalTransferQuayStub dttQuayStub;          // stub Departure Terminal Transfer Quay
        TemporaryStorageAreaStub          tsaStub;              // stub Temporary Storage Area
        String fName;                                        // nome do ficheiro de logging 
        String serverHostName;                               // nome do sistema computacional onde está o servidor
        int serverPortNumb;                                  // número do port de escuta do servidor

        /* Obtenção dos parâmetros do problema */

        System.out.println("----------AirportRhapsody---------\n");
       
        
        System.out.println("Nome do ficheiro de logging? ");
        fName = sc.nextLine(); 
        System.out.println("Nome do sistema computacional onde está o servidor? ");
        serverHostName = sc.nextLine();
        System.out.println("Número do port de escuta do servidor? ");
        serverPortNumb = sc.nextInt();
        aLoungStub = new ArraivalLoungeStub (serverHostName, serverPortNumb);
        //prob vamos ter de limpar os buffers ...
        System.out.println("Nome do sistema computacional onde está o servidor? ");
        serverHostName = sc.nextLine();
        System.out.println("Número do port de escuta do servidor? ");
        serverPortNumb = sc.nextInt();
        atExitStub = new ArraivalTerminalExitStub (serverHostName, serverPortNumb);

         
    }

}
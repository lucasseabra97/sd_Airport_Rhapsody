import java.util.*;

import clientSide.BusDriver;
import clientSide.Passenger;
import clientSide.Porter;
import clientSide.stubs.*;
import commonInfra.Baggage;
import main.global;
import serverSide.*;

import java.util.Scanner;
public class AirportBusDriver {
    

    public static void main (String [] args)
    {   System.out.println("----------AirportRhapsody---------\n");

        final Random random = new Random();
       
        Scanner sc = new Scanner(System.in); 
        int busSize;
        System.out.println("Tamanho do autocarro? ");
        busSize = sc.nextInt();
      
        ArrailvalTTransferQuayStub        attQuayStub;                   // stub Arraival Terminal Transfer Quay
        DepartureTerminalTransferQuayStub dttQuayStub;          // stub Departure Terminal Transfer Quay
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
        
      
        attQuayStub  = new ArrailvalTTransferQuayStub("localhost",3006);
        dttQuayStub  = new DepartureTerminalTransferQuayStub("localhost",3007);
        

        BusDriver busdriver = new BusDriver(attQuayStub, dttQuayStub,busSize);       
        busdriver.start();
    

        try {
            
            busdriver.join();
            
        } catch (Exception e) {

        }finally{
        }
    }
}

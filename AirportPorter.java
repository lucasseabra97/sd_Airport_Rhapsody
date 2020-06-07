import java.util.*;

import clientSide.BusDriver;
import clientSide.Passenger;
import clientSide.Porter;
import clientSide.stubs.*;
import commonInfra.Baggage;
import main.global;
import serverSide.*;

import java.util.Scanner;
public class AirportPorter {
   

    public static void main (String [] args)
    {   System.out.println("----------AirportRhapsody---------\n");

        final Random random = new Random();
       
        Scanner sc = new Scanner(System.in); 
        


        ArraivalLoungeStub                aLoungStub;                     //stub Arraival Lounge
        TemporaryStorageAreaStub          tsaStub;              // stub Temporary Storage Area
        BagageCollectionPointStub         bcPointStub;                  // stub Baggage Collection Point 
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
        
      
     
        aLoungStub = new ArraivalLoungeStub(global.SERVER_HOST_NAME_AL,global.SERVER_PORT_NUMB_AL); 
        bcPointStub = new BagageCollectionPointStub(global.SERVER_HOST_NAME_BCP,global.SERVER_PORT_NUMB_BCP);
        tsaStub = new TemporaryStorageAreaStub(global.SERVER_HOST_NAME_TSA,global.SERVER_PORT_NUMB_TSA);
       
        Porter porter = new Porter(aLoungStub, bcPointStub, tsaStub);
        porter.start();
   
    

        try {
            porter.join();
          
            
        } catch (Exception e) {

        }finally{
        }
        tsaStub.shutdown();
    }
}


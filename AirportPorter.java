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
        
      
     
        aLoungStub = new ArraivalLoungeStub("localhost",3000); 
        bcPointStub = new BagageCollectionPointStub("localhost",3001);
        tsaStub = new TemporaryStorageAreaStub("localhost",3005);
       
        Porter porter = new Porter(aLoungStub, bcPointStub, tsaStub);
        porter.start();
   
    

        try {
            porter.join();
          
            
        } catch (Exception e) {

        }finally{
        }
    }
}


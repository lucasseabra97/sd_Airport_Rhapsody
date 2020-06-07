# sd_Airport_Rhapsody
distributed systems P3G6

Shared regions server host name and port number can be defined at sd_Airport_Rhapsody/main/global.java

To run tthe project run the followings commands:

**1-Open a terminal and run the followings commands:**
----------------------------------------
 ```
    > chmod 777 client.sh
    > ./client.sh
```
Go to PASSENGER tab , In order to run Passenger we have to set some parameters,  example:   

Numero de iterações?  
20  
Numero de Passageiros?  
6  
Numero de malas?   
2  
Tamanho do autocarro?  
3  
  
Go to BUS DRIVER tab , In order to run BUS DRIVER we have to set some parameters,  example:  

Tamanho do autocarro?   
3  
  
NOTE: The bus size needs to be the same at the PASSENGER and at the BUS DRIVER  

**2-Open another terminal and run the followings commands:**
----------------------------------------
 ```
    > chmod 777 server.sh
    > ./server.sh
```


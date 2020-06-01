#!/bin/bash


# Compile Arraival Lounge  (AL)
javac serverSide/serverAL/ArraivalLoungeMain.java

# Compile ArraivalTerminal Exit  (ATE)
javac serverSide/serverATE/ArraivalTerminalExitMain.java


# Compile ArraivalTerminal TransferQuay  (ATTQ)
javac serverSide/serverATTQ/ArraivalTerminalTransferQuayMain.java


# Compile Baggage Collection Point  (BCP)
javac serverSide/serverBCP/BaggageCollectionPointMain.java

# Compile Baggage Reclaim Office  (BRO)
javac serverSide/serverBRO/BaggageReclaimOfficeMain.java

# Compile Departure Terminal Entrance  (DTE)
javac serverSide/serverDTE/DepartureTerminalEntranceMain.java

# Compile Departure Terminal Transfer Quay  (DTTQ)
javac serverSide/serverDTTQ/DepartureTerminalTransferQuayMain.java
  

# Compile Baggage Reclaim Office  (TSA)
javac serverSide/serverTSA/TemporaryStorageAreaMain.java

#run all instances
gnome-terminal --tab -e "java serverSide/serverAL/ArraivalLoungeMain" \
                --tab -e "java serverSide/serverATE/ArraivalTerminalExitMain " \
                --tab -e "java serverSide/serverBCP/BaggageCollectionPointMain" \
                --tab -e "java serverSide/serverBRO/BaggageReclaimOfficeMain" \
                --tab -e "java serverSide/serverDTE/DepartureTerminalEntranceMain" \
                --tab -e "java serverSide/serverDTTQ/DepartureTerminalTransferQuayMain" \
                --tab -e "java serverSide/serverTSA/TemporaryStorageAreaMain "\
                --tab -e "java serverSide/serverATTQ/ArraivalTerminalTransferQuayMain" 
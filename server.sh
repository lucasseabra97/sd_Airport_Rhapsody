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
gnome-terminal --tab --title="AL Server" -e "java serverSide/serverAL/ArraivalLoungeMain" \
                --tab --title="ATE Server" -e "java serverSide/serverATE/ArraivalTerminalExitMain " \
                --tab --title="BCP Server" -e "java serverSide/serverBCP/BaggageCollectionPointMain" \
                --tab --title="BRO Server" -e "java serverSide/serverBRO/BaggageReclaimOfficeMain" \
                --tab --title="DTE Server" -e "java serverSide/serverDTE/DepartureTerminalEntranceMain" \
                --tab --title="DTTQ Server" -e "java serverSide/serverDTTQ/DepartureTerminalTransferQuayMain" \
                --tab --title="TSA Server" -e "java serverSide/serverTSA/TemporaryStorageAreaMain "\
                --tab --title="ATTQ Server" -e "java serverSide/serverATTQ/ArraivalTerminalTransferQuayMain" 
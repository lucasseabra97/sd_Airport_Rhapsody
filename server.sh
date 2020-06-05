#!/bin/bash


# Compile Arraival Lounge  (AL)
javac serverSide/serverAL/ArraivalLoungeMain.java

# Compile ArraivalTerminal Exit  (ATE)
javac serverSide/serverATE/ArraivalTerminalExitMain.java


# Compile General Repository   (GR)
javac serverSide/serverGR/GeneralRepositoryMain.java

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
gnome-terminal --tab --title="AL Server" -e "bash -c \"java serverSide/serverAL/ArraivalLoungeMain ; exec bash\"" \
                --tab --title="ATE Server" -e "bash -c \"java serverSide/serverATE/ArraivalTerminalExitMain ; exec bash\"" \
                --tab --title="BCP Server" -e "bash -c \"java serverSide/serverBCP/BaggageCollectionPointMain ; exec bash\"" \
                --tab --title="BRO Server" -e "bash -c \"java serverSide/serverBRO/BaggageReclaimOfficeMain ; exec bash\"" \
                --tab --title="DTE Server" -e "bash -c \"java serverSide/serverDTE/DepartureTerminalEntranceMain ; exec bash\"" \
                --tab --title="DTTQ Server" -e "bash -c \"java serverSide/serverDTTQ/DepartureTerminalTransferQuayMain ; exec bash\"" \
                --tab --title="TSA Server" -e "bash -c \"java serverSide/serverTSA/TemporaryStorageAreaMain ; exec bash\"" \
                --tab --title="GR Server" -e "bash -c \"java serverSide/serverGR/GeneralRepositoryMain ; exec bash\"" \
                --tab --title="ATTQ Server" -e "bash -c \"java serverSide/serverATTQ/ArraivalTerminalTransferQuayMain ; exec bash\"" 
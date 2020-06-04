#!/bin/bash

javac AirportPorter.java
javac AirportPassenger.java
javac AirportBusDriver.java


gnome-terminal --tab --title="PORTER" -e "bash -c \"java AirportPorter ; exec bash\"" \
               --tab --title="BUS DRIVER" -e "bash -c \"java AirportBusDriver ; exec bash\"" \
               --tab --title="PASSENGER" -e "bash -c \"java AirportPassenger ; exec bash\"" 
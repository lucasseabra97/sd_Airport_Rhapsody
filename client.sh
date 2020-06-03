#!/bin/bash

javac AirportPorter.java
javac AirportPassenger.java
javac AirportBusDriver.java


gnome-terminal --tab --title="PORTER" -e "java AirportPorter" \
                --tab --title="BUS DRIVER" -e "java AirportBusDriver" \
                --tab --title="PASSENGER" -e "java AirportPassenger" 
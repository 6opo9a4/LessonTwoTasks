package edu.epam.task3.variables;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Scanner;

public class Train implements Serializable {
    private String destination;
    private int trainNumber;
    private String departureTime;
    private int[] typesOfPalaces;

    public Train(String destination, String departureTime, int commonPlaces, int coupePlaces, int reservedSeatPlaces, int luxuryPlaces) {
        IDGenerator idGenerator=new IDGenerator();
        if (!departureTime.matches("([0-9]|[0-2][0-3]|[0-1][1-9]):([0-5][0-9]|[0-9])")){
            throw new IllegalArgumentException("illegal time format");
        }
        this.destination = destination;
        this.trainNumber = idGenerator.createID();
        this.departureTime = departureTime;
        this.typesOfPalaces = new int[]{commonPlaces, coupePlaces, reservedSeatPlaces, luxuryPlaces};
    }

    public Train(String destination, String departureTime, int[] typesOfPalaces) {
        IDGenerator idGenerator=new IDGenerator();
        if (!departureTime.matches("([0-9]|[0-2][0-3]|[0-1][1-9]):([0-5][0-9]|[0-9])")){
            throw new IllegalArgumentException("illegal time format");
        }
        if(typesOfPalaces.length!=4){
            throw new IllegalArgumentException("illegal types of places format");
        }
        this.destination = destination;
        this.trainNumber = idGenerator.createID();
        this.departureTime = departureTime;
        this.typesOfPalaces = typesOfPalaces;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public int getTrainNumber() {
        return trainNumber;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        if (!departureTime.matches("([0-9]|[0-2][0-3]|[0-1][1-9]):([0-5][0-9]|[0-9])")){
            throw new IllegalArgumentException("illegal time format(HH:mm)");
        }
        this.departureTime = departureTime;
    }

    public int[] getTypesOfPalaces() {
        if(typesOfPalaces.length>0) {
            return typesOfPalaces;
        }
        else{
            throw new IllegalArgumentException("count of places should be more than 0");
        }
    }

    public int getCommonPlaces(){
        return getTypesOfPalaces()[0];
    }

    public int getCouplePlaces(){
        return getTypesOfPalaces()[1];
    }

    public int getReservedPlaces(){
        return getTypesOfPalaces()[2];
    }

    public int getLuxuryPlaces(){
        return getTypesOfPalaces()[3];
    }

    public void setTypesOfPalaces(int... typesOfPalaces) {
        int[] places = this.typesOfPalaces;
        if(typesOfPalaces.length!=4){
            throw new IllegalArgumentException("illegal number of places types");
        }
        this.typesOfPalaces = typesOfPalaces;
    }

    public int getNumberOfPlaces() {
        int numberOfPlaces = 0;
        int[] places = this.typesOfPalaces;
        if(places.length>0) {
            numberOfPlaces = numberOfPlaces + this.typesOfPalaces[0] * 3;
            numberOfPlaces = numberOfPlaces + this.typesOfPalaces[1] * 6;
            numberOfPlaces = numberOfPlaces + this.typesOfPalaces[2] * 2;
            numberOfPlaces = numberOfPlaces + this.typesOfPalaces[3] * 1;
        }
        return numberOfPlaces;
    }

    @Override
    public String toString() {
        String forOut = String.format("Time: %s, destination - %s(№%s), count of places - %s", departureTime, destination,trainNumber,getNumberOfPlaces());
        return forOut;
    }

    public int getDepartureMinutes() {
        int minutes;
        String time = this.departureTime;
        String[] hoursAndMinutes;
        hoursAndMinutes = time.split(":");
        minutes = Integer.parseInt(hoursAndMinutes[1]);
        return minutes;
    }

    public int getDepartureHours() {
        int hours;
        String time = this.departureTime;
        String[] hoursAndMinutes;
        hoursAndMinutes = time.split(":");
        hours = Integer.parseInt(hoursAndMinutes[0]);
        return hours;
    }
}

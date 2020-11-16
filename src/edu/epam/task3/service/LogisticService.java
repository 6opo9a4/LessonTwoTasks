package edu.epam.task3.service;

import edu.epam.task3.variables.LogisticСompany;
import edu.epam.task3.variables.Train;

import java.util.ArrayList;

public class LogisticService {

    public ArrayList<Train> sameDestinationTrains(String destinationPoint, LogisticСompany company){
        ArrayList<Train> trains = new ArrayList<>();
        for (Train train : company.getTrains()) {
            if(train.getDestination().equals(destinationPoint))
            {
                trains.add(train);
            }
        }
        return trains;
    }

    public ArrayList<Train> sameDestinationAndAfterTimeTrains(String destinationPoint, LogisticСompany company, String time){
        if (!time.matches("([0-9]|[0-2][0-3]|[0-1][1-9]):([0-5][0-9]|[0-9])")){
            throw new IllegalArgumentException("illegal time format");
        }
        ArrayList<Train> sameDestinationTrains = sameDestinationTrains(destinationPoint,company);
        ArrayList<Train> trains = new ArrayList<>();
        for (Train train : sameDestinationTrains) {
            if(train.getDepartureHours() > getDepartureHours(time)) {
                trains.add(train);
            }
        }
        return trains;
    }

    public ArrayList<Train> sameDestinationAndWithPlacesTrains(String destinationPoint, LogisticСompany company){
        ArrayList<Train> trains = new ArrayList<>();
        for (Train train : company.getTrains()) {
            String destination = train.getDestination();
            if(destination.equals(destinationPoint)) {
                if(train.getTypesOfPalaces()[0] > 0) {
                    trains.add(train);
                }
            }
        }
        return trains;
    }

    public ArrayList<Train> bubbleSortID(ArrayList<Train> trains){
        if(trains.isEmpty() || trains.size()<2) {
            throw new IllegalArgumentException("you must add more trains to sort");
        }
        else {
            Train train1 = trains.get(0);
            Train train2 = trains.get(1);
            boolean needIteration = true;
            if(train1.getTrainNumber()<train2.getTrainNumber()) {
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < trains.size(); i++) {
                        train1 = trains.get(i);
                        train2 = trains.get(i - 1);
                        if (train1.getTrainNumber() > train2.getTrainNumber()) {
                            Train tmp = train1;
                            trains.set(i, train2);
                            trains.set(i-1, tmp);
                            needIteration = true;
                        }
                    }
                }
            }
            else{
                while (needIteration) {
                    needIteration = false;
                    for (int i = 1; i < trains.size(); i++) {
                        train1 = trains.get(i);
                        train2 = trains.get(i - 1);
                        if (train1.getTrainNumber() < train2.getTrainNumber()) {
                            Train tmp = train1;
                            trains.set(i, train2);
                            trains.set(i-1, tmp);
                            needIteration = true;
                        }
                    }
                }
            }
            return trains;
        }
    }

    public ArrayList<Train> shuttleSortID(ArrayList<Train> trains){
        if(trains.isEmpty() || trains.size()<2) {
            throw new IllegalArgumentException("you must add more trains to sort");
        }
        else {
            Train train1 = trains.get(0);
            Train train2 = trains.get(1);
            if(train1.getTrainNumber()<train2.getTrainNumber()) {
                for (int i = 1; i < trains.size(); i++) {
                    train1 = trains.get(i);
                    train2 = trains.get(i - 1);
                    if (train1.getNumberOfPlaces() > train2.getNumberOfPlaces()) {
                        Train tmp = train1;
                        trains.set(i, train2);
                        trains.set(i-1, tmp);
                        for (int z = i - 1; (z - 1) >= 0; z--) {
                            train1 = trains.get(z);
                            train2 = trains.get(z - 1);
                            if (train1.getNumberOfPlaces() > train2.getNumberOfPlaces()) {
                                tmp = train1;
                                trains.set(z, train2);
                                trains.set(z-1, tmp);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            else{
                for (int i = 1; i < trains.size(); i++) {
                    train1 = trains.get(i);
                    train2 = trains.get(i - 1);
                    if (train1.getNumberOfPlaces() < train2.getNumberOfPlaces()) {
                        Train tmp = train1;
                        trains.set(i, train2);
                        trains.set(i-1, tmp);
                        for (int z = i - 1; (z - 1) >= 0; z--) {
                            train1 = trains.get(z);
                            train2 = trains.get(z - 1);
                            if (train1.getNumberOfPlaces() < train2.getNumberOfPlaces()) {
                                tmp = train1;
                                trains.set(z, train2);
                                trains.set(z-1, tmp);
                            } else {
                                break;
                            }
                        }
                    }
                }
            }
            return trains;
        }
    }
    public ArrayList<Train> shellSortID(ArrayList<Train> trains){
        if(trains.isEmpty() || trains.size()<2) {
            throw new IllegalArgumentException("you must add more trains to sort");
        }
        else {
            Train train1 = trains.get(0);
            Train train2 = trains.get(1);
            if(train1.getTrainNumber()>train2.getTrainNumber()) {
                int gap = trains.size() / 2;
                while (gap >= 1) {
                    for (int right = 0; right < trains.size(); right++) {
                        for (int c = right - gap; c >= 0; c -= gap) {
                            train1 = trains.get(c);
                            train2 = trains.get(c+gap);
                            if (trains.get(c).getTrainNumber() > trains.get(c + gap).getTrainNumber()) {
                                Train tmp = train1;
                                trains.set(c, train2);
                                trains.set(c+gap, tmp);
                            }
                        }
                    }
                    gap = gap / 2;
                }
            }
            else{
                int gap = trains.size() / 2;
                while (gap >= 1) {
                    for (int right = 0; right < trains.size(); right++) {
                        for (int c = right - gap; c >= 0; c -= gap) {
                            train1 = trains.get(c);
                            train2 = trains.get(c+gap);
                            if (trains.get(c).getTrainNumber() < trains.get(c + gap).getTrainNumber()) {
                                Train tmp = train1;
                                trains.set(c, train2);
                                trains.set(c+gap, tmp);
                            }
                        }
                    }
                    gap = gap / 2;
                }
            }
            return trains;
        }
    }

    private int getDepartureMinutes(String time) {
        int minutes;
        String[] hoursAndMinutes;
        hoursAndMinutes = time.split(":");
        minutes = Integer.parseInt(hoursAndMinutes[1]);
        return minutes;
    }

    private int getDepartureHours(String time) {
        int hours;
        String[] hoursAndMinutes;
        hoursAndMinutes = time.split(":");
        hours = Integer.parseInt(hoursAndMinutes[0]);
        return hours;
    }
}

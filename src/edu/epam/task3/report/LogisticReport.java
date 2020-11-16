package edu.epam.task3.report;

import edu.epam.task3.variables.Train;

import java.util.ArrayList;

public class LogisticReport {
    public void trainsOut(ArrayList<Train> sameDestinationTrains)
    {
        String forOut = "";
        for(Train train : sameDestinationTrains){
            forOut = String.format("%s \n %s", forOut, train.toString());
        }
        System.out.println(forOut);
    }
}

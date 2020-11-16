package edu.epam.task3.main;

import edu.epam.task3.report.LogisticReport;
import edu.epam.task3.service.LogisticService;
import edu.epam.task3.variables.LogisticСompany;
import edu.epam.task3.variables.Train;

import java.util.ArrayList;

public class LogisticMain {
    public static void main(String[] args)
    {
        Train train = new Train();
        train.keyboardInput();
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        LogisticService logisticService = new LogisticService();
        ArrayList<Train> sameDestinationTrains = logisticService.sameDestinationTrains("Mozyr",belorussianRailway);
        LogisticReport logisticReport = new LogisticReport();
        logisticReport.trainsOut(sameDestinationTrains);
        ArrayList<Train> sameDestinationAndPlacesTrains = logisticService.sameDestinationAndWithPlacesTrains("Mozyr",belorussianRailway);
        logisticReport.trainsOut(sameDestinationAndPlacesTrains);
        ArrayList<Train> sameDestinationAndTimeTrains = logisticService.sameDestinationAndAfterTimeTrains("Mozyr",belorussianRailway,"10:59");
        logisticReport.trainsOut(sameDestinationAndTimeTrains);
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.bubbleSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.bubbleSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.shuttleSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.shuttleSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.shellSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
        logisticService.shellSortID(belorussianRailway.getTrains());
        logisticReport.trainsOut(belorussianRailway.getTrains());
    }
}

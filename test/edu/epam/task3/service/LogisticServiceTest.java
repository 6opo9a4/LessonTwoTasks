package edu.epam.task3.service;

import edu.epam.task3.variables.LogisticСompany;
import edu.epam.task3.variables.Train;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;


public class LogisticServiceTest {
    @Test
    public void sameDestinationFindTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(first);
        execute.add(second);
        execute.add(third);
        LogisticService logisticService = new LogisticService();
        ArrayList<Train> sameDestinationTrains = logisticService.sameDestinationTrains("Mozyr",belorussianRailway);
        Assert.assertEquals(execute,sameDestinationTrains);
    }

    @Test
    public void sameDestinationTimeFindTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(first);
        execute.add(second);
        LogisticService logisticService = new LogisticService();
        ArrayList<Train> sameDestinationTimeTrains = logisticService.sameDestinationAndAfterTimeTrains("Mozyr",belorussianRailway,"10:59");
        Assert.assertEquals(execute,sameDestinationTimeTrains);
    }

    @Test
    public void sameDestinationPlacesFindTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(first);
        execute.add(third);
        LogisticService logisticService = new LogisticService();
        ArrayList<Train> sameDestinationPlacesTrains = logisticService.sameDestinationAndWithPlacesTrains("Mozyr",belorussianRailway);
        Assert.assertEquals(execute,sameDestinationPlacesTrains);
    }

    @Test
    public void bubleSortIDTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(second);
        execute.add(forth);
        execute.add(first);
        execute.add(third);
        LogisticService logisticService = new LogisticService();
        logisticService.bubbleSortID(belorussianRailway.getTrains());
        Assert.assertEquals(execute,belorussianRailway.getTrains());
    }
    @Test
    public void shuttleSortIDTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(forth);
        execute.add(first);
        execute.add(second);
        execute.add(third);
        LogisticService logisticService = new LogisticService();
        logisticService.shuttleSortID(belorussianRailway.getTrains());
        Assert.assertEquals(execute,belorussianRailway.getTrains());
    }
    @Test
    public void shellSortIDTest(){
        Train first =  new Train("Mozyr",12,"12:34",2,2,12,0);
        Train second =  new Train("Mozyr",1,"23:55",0,3,18,12);
        Train third =  new Train("Mozyr",48,"9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy",5,"12:34",5,0,3,1);
        LogisticСompany belorussianRailway = new LogisticСompany(first,second,third,forth);
        ArrayList<Train> execute = new  ArrayList<>();
        execute.add(second);
        execute.add(forth);
        execute.add(first);
        execute.add(third);
        LogisticService logisticService = new LogisticService();
        logisticService.shellSortID(belorussianRailway.getTrains());
        Assert.assertEquals(execute,belorussianRailway.getTrains());
    }

    @Test
    public void consoleInputTest(){
        Train train = new Train();
        train.keyboardInput();
    }
}
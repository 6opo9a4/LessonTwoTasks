package edu.epam.task3.variables;

import edu.epam.task3.service.LogisticService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogisticСompanyTest {
    @Test
    public void setAndGetLogisticCompanyFromFile(){
        String filePath = "logisticCompany.dat";
        Train first =  new Train("Mozyr","12:34",2,2,12,0);
        Train second =  new Train("Mozyr","23:55",0,3,18,12);
        Train third =  new Train("Mozyr","9:47",1,8,32,4);
        Train forth =  new Train("Baranowichy","12:34",5,0,3,1);
        LogisticCompany belorussianRailway = new LogisticCompany(first,second,third,forth);
        LogisticService logisticService = new LogisticService();
        logisticService.setCompanyToFile(filePath,belorussianRailway);
        LogisticCompany deserializeBelorussianRailway = new LogisticCompany(filePath);
        Assert.assertEquals(belorussianRailway,deserializeBelorussianRailway);
    }

}
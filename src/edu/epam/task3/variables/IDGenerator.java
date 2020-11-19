package edu.epam.task3.variables;


public class IDGenerator {
    private static int idCounter = 0;

    public static int createID()
    {
        return idCounter++;
    }
}

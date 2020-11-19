package edu.epam.task3.variables;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class LogisticCompany implements Serializable {
    private ArrayList<Train> trains = new ArrayList<>();

    public LogisticCompany(){
    }
    public LogisticCompany(Train... trains) {
        Collections.addAll(this.trains, trains);
    }

    public LogisticCompany(ArrayList<Train> trains) {
        this.trains = trains;
    }

    public LogisticCompany(String filePath){
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            this.trains = (ArrayList<Train>) ois.readObject();
        }
        catch(Exception ex){

            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(Train... trains) {
        Collections.addAll(this.trains, trains);
    }

    public void setTrains(ArrayList<Train> trains) {
        Collections.addAll(this.trains = trains);
    }

    public void setTrain(Train train) {
        if(train.getDepartureTime()!=null) {
            this.trains.add(train);
        }
    }

    public void delTrains(int position) {
        if(position>=0 && position<trains.size()) {
            this.trains.remove(position);
        }
    }

    public Train getTrain(int position) {
        if(position>=0 && position<trains.size()) {
          Train train = this.trains.get(position);
          return train;
        }
        else {
            throw new IllegalArgumentException("Out of trains range");
        }
    }

    @Override
    public String toString() {
        String forOut = "";
        for(Train train : getTrains()){
            forOut = String.format("%s \n %s", forOut, train.toString());
        }
        return forOut;
    }
}

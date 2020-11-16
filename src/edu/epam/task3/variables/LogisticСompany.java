package edu.epam.task3.variables;

import java.nio.file.LinkOption;
import java.util.ArrayList;
import java.util.Collections;

public class LogisticСompany {
    private ArrayList<Train> trains = new ArrayList<>();

    public LogisticСompany(){
    }
    public LogisticСompany(Train... trains) {
        Collections.addAll(this.trains, trains);
    }
    public LogisticСompany(ArrayList<Train> trains) {
        this.trains = trains;
    }
    public ArrayList<Train> getTrains() {
        return trains;
    }

    public void setTrains(Train... trains) {
        Collections.addAll(this.trains, trains);
    }

    public void delTrains(int position) {
        if(position>=0 && position<trains.size()) {
            this.trains.remove(position);
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

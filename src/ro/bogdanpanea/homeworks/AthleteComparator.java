package ro.bogdanpanea.homeworks;

import java.util.Comparator;

public class AthleteComparator implements Comparator<Athlete> {

    public int compare(Athlete operand1, Athlete operand2) {
        return operand1.minSecToSeconds(operand1.getFinalTime()).compareTo(operand2.minSecToSeconds(operand2.getFinalTime()));
    }
}

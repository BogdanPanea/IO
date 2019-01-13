package ro.bogdanpanea.homeworks;

import java.util.Arrays;

public class Athlete {

    private int number;
    private String name;
    private String countryCode;
    private String skiTimeResult;
    private String[] shootingRange;
    private String finalTime;

    public Athlete(int number, String name, String countryCode, String skiTimeResult, String[] shootingRange) {
        this.number = number;
        this.name = name;
        this.countryCode = countryCode;
        this.skiTimeResult = skiTimeResult;
        this.shootingRange = shootingRange;
        this.finalTime = calculateFinalTime(skiTimeResult, shootingRange);
    }

    private String calculateFinalTime(String skiTimeResult, String[] shootingRange) {
        int t = minSecToSeconds(skiTimeResult);
        for (String s : shootingRange) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == 'o') {
                    t = t + 10;
                }
            }
        }
        return secondsToMinSec(t);
    }

    public int getNumber() {
        return number;
    }

    String getName() {
        return name;
    }

    public String getSkiTimeResult() {
        return skiTimeResult;
    }

    public String[] getShootingRange() {
        return shootingRange;
    }

    Integer minSecToSeconds(String time) {
        String[] t = time.split(":");
        int minutes = Integer.parseInt(t[0]);
        int seconds = Integer.parseInt(t[1]);
        return (60 * minutes + seconds);
    }

    public String secondsToMinSec(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return minutes + ":" + seconds;
    }

    @Override
    public String toString() {
        return "Athlete{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", skiTimeResult='" + skiTimeResult + '\'' +
                ", shootingRange=" + Arrays.toString(shootingRange) +
                ", finalTime='" + finalTime + '\'' +
                '}';
    }

    String getFinalTime() {
        return finalTime;
    }
}

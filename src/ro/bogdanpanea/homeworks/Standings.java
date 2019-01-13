package ro.bogdanpanea.homeworks;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Standings {

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());


    private String csvFile = "Fisiere cu date" + File.separator + "Standings.csv";
    private String line = "";
    private String cvsSplitBy = ",";
    private List<Athlete> athletes = new ArrayList<>();

    void readFromCSV() {

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                String[] athleteDetails = line.split(cvsSplitBy);
                String[] shotResults = {athleteDetails[4], athleteDetails[5], athleteDetails[6]};
                athletes.add(new Athlete(Integer.parseInt(athleteDetails[0]), athleteDetails[1], athleteDetails[2], athleteDetails[3], shotResults));
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    void readFromCSV(List<String> lines) throws StandingException {

        if (lines.size() < 0) {
            throw new StandingException("Fisierul nu contine inregistrari !", "Fisier gol.");
        }
        for (String l : lines) {
            String[] athleteDetails = l.split(cvsSplitBy);
            if (athleteDetails.length != 7) {
                throw new StandingException("Linie nu contine toate informatiile despre concurent !", "Linie invalida.");
            }
            String[] shotResults = {athleteDetails[4], athleteDetails[5], athleteDetails[6]};
            athletes.add(new Athlete(Integer.parseInt(athleteDetails[0]), athleteDetails[1], athleteDetails[2], athleteDetails[3], shotResults));
        }

    }

    void printAtletes() {
        for (Athlete a : athletes) {
            LOGGER.info(a.toString());
        }
    }

    void sortAthleteByFinalTime() {

        athletes.sort(new AthleteComparator());
    }

    List<Athlete> getAthletes() {
        return athletes;
    }
}

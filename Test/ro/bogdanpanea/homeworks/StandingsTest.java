package ro.bogdanpanea.homeworks;

import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import static org.junit.Assert.*;

public class StandingsTest {

    private Standings standings = new Standings();
    private String csvFile = "Fisiere cu date" + File.separator + "Standings.csv";
    private List<String> lines = new ArrayList<>();

    @Before
    public void setup() {
        try {
            lines = Files.readAllLines(Paths.get(csvFile), StandardCharsets.UTF_8);
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    @Test
    public void readFromCSV() throws StandingException {
        standings.readFromCSV(lines);
        assertEquals(9, standings.getAthletes().size());
    }

    @Test
    public void sortAthleteByFinalTime1() throws StandingException {
        standings.readFromCSV(lines);
        standings.sortAthleteByFinalTime();
        assertEquals("Bogdan", standings.getAthletes().get(0).getName());
    }

    @Test
    public void sortAthleteByFinalTime2() throws StandingException {
        standings.readFromCSV(lines);
        standings.sortAthleteByFinalTime();
        assertEquals("Alin", standings.getAthletes().get(8).getName());
    }

    @Test
    public void sortAthleteByFinalTime3() throws StandingException {
        standings.readFromCSV(lines);
        standings.sortAthleteByFinalTime();
        assertEquals("Umar Jorgson", standings.getAthletes().get(4).getName());
    }

}
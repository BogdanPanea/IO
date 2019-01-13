package ro.bogdanpanea.homeworks;

import java.util.logging.Level;

import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;

public class Main {

    public static void main(String[] args) {

        try {
            Standings standings = new Standings();
            standings.readFromCSV();
            standings.sortAthleteByFinalTime();
            standings.printAtletes();
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }
}

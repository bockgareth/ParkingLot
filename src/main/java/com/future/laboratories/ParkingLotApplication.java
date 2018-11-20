package com.future.laboratories;

import com.future.laboratories.report.api.controller.impl.ReportControllerImpl;
import com.future.laboratories.ticket.api.controller.impl.TicketControllerImpl;
import org.flywaydb.core.Flyway;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * This class acts as the application starting point.
 */
public class ParkingLotApplication extends Application {

    /**
     * Set used to store app-wide singleton providers. These
     * providers live throughout the lifetime of the application.
     */
    private Set<Object> singletons = new HashSet<>();

    public ParkingLotApplication() {
        Flyway flyway = new Flyway();
        flyway.setDataSource("jdbc:hsqldb:mem:pool", "sa", "root");
        flyway.clean();
        flyway.migrate();

        singletons.add(new TicketControllerImpl());
        singletons.add(new ReportControllerImpl());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

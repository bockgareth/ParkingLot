package com.future.laboratories;

import com.future.laboratories.ui.controller.ReportController;
import com.future.laboratories.ui.controller.TicketController;
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
        singletons.add(new TicketController());
        singletons.add(new ReportController());
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

package com.future.laboratories;

import com.future.laboratories.ui.controller.ReportController;
import com.future.laboratories.ui.controller.TicketController;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ParkingLotApplication extends Application {

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

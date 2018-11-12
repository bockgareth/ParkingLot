package com.future.laboratories;

//import com.future.laboratories.shared.dao.TicketDao;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//
//public class ParkingLotApplication {
//
//    public static void main(String[] args) {
//
//        Connection conn = null;
//
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/parking_lot", "root", "password");
//
//            if (conn != null) {
//                System.out.println("Connection created successfully");
//            } else {
//                System.out.println("Connection failed");
//                System.exit(0);
//            }
//
////            TicketDao ticketDao = ctx.getBean("ticketDao", TicketDao.class);
//
////            System.out.println(ticketDao.getTicketById(1).toString());
//
//        } catch (Exception e) {
//            System.out.println("Exception was thrown: " + e.getMessage());
//        }
//    }
//}

// import the rest service you created!
import com.future.laboratories.ui.controller.TicketController;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

public class ParkingLotApplication extends Application {

    private Set<Object> singletons = new HashSet<>();

    public ParkingLotApplication() {
        singletons.add(new TicketController());
    }
    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }
}

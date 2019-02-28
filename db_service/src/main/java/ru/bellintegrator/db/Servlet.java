//package ru.bellintegrator.db;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.context.support.SpringBeanAutowiringSupport;
//import ru.bellintegrator.db.service.YahooWeatherService;
//
//import javax.servlet.ServletConfig;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(value="/test", loadOnStartup=1)
//public class Servlet extends HttpServlet {
//
//    @Autowired
//    YahooWeatherService yahooWeatherService;
//
//    public void init(ServletConfig config) {
//        try {
//            super.init(config);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
////        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
//    }
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//
////        Locations locations = new Locations();
////        locations.setLoc("Moscow");
////        try {
////            locationsDao.saveLocations(locations);
////        }catch (Exception e) {
////            e.printStackTrace();
////        }
//
//        resp.getWriter().println("Hello from servlet");
//    }
//}
//

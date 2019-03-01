package net.proselyte.bookmanager;

import net.proselyte.bookmanager.view.LocationView;
import net.proselyte.bookmanager.view.YahooWeatherView;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/test", loadOnStartup=1)
public class Servlet extends HttpServlet {

//    @Autowired
//    private YahooWeatherService yahooWeatherService;
//
//    @Autowired
//    private YahooWeatherDao yahooWeatherDao;

//    public void init(ServletConfig config) {
//        try {
//            super.init(config);
//        } catch (ServletException e) {
//            e.printStackTrace();
//        }
////        SpringBeanAutowiringSupport.processInjectionBasedOnCurrentContext(this);
//        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
//    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        LocationView locationsView  = new LocationView();
        locationsView.setCity("Moscow");
        locationsView.setWoeid(2124045);
        locationsView.setCity("Ufa");
        locationsView.setRegion("Bash");
        locationsView.setCountry("Russia");
        locationsView.setLattitude((float)54.4955);
        locationsView.setLongitude((float)56.5464);
        locationsView.setTimezoneId("Asia/Yekaterinburg");

        YahooWeatherView yahooWeatherView = new YahooWeatherView();
        yahooWeatherView.setLocationView(locationsView);

//        yahooWeatherService.saveWeather(yahooWeatherView);

        resp.getWriter().println("Hello from servlet");
    }
}


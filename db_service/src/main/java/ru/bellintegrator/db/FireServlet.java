package ru.bellintegrator.db;

import com.caucho.hessian.server.HessianServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import ru.bellintegrator.db.service.YahooWeatherService;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;


@WebServlet(value = "/list", loadOnStartup = 1)
public class FireServlet extends HessianServlet {

    @Autowired
    YahooWeatherService yahooWeatherService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
    }
}


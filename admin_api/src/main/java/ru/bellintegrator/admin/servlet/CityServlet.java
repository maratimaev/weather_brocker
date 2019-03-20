package ru.bellintegrator.admin.servlet;

import org.apache.commons.lang3.StringUtils;
import ru.bellintegrator.admin.service.CityNameSender;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Сервлет, принимающий название города
 */
public class CityServlet extends HttpServlet {

    @Inject
    private CityNameSender cityNameSender;

    /**
     * Получение названия города
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cityName = request.getParameter("cityName");

        if(StringUtils.isEmpty(cityName)){
            reloadJsp(request, response, "City name form must not to be null or empty");
        } else {
            cityNameSender.sendMessage(cityName);
            reloadJsp(request, response, "poll weather for " + cityName);
        }
    }

    /**
     * Обновление страницы index.jsp с информацией о статусе отправки
     */
    private void reloadJsp(HttpServletRequest request, HttpServletResponse response, String reloadStatus) throws ServletException, IOException {
        request.setAttribute("message", reloadStatus);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

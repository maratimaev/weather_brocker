<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="ru.bellintegrator.SetWeatherLocation" %>
<%@ page import="javax.naming.Context" %>
<%@ page import="javax.naming.InitialContext" %>
<%@ page import="javax.naming.NamingException" %>
<html>
    <head>
        <title>admin-api</title>
    </head>
    <body>
        <form id="search form">
            <p><input type="text" name="cityName">
            <input type="submit" value="Название города">
        </form>
        <%  String result = "ready for send";
            try {
                Context ctx = new InitialContext();
                SetWeatherLocation setWeatherLocation = (SetWeatherLocation) ctx.lookup("java:app/admin-api-0.1/SetWeatherLocation!ru.bellintegrator.SetWeatherLocation");
                String cityName = request.getParameter("cityName");
                if (cityName != null) {
                    setWeatherLocation.sendMessage(cityName);
                    result = "poll weather for " + cityName;
                }
            } catch (NamingException e) {
                result = e.getMessage();
            }
        %>
        <div>
            State: <%= result %>
        </div
    </body>
</html>
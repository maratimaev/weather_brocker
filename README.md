# Web-приложение "Погодный брокер"
![alt text](https://github.com/maratimaev/weather_brocker/blob/master/weather_brocker.png)
  Информация по прогнозу погоды для запрашиваемого города берется с сайта https://weather-ydn-yql.media.yahoo.com/forecastrss и доступна в виде json.

Приложение состоит из 4 модулей. В качестве сервера приложений используется Wildfly 15

  * В модуле admin_api.war запрашивается название города через jsp форму и передается через ejb jms queue в модуль yahoo_weather.jar
Параметры очереди настраиваются в standalone.xml wildfly и доступны через jndi.
  * В модуле yahoo_weather.jar происходит запрос к сайту yahoo, преобразование json ответа в dto и отправка в следующую очередь сообщений модулю db_service.war.
  * В модуле db_service.war входящий dto сохраняется в БД Postgresql. Откуда доступен как объект json по входящему GET запросу /{cityName} из модуля weather_service.war через Hessian Remote Proxy.

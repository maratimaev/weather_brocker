package ru.bellintegrator.db.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.common.CommonWeatherService;
import ru.bellintegrator.common.view.YahooWeatherView;
import ru.bellintegrator.db.dao.YahooWeatherDao;
import ru.bellintegrator.db.model.YahooWeather;
import ru.bellintegrator.db.model.mapper.MapperFacade;

import java.util.List;

@Service
public class CommonWeatherServiceImpl implements CommonWeatherService {

    private MapperFacade mapperFacade;

    private YahooWeatherDao yahooWeatherDao;

//    public CommonWeatherServiceImpl() {
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("file:db_service/src/main/webapp/WEB-INF/applicationContext.xml");
//        yahooWeatherDao = (YahooWeatherDao) applicationContext.getBean("yahooWeatherDao");
//        mapperFacade = applicationContext.getBean("mappperFacade", MapperFacade.class);
//    }

//    @Autowired
    public void setYahooWeatherDao(YahooWeatherDao yahooWeatherDao) {
        this.yahooWeatherDao = yahooWeatherDao;
    }
//
//    @Autowired
    public void setMapperFacade(MapperFacade mapperFacade) {
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional
    public List<YahooWeatherView> findAll() {
        List<YahooWeather> yahooWeatherList = yahooWeatherDao.findAll();
        List<YahooWeatherView> yahooWeatherViewList = mapperFacade.mapAsList(yahooWeatherList, YahooWeatherView.class);
        return yahooWeatherViewList;
    }
}

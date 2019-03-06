package ru.bellintegrator.db.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.db.model.YahooWeather;

import java.util.List;

@Repository
public class YahooWeatherDaoIml implements YahooWeatherDao{

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public void save(YahooWeather yahooWeather) {
        try {
            Session session = this.sessionFactory.getCurrentSession();
            session.persist(yahooWeather);
        }catch (Exception e) {
            System.out.println(e);
        }
    }

    public YahooWeather findWeather(String city){
        Session session = this.sessionFactory.getCurrentSession();
        Query query = session.createQuery("from YahooWeather where location in (select idLoc from Location where city = :paramCity)");
        query.setParameter("paramCity", city);
        List<YahooWeather> yahooWeatherList = query.list();
        YahooWeather yahooWeather = null;
        if(!yahooWeatherList.isEmpty()){
            yahooWeather = yahooWeatherList.get(0);
        }
        return yahooWeather;
    }
}
